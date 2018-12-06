<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>success</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/master.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<style>

.jumbotron{
  background: #000000;
  color: white;
  a{
    text-decoration: none;
  }
}

</style>
  </head>
  <body class="container">
<div class="jumbotron">
  <h1>Thanks ,For Using My Bot :D </h1>
  <p>
    <strong>Your Direct Downlaod Links Is  </strong>
  </p>
<div class="row">
  <div class="col-md-4 col-auto">
    <button type="button" name="button" class="btn btn-success btn-lg">
      <span class="fab fa-telegram fa-lg">
        <a style='text-decoration: none;'href="http://t.me/MovieSherif" class="text-white"><strong>Contact Me</strong></a>
      </span>
    </button>
  </div>

  <div class="col-md-4 col-auto">
    <button type="button" name="button" class="btn btn-primary btn-lg">
      <span class="fas fa-download fa-lg">

        <?php
        $uip = $_SERVER["REMOTE_ADDR"];

        $directlink=$_SERVER['REQUEST_URI'];
        $downloadlink=explode('?',$directlink);
        $downloadlink=$downloadlink[1];
        $downloadlink=str_replace("{!!}",$uip,$downloadlink);

        echo '<a class="text-white" href="'.$downloadlink.'?mime=true">Direct Download</a>';
        ?>

      </span>
    </button>
  </div>
</div>
</div>


<hr>
<div class="COPYRIGHT">
  <p>
    COPYRIGHT 2018 - Founder Of <a href="t.me/watchmoviebot">@Watchmoviebot</a>

  </p>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
