package com.github.projetoifsc.estagios.core.dto;

import com.github.projetoifsc.estagios.core.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobImpl implements IJobEntryData {

    private String id;
    private IOrganization owner;
    private List<String> receivers = new ArrayList<>();
    private List<IArea> areas = new ArrayList<>();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public OrgBasicInfoProjection getOwner() {
        return (OrgBasicInfoProjection) owner;
    }

    @Override
    public void setOwner(IOrganization owner) {
        this.owner = owner;
    }

    @Override
    public List<String> getAreasIds() {
        return List.of();
    }

    @Override
    public List<String> getReceiversIds() {
        return receivers;
    }

    @Override
    public void setReceiversIds(List<String> receivers) {
        this.receivers = receivers;
    }

    @Override
    public String getContactId() {
        return "";
    }

    @Override
    public String getAddressId() {
        return "";
    }

    //@Override
    public List<IArea> getAreas() {
        return areas;
    }

    @Override
    public short getPeriodId() {
        return 0;
    }

    @Override
    public short getLevelId() {
        return 0;
    }

    @Override
    public short getFormatId() {
        return 0;
    }

    @Override
    public String getTitulo() {
        return "";
    }

    @Override
    public String getDescricao() {
        return "";
    }

    @Override
    public String getImagem() {
        return "";
    }

    @Override
    public String getRequisitos() {
        return "";
    }

    @Override
    public LocalDate getDataInicio() {
        return null;
    }

    @Override
    public LocalDate getDataFinal() {
        return null;
    }

    @Override
    public int getDuracaoMeses() {
        return 0;
    }

    @Override
    public float getRemuneracao() {
        return 0;
    }

    @Override
    public int getCargaHorariaSemanal() {
        return 0;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return null;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return null;
    }

    @Override
    public AddressProjection getAddress() {
        return null;
    }

    @Override
    public ContactProjection getContact() {
        return null;
    }

    @Override
    public List<OrgBasicInfoProjection> getExclusiveReceivers() {
        return List.of();
    }

}
