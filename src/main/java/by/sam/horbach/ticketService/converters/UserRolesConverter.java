package by.sam.horbach.ticketService.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import by.sam.horbach.ticketService.entities.UserRoles;

/**
 * Converts entity attribute state of type UserRoles into database column
 * representation of type Integer and back again.
 * 
 * @author Антон
 *
 */
@Converter(autoApply = true)
public class UserRolesConverter implements AttributeConverter<UserRoles, Integer> {

	private static final UserRoles[] roles = UserRoles.values();

	@Override
	public Integer convertToDatabaseColumn(UserRoles attribute) {
		return attribute == null ? null : attribute.getId();
	}

	@Override
	public UserRoles convertToEntityAttribute(Integer dbData) {
		return dbData == null ? null : roles[dbData.intValue() + 1];
	}

}
