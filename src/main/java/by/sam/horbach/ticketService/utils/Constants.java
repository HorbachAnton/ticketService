package by.sam.horbach.ticketService.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public interface Constants {

	public static final String REDIRECT_PREFIX = "redirect:";
	public static final String PASSWORD_REGEX = "^(?=\\P{Ll}*\\p{Ll})(?=\\P{Lu}*\\p{Lu})(?=\\P{N}*\\p{N})(?=[\\p{L}\\p{N}]*[^\\p{L}\\p{N}])[\\s\\S]{8,}$";

	public static final Path USER_PROFILE_ICONS_PATH = Paths.get("resources/img/profile_icons");
	public static final ServletContext SERVLET_CONTEXT = ((ServletRequestAttributes) RequestContextHolder
			.getRequestAttributes()).getRequest().getServletContext();

}
