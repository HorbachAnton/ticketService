package by.sam.horbach.ticketService.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.sam.horbach.ticketService.dao.AbstractBaseDao;
import by.sam.horbach.ticketService.dao.CommentDao;

/**
 * A class implementing database operations associated with the Comment entity.
 * 
 * @author Horbach Anton
 *
 */
@Transactional
public class CommentDaoImpl extends AbstractBaseDao implements CommentDao {

}
