package com.github.projetoifsc.estagios.infra.db.jpa;

import com.github.javafaker.Faker;
import com.github.projetoifsc.estagios.app.interfaces.JobBasicInfoProjection;
import com.github.projetoifsc.estagios.app.interfaces.JobPublicSummaryProjection;
import com.github.projetoifsc.estagios.app.interfaces.OrgBasicInfoProjection;
import com.github.projetoifsc.estagios.core.IJob;
import com.github.projetoifsc.estagios.utils.JsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@SpringBootTest
class JobRepositoryUnitTest {

    @Autowired
    JobRepository repository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    JsonParser jsonParser;

    @Autowired
    RejectedJobRepository rejectedJobRepository;

    @Autowired
    ApprovedJobRepository approvedJobRepository;

    JobMocker jobMocker = new JobMocker(new Faker(new Locale("pt-BR")));

    IJob job;


    @Test
    @Transactional
    @Rollback(false)
    void save() {
        var owner = organizationRepository.findById(352L, OrganizationEntity.class);
        var job = jobMocker.generate();
        job.setOwner(owner.get());
        var saved = repository.save(job);
        jsonParser.printValue (saved);
    }


    @Test
    void delete() {
        var opt = repository.findById(19L, JobEntity.class);
        var job = opt.orElse(null);
        jsonParser.printValue(job);
        repository.delete(job);
    }


    @Test
    void findById() {}


    @Test
    void findAllByOwnerId() {
        var jobs = repository.findAllByOwnerId(195L, PageRequest.of(0, 50), JobPublicSummaryProjection.class);
        System.out.println(jobs.getNumberOfElements());
        jsonParser.printValue(jobs.getContent());
    }


    @Test
    void findAllByExclusiveReceiversEmpty() {
        var jobs = repository.findAllByExclusiveReceiversEmpty(JobBasicInfoProjection.class);
        System.out.println(jobs.size());
        jsonParser.printValue(jobs);
    }


    @Test
    void findAllByExclusiveReceiversId() {
        var jobs = repository.findAllByExclusiveReceiversId(272L, JobBasicInfoProjection.class);
        System.out.println(jobs.size());
        jsonParser.printValue(jobs);
    }

    @Test
    void saveApproved() {
        var approved = new ApprovedJobEntity();
        approved.setJobId(34);
        approved.setOrgId(378);
        var saved = approvedJobRepository.save(approved);
        jsonParser.printValue(saved);
    }

    @Test
    void saveRejected() {
        var rejected = new RejectedJobEntity();
        rejected.setJobId(36);
        rejected.setOrgId(378);
        var saved = rejectedJobRepository.save(rejected);
        jsonParser.printValue(saved);
    }


    @Test
    void deleteApproved() {
        approvedJobRepository.deleteById(1L);
    }

    @Test
    void deleteRejected() {
        rejectedJobRepository.deleteById(1L);
    }


    @Test
    void findByApprovals() {
        var orgId = 379;
        var approved = repository.findAllByApprovalsOrganizationId(orgId, JobPublicSummaryProjection.class);
        jsonParser.printValue(approved);
    }

    @Test
    void findByRejection() {
        var orgId = 378;
        var rejected = repository.findAllByRejectionsOrganizationId(orgId, JobPublicSummaryProjection.class);
        jsonParser.printValue(rejected);
    }

}