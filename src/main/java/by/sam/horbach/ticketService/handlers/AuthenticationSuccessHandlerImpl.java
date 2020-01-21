package by.sam.horbach.ticketService.handlers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private static final String RESPONSE_COMMITTED_MESSAGE = "Response has already been committed. Unable to redirect to %s";

	private static final String CONSUMER_AUTHORITY = "CONSUMER";
	private static final String ADMINISTRATOR_AUTHORITY = "ADMINISTRATOR";

	private static final String INDEX_PAGE_URL = "/";
	private static final String ADMIN_PAGE_URL = "/admin_page";

	public static final Logger LOGGER = LogManager.getLogger(AuthenticationSuccessHandlerImpl.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			LOGGER.debug(RESPONSE_COMMITTED_MESSAGE, targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		boolean isConsumer = false;
		boolean isAdministrator = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals(CONSUMER_AUTHORITY)) {
				isConsumer = true;
				break;
			} else if (grantedAuthority.getAuthority().equals(ADMINISTRATOR_AUTHORITY)) {
				isAdministrator = true;
				break;
			}
		}

		if (isConsumer) {
			return INDEX_PAGE_URL;
		} else if (isAdministrator) {
			return ADMIN_PAGE_URL;
		} else {
			throw new IllegalStateException();
		}
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
