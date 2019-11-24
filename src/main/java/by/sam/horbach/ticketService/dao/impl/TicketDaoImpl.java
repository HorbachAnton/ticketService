package by.sam.horbach.ticketService.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.TicketDao;

/**
 * A class implementing database operations associated with the Ticket entity.
 * 
 * @author Horbach Anton
 *
 */
@Transactional
public class TicketDaoImpl extends AbstractBaseDao implements TicketDao {

}
