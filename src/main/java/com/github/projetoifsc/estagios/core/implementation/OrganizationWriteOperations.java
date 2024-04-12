package com.github.projetoifsc.estagios.core.implementation;

import com.github.projetoifsc.estagios.core.IOrganization;
import com.github.projetoifsc.estagios.core.IOrganizationRepository;
import com.github.projetoifsc.estagios.core.implementation.UnauthorizedAccessException;

class OrganizationWriteOperations {

    IOrganizationRepository organizationRepository;

    public OrganizationWriteOperations(IOrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    public IOrganization createProfile(IOrganization organization) {
        return organizationRepository.save(organization);
    }


    public IOrganization updateProfile(String loggedId, String targetId, IOrganization organization) {
        if(OrganizationValidation.isSelf(loggedId, targetId)) {
            organization.setId(targetId);
            return organizationRepository.save(organization);
        }
        var exceptionMessage = "Organizations can only update their own profiles";
        throw new UnauthorizedAccessException(exceptionMessage);
    }


    public void deleteProfile(String loggedId, String targetId) {
        if(OrganizationValidation.isSelf(loggedId, targetId)){
            organizationRepository.delete(targetId);
            return;
        }
        var exceptionMessage = "Organizations can only delete their own profiles";
        throw new UnauthorizedAccessException(exceptionMessage);
    }


}
