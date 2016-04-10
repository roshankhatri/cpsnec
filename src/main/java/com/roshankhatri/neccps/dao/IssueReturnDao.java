package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.IssueReturn;

public interface IssueReturnDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<IssueReturn> listall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('IR')")
	void save(IssueReturn issueReturn);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<IssueReturn> listbyStudent(long studentId);
	long getCount();
}
