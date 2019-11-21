<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
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
                <spring:message code="header.a.main_page" var="main_page"/>
                <spring:message code="header.a.news_page" var="news_page"/>
                <spring:message code="header.a.poster_page" var="poster_page"/>
                <spring:message code="header.a.rating_page" var="rating_page"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="registration(authorization).label.email_address" var="email_address_lb"/>
                <spring:message code="registration(authorization).placeholder.email_address" var="email_address_ph"/>
                <spring:message code="registration(authorization).small.email_address" var="email_address_sm"/>
                <spring:message code="registration(authorization).label.password" var="password_lb"/>
                <spring:message code="registration(authorization).placeholder.password" var="password_ph"/>
                <spring:message code="registration.button.registration" var="registration"/>
                <spring:message code="footer.div.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-md-4 d-flex justify-content-around">
                        <p>
                          <a href="welcome"><c:out value="${main_page}"/></a>
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
                        <a href="?lang=en_EN">
                          <button class="btn btn-primary" type="submit">${english_locale}</button>
                        </a>
                        <a href="?lang=ru_RU">
                          <button class="btn btn-primary" type="submit">${russian_locale}</button>
                        </a>
                      </div>
                      <div class="col-xl-4">
                        <img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
                      </div>
                      <div class="col-xl-4 d-flex justify-content-end">
                        <form class="form-inline">
                          <input class="form-control" type="search" placeholder="${message}" aria-label="${message}"/>
                          <button class="btn btn-outline-success" type="submit">${message}</button>
                        </form>
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

                <div class="container-fluid form-container">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <form:form class="col-md-4 border border-dark rounded" method="POST" action="register" modelAttribute="userDTO">
                      <div class="form-group">
                        <form:label path="email" for="exampleInputEmail1">${email_address_lb}</form:label>
                        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${email_address_ph}"/>
                        <form:errors path="email" CssClass="error"/>
                        <small id="emailHelp" class="form-text text-muted">${email_address_sm}</small>
                      </div>
                      <div class="form-group">
                        <form:label path="password" for="exampleInputPassword1">${password_lb}</form:label>
                        <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="${password_ph}"/>
                        <form:errors path="password" CssClass="error"/>
                      </div>
                      <button type="submit" class="btn btn-primary">${registration}</button>
                    </form:form>
                    <div class="col-md-4"></div>
                  </div>
                </div>
                <footer class="footer d-flex align-items-center">
                  <div class="container-fluid">
                    <div class="row flex-d justify-content-center">
                      ${rights}
                    </div>
                  </div>
                </footer>
              </body>
            </html>
