<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>PocTable</title>
    


    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/parkingcss.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/style-4g.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.3.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
	$(document).ready(function() {
	
		//generateChart();

	});
	
	

	


	
	
</script>


</head>
<body>
		
 
 
 														
 
 
 
		<div class="title1"><h4>Site Details</h4></div>
		<table  cellspacing="0" width="100%" style="border: 1px solid black">
			<thead align="center">
				<tr>
				<th width="3%">Sr No</th>
                <th width="4%">Site Name</th>
                <th width="4%">Site ID</th>
                <th width="4%">Mobile Number</th>
                <th width="4%">Site Status</th>
                <th width="4%">Commercial Power</th>
                <th width="4%">DG</th> 
               	<th width="4%">Load Status </th> 
               
               	<th width="4%">Bat Volt</th>
                <th width="4%">Temp</th>
                <th width="4%">Mains Contactor</th>
                <th width="4%">DG Contactor</th>
                <th width="4%">DG BAT</th> 
               	<th width="4%">DG Safety-1</th> 
               	<th width="4%">DG Safety-2</th>
               	<th width="4%">DG Fuel Level</th>
               	<th width="4%">DG Run Hours</th> 
               	<th width="4%">BAT Run Hours</th> 
               	<th width="4%">Mains Run Hours</th> 
				</tr>
			</thead>


	
			<tbody>
				<c:forEach items="${map.dataTableList}" var="dataTableList" varStatus="varStatus">
					<tr>
				<td width="3%" id="field0ID"> ${varStatus.index+1}  </td>
				<td width="4%" id="field1ID"> ${dataTableList.siteName}</td>
			<td width="4%" id="field1ID"> ${dataTableList.siteId}</td>
			<td width="4%" id="field1ID"> ${dataTableList.mobileNumber}</td>
			<td width="4%" style="background-color:${dataTableList.siteStaus}"><%--  ${dataTableList.siteStaus} --%></td>
			<td width="4%" id="field1ID" style="background-color:${dataTableList.commercialPower}"> <%-- ${dataTableList.commercialPower} --%></td>
			<td width="4%" id="field1ID" style="background-color:${dataTableList.dg}"> <%-- ${dataTableList.dg} --%></td>
			<td width="4%" id="field1ID" style="background-color:${dataTableList.loadStatus}"> <%-- ${dataTableList.loadStatus} --%></td>
			<td width="4%" id="field1ID"> ${dataTableList.batVolt}</td>
			<td width="4%" id="field1ID"> ${dataTableList.temp}</td>
			<td width="4%" id="field1ID"> ${dataTableList.mainsContractor}</td>
			<td width="4%" id="field1ID"> ${dataTableList.dgContractor}</td>
			<td width="4%" id="field1ID"> ${dataTableList.dgBat}</td>

		
			<td width="4%" id="field1ID"> ${dataTableList.dgSafety1}</td>
			<td width="4%" id="field1ID"> ${dataTableList.dgSafety2}</td>
			<td width="4%" id="field1ID"> ${dataTableList.dgFuelLevel}</td>

			<td width="4%" id="field1ID"> ${dataTableList.dgRunHours}</td>
			<td width="4%" id="field1ID"> ${dataTableList.batRunHours}</td>
			<td width="4%" id="field1ID"> ${dataTableList.mainRunHours}</td>
                    
						
							
							
                        
                        
                     
						
					</tr>
				 </c:forEach> 
			</tbody>

		</table>
	
	</div>
 
 
 
 
 
 



</body>
</html>
