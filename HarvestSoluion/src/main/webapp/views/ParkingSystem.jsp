<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Harvest Solution</title>


<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">




<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="css/style.css">



</head>

<body id="dashbord">

	<!-- Header Start -->
	<header>

		<!-- Logo starts -->
		<div class="logo">
			<a href="#" onClick="document.location.reload(true)"><span
				class="menu-toggle hidden-xs"> <i class="fa fa-bars"></i>
			</span> <img src="./resources/img/logo.jpg" alt="logo"> </a>
		</div>
		<!-- Logo ends -->



		<!-- Mini right nav starts -->
		<div class="pull-right">
			<ul id="mini-nav" class="clearfix">
				<li class="list-box hidden-lg hidden-md hidden-sm" id="mob-nav">
					<a href="#"> <i class="fa fa-reorder"></i>
				</a>
				</li>
				<li class="list-box dropdown hidden-xs"><a href="#"
					data-toggle="modal1" data-target="#myModal2"><i
						class="fa fa-envelope"></i></a> <span
					class="info-label info-bg animated rubberBand">3+</span></li>

				<li class="list-box dropdown hidden-xs">
					<!-- <a id="drop3" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> -->
					<a href="#" data-toggle="modal1" data-target="#myModal2"> <i
						class="fa fa-bell"></i>
				</a> <span class="info-label danger-bg animated rubberBand">4</span>
					<ul class="dropdown-menu messages">
						<li class="plain">Messages</li>
						<li>
							<div class="user-pic">
								<img src="./resources/img/user4.jpg" alt="User">
							</div>
							<div class="details">
								<strong class="text-danger">Wilson</strong> <span>Lorem
									Ipsum.</span>
								<div class="progress progress-xs no-margin">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"
										style="width: 90%;"></div>
								</div>
							</div>
						</li>
						<li>
							<div class="user-pic">
								<img src="./resources/img/user4.jpg" alt="User">
							</div>
							<div class="details">
								<strong class="text-danger">Wilson</strong> <span>Lorem
									Ipsum.</span>
								<div class="progress progress-xs no-margin">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"
										style="width: 90%;"></div>
								</div>
							</div>
						</li>
					</ul>
				</li>

				<li class="list-box dropdown hidden-xs"><a id="drop3" href="#"
					role="button" class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-wechat"></i>
				</a> <span class="info-label success-bg animated rubberBand">4</span>
					<ul class="dropdown-menu messages">
						<li class="plain">Chat</li>
						<li>
							<div class="user-pic">
								<img src="./resources/img/user4.jpg" alt="User">
							</div> <!-- <div class="details"> --> <strong class="text-danger">Wilson</strong>
							<span>Lorem Ipsum.</span>
							<div class="progress progress-xs no-margin">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"
									style="width: 90%;"></div>
							</div>
		</div>
		</li>
		<li>
			<div class="user-pic"></div> 
		</li>
		</ul>
		</li>
		<li class="list-box user-profile hidden-xs"><a id="drop4"
			href="#" class="user-avtar animated rubberBand dropdown-toggle"
			data-toggle="dropdown"> <span class="user-name">Mr. xyz <i
					class="fa fa-angle-down"></i></span>
		</a>
			<ul class="dropdown-menu sm user-settings">

				<li><a href="#"> <i class="fa fa-user"></i> Mr Deepak
				</a></li>

				<li><a href="#"> <i class="fa fa-sun-o"></i> Settings
				</a></li>
				<li><a href="login.html"> <i class="fa fa-sign-out"></i>
						Logout
				</a></li>
			</ul></li>
		</ul>
		</div>
		<!-- Mini right nav ends -->

	</header>
	<!-- Header ends -->

	<!-- Left sidebar starts -->
	<aside id="sidebar">

		<!-- Menu start -->
		<div id='menu'>
			<ul>
				<li class="highlight"><a href='#'> <i
						class="fa fa-product-hunt"></i> <span>Harvest System</span>

				</a></li>
				<li>
					<!-- <a href='#'> --> <!-- Custom Search Starts -->
					<div class="custom-search hidden-xs hidden-sm">
						<input type="text" class="search-query" placeholder="Search...">
						<i class="fa fa-search"></i>
					</div> <!-- Custom Search Ends --> <!-- 						</a> -->
				</li>
				<li style="margin-bottom: 20px;"><a href='#'> <i
						class="fa fa-male" style="font-size: 80px;"></i> <span
						style="margin-left: 60px;">Mike </span>
						<div class="selectwrap">
							<div class="input-group">

								<select class="form-control1">
									<option><span><span
											style="color: #008000 !important;">&#xf111;</span> Available</span></option>

								</select>

							</div>
						</div>





				</a></li>
				<li class="highlight" style="margin-top: 50px;"><a href='#'
					onClick="document.location.reload(true)"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span> <span
						class="current-page"></span>
				</a></li>
				<!-- <li>
						<a href='#'>
							<i class="fa fa-area-chart"></i>
							<span>Charts</span>
						</a>
					</li> -->

