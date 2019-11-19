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
              <spring:message code="header.button_authorization" var="button_authorization"/>
              <spring:message code="header.button_registration" var="button_registration"/>
              <spring:message code="body.welcome.news" var="news"/>
              <spring:message code="body.welcome.button_read_news" var="button_read_news"/>
              <spring:message code="body.welcome.upcoming_events" var="upcoming_events"/>
              <spring:message code="body.welcome.upcoming_events.button" var="button"/>
              <spring:message code="body.welcome.recent_commnets" var="recent_commnets"/>
              <spring:message code="body.welcome.button_read_recent_comments" var="button_read_recent_comments"/>
              <spring:message code="footer.rights" var="rights"/>

              <header>
                <div class="container-fluid">
                  <div class="row d-flex align-items-center">
                    <div class="col-xl-4 d-flex justify-content-around">
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
                    <div class="col-xl-4 d-flex justify-content-end">
                      <form class="form-inline">
                        <input class="form-control" type="search" placeholder="${button_message}" aria-label="${button_message}"/>
                        <button class="btn btn-outline-success" type="submit">${button_message}</button>
                      </form>
                      <form:form method="GET" action="authorization">
                        <input class="btn btn-primary" type="submit" value="${button_authorization}"/>
                      </form:form>
                      <form:form method="GET" action="registration">
                        <input class="btn btn-primary" type="submit" value="${button_registration}"/>
                      </form:form>
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
                        <button type="button" class="btn btn-primary">${button_read_news}</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary">Читать</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded center-block"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary">Читать</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary text-center">Читать</button>
                      </figure>
                    </div>
                  </div>
                </div>
                <div class="container-fluid border border-dark">
                  <div class="row border border-dark">
                    <div class="col-xl-12 center-block text-center">
                      <h1>${upcoming_events}</h1>
                    </div>
                  </div>
                  <div class="row border border-dark">
                    <c:forEach var="event" items="${upcomingEvents}">
                      <div class="col-xl-3 border border-dark rounded d-flex justify-content-center upcoming-events-block">
                        <figure class="figure">
                          <img src="<c:url value="${event.getIconPath()}" />" class="border border-dark rounded"/>
                          <figcaption class="figure-caption text-center"><c:out value="${event.getTitle()}"/></figcaption>
                          <figcaption class="figure-caption text-center"><c:out value="${event.getSummary()}"/></figcaption>
                          <button type="button" class="btn btn-primary">${button}</button>
                        </figure>
                      </div>
                    </c:forEach>
                  </div>
                </div>
                <div class="container-fluid border border-dark">
                  <div class="row border border-dark">
                    <div class="col-xl-12 center-block text-center">
                      <h1>${recent_commnets}</h1>
                    </div>
                  </div>
                  <div class="row border border-dark">
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary">${button_read_recent_comments}</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary">Читать</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded center-block"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary">Читать</button>
                      </figure>
                    </div>
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center">
                      <figure class="figure">
                        <img src="<c:url value="/resources/img/page_not_found.png" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center">Тестовое название</figcaption>
                        <figcaption class="figure-caption text-center">Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст</figcaption>
                        <button type="button" class="btn btn-primary text-center">Читать</button>
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
