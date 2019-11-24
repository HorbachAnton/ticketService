package by.sam.horbach.ticketService.converters;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts entity attribute state of type Path into database column
 * representation of type String and back again.
 * 
 * @author Horbach Anton
 *
 */
@Converter(autoApply = true)
public class PathConverter implements AttributeConverter<Path, String> {

	@Override
	public String convertToDatabaseColumn(Path attribute) {
		return attribute == null ? null : attribute.toString();
	}

	@Override
	public Path convertToEntityAttribute(String dbData) {
		return dbData == null ? null : Paths.get(dbData);
	}
}
