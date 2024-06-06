package com.github.projetoifsc.estagios.infra.db.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface JobRepository extends ListPagingAndSortingRepository<JobEntity, Long> {

    JobEntity save(JobEntity jobEntity);
    void delete(JobEntity job);
    void deleteById(long id);

    <T> Optional<T> findById(long id, Class<T> type);

    <T> Page<T> findAllByOwnerId(long id, Pageable pageable, Class<T> type);
    <T> List<T> findAllByExclusiveReceiversEmpty(Class<T> type);
    <T> List<T> findAllByExclusiveReceiversId(long id, Class<T> type);

    <T> List<T> findAllByApprovalsOrganizationId(long orgId, Class<T> type);
    <T> List<T> findAllByRejectionsOrganizationId(long orgId, Class<T> type);

    <T> List<T> findDistinctByApprovalsOrganizationIdOrOwnerId(long orgId, long ownerId, Class<T> type);

}