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
public class ChangePasswordPageControllerTest {

	public static final String CHANGE_PASSWORD_PAGE_CONTROLLER_BEAN_NAME = "changePasswordPageController";

	public static final String CHANGE_PASSWORD_PAGE_URL = "/change_password_page";
	public static final String GET_PAGE_EXPECTED_VIEW_NAME = "change_password";
	public static final String GET_PAGE_EXPECTING_ATTRIBUTE = "passwordDTO";

	public static final String REDIRECT_URL = "/";
	public static final String REDIRECT_VIEW_NAME = "redirect:/";

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
		Assert.assertNotNull(wac.getBean(CHANGE_PASSWORD_PAGE_CONTROLLER_BEAN_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(CHANGE_PASSWORD_PAGE_URL)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.view().name(GET_PAGE_EXPECTED_VIEW_NAME))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeExists(GET_PAGE_EXPECTING_ATTRIBUTE));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void change() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/change_password").param("password", "qQ1122@@")
						.param("confirmPassword", "qQ1122@@").with((SecurityMockMvcRequestPostProcessors.csrf())))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isFound())
				.andExpect(MockMvcResultMatchers.redirectedUrl(REDIRECT_URL))
				.andExpect(MockMvcResultMatchers.view().name(REDIRECT_VIEW_NAME));

	}

}
