package by.sam.horbach.ticketService.services.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.sam.horbach.ticketService.dao.EventDao;
import by.sam.horbach.ticketService.entities.Event;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {

	@InjectMocks
	private EventServiceImpl eventService;

	@Mock
	private EventDao eventDao;

	private Event expectedEvent;

	private Event deletedEvent;

	private List<Event> expectedEventsList;

	private List<Event> expectedUpcomingEventsList;

	@Before
	public void createExpectedEvent() {
		expectedEvent = new Event();
		expectedEvent.setId(1);
		expectedEvent.setDate(LocalDateTime.of(1999, 11, 12, 20, 33));
	}

	@Before
	public void createExpectedEventsList() {
		expectedEventsList = Arrays.asList(expectedEvent);
	}

	@Before
	public void createExpectedUpcomingEventsList() {
		Event firstEvent = new Event();
		firstEvent.setDate(LocalDateTime.of(2001, 11, 12, 20, 33));
		Event secondEvent = new Event();
		secondEvent.setDate(LocalDateTime.of(2000, 11, 12, 20, 33));

		expectedUpcomingEventsList = Arrays.asList(firstEvent, secondEvent, expectedEvent);
	}

	@Before
	public void createDeletedEvent() {
		deletedEvent = new Event();
		deletedEvent.setId(1);
	}

	@Test
	public void getEventByIdTest() {
		doReturn(expectedEvent).when(eventDao).getById(Event.class, 1);
		Event actualEvent = eventService.getEventById(1);
		assertThat(actualEvent, is(equalTo(expectedEvent)));
	}

	@Test
	public void getEventsTest() {
		doReturn(expectedEventsList).when(eventDao).getEvents();
		List<Event> actualEventsList = eventService.getEvents();
		assertThat(actualEventsList, is(equalTo(expectedEventsList)));
	}

	@Test
	public void getUpcomingEventsTest() {
		doReturn(expectedUpcomingEventsList).when(eventDao).getUpcomingEvents();
		List<Event> actualUpcomingEventsList = eventService.getUpcomingEvents();
		assertThat(actualUpcomingEventsList, is(equalTo(expectedUpcomingEventsList)));
	}

}
