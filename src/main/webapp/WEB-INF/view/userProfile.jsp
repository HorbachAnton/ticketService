<%@ page contentType="text/html;charset=UTF-8" language="java"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
				<html>
					<head>
						<head-tag:addCssAndScripts/>
					</head>
					<body>
						<c:set var = "enabled" scope = "session" value = "${userDTO.enabled}"/>
						<header>
							<div class="container-fluid border border-dark">
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
							<div class="container-fluid">
								<div class="row">
									<div class="col-xl-2"></div>
									<div class="col-xl-8  border border-dark rounded">
										<div class="container-fluid text-center">
											<figure class="figure">
												<img src="<c:url value="/resources/img/icon_profile_not_found.png" />" class="border border-dark rounded"/>
												<figcaption class="figure-caption text-center">
													<h3>Почтовый ящик: ${userDTO.email}</h3>
												</figcaption>
												<figcaption class="figure-caption text-center">
													<h2>Имя: ${userDTO.name} &nbsp; Фамилия: ${userDTO.surname}</h2>
												</figcaption>
												<figcaption class="figure-caption text-center">
													<h2>Учётная запись: <c:out value="${enabled eq true ? 'Активирована' : 'Не активирована'}" /></h2>
												</figcaption>
											</figure>
										</div>
										<div class="container-fluid text-center">
											<button type="button" class="btn btn-primary text-center">Сменить пароль</button>
											<button type="button" class="btn btn-primary text-center">Сменить имя и фамилию</button>
											<button type="button" class="btn btn-primary text-center">Сменить почтовый ящик</button>
										</div>
									</div>
									<div class="col-xl-2"></div>
								</div>
							</div>
						</body>
					</html>
