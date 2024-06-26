package com.github.projetoifsc.estagios.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.projetoifsc.estagios.core.models.IArea;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@JsonPropertyOrder(value = {"id", "nome", "_links"})
public class Area extends Response implements IArea {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "1")
    private String id;

    @JsonProperty(value = "nome", access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "Educação")
    @NotBlank
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
