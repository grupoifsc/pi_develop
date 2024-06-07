package com.github.projetoifsc.estagios.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.projetoifsc.estagios.core.models.OrgPublicProfileProjection;
import com.github.projetoifsc.estagios.app.model.shared.AddressModel;
import com.github.projetoifsc.estagios.app.model.shared.ContactModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Schema(name = "Perfil Público da Organização", description = "Perfil Público da Organização")
@JsonPropertyOrder(value = {"id", "nome", "instituicao_de_ensino",
        "info", "contato_principal", "endereco", "website", "redes_sociais", "_links"})
@Validated
public class PublicOrgProfileResponse extends BasicOrgResponse implements OrgPublicProfileProjection {

    @JsonProperty(value = "info", required = true)
    @Schema(description = "Informações sobre a organização", requiredMode = Schema.RequiredMode.REQUIRED, example = "Uma organização sem bancos", maxLength = 500)
    @NotBlank
    private String info;

    private String website;

    @JsonProperty(value = "redes_sociais")
    private String redesSociais;

    @JsonProperty(value = "contato_principal", required = true)
    @NotNull
    @Valid
    private PublicContactResponse mainContact;

    @JsonProperty(value = "endereco", required = true)
    private PublicAddressResponse mainAddress;


    @Override
    public @NotBlank String getInfo() {
        return info;
    }

    public void setInfo(@NotBlank String info) {
        this.info = info;
    }

    @Override
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }

    @Override
    public @NotNull @Valid ContactModel getMainContact() {
        return mainContact;
    }

    public void setMainContact(@NotNull @Valid PublicContactResponse mainContact) {
        this.mainContact = mainContact;
    }

    @Override
    public AddressModel getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(PublicAddressResponse mainAddress) {
        this.mainAddress = mainAddress;
    }

}
