<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>ATMs Monitoring System</title>
    <!-- Latest compiled and minified CSS -->
  		 <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  
    <!-- style.css -->
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/style.css">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  
    <!-- <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="col-md-8">
				<h3>ATMMON</h3>
			</div>
			<div class="col-md-4">
				<h3>News:..</h3>
			</div>
        </div>
    </nav> -->
   
	
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-sm-8 col-md-4 col-md-offset-4 login">
						<center><img src="./resources/img/logo.png" class="img-responsive" width="200px"/></center>
						<h2 style="text-align: center">
							Login & Monitor ATMs</h2>
							<p style="color:red;">${errorMessage}</p>
						<form class="form" action="login" id="frm" method="post">
						  <div class="form-group">
							<label class="sr-only" for="email">Username or Email:</label>
							
							<input type="text" id="username" name="username" placeholder="&#xf007;  Username or Email" required>
							
						  </div>
						  
						   <div class="form-group">
							<label class="sr-only" for="password">Password:</label>
							
							<input type="password" id="password" name="password" placeholder="&#xf129;  Password" required>
							
						  </div>
						  
						  <center><input type="submit" value="Login" class="btn btn-success btn-lg"></a></center>
						</form>
					
				</div>
				
		</div>
	</div>
	<footer style="background: #2e2e2e;color: #fff;border-top: none;">
		<p class="text-center">Copyright © 2017, BOSACH Technologies & Consulting Pvt. Ltd. All Rights Reserved.</p>
	</footer>
	
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="js/bootstrap.min.js"></script>
   
</body>
</html>
