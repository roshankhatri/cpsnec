package com.roshankhatri.neccps.dao;

import com.roshankhatri.neccps.model.Account;

public interface AccountDao {
	long save(Account account);
	long update(Account account);

}
