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
                <c:url value="/resources/img/user_center/user_center_icon.png" var="user_center_icon"/>
                <c:url value="/resources/img/event_center/event_center_icon.png" var="event_center_icon"/>
                <c:url value="/resources/img/ticket_center/ticket_center_icon.png" var="ticket_center_icon"/>
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <spring:message code="header.a.admin_page" var="admin_page"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization_hd"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="admin_page.input.event_center" var="event_center"/>
                <spring:message code="admin_page.input.ticket_center" var="ticket_center"/>
                <spring:message code="admin_page.h3.event_center_summary" var="event_center_summary"/>
                <spring:message code="admin_page.h3.ticket_center_summary" var="ticket_center_summary"/>
                <spring:message code="footer.div.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-md-4 d-flex justify-content-around">
                        <div class="container">
                          <p>
                            <a href="${contextPath}/admin_page"><c:out value="${admin_page}"/></a>
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

                <div class="container-fluid user_profile_container">
                  <div class="row">
                    <div class="col-xl-6 border border-dark rounded">
                      <div class="container-fluid text-center">
                        <figure class="figure">
                          <img src="${event_center_icon}" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">
                            <h3>${event_center_summary}</h3>
                          </figcaption>
                        </figure>
                      </div>
                      <div class="container-fluid d-flex justify-content-center form_buttons">
                        <form:form method="GET" action="event_center_page">
                          <input class="btn btn-primary" type="submit" value="${event_center}"/>
                        </form:form>
                      </div>
                    </div>
                    <div class="col-xl-6 border border-dark rounded">
                      <div class="container-fluid text-center">
                        <figure class="figure">
                          <img src="${ticket_center_icon}" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">
                            <h3>${ticket_center_summary}</h3>
                          </figcaption>
                        </figure>
                      </div>
                      <div class="container-fluid d-flex justify-content-center form_buttons">
                        <form:form method="GET" action="ticket_center_page">
                          <input class="btn btn-primary" type="submit" value="${ticket_center}"/>
                        </form:form>
                      </div>
                    </div>
                  </div>
                </div>

                <footer class="footer d-flex align-items-center">
                  <div class="container-fluid">
                    <div class="row flex-d justify-content-center">${rights}</div>
                  </div>
                </footer>
              </body>
            </html>
