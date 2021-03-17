<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/template/header.jsp"%>

</head> <!-- added -->

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src='<c:url value="/resources/images/back1.jpg" />' alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Welcome to ShortyShoes</h1>

               <p>Here you can browse and buy Different Variety Of Shoes,Order Now for
                        Your Amazing New Kit!</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="<c:url value="/resources/images/back2.jpeg" />" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>Facts You Should Know About Music</h1>

              <p>Music brings joy, to all of our hearts, It's one of those, emotional arts.</p> -->
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="<c:url value="/resources/images/back3.jpeg" />" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>It's A Jazz Affair</h1>

              <p>Through ups and downs, Somehow I manage to survive in life.</p> -->
              
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="/resources/images/Img1.jpeg" alt="Generic placeholder image" width="140" height="140">
          <h2>Running Shoes</h2>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="/resources/images/Img2.jpeg" alt="Generic placeholder image" width="140" height="140">
          <h2>Casual Shoes</h2>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="/resources/images/Img3.jpeg" width="140" height="140">
          <h2>Sport Shoes</h2>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

        <%@include file="/WEB-INF/view/template/footer.jsp" %>
        
        </div>
        