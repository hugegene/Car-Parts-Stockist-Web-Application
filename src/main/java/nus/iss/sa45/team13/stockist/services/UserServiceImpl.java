package nus.iss.sa45.team13.stockist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nus.iss.sa45.team13.stockist.model.Role;
import nus.iss.sa45.team13.stockist.model.User;
import nus.iss.sa45.team13.stockist.repository.RoleRepository;
import nus.iss.sa45.team13.stockist.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Integer saveUser(User user, Role role) {
		Role savedRole;
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		savedRole = roleRepository.save(role);
		user.setStaffId(savedRole.getStaffId());
		userRepository.save(user);
		
		return savedRole.getStaffId();
	}

}
