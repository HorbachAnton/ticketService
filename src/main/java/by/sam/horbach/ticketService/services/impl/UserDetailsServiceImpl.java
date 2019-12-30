package by.sam.horbach.ticketService.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.UserDao;
import by.sam.horbach.ticketService.entities.User;
import by.sam.horbach.ticketService.entities.UserRoles;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = userDao.findByUserEmail(email);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getIdRole());
		return buildUserForAuthentication(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(int idRole) {
		Set<GrantedAuthority> setAuths = new HashSet<>();
		setAuths.add(new SimpleGrantedAuthority(UserRoles.getRoleById(idRole).toString()));
		return new ArrayList<>(setAuths);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
