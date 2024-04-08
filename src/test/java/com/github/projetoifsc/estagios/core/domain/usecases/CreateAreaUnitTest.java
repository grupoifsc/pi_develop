package com.github.projetoifsc.estagios.core.domain.usecases;

import com.github.projetoifsc.estagios.core.domain.IAreaRepository;
import com.github.projetoifsc.estagios.core.domain.IOrganization;
import com.github.projetoifsc.estagios.core.domain.dto.AreaImpl;
import com.github.projetoifsc.estagios.core.domain.dto.OrganizationImpl;
import com.github.projetoifsc.estagios.core.domain.iArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateAreaUnitTest {

    IAreaRepository areaRepository = mock();
    CreateArea service = new CreateArea(areaRepository);

    private IOrganization school = new OrganizationImpl("1", true);
    private IOrganization enterprise = new OrganizationImpl("2", false);

    private AreaImpl area;
    private AreaImpl created;

    @BeforeEach
    void setUp() {
        area = new AreaImpl("Educação");
    }

    @Test
    void onlySchoolsCanCreateArea() {
        when(areaRepository.create(area)).thenReturn(area);
        assertDoesNotThrow(() -> service.create(school, area));
        assertThrows(Exception.class, () -> service.create(enterprise, area));
    }

    @Test
    void createReturnsCreatedArea() {
        when(areaRepository.create(area)).thenReturn(area);
        assertInstanceOf(iArea.class, service.create(school, area));
    }


}
