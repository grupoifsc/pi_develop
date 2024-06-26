package com.github.projetoifsc.estagios.infra.db.jpa;

import com.github.javafaker.Faker;
import com.github.projetoifsc.estagios.core.models.IArea;

public class AreaMocker {

    Faker faker;

    public AreaMocker(Faker faker) {
        this.faker = faker;
    }

    public IArea generate() {
        var nomeCurso = faker.educator().course();
        var nomeArea = getLast(nomeCurso);
        return new AreaEntity(nomeArea);
    }

    private String getLast(String compostName) {
        var splittedList = compostName.split(" ");
        var lastIndex = splittedList.length - 1;
        return splittedList[lastIndex];
    }

}
