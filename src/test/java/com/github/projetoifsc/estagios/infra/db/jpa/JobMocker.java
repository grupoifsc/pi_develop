package com.github.projetoifsc.estagios.infra.db.jpa;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

class JobMocker {

    Faker faker;

    JobMocker(Faker faker) {
        this.faker = faker;
    }

    public Job generate() {

        Job job = new Job();

        job.titulo = faker.job().title();
        job.carga_horaria_semanal = faker.number().numberBetween(0, 50);
        job.data_final = faker.date().future(500, TimeUnit.DAYS).toString();
        job.data_inicio = LocalDateTime.parse(job.data_final).minusDays(50).toString();
        job.descricao = job.titulo + " performing " + faker.job().field() + " " + faker.job().position() + " activities with our clients at " + faker.lordOfTheRings().location() ;
        job.duracao_meses = faker.number().numberBetween(0, 24);
        job.id_externo_autor = faker.bothify("sdssfsdf");
        job.imagem = faker.company().logo();
        job.remuneracao = faker.number().numberBetween(0, 5000);
        job.requisitos = faker.job().keySkills() + ";" + faker.job().keySkills() + ";" + faker.job().keySkills();

        return job;

    }


}
