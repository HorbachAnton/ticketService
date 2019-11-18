<%@ page contentType="text/html;charset=UTF-8" language="java"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				<%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
					<html>
						<head>
							<head-tag:addCssAndScripts/>
						</head>
						<body>
							<c:set var="enabled" scope="session" value="${userDTO.enabled}"/>
							<spring:message code="header.link_main_page" var="link_main_page"/>
							<spring:message code="header.link_news_page" var="link_news_page"/>
							<spring:message code="header.link_poster_page" var="link_poster_page"/>
							<spring:message code="header.link_rating_page" var="link_rating_page"/>
							<spring:message code="header.button_message" var="button_message"/>
							<spring:message code="body.user_profile.email" var="email"/>
							<spring:message code="body.user_profile.name" var="name"/>
							<spring:message code="body.user_profile.surname" var="surname"/>
							<spring:message code="body.user_profile.account" var="account"/>
							<spring:message code="body.user_profile.account_enabled" var="account_enabled"/>
							<spring:message code="body.user_profile.account_disabled" var="body.user_profile.account_disabled"/>
							<spring:message code="body.user_profile.change_password_button" var="change_password_button"/>
							<spring:message code="body.user_profile.change_personal_data_button" var="change_personal_data_button"/>
							<spring:message code="body.user_profile.loadIcon" var="loadIcon"/>
							<spring:message code="footer.rights" var="rights"/>

							<header>
								<div class="container-fluid border border-dark">
									<div class="row d-flex align-items-center">
										<div class="col-xl-4 d-flex justify-content-around">
											<p>
												<a href="#">${link_main_page}</a>
											</p>
											<p>
												<a href="#">${link_news_page}</a>
											</p>
											<p>
												<a href="#">${link_poster_page}</a>
											</p>
											<p>
												<a href="#">${link_rating_page}</a>
											</p>
										</div>
										<div class="col-xl-4">
											<img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
										</div>
										<div class="col-xl-4">
											<form class="form-inline">
												<input class="form-control" type="search" placeholder="${button_message}" aria-label="${button_message}"/>
												<button class="btn btn-outline-success" type="submit">${button_message}</button>
											</form>
										</div>
									</div>
								</div>
							</header>
							<body>
								<div class="container-fluid form-container">
									<div class="row">
										<div class="col-xl-2"></div>
										<div class="col-xl-8  border border-dark rounded">
											<div class="container-fluid text-center">
												<figure class="figure">
													<img src="<c:url value="/resources/img/icon_profile_not_found.png" />" class="border border-dark rounded"/>
													<figcaption class="figure-caption text-center">
														<h3>${email} ${userDTO.email}</h3>
													</figcaption>
													<figcaption class="figure-caption text-center">
														<h2>${name} ${userDTO.name} &nbsp; ${surname} ${userDTO.surname}</h2>
													</figcaption>
													<figcaption class="figure-caption text-center">
														<h2>${account}
															<c:out value="${enabled eq true ? account_enabled : account_disabled}"/></h2>
													</figcaption>
												</figure>
											</div>
											<div class="container-fluid d-flex justify-content-center form_buttons">
												<form:form method="GET" action="change_password_page">
													<input class="btn btn-primary" type="submit" value="${change_password_button}"/>
												</form:form>
												<form:form method="GET" action="change_perdonal_data_page">
													<input class="btn btn-primary" type="submit" value="${change_personal_data_button}"/>
												</form:form>
												<form:form method="GET" action="load_page">
													<input class="btn btn-primary" type="submit" value="${loadIcon}"/>
												</form:form>
											</div>
										</div>
										<div class="col-xl-2"></div>
									</div>
								</div>
							</body>
							<footer class="footer d-flex align-items-center">
								<div class="container">
									<div class="row flex-d justify-content-center">${rights}</div>
								</div>
							</footer>
						</html>
