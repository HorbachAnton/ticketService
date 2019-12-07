package by.sam.horbach.ticketService.controllers;

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
public class ChangePersonalDataPageControllerTest {

	public static final String CHANGE_PERSONAL_DATA_PAGE_CONTROLLER_BEAN_NAME = "changePersonalDataPageController";

	public static final String CHANGE_PERSONAL_DATA_PAGE_URL = "/change_personal_data_page";
	public static final String CHANGE_PERSONAL_DATA_VIEW_NAME = "change_personal_data";

	public static final String CHANGE_PERSONAL_DATA_COMMAND_URL = "/change_personal_data";
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
		Assert.assertNotNull(wac.getBean(CHANGE_PERSONAL_DATA_PAGE_CONTROLLER_BEAN_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(CHANGE_PERSONAL_DATA_PAGE_URL))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name(CHANGE_PERSONAL_DATA_VIEW_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void change() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(CHANGE_PERSONAL_DATA_COMMAND_URL).param("name", "David")
						.param("surname", "Copperfield").with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isFound())
				.andExpect(MockMvcResultMatchers.redirectedUrl(REDIRECT_URL))
				.andExpect(MockMvcResultMatchers.view().name(REDIRECT_VIEW_NAME));
	}

}
