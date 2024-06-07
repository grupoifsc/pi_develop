package com.github.projetoifsc.estagios.core.dto;

import com.github.projetoifsc.estagios.core.models.IAddress;
import com.github.projetoifsc.estagios.core.models.IContact;
import com.github.projetoifsc.estagios.core.models.IOrganization;

public class OrganizationImpl implements IOrganization {

    private String id;
    boolean isSchool;

    public OrganizationImpl(String id, boolean isSchool) {
        this.id = id;
        this.isSchool = isSchool;
    }

    @Override
    public String getId() {
        return id;
    }

//    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Boolean getIe() {
        return isSchool;
    }

    public void setIe(boolean school) {
        isSchool = school;
    }

}
