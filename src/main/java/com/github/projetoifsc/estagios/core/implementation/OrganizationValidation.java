package com.github.projetoifsc.estagios.core.implementation;

import com.github.projetoifsc.estagios.core.models.IOrg;
import com.github.projetoifsc.estagios.core.models.IJob;
import com.github.projetoifsc.estagios.core.models.projections.JobSummaryProjection;

import java.util.List;

class OrganizationValidation {

    public static boolean isSelf(String loggedId, String targetId) {
        return loggedId
                .equalsIgnoreCase(targetId);
    }

    public static boolean isReceiver(IOrg organization, List<IOrg> receiversList) {
        return receiversList.isEmpty() || receiversList.contains(organization);
    }

    public static boolean isReceiver(IOrg organization, JobSummaryProjection job) {
        if (job.getExclusiveReceivers().isEmpty()) return true;
        return job.getExclusiveReceivers().stream()
                .anyMatch(org -> org.getId().equalsIgnoreCase(organization.getId()));
    }


    public static boolean isOwner(IOrg organization, IJob traineeship) {
        var orgId = organization.getId();
        var jobOwnerId = traineeship.getOwner().getId();
        return isSelf(orgId, jobOwnerId);
    }

    public static boolean isValidReceiver(IOrg organization) {
        return organization.getIe();
    }

    public static boolean isIE(IOrg organization) {
        return organization.getIe();
    }

}
