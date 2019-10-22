<html>
  <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
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
            <img src="img/logo.png" class="img-fluid rounded mx-auto d-block" alt="logo"/>
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
    </header class="bg-secondary">
    <div class="main-place container-fluid">
      <div class="row">
        <div class="col-md-4"></div>
        <form class="col-md-4" method="post" action="register">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
          </div>
          <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
          <div class="col-md-4"></div>
        </div>
      </div>
      <footer>
        <div class="container-fluid">
          <div class="row flex-d justify-content-center">
            All rights reserved.
          </div>
        </div>
      </footer>
      <script type="text/javascript" src="js/bootstrap.min.js"></script>
      <script type="text/javascript" src="js/jquery-3.4.1.min"></script>
    </body>
  </html>
