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
public class EventPageControllerTest {

	public static final String EVENT_PAGE_CONTROLLER_BEAN_NAME = "eventPageController";

	public static final String EVENT_PAGE_URL = "/event_page";
	public static final String GET_PAGE_PARAM_NAME = "eventId";
	public static final String GET_PAGE_PARAM_VALUE = "1";
	public static final String EVENT_PAGE_VIEW_NAME = "event";
	public static final String EVENT_PAGE_MODEL_ATTRIBUTE_NAME = "eventDTO";
	public static final String EVENT_PAGE_MODEL_DTO_ATTRIBUTE_NAME = "buyTicketsDTO";

	public static final String BUY_TICKETS_COMMAND_URL = "/buy_tickets";
	public static final String BUY_TICKETS_PARAM_ID_EVENT_NAME = "idEvent";
	public static final String BUY_TICKETS_PARAM_ID_EVENT_VALUE = "1";
	public static final String BUY_TICKETS_PARAM_QUANTITY_NAME = "quantity";
	public static final String BUY_TICKETS_PARAM_QUANTITY_VALUE = "2";
	public static final String BUY_TICKETS_REDIRECTED_URL = "/ticket-service/?eventId="
			+ BUY_TICKETS_PARAM_ID_EVENT_VALUE;

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
		Assert.assertNotNull(wac.getBean(EVENT_PAGE_CONTROLLER_BEAN_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void getPage() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get(EVENT_PAGE_URL).param(GET_PAGE_PARAM_NAME, GET_PAGE_PARAM_VALUE))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name(EVENT_PAGE_VIEW_NAME))
				.andExpect(MockMvcResultMatchers.model().attributeExists(EVENT_PAGE_MODEL_ATTRIBUTE_NAME))
				.andExpect(MockMvcResultMatchers.model().attributeExists(EVENT_PAGE_MODEL_DTO_ATTRIBUTE_NAME));
	}

	@Test
	@WithMockUser(username = "dmitri@yandex.by", roles = { "CONSUMER" })
	public void buyTickets() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(BUY_TICKETS_COMMAND_URL)
						.param(BUY_TICKETS_PARAM_ID_EVENT_NAME, BUY_TICKETS_PARAM_ID_EVENT_VALUE)
						.param(BUY_TICKETS_PARAM_QUANTITY_NAME, BUY_TICKETS_PARAM_QUANTITY_VALUE)
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isFound())
				.andExpect(MockMvcResultMatchers.redirectedUrl(BUY_TICKETS_REDIRECTED_URL));
	}

}
