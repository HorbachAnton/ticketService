package by.sam.horbach.ticketService.controllers;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.test.context.support.WithMockUser;
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
public class LoadProfileIconPageControllerTest {

	public static final String LOAD_PROFILE_ICON_CONTROLLER_BEAN_NAME = "loadProfileIconPageController";

	public static final String LOAD_PROFILE_PAGE_URL = "/load_user_icon_page";
	public static final String LOAD_PROFILE_ICON_VIEW_NAME = "load_profile_icon";
	public static final String LOAD_PROFILE_ICON_DTO_ATTRIBUTE = "fileUploadDTO";

	public static final String LOAD_PROFILE_ICON_METHOD_URL = "/upload_file";
	public static final String LOAD_PROFILE_ICON_FILE_ATTRIBUTE = "file";

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
		Assert.assertNotNull(wac.getBean(LOAD_PROFILE_ICON_CONTROLLER_BEAN_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(LOAD_PROFILE_PAGE_URL)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name(LOAD_PROFILE_ICON_VIEW_NAME))
				.andExpect(MockMvcResultMatchers.model().attributeExists(LOAD_PROFILE_ICON_DTO_ATTRIBUTE));
	}

}
