<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="head-tag" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <head-tag:addCssAndScripts />
</head>
<body>
	<header>
		<div class="container-fluid">
			<div class="row d-flex align-items-center">
				<div class="col-md-4 d-flex justify-content-around">
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
					<img src="<c:url value="/resources/img/logo.png" />"
						class="img-fluid rounded mx-auto d-block" alt="logo" />
				</div>
				<div class="col-xl-4">
					<input class="btn btn-primary" type="button" value="Input" />
					<form class="form-inline">
						<input class="form-control" type="search" placeholder="Search"
							aria-label="Search" />
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</div>
	</header>
	<div class="main-place container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<form:form class="col-md-4" method="POST" action="register"
				modelAttribute="user">
				<div class="form-group">
					<form:label path="email" for="exampleInputEmail1">Email address</form:label>
					<form:input path="email" type="email" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp"
						placeholder="Enter email" />
					<small id="emailHelp" class="form-text text-muted">We'll
						never share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<form:label path="password" for="exampleInputPassword1">Password</form:label>
					<form:input path="password" type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password" />
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1" />
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<button type="submit" class="btn btn-primary">Log in</button>
			</form:form>
			<div class="col-md-4"></div>
		</div>
	</div>
	<footer>
		<div class="container-fluid">
			<div class="row flex-d justify-content-center">All rights
				reserved.</div>
		</div>
	</footer>
</body>
</html>
