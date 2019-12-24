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
                <spring:message code="header.a.main_page" var="main_page"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="change_password.label.password" var="password_lb"/>
                <spring:message code="change_password.placeholder.password" var="password_ph"/>
                <spring:message code="change_password.label.password_confirm" var="password_confirm_lb"/>
                <spring:message code="change_password.placeholder.password_confirm" var="password_confirm_ph"/>
                <spring:message code="change_password.button.change_password" var="change_password"/>
                <spring:message code="footer.div.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-xl-4 d-flex justify-content-around">
                        <div class="container">
                          <p>
                            <a href="${contextPath}/">${main_page}</a>
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
                <div class="main-place container-fluid form-container">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <form:form class="col-md-4 border border-dark rounded" method="POST" action="change_password" modelAttribute="passwordDTO" oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>
                      <div class="form-group">
                        <form:label path="password" for="password">${password_lb}</form:label>
                        <form:input path="password" type="password" class="form-control" id="password" placeholder="${password_ph}" name="password" required="required"/>
                        <form:errors path="password" CssClass="error"/>
                      </div>
                      <div class="form-group">
                        <form:label path="confirmPassword" for="confirmPassword">${password_confirm_lb}</form:label>
                        <form:input path="confirmPassword" type="password" class="form-control" placeholder="${password_confirm_ph}" id="confirmPassword" name="confirmPassword" required="required"/>
                        <form:errors path="confirmPassword" CssClass="error"/>
                      </div>
                      <button type="submit" class="btn btn-primary">${change_password}</button>
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
