package com.github.projetoifsc.estagios.core;


public interface IJob {

    String getId();
    void setId(String id);
    IOrganization getOwner();
    void setOwner(IOrganization user);

}
