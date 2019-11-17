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
              <spring:message code="header.link_main_page" var="link_main_page"/>
              <spring:message code="header.link_news_page" var="link_news_page"/>
              <spring:message code="header.link_poster_page" var="link_poster_page"/>
              <spring:message code="header.link_rating_page" var="link_rating_page"/>
              <spring:message code="header.button_message" var="button_message"/>
              <spring:message code="body.form.email_address" var="email_address"/>
              <spring:message code="body.form.email_address_placeholder" var="email_address_placeholder"/>
              <spring:message code="body.form.email_address_note" var="email_address_note"/>
              <spring:message code="body.form.password" var="form.password"/>
              <spring:message code="body.form.password_placeholder" var="password_placeholder"/>
              <spring:message code="body.form.checkbox.remember_me" var="remember_me"/>
              <spring:message code="body.form.authorization_button" var="authorization_button"/>
              <spring:message code="footer.rights" var="rights"/>

              <header>
                <div class="container-fluid">
                  <div class="row d-flex align-items-center">
                    <div class="col-md-4 d-flex justify-content-around">
                      <p>
                        <a href="#"><c:out value="${link_main_page}"/></a>
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
              <div class="main-place container-fluid form-container">
                <div class="row">
                  <div class="col-md-4"></div>
                  <form:form class="col-md-4 border border-dark rounded" method="POST" action="login">
                    <div class="form-group">
                      <label for="exampleInputEmail1">${email_address}</label>
                      <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${email_address_placeholder}"/>
                      <small id="emailHelp" class="form-text text-muted">${email_address_note}</small>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">${password}</label>
                      <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="${password_placeholder}"/>
                    </div>
                    <div class="form-group form-check">
                      <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
                      <label class="form-check-label" for="exampleCheck1">${remember_me}</label>
                    </div>
                    <button type="submit" class="btn btn-primary">${authorization_button}</button>
                  </form:form>
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