<li class='has-sub'><a href='#'> <i class="fa fa-pie-chart"></i>
						<span>Administrator</span>

				</a>
					<ul>
						
						<li><a href='#' onclick="gotolink('getAdminUser')"> <i
								class="fa fa-user"></i> <span>Admin User</span>
						</a></li>

						<li><a href='#' onclick="gotolink('getCustomerr')"> <i
								class="fa fa-tags"></i> <span>Customer</span>
						</a></li>

					
						
						
						<li><a href='#' onclick="gotolink('getRateSlab')"> <i
								class="fa fa-tags"></i> <span>Rate Slab</span>
						</a></li>

						<li><a href='#' onclick="gotolink('billingDetail')"> <i
								class="fa fa-tags"></i> <span>Billing Detail</span>
						</a></li>
						

																
			
					</ul></li>


				

				
						


			</ul>
		</div>
		<!-- Menu End -->


	</aside>
	<!-- Left sidebar ends -->

	<!-- Dashboard Wrapper starts -->
	<div class="dashboard-wrapper">

		<!-- Top Bar starts -->
		<div class="top-bar">
			<div class="page-title">Dashboard / My Dashboard</div>

		</div>
		<!-- Top Bar ends -->

		<!-- Main Container starts -->
		<div class="main-container" id="getAjaxdataDiv">

		

   
<div class="col-xs-12 col-sm-12 sidebar-offcanvas">
									
				<div id="getAjaxdataDiv1"></div>

									
						
</div>       
      
						


						
				








		</div>
		<!-- Dashboard Wrapper ends -->
		<footer>
			<p class="text-center">Copyright © 2018, FI-SM Pvt. Ltd. All Rights Reserved.</p>
		</footer>

		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-ui-v1.10.3.js" />"></script>
		<script src="<c:url value="/resources/js/main.js" />"></script>
		<script src="<c:url value="/resources/js/parkingjs.js" />"></script>
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">

					<div class="modal-body">
						<img src="./resources/img/graph.png" class="img-responsive" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>


			<script type="text/javascript">
			$(document).ready(function() {

				gotolink12('parkingIN');

			});

			function gotolink12(action) {

				hideNMSMessages();
				$('.loader').show();
				$('#loader-overlay').show();
				var data = new FormData();
				
				$.ajax({
					type : "POST",
					url : action + ".c",
					data : data,
					cache : false,
					contentType : false,
					processData : false,
					async : true,
					success : function(result) {

						$("#getAjaxdataDiv1").html(result);
						$('.loader').hide();
						$('.loader-overlay').hide();

					},
					error : function(result) {
						$('.loader').hide();
						$('.loader-overlay').hide();
						$('#errorRedirectfrm').submit();
					}
				});
			}
		</script>
</body>
</html>