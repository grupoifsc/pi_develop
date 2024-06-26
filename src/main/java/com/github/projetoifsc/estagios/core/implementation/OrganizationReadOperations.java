package com.github.projetoifsc.estagios.core.implementation;

import com.github.projetoifsc.estagios.core.IOrganizationDAO;
import com.github.projetoifsc.estagios.core.models.projections.AddressDetailsProjection;
import com.github.projetoifsc.estagios.core.models.projections.ContactDetailsProjection;
import com.github.projetoifsc.estagios.core.models.projections.OrgPrivateProfileProjection;
import com.github.projetoifsc.estagios.core.models.projections.OrgPublicProfileProjection;
import org.springframework.data.domain.Page;

import java.util.List;

class OrganizationReadOperations {

    IOrganizationDAO organizationRepository;

    public OrganizationReadOperations(IOrganizationDAO organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public OrgPublicProfileProjection getPublicProfile(String loggedId, String targetId) {
        return organizationRepository.getOrgPublicProfile(targetId);
    }


    public OrgPrivateProfileProjection getPrivateProfile(String loggedId, String targetId) {
        if(OrganizationValidation.isSelf(loggedId, targetId))
            return organizationRepository.getOrgPrivateProfile(targetId);
        var exceptionMessage = "Organizations can only see their own private profiles";
        throw new UnauthorizedAccessException(exceptionMessage);
    }


    public Page<OrgPublicProfileProjection> getAllSchools() {
        return this.organizationRepository.getAllSchoolsPublicProfile();
    }


    public List<AddressDetailsProjection> getAddresses(String loggedId, String targetId) {
        if(OrganizationValidation.isSelf(loggedId, targetId))
            return organizationRepository.getAllAddressesFromOrg(targetId);
        var exceptionMessage = "Organizations can only see their own private profiles";
        throw new UnauthorizedAccessException(exceptionMessage);
    }

    public List<ContactDetailsProjection> getContacts(String loggedId, String targetId) {
        if(OrganizationValidation.isSelf(loggedId, targetId))
            return organizationRepository.getAllContactsFromOrg(targetId);
        var exceptionMessage = "Organizations can only see their own private profiles";
        throw new UnauthorizedAccessException(exceptionMessage);
    }

}
