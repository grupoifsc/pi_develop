package com.github.projetoifsc.estagios.core.implementation;

import com.github.projetoifsc.estagios.core.*;
import com.github.projetoifsc.estagios.core.models.IOrgEntryData;
import com.github.projetoifsc.estagios.core.models.projections.AddressDetailsProjection;
import com.github.projetoifsc.estagios.core.models.projections.ContactDetailsProjection;
import com.github.projetoifsc.estagios.core.models.projections.OrgPrivateProfileProjection;
import com.github.projetoifsc.estagios.core.models.projections.OrgPublicProfileProjection;
import org.springframework.data.domain.Page;

import java.util.List;


public class OrganizationUseCases implements IOrganizationUseCases {

    OrganizationWriteOperations writeUC;
    OrganizationReadOperations readUC;

    public OrganizationUseCases(IOrganizationDAO organizationDB) {
        this.readUC = new OrganizationReadOperations(organizationDB);
        this.writeUC = new OrganizationWriteOperations(organizationDB);
    }

    @Override
    public OrgPrivateProfileProjection createProfile(IOrgEntryData organization) {
        return writeUC.createProfile(organization);
    }

    @Override
    public OrgPrivateProfileProjection updateProfile(String loggedId, String targetId, IOrgEntryData organization) {
        return writeUC.updateProfile(loggedId, targetId, organization);
    }

    @Override
    public void deleteProfile(String loggedId, String targetId) {
        writeUC.deleteProfile(loggedId, targetId);
    }

    @Override
    public OrgPublicProfileProjection getPublicProfile(String loggedId, String targetId) {
        return readUC.getPublicProfile(loggedId, targetId);
    }

    @Override
    public OrgPrivateProfileProjection getPrivateProfile(String loggedId, String targetId) {
        return readUC.getPrivateProfile(loggedId, targetId);
    }

    @Override
    public Page<OrgPublicProfileProjection> getAllSchools() {
        return readUC.getAllSchools();
    }

    @Override
    public List<AddressDetailsProjection> getAddresses(String loggedId, String targetId) {
        return readUC.getAddresses(loggedId, targetId);
    }

    @Override
    public List<ContactDetailsProjection> getContacts(String loggedId, String targetId) {
        return readUC.getContacts(loggedId, targetId);
    }

}
