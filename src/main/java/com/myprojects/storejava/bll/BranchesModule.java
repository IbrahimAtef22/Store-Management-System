package com.myprojects.storejava.bll;

import java.util.List;
import storejava.dal.hibernate.entity.Branches;

/**
 *
 * @author Ibrahim22
 */
public interface BranchesModule {

    Branches addBranch(Branches branch) throws Exception;

    Branches editBranch(Branches branch) throws Exception;

    void deleteBranch(Branches branch) throws Exception;

    Branches getBranch(Branches branch) throws Exception;

    List<Branches> getAllBranches() throws Exception;
}
