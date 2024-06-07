package com.github.projetoifsc.estagios.core.models;

import java.util.List;


public interface IJobEntryData extends JobPrivateDetailsProjection {

    List<String> getAreasIds();
    List<String> getReceiversIds();
    void setReceiversIds(List<String> receivers);
    String getContactId();
    String getAddressId();

}
