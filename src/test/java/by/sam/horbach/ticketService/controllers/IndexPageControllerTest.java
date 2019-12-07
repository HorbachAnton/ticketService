package by.sam.horbach.ticketService.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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
public class IndexPageControllerTest {

	private static final String INDEX_PAGE_CONTROLLER_BEAN_NAME = "indexPageController";

	private static final String INDEX_PAGE_URL = "/";
	private static final String GET_PAGE_EXPECTED_VIEW_NAME = "index";
	private static final String GET_PAGE_EXPECTING_ATTRIBUTE = "upcomingEvents";

	private static final String REDIRECT_TO_EVENT_PAGE_URL = "/learn_more_about_event";
	private static final String EVENT_ID_PARAMETER_NAME = "eventId";
	private static final String TEST_VALUE_EVENT_ID = "1";
	private static final String REDIRECTED_URL = "/ticket-service/event_page?eventId=" + TEST_VALUE_EVENT_ID;

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
		Assert.assertNotNull(wac.getBean(INDEX_PAGE_CONTROLLER_BEAN_NAME));
	}

	@Test
	public void getPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(INDEX_PAGE_URL)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.view().name(GET_PAGE_EXPECTED_VIEW_NAME))
				.andExpect(model().attributeExists(GET_PAGE_EXPECTING_ATTRIBUTE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void requestToEventPage() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get(REDIRECT_TO_EVENT_PAGE_URL).param(EVENT_ID_PARAMETER_NAME,
						TEST_VALUE_EVENT_ID))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.redirectedUrl(REDIRECTED_URL))
				.andExpect(MockMvcResultMatchers.status().isFound());
	}

}
