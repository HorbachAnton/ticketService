<%@ page contentType="text/html;charset=UTF-8" language="java"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
			<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
					<%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
						<html>
							<head>
								<head-tag:addCssAndScripts/>
							</head>
							<body>
								<c:url value="/resources/img/profile_icons/icon_profile_not_found.png" var="icon_profile_not_found"/>
								<c:url value="${userDTO.iconPath}" var="icon_profile_path"/>
								<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
								<c:set var="enabled" scope="session" value="${userDTO.enabled}"/>
								<c:set var="iconPath" scope="session" value="${empty icon_profile_path ? icon_profile_not_found : icon_profile_path}"/>

								<spring:message code="header.a.main_page" var="main_page"/>
								<spring:message code="header.button.english_locale" var="english_locale"/>
								<spring:message code="header.button.russian_locale" var="russian_locale"/>
								<spring:message code="header.input.message" var="message"/>
								<spring:message code="header.input.authorization" var="authorization"/>
								<spring:message code="header.input.registration" var="registration"/>
								<spring:message code="header.input.logout" var="logout"/>
								<spring:message code="header.input.user_profile" var="user_profile"/>
								<spring:message code="user_profile.h3.email" var="email"/>
								<spring:message code="user_profile.h2.name" var="name"/>
								<spring:message code="user_profile.h2.surname" var="surname"/>
								<spring:message code="user_profile.h2.account" var="account"/>
								<spring:message code="user_profile.h2.account_enabled" var="account_enabled"/>
								<spring:message code="user_profile.h2.account_disabled" var="account_disabled"/>
								<spring:message code="user_profile.button.change_password" var="change_password"/>
								<spring:message code="user_profile.button.change_personal_data" var="change_personal_data"/>
								<spring:message code="user_profile.button.loadIcon" var="loadIcon"/>
								<spring:message code="footer.div.rights" var="rights"/>

								<header>
									<div class="container-fluid">
										<div class="row d-flex align-items-center">
											<div class="col-md-4 d-flex justify-content-around">
												<div class="container">
													<p>
														<a href="${contextPath}/"><c:out value="${main_page}"/></a>
													</p>
												</div>
												<div class="container">
													<a href="?lang=en_EN">
														<button class="btn btn-primary" type="submit">${english_locale}</button>
													</a>
													<a href="?lang=ru_RU">
														<button class="btn btn-primary" type="submit">${russian_locale}</button>
													</a>
												</div>
											</div>
											<div class="col-xl-4">
												<img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
											</div>
											<div class="col-xl-4 d-flex justify-content-end">
												<sec:authorize access="!isAuthenticated()">
													<form:form method="GET" action="authorization">
														<input class="btn btn-primary" type="submit" value="${authorization}"/>
													</form:form>
													<form:form method="GET" action="registration">
														<input class="btn btn-primary" type="submit" value="${registration}"/>
													</form:form>
												</sec:authorize>
												<sec:authorize access="isAuthenticated()">
													<form:form method="POST" action="logout">
														<input class="btn btn-primary" type="submit" value="${logout}"/>
													</form:form>
													<form:form method="GET" action="user_profile">
														<input class="btn btn-primary" type="submit" value="${user_profile}"/>
													</form:form>
												</sec:authorize>
											</div>
										</div>
									</div>
								</header>
								<body>

									<div class="container-fluid user_profile_container">
										<div class="row">
											<div class="col-xl-2"></div>
											<div class="col-xl-8  border border-dark rounded">
												<div class="container-fluid text-center">
													<figure class="figure">
														<img src="${iconPath}" class="border border-dark rounded"/>
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
														<input class="btn btn-primary" type="submit" value="${change_password}"/>
													</form:form>
													<form:form method="GET" action="change_personal_data_page">
														<input class="btn btn-primary" type="submit" value="${change_personal_data}"/>
													</form:form>
													<form:form method="GET" action="load_user_icon_page">
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
