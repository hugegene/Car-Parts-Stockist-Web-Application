package nus.iss.sa45.team13.stockist.services;

import nus.iss.sa45.team13.stockist.model.Role;
import nus.iss.sa45.team13.stockist.model.User;

public interface UserService {
	public Integer saveUser(User user, Role role);
}
