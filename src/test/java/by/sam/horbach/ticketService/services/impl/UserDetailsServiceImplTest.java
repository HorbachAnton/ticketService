package by.sam.horbach.ticketService.services.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

	@Mock
	private UserDetailsServiceImpl userDetailsService;

	private UserDetails userDetails;

	@Before
	public void createUserDetails() {
		Set<GrantedAuthority> setAuths = new HashSet<>();
		setAuths.add(new SimpleGrantedAuthority("Consumer"));
		userDetails = new org.springframework.security.core.userdetails.User("emailn@yadex.com", "112233", false, true,
				true, true, new ArrayList<>(setAuths));
	}

	@Test
	public void loadUserByUsernameTest() {
		doReturn(userDetails).when(userDetailsService).loadUserByUsername("emailn@yadex.com");
		UserDetails actualUserDetails = userDetailsService.loadUserByUsername("emailn@yadex.com");
		assertThat(actualUserDetails, is(equalTo(userDetails)));
	}

}
