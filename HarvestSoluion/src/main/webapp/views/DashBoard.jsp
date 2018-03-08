<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Dashboard</title>
    


    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/parkingcss.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/style-4g.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.3.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
     <script src="<c:url value="/resources/js/parkingjs.js" />"></script>






<script type="text/javascript">
	$(document).ready(function() {
	
		//generateChart();

	});
	
	
	function generateChart()
	{
		alert("3");
	chartType="passpercentage";
	$("#placeholder2").text("");
		
		 $.ajax({
	 			type: "GET",
								url:"http://localhost:8080/ChartDemo/GetChartDetails?jsonp="+chartType,
								dataType: 'jsonp',
								jsonpCallback: chartType, // the function to call
								error: function () {
											   alert("Error is occured");
								}
							}); 


	}
	
	
	



function passpercentage(json) {


	$(function () {
	  

	    var len=json.passpercentage.length;
	    i = 0;

	    var options = {
	         chart: {
	                type: 'column'
	        
	            },
	         credits: {
	     		 enabled: false
		  		},
	            title: {
	                text: 'Trouble Ticket Dispatch'
	             },
	            subtitle: {
	                text: 'Live Data',
	                x: -20
	            },
	          yAxis: {
	            min: 0,
	            title: {
	                text: 'ATMs'
	            }
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        xAxis: {
	            categories: []
	        },
	        series: []
	    }
	    
	

		    for (i; i <len; i++) {
		        if (i === 0) {
		            var dat = json.passpercentage[i].category,
		                lenJ = dat.length,
		                j = 0,
		                tmp;

		            for (j; j < lenJ; j++) {
		                options.xAxis.categories.push(dat[j]);
		            }
		        } else {
			            options.series.push(json.passpercentage[i]);
		        }
		    }


		$('#placeholder2').highcharts(options);

	    
	    
	});


	}

	
	
</script>


</head>
<body>
		<div class="alC">
		<c:choose>
		  <c:when test="${not empty successCode}">
		
			<div class="isa_success" id="isa_success">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_success"><s:property
						value="successCode" /></span>

			</div>
		
		 </c:when>
		   <c:otherwise>
		   
		
			<div class="isa_success" id="isa_success" style="display: none">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_success"><s:property
						value="successCode" /></span>

			</div>

		</c:otherwise>
</c:choose>
		<c:choose>
		  <c:when test="${not empty errorCode}">
			<div class="isa_error" id="isa_error">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_error"><s:property
						value="errorCode" /></span>

			</div>
		 </c:when>
		   <c:otherwise>
			<div class="isa_error" id="isa_error" style="display: none">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_error"><s:property
						value="errorCode" /></span>

			</div>
		</c:otherwise>
</c:choose>
<c:choose>
		  <c:when test="${not empty warningCode}">
		
			<div class="isa_warning" id="isa_warning">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_warning"><s:property
						value="warningCode" /></span>

			</div>
		 </c:when>
		   <c:otherwise>
			<div class="isa_warning" id="isa_warning" style="display: none">
				<a href="javascript:void(0)" class="close-msg"><img
					src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg" onclick="hideMessage()" /></a>
				<i class="fa fa-check"></i> <span id="message_placeholder_warning"><s:property
						value="warningCode" /></span>

			</div>
		</c:otherwise>
</c:choose>

	</div>
	
	<div>
	
	<div  id="nmsdataGrid"  class="userListClass">
	<a id="modalAddButton" class="btn btn-primary"
		           href="javascript:void(0)" style="display: none" data-toggle="modal" data-target="#myModal"></a>
        		
        		<a class="addTableRow btn btn-primary" href="javascript:void(0)" onclick="openGraph('graph')">ATMs TOTAL</a></td>
 
 
 
 	<a id="modalAddButton" class="btn btn-primary"
		           href="javascript:void(0)" style="display: none" data-toggle="modal" data-target="#myModal"></a>
        		
        		<a class="addTableRow btn btn-primary" href="javascript:void(0)" onclick="openGraph('graph')">OPEN</a></td>
 
	<a id="modalAddButton" class="btn btn-primary"
		           href="javascript:void(0)" style="display: none" data-toggle="modal" data-target="#myModal"></a>
        		
        		<a class="addTableRow btn btn-primary" href="javascript:void(0)" onclick="openGraph('graph2')">LOW</a></td>
    <a id="modalAddButton" class="btn btn-primary"
		           href="javascript:void(0)" style="display: none" data-toggle="modal" data-target="#myModal"></a>
        		
        		<a class="addTableRow btn btn-primary" href="javascript:void(0)" onclick="openGraph('graph3')">DOWN</a></td>
     		
 
 
 </div>
 
 
 
 
 
 <div>
<table>
		<tr>
				<td align="center">
				<div id="outerDiv" >
				<div  id="placeholder2"></div>
				</div>
				 </td>
		 </tr>
</table>
</div>
 
 
 
 
 
 <div id="nmsdataGrid" class="userListClass">
		<div class="title1"><h4>ATM Request Messages</h4></div>
		<table id="userListTable" class="display" cellspacing="0" width="100%" >
			<thead align="center">
				<tr>
				<th width="3%">Sr No</th>
                <th width="4%">TERMID</th>
                <th width="4%">MSGLEN</th>
                <th width="4%">MSGTYPE</th>
                <th width="4%">MSGXDATE</th>
                <th width="4%">MSGXTIME</th>
                <th width="30%">MSGDATA</th> 
               <th width="4%">Edit </th> 
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${dataTableList}" var="dataTableList" varStatus="varStatus">
					<tr>
<td width="3%" id="field0ID"> ${varStatus.index+1}  </td>
<td width="4%" id="field1ID"> <c:out value="${dataTableList.field1}"/></td>
<td  width="4%" id="field2ID"><c:out value="${dataTableList.field2}"/></td>
<td  width="4%" id="field3ID"> 
                       <c:choose>
							<c:when test="${dataTableList.field3 eq 'N'}">
						      NDC
							</c:when>
							<c:when test="${dataTableList.field3 eq 'D'}">
						      912
							</c:when>
						</c:choose> </td>
						
<td  width="4%" id="field4ID"><c:out value="${dataTableList.field4}"/></td>
<td width="4%" id="field5ID"><c:out value="${dataTableList.field5}"/></td>
<td  width="30%" id="field6ID"><c:out value="${dataTableList.field6}"/></td>
<td width="4%"><a href="#" onclick="gridDetailEditClick(this)">Edit</a></td>
                      
                    
						
							
							
                        
                        
                     
						
					</tr>
				 </c:forEach> 
			</tbody>

		</table>
	
	</div>
 
 
 
 
 
 
 
 
	
	</div>
	
	<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog1" with="1200px">

    <!-- Modal content-->
    <div class="modal-content" >
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Graph</h4>
      </div>
      <div class="modal-body" id="divAdd">
      <div class="alC">
						<div class="isa_warning" id="isa_warning_dialog"
							style="display: none">
							<a href="javascript:void(0)" class="close-msg"><img
								src="<c:url value="/resources/images/cross-icon.png" />" alt="close-msg"
								onclick="hideMessage()"></a> <i
								class="fa fa-check"></i> <span
								id="message_placeholder_warning_dialog">All fields
								are mandatory..!!</span>
						</div>
					</div>
        <section id="userForm">
              <div class="common-container">
                <form action="" method="post" id="frmNewUser">
                <div class="form" id=graphdatadiv>
                  Graph data
                </div>
                <div class="controls alR">
                      <button type="reset" class="btn btn-danger" data-dismiss="modal">Back</button>
                     
                     </div>
                </form>
              </div>
            </section>
      </div>
      
    </div>

  </div>
</div>

</body>
</html>
