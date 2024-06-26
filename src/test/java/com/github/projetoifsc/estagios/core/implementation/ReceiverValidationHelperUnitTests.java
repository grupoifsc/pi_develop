package com.github.projetoifsc.estagios.core.implementation;

import com.github.projetoifsc.estagios.core.dto.OrgImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class ReceiverValidationHelperUnitTests {

    private final OrgImpl schoolA = new OrgImpl("1", true);
    private final OrgImpl schoolB = new OrgImpl("2", true);
    private final OrgImpl enterpriseA = new OrgImpl("3", false);

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenOrgList_ifAllAreValidReceivers_ListIsValid() {
        try (MockedStatic<OrganizationValidation> mockStatic = mockStatic(OrganizationValidation.class)) {
            mockStatic.when(() -> OrganizationValidation.isValidReceiver(schoolA)).thenReturn(true);
            mockStatic.when(() -> OrganizationValidation.isValidReceiver(schoolB)).thenReturn(true);
            assertDoesNotThrow(() -> ReceiverValidation.validateReceivers(List.of(schoolA, schoolB)));
        }
    }

    @Test
    void givenOrgList_ifOneIsNotValidReceivers_ThrowsErrorWithOrgIdInMessage() {
        try (MockedStatic<OrganizationValidation> mockStatic = mockStatic(OrganizationValidation.class)) {
            mockStatic.when(() -> OrganizationValidation.isValidReceiver(schoolA)).thenReturn(true);
            mockStatic.when(() -> OrganizationValidation.isValidReceiver(enterpriseA)).thenReturn(false);
            assertThrows(Exception.class, () -> ReceiverValidation.validateReceivers(List.of(schoolA, enterpriseA)));
            try {
                ReceiverValidation.validateReceivers(List.of(schoolA, enterpriseA));
            } catch (Exception e) {
//                System.out.println(e.getMessage());
              assertTrue(e.getMessage().contains(enterpriseA.getId()));
            }
        }
    }


}
