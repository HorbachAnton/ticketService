package by.sam.horbach.ticketService.controllers;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
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
public class AuthorizationPageControllerTest {

	public static final String AUTHORIZATION_PAGE_CONTROLLER_BEAN_NAME = "authorizationPageController";

	public static final String AUTHORIZATION_PAGE_URL = "/authorization";
	public static final String AUTHORIZATION_EXPECTED_VIEW_NAME = "authorization";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void verifyConfiguration() {
		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean(AUTHORIZATION_PAGE_CONTROLLER_BEAN_NAME));
	}

	@Test
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(AUTHORIZATION_PAGE_URL)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.view().name(AUTHORIZATION_EXPECTED_VIEW_NAME))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
