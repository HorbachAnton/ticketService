package by.sam.horbach.ticketService.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface Constants {

	public static final String REDIRECT_PREFIX = "redirect:";
	public static final String PASSWORD_REGEX = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
	public static final Path USER_PROFILE_ICONS_PATH = Paths.get("resources\\img\\profile_icons");

}
