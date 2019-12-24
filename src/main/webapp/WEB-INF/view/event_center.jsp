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
                <c:url value="/resources/img/user_center/user_center_icon.png" var="user_center_icon"/>
                <c:url value="/resources/img/event_center/event_center_icon.png" var="event_center_icon"/>
                <c:url value="/resources/img/ticket_center/ticket_center_icon.png" var="ticket_center_icon"/>
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <spring:message code="header.a.main_page" var="main_page"/>
                <spring:message code="header.button.english_locale" var="english_locale"/>
                <spring:message code="header.button.russian_locale" var="russian_locale"/>
                <spring:message code="header.input.message" var="message"/>
                <spring:message code="header.input.authorization" var="authorization_hd"/>
                <spring:message code="header.input.registration" var="registration"/>
                <spring:message code="header.input.logout" var="logout"/>
                <spring:message code="header.input.user_profile" var="user_profile"/>
                <spring:message code="event_center.p.id" var="id"/>
                <spring:message code="event_center.p.title" var="title"/>
                <spring:message code="event_center.p.summary" var="summary"/>
                <spring:message code="event_center.p.date" var="date"/>
                <spring:message code="event_center.p.location" var="location"/>
                <spring:message code="event_center.p.price" var="price"/>
                <spring:message code="event_center.p.icon_path" var="icon_path"/>
                <spring:message code="event_center.button.change_event_data" var="change_event_data"/>
                <spring:message code="event_center.button.delete_event" var="delete_event"/>
                <spring:message code="event_center.button.add_event" var="add_event"/>
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
                          <a href="?chosen_page=${chosen_page}&lang=en_EN">
                            <button class="btn btn-primary" type="submit">${english_locale}</button>
                          </a>
                          <a href="?chosen_page=${chosen_page}&lang=ru_RU">
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

                <div class="container-fluid user_profile_container">
                  <div class="row">
                    <div class="col-xl-12">
                      <div class="container d-flex flex-row block_events_information">
                        <div class="col-xl-1 d-flex align-items-center text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${id}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-1 d-flex align-items-center text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${title}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-2 d-flex align-items-center text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${summary}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-2 d-flex align-items-center text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${date}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-2 d-flex align-items-center text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${location}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${price}</p>
                            </div>
                          </div>
                        </div>
                        <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                          <div class="container d-flex flex-column">
                            <div class="block_attribute_event_info d-flex justify-content-center">
                              <p>${icon_path}</p>
                            </div>
                          </div>
                        </div>
                      </div>
                      <c:forEach var="eventDTO" items="${listEvents}">
                        <div class="row">
                          <div class="col-xl-12">
                            <div class="container d-flex flex-row">
                              <div class="col-xl-1 d-flex align-items-center text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getId()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-1 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getTitle()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getSummary()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getDate()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getLocation().getTitle()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getPrice()}</p>
                                  </div>
                                </div>
                              </div>
                              <div class="col-xl-2 d-flex align-items-center  text-center border border-dark">
                                <div class="container d-flex flex-column">
                                  <div class="block_attribute_event_info d-flex justify-content-center">
                                    <p>${eventDTO.getIconPath()}</p>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-xl-12">
                            <div class="container d-flex flex-row justify-content-center">
                              <form class="form_changing_buttons_block" action="admin_event">
                                <input type="hidden" name="eventId" value="${eventDTO.getId()}"/>
                                <button type="submit" class="btn btn-primary">${change_event_data}</button>
                              </form>
                              <form class="form_changing_buttons_block" action="delete_event">
                                <input type="hidden" name="event_id" value="${eventDTO.getId()}"/>
                                <button type="submit" class="btn btn-primary">${delete_event}</button>
                              </form>
                              <form class="form_changing_buttons_block" action="event_creation">
                                <button type="submit" class="btn btn-primary">${add_event}</button>
                              </form>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                    </div>
                  </div>
                </div>

                <div class="container-fluid pagination_container">
                  <div class="row">
                    <div class="col-xl-12">
                      <div class="container d-flex flex-row  justify-content-center block_pagination_pages">
                        <c:forEach begin="${1}" end="${numberOfPages}" varStatus="сounter">
                          <form class="form_button_paggination" action="get_chosen_page">
                            <input type="hidden" name="chosen_page" value="${сounter.count}"/>
                            <button type="submit" class="btn btn-primary">${сounter.count}</button>
                          </form>
                        </c:forEach>
                      </div>
                    </div>
                  </div>
                </div>

                <footer class="footer d-flex align-items-center">
                  <div class="container-fluid">
                    <div class="row flex-d justify-content-center">${rights}</div>
                  </div>
                </footer>
              </body>
            </html>
