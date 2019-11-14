<%@ page contentType="text/html;charset=UTF-8" language="java"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
        <html>
          <head>
            <head-tag:addCssAndScripts/>
          </head>
          <body>
            <header>
              <div class="container-fluid">
                <div class="row d-flex align-items-center">
                  <div class="col-xl-4 d-flex justify-content-around">
                    <p>
                      <a href="#">Главная</a>
                    </p>
                    <p>
                      <a href="#">Новости</a>
                    </p>
                    <p>
                      <a href="#">Афиша</a>
                    </p>
                    <p>
                      <a href="#">Рейтинг</a>
                    </p>
                  </div>
                  <div class="col-xl-4">
                    <img src="<c:url value="/resources/img/logo.png" />" class="img-fluid rounded mx-auto d-block" alt="logo"/>
                  </div>
                  <div class="col-xl-4">
                    <input class="btn btn-primary" type="button" value="Input"/>
                    <form class="form-inline">
                      <input class="form-control" type="search" placeholder="Search" aria-label="Search"/>
                      <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                  </div>
                </div>
              </div>
            </header>
            <body>
              <div class="container-fluid border border-dark">
                <div class="row border border-dark">
                  <div class="col-xl-12 center-block text-center">
                    <h1>Новости</h1>
                  </div>
                </div>
                <div class="row border border-dark">
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
                    <h1>Ближайшие мероприятия</h1>
                  </div>
                </div>
                <div class="row border border-dark">
                  <c:forEach var="event" items="${upcomingEvents}">
                    <div class="col-xl-3 border border-dark rounded d-flex justify-content-center upcoming-events-block">
                      <figure class="figure">
                        <img src="<c:url value="${event.getIconPath()}" />" class="border border-dark rounded"/>
                        <figcaption class="figure-caption text-center"><c:out value="${event.getTitle()}"/></figcaption>
                        <figcaption class="figure-caption text-center"><c:out value="${event.getSummary()}"/></figcaption>
                        <button type="button" class="btn btn-primary">Купить билет</button>
                      </figure>
                    </div>
                  </c:forEach>
                </div>
              </div>
              <div class="container-fluid border border-dark">
                <div class="row border border-dark">
                  <div class="col-xl-12 center-block text-center">
                    <h1>Недавние обзоры</h1>
                  </div>
                </div>
                <div class="row border border-dark">
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
                <div class="row flex-d justify-content-center">All rights reserved.</div>
              </div>
            </footer>
          </html>
