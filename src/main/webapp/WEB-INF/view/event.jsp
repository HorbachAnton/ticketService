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
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization_hd"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="event.p.title" var="title"/>
                <spring:message code="event.p.summary" var="summary"/>
                <spring:message code="event.p.date" var="date"/>
                <spring:message code="event.p.location" var="location"/>
                <spring:message code="event.p.price" var="price"/>
                <spring:message code="event.label.indicate_quantity" var="indicate_quantity"/>
                <spring:message code="event.button.buy_tickets" var="buy_tickets"/>
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
                          <a href="?eventId=${eventId}&lang=en_EN">
                            <button class="btn btn-primary" type="submit">${english_locale}</button>
                          </a>
                          <a href="?eventId=${eventId}&lang=ru_RU">
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

                <div class="main-place container-fluid event_details_contailner">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4 border border-dark rounded">
                      <div class="container-fluid text-center">
                        <h4>${title} &nbsp; ${eventDTO.getTitle()}</h4>
                        <figure class="figure">
                          <img src="<c:url value="${eventDTO.getIconPath().toString()}"/>"/>
                          <figcaption class="text-center">
                            <h4>${summary}
                              <br>
                                ${eventDTO.getSummary()}</h4>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${date} &nbsp; ${eventDTO.getDate().toLocalDate()} &nbsp; ${eventDTO.getDate().toLocalTime()}</h4>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${location} &nbsp; ${eventDTO.getLocation().getTitle()}</h4>
                            </figcaption>
                            <figcaption class="text-center">
                              <h4>${price} &nbsp; ${eventDTO.getPrice()}</h4>
                            </figcaption>
                          </figure>
                        </div>
                      </div>
                      <div class="col-md-4"></div>
                    </div>
                    <div class="row">
                      <div class="col-md-4"></div>
                      <form:form class="col-md-4 border border-dark rounded text-center" method="POST" action="buy_tickets" modelAttribute="buyTicketsDTO">
                        <div class="form-group">
                          <form:hidden path="idEvent" value="${eventId}"/>
                          <form:label path="quantity">${indicate_quantity}</form:label>
                          <form:input path="quantity" type="text" class="form-control" placeholder="0" name="name"/>
                          <form:errors path="quantity" CssClass="error"/>
                        </div>
                        <button type="submit" class="btn btn-primary">${buy_tickets}</button>
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
