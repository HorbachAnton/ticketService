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
