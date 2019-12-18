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
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <c:set var="eventId" value="${eventDTO.getId()}"/>
                <spring:message code="header.a.main_page" var="main_page"/>
                <spring:message code="header.a.news_page" var="news_page"/>
                <spring:message code="header.a.poster_page" var="poster_page"/>
                <spring:message code="header.a.rating_page" var="rating_page"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization_hd"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="admin_event.h4.id" var="id"/>
                <spring:message code="admin_event.h4.title" var="title"/>
                <spring:message code="admin_event.h4.summary" var="summary"/>
                <spring:message code="admin_event.h4.date" var="date"/>
                <spring:message code="admin_event.h4.location_id" var="location_id"/>
                <spring:message code="admin_event.h4.location_title" var="location_title"/>
                <spring:message code="admin_event.h4.price" var="price"/>
                <spring:message code="admin_event.h4.iconPath" var="iconPath"/>
                <spring:message code="admin_event.label.date" var="label_date"/>
                <spring:message code="admin_event.label.iconPath" var="label_iconPath"/>
                <spring:message code="admin_event.button.change_event_details" var="change_event_details"/>
                <spring:message code="footer.div.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-md-4 d-flex justify-content-around">
                        <p>
                          <a href="${contextPath}/"><c:out value="${main_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${news_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${poster_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${rating_page}"/></a>
                        </p>
                        <a href="?eventId=${eventId}&lang=en_EN">
                          <button class="btn btn-primary" type="submit">${english_locale}</button>
                        </a>
                        <a href="?eventId=${eventId}&lang=ru_RU">
                          <button class="btn btn-primary" type="submit">${russian_locale}</button>
                        </a>
                      </div>
                      <div class="col-xl-4">
                        <img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
                      </div>
                      <div class="col-xl-4 d-flex justify-content-end">
                        <form class="form-inline">
                          <input class="form-control " type="search" placeholder="${message}" aria-label="${message}"/>
                          <button class="btn btn-outline-success" type="submit">${message}</button>
                        </form>
                        <sec:authorize access="!isAuthenticated()">
                          <form:form method="GET" action="authorization">
                            <input class="btn btn-primary" type="submit" value="${authorization_hd}"/>
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

                <div class="main-place container-fluid admin_event_details_contailner">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4 border border-dark rounded">
                      <div class="container-fluid text-center">
                        <figure class="figure">
                          <img src="<c:url value="${eventDTO.getIconPath().toString()}"/>"/>
                          <form:form action="change_event_details" method="POST" modelAttribute="eventDTO">
                            <figcaption class="text-center">
                              <h4>${id} : ${eventId}</h4>
                              <form:input path="id" type="hidden" class="form-control" value="${eventId}" required="required"/>
                              <form:errors path="id" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${title}</h4>
                              <form:input path="title" type="text" class="form-control" value="${eventDTO.getTitle()}" maxlength="45" required="required"/>
                              <form:errors path="title" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${summary}</h4>
                              <form:input path="summary" type="text" class="form-control" value="${eventDTO.getSummary()}" maxlength="400" required="required"/>
                              <form:errors path="summary" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${date}</h4>
                              <form:label path="date">${label_date}</form:label>
                              <form:input
                                path="date"
                                type="text"
                                class="form-control"
                                value="${eventDTO.getDate()}"
                                pattern="^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))T(20|21|22|23|[01]\d|\d)((:[0-5]\d){1,2})((:[0-5]\d){1,2})$"
                                required="required"/>
                              <form:errors path="date" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${location_id} : ${eventDTO.getLocation().getId()}</h4>
                              <form:input path="location.id" type="hidden" class="form-control" value="${eventDTO.getLocation().getId()}" required="required"/>
                              <form:errors path="location.id" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${location_title}</h4>
                              <form:input path="location.title" type="text" class="form-control" value="${eventDTO.getLocation().getTitle()}" maxlength="45" required="required"/>
                              <form:errors path="location.title" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${price}</h4>
                              <form:input path="price" type="text" class="form-control" value="${eventDTO.getPrice()}" pattern="^\d+$" required="required"/>
                              <form:errors path="price" CssClass="error"/>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${iconPath}</h4>
                              <form:label path="date">${label_iconPath}</form:label>
                              <form:input path="iconPath" type="text" class="form-control" value="${eventDTO.getIconPath().toString()}" maxlength="100" pattern="^(\S*/)*(\S*)\.png$" required="required"/>
                              <form:errors path="iconPath" CssClass="error"/>
                            </figcaption>
                            <button type="submit" class="btn btn-primary">${change_event_details}</button>
                          </form:form>
                        </figure>
                      </div>
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                </div>

                <footer class="footer d-flex align-items-center">
                  <div class="container-fluid">
                    <div class="row flex-d justify-content-center">${rights}</div>
                  </div>
                </footer>
              </body>
            </html>
