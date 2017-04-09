package com.example.config;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.models.Fresher;
import com.example.models.Role;
import com.example.models.Users;
import com.example.repository.FresherRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;


@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private FresherRepository fresherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}

		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}
		Users tmp;
		
		// Admin account
		if (userRepository.findByUsername("admin") == null) {
			tmp = new Users();
			Users admin = new Users();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("123456"));
			admin.setActive("1");
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			admin.setRoles(roles);
			tmp = userRepository.save(admin);			
		}

		createFresher("11531846","Le Cong Minh Thuan","M","tle237","NTO",68);
		createFresher("11531841","Nguyen Vu Xuan Thu","F","tnguyen490","ETO1",14);
		createFresher("11531840","Vuong Thi Phuong","F","pvuong5","ETO3",107);
		createFresher("11531816","Tran Hoang Quan","M","qtran30","ETO3",153);
		createFresher("11531817","Nguyen Huy Tuan","M","tnguyen489","ETO1",35);
		createFresher("11531816","Tran Thanh Quan","M","qtran31","NTO",67);
		//createFresher("11531846","Le Cong Minh Thuan","M","tle237","NTO",68);
		

	}

	private void createFresher(String employeeId, String fullName, String sex, String shortName, String office, int cube) {
		Fresher f;
		
		if (fresherRepository.findByEmployeeId(employeeId) == null) {
			f = new Fresher(employeeId, fullName, sex, shortName, office, cube);
			
			fresherRepository.save(f);
		}
	}

}
