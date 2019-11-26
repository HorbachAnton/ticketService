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
                <spring:message code="welcome.h1.news" var="news"/>
                <spring:message code="welcome.button.read_news" var="read_news"/>
                <spring:message code="welcome.h1.upcoming_events" var="upcoming_events_message"/>
                <spring:message code="welcome.button.upcoming_events" var="upcoming_events_bt"/>
                <spring:message code="welcome.h1.recent_comments" var="recent_comments"/>
                <spring:message code="welcome.button.read_recent_comments" var="read_recent_comments"/>
                <spring:message code="footer.div.rights" var="rights"/>

                <header>
                  <div class="container-fluid">
                    <div class="row d-flex align-items-center">
                      <div class="col-xl-4 d-flex justify-content-around">
                        <p>
                          <a href="/ticket-service/">${main_page}</a>
                        </p>
                        <p>
                          <a href="#">${news_page}</a>
                        </p>
                        <p>
                          <a href="#">${poster_page}</a>
                        </p>
                        <p>
                          <a href="#">${rating_page}</a>
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
                <body>
                  <div class="container-fluid border border-dark">
                    <div class="row border border-dark">
                      <div class="col-xl-12 center-block text-center">
                        <h1>${news}</h1>
                      </div>
                    </div>
                    <div class="row border border-dark">
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_news}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_news}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded center-block"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_news}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary text-center">${read_news}</button>
                        </figure>
                      </div>
                    </div>
                  </div>
                  <div class="container-fluid border border-dark">
                    <div class="row border border-dark">
                      <div class="col-xl-12 center-block text-center">
                        <h1>${upcoming_events_message}</h1>
                      </div>
                    </div>
                    <div class="row border border-dark">
                      <c:forEach var="event" items="${upcomingEvents}">
                        <div class="col-xl-3 border border-dark rounded d-flex justify-content-center upcoming-events-block">
                          <figure class="figure">
                            <img src="<c:url value="${event.getIconPath()}" />" class="border border-dark rounded"/>
                            <figcaption class="figure-caption text-center"><c:out value="${event.getTitle()}"/></figcaption>
                            <figcaption class="figure-caption text-center"><c:out value="${event.getSummary()}"/></figcaption>
                            <button type="button" class="btn btn-primary">${upcoming_events_bt}</button>
                          </figure>
                        </div>
                      </c:forEach>
                    </div>
                  </div>
                  <div class="container-fluid border border-dark">
                    <div class="row border border-dark">
                      <div class="col-xl-12 center-block text-center">
                        <h1>${recent_comments}</h1>
                      </div>
                    </div>
                    <div class="row border border-dark">
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_recent_comments}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_recent_comments}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded center-block"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary">${read_recent_comments}</button>
                        </figure>
                      </div>
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                        <figure class="figure">
                          <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                          <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                          <button type="button" class="btn btn-primary text-center">${read_recent_comments}</button>
                        </figure>
                      </div>
                    </div>
                  </div>
                </body>
                <footer class="footer-welcome  d-flex align-items-center">
                  <div class="container-fluid">
                    <div class="row flex-d justify-content-center">${rights}</div>
                  </div>
                </footer>
              </html>
