package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.IssueReturn;

public interface IssueReturnDao {
	List<IssueReturn> listall();
	void save(IssueReturn issueReturn);
	List<IssueReturn> listbyStudent(long studentId);
}
