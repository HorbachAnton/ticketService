package by.sam.horbach.ticketService.services.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.sam.horbach.ticketService.dao.LocationDao;
import by.sam.horbach.ticketService.entities.Location;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

	@InjectMocks
	private LocationServiceImpl locationService;

	@Mock
	private LocationDao locationDao;

	private Location expectedLocation;

	@Before
	public void createLocation() {
		expectedLocation = new Location(1, "Location");
	}

	@Test
	public void getLocationTest() {
		doReturn(expectedLocation).when(locationDao).getById(Location.class, 1);
		Location actualLocation = locationService.getLocation(1);
		assertThat(actualLocation, is(equalTo(expectedLocation)));
	}

	@Test
	public void getLocationByTitleTest() {
		doReturn(expectedLocation).when(locationDao).getLocationByTitle("Location");
		Location actualLocation = locationService.getLocationByTitle("Location");
		assertThat(actualLocation, is(equalTo(expectedLocation)));
	}

}
