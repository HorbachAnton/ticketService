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
                <spring:message code="header.input.authorization" var="authorization_hd"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="load_profile_icon.label.select_image" var="select_image"/>
                <spring:message code="load_profile_icon.button.download_image" var="download_image"/>
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
                <div class="main-place container-fluid form-container">
                  <div class="row">
                    <div class="col-md-4"></div>
                    <form:form class="col-md-4 border border-dark rounded" method="POST" action="upload_file?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" modelAttribute="fileUploadDTO">
                      <div class="form-group">
                        <h2>${select_image}</h2>
                        <div class="custom-file">
                          <form:input path="file" type="file" class="custom-file-input" id="customFile" required="required"/>
                          <form:label path="file" class="custom-file-label" for="customFile">Choose file</form:label>
                        </div>
                        <form:errors path="file" CssClass="error"/>
                      </div>
                      <button type="submit" class="btn btn-primary">${download_image}</button>
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
