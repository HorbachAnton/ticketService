package by.sam.horbach.ticketService.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
public class RegistrationPageControllerTest {

	public static final String REGISTRAION_CONTROLLER_BEAN_NAME = "registrationPageController";

	public static final String REGISTRATION_CONTROLLER_PAGE_URL = "/registration";
	public static final String REGISTRATION_CONTROLLER_DTO_ATTRIBUTE = "userDTO";
	public static final String REGISTRATION_PAGE_VIEW_NAME = "registration";

	public static final String REGISTER_COMMAND_URL = "/register";
	public static final String REGISTER_COMMAND_EMAIL_ATTRIBUTE_NAME = "email";
	public static final String REGISTER_COMMAND_EMAIL_ATTRIBUTE_VALUE = "egsbtrh@mail.ru";
	public static final String REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME = "password";
	public static final String REGISTER_COMMAND_PASSWORD_ATTRIBUTE_VALUE = "dH12$$Bd";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}

	@Test
	public void verifyConfiguration() {
		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean(REGISTRAION_CONTROLLER_BEAN_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(REGISTRATION_CONTROLLER_PAGE_URL))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeExists(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void register() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_EMAIL_ATTRIBUTE_NAME, REGISTER_COMMAND_EMAIL_ATTRIBUTE_VALUE)
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, REGISTER_COMMAND_PASSWORD_ATTRIBUTE_VALUE)
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
