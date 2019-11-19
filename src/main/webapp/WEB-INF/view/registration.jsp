<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
              <spring:message code="body.form.email_address_placeholder" var="email_address_placeholder"/>
              <spring:message code="body.form.email_address" var="email_address"/>
              <spring:message code="body.form.email_address_note" var="email_address_note"/>
              <spring:message code="body.form.password" var="password"/>
              <spring:message code="body.form.password_placeholder" var="placeholder_password"/>
              <spring:message code="body.form.registration_button" var="registration_button"/>
              <spring:message code="footer.rights" var="rights"/>

              <header>
                <div class="container-fluid">
                  <div class="row d-flex align-items-center">
                    <div class="col-md-4 d-flex justify-content-around">
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
                      <form:form method="GET" action="authorization">
                        <input class="btn btn-primary" type="submit" value="${button_authorization}"/>
                      </form:form>
                    </div>
                  </div>
                </div>
              </header>
              <div class="container-fluid form-container">
                <div class="row">
                  <div class="col-md-4"></div>
                  <form:form class="col-md-4 border border-dark rounded" method="POST" action="register" modelAttribute="userDTO">
                    <div class="form-group">
                      <form:label path="email" for="exampleInputEmail1">${email_address}</form:label>
                      <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${email_address_placeholder}"/>
                      <form:errors path="email" CssClass="error"/>
                      <small id="emailHelp" class="form-text text-muted">${email_address_note}</small>
                    </div>
                    <div class="form-group">
                      <form:label path="password" for="exampleInputPassword1">${password}</form:label>
                      <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="${placeholder_password}"/>
                      <form:errors path="password" CssClass="error"/>
                    </div>
                    <button type="submit" class="btn btn-primary">${registration_button}</button>
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
