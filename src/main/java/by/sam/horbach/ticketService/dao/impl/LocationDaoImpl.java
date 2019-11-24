package by.sam.horbach.ticketService.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.LocationDao;

/**
 * A class implementing database operations associated with the Location entity.
 * 
 * @author Horbach Anton
 *
 */
@Transactional
public class LocationDaoImpl extends AbstractBaseDao implements LocationDao {

}
