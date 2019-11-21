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
                <spring:message code="header.link_main_page" var="link_main_page"/>
                <spring:message code="header.link_news_page" var="link_news_page"/>
                <spring:message code="header.link_poster_page" var="link_poster_page"/>
                <spring:message code="header.link_rating_page" var="link_rating_page"/>
                <spring:message code="header.button_message" var="button_message"/>
                <spring:message code="header.button_authorization" var="button_authorization"/>
                <spring:message code="header.button_registration" var="button_registration"/>
                <spring:message code="body.form.name" var="name"/>
                <spring:message code="body.form.name_placeholder" var="name_placeholder"/>
                <spring:message code="body.form.surname" var="surname"/>
                <spring:message code="body.form.surname_placeholder" var="surname_placeholder"/>
                <spring:message code="body.form.change_password_button" var="change_password_button"/>
                <spring:message code="footer.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-md-4 d-flex justify-content-around">
                        <p>
                          <a href="welcome"><c:out value="${link_main_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${link_news_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${link_poster_page}"/></a>
                        </p>
                        <p>
                          <a href="#"><c:out value="${link_rating_page}"/></a>
                        </p>
                        <a href="?lang=en_EN">
                          <button class="btn btn-primary" type="submit">ENG</button>
                        </a>
                        <a href="?lang=ru_RU">
                          <button class="btn btn-primary" type="submit">RUS</button>
                        </a>
                      </div>
                      <div class="col-xl-4">
                        <img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
                      </div>
                      <div class="col-xl-4 d-flex justify-content-end">
                        <form class="form-inline">
                          <input class="form-control" type="search" placeholder="${button_message}" aria-label="${button_message}"/>
                          <button class="btn btn-outline-success" type="submit">${button_message}</button>
                        </form>
                        <sec:authorize access="!isAuthenticated()">
                          <form:form method="GET" action="authorization">
                            <input class="btn btn-primary" type="submit" value="${button_authorization}"/>
                          </form:form>
                          <form:form method="GET" action="registration">
                            <input class="btn btn-primary" type="submit" value="${button_registration}"/>
                          </form:form>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                          <form:form method="POST" action="logout">
                            <input class="btn btn-primary" type="submit" value="Log out"/>
                          </form:form>
                        </sec:authorize>
                      </div>
                    </div>
                  </div>
                </header>
                <div class="main-place container-fluid form-container">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <form:form class="col-md-4 border border-dark rounded" method="POST" action="change_personal_data" modelAttribute="personalDataDTO">
                      <div class="form-group">
                        <form:label path="name" for="name">${name}</form:label>
                        <form:input path="name" type="text" class="form-control" placeholder="${name_placeholder}" name="name"/>
                      </div>
                      <div class="form-group">
                        <form:label path="surname" for="surname">${surname}</form:label>
                        <form:input path="surname" type="text" class="form-control" placeholder="${surname_placeholder}" name="surname"/>
                      </div>
                      <button type="submit" class="btn btn-primary">${change_password_button}</button>
                    </form:form>
                    <div class="col-md-4"></div>
                  </div>
                </div>
              </body>
              <footer class="footer d-flex align-items-center">
                <div class="container">
                  <div class="row flex-d justify-content-center">${rights}</div>
                </div>
              </footer>
            </html>
