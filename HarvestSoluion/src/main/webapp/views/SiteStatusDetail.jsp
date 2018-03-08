<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SiteStatusDetail</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/parkingcss.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/style-4g.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.3.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
     <script src="<c:url value="/resources/js/parkingjs.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sitestatusGrid').DataTable(
		
		{
		 "initComplete": function(settings, json) {
        									 hideNMSLoader();
                                          }
		});

	});
	
	
	function DataTableGridBean(){
		var field1;
		var field2;
		var field3;
		var field4;
		var field5;
		var field6;	
		var field7;
		var field8;
		var field9;
		var field10;
	    
	}
	
	function gridDetailEditClick(e){

		if($(e).text() == "Edit"){

			$(e).text("Save");
			var PAR = $(e).parent().parent();
		
			$(PAR).find("td").each(function(){
	
				if($(this).attr("id") != null){
					if($(this).attr("id").trim() == "field1ID" || $(this).attr("id").trim() == "field2ID" || $(this).attr("id").trim() == "field3ID"){
						$(this).html("<input type='text' value='"+$(this).text()+"' />");
					}
					if($(this).attr("id").trim() == "field4ID" || $(this).attr("id").trim() == "field5ID" ){
						$(this).html("<input type='text' value='"+$(this).text()+"' />");
					}
					if($(this).attr("id").trim() == "tdRole"){
						var opt = $(this).text();
						var value = 0;
						$(this).html("<select>"+$("select#selectRole").html()+"<select>");				
						$(this).find("select option").each(function(){
							if($(this).text().trim() == opt){
								value = $(this).val();
							}
						})
						$(this).find("select").val(value);
					}
					if($(this).attr("id").trim() == "tdGender"){
						var opt = $(this).text();
						$(this).html("<select>"+$("select#selectGender").html()+"<select>");		
						if(opt == "Male")
							$(this).find("select").val("M");
						else
							$(this).find("select").val("F");
					}
				
				}
			});
		}else{
			$(e).text("Edit");
			var PAR = $(e).parent().parent();
			var obj = new UserBean();
			obj.userId = $(PAR).find("#tdUserId").text().trim();
			obj.loginId = $(PAR).find("#tdLoginId").text().trim();
			
			obj.loginId = $(PAR).find("#tdLoginId").text().trim();
			obj.loginId = $(PAR).find("#tdLoginId").text().trim();
			obj.loginId = $(PAR).find("#tdLoginId").text().trim();
			
			obj.userName = $(PAR).find("#tdUserName input").val().trim();
			obj.role = $(PAR).find("#tdRole select").val().trim();
			obj.emailId =  $(PAR).find("#tdEmailId input").val().trim();
			obj.mobileNo= $(PAR).find("#tdMobileNo input").val().trim();
			obj.gender = $(PAR).find("#tdGender select").val().trim();
			obj.userType = $(PAR).find("#tdUserType").text().trim();
			
			
	       	submitJSON(obj, 'updateCustomerDetail.c');
	       	$(PAR).find("td").each(function(){
				if($(this).attr("id") != null){
					if($(this).attr("id").trim() == "tdUserName" || $(this).attr("id").trim() == "tdEmailId" || $(this).attr("id").trim() == "tdMobileNo"){
						$(this).html($(this).find("input").val().trim());
					}
					if($(this).attr("id").trim() == "tdRole" || $(this).attr("id").trim() == "tdGender"){
						$(this).html($(this).find("select option:selected").text().trim());
					}
				}
			});
			
			
		}
	}
	
	function doGetStatus(loginId,val) {
	
	var vars = {};
	var tdLoginId;
	var tdStatus;

	var dataObj = {
				"loginId" : loginId,
				"status" : val
			};
			
			
			/* alert(JSON.stringify(dataObj)); */
			submitJSON(dataObj, 'userwfstatus');


}
	
	function doCleanWork(){
		$("#userDetailsForm").find("input").each(function(){
			$(this).val("");
		});
		$("#userDetailsForm").find("select").each(function(){
			$(this).val(0);
		});
		//$("#").modal("hide");
	}
	
	 function doCleanaddForm(){
		$("#frmNewuser").find("input").each(function(){
			$(this).val("");
		});
		$("#frmNewuser").find("select").each(function(){
			$(this).val(0);
		});
	}
	
	
	//Added by Gopal for Adduser
	
	
	function createNewUser(){
	//changeMessage("Mobile number cannot be blank..!!");
	
	var loginId=$("#txtloginId").val().trim();
	var Gender=$("#selectGender").val().trim();
	var MobileNo=$("#txtMobile").val().trim();
	var UserName=$("#txtUserName").val().trim();
	var EmailId=$("#txtEmailId").val().trim();
	
	    if (loginId == "") {
			warningMessageOnDialog("LoginId cannot be blank...");
			return false;
		}
		if (UserName == "") {
			warningMessageOnDialog("User Name cannot be blank...");
			return false;
		}
		if (Gender == "0") {
			warningMessageOnDialog("Gender cannot be blank...");
			return false;
		}
			
		if (MobileNo == "") {
			warningMessageOnDialog("Mobile number cannot be blank...");
			return false;
		}
		if(MobileNo.charAt(0)=="0") {
			warningMessageOnDialog("Mobile number Can not Start with Zero...");
		    return false;
		}
		if (MobileNo.length != parseInt(10)) {
			warningMessageOnDialog("Mobile number can be of 10 digits only...");
			return false;
		}
		if(isNaN(MobileNo)){
			warningMessageOnDialog("Enter mobile number in digits only...");
			return false;
		}
		 if (EmailId == "") {
			warningMessageOnDialog("Email Id cannot be blank ...");
			return false;
		}
		if(!EmailId == ""){
			var atpos = EmailId.indexOf("@");
		    var dotpos = EmailId.lastIndexOf(".");
		    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=EmailId.length) {
		    	warningMessageOnDialog("Please Enter valid e-mail Id...");  
			    return false;
			}
		 }	
	
			
		
		var dataObj = {
		
			"loginId" : loginId,
			"gender"  : Gender,
			"mobileNo": MobileNo,
			"userName": UserName,
			"userRoles": Role,
			"emailId" : EmailId

		};		
		var JSONdata = JSON.stringify(dataObj);
	//	alert(JSONdata);
	submitJSON(dataObj,'addwfusr');
		  $(".modal-backdrop.fade.in").remove();
	
	
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
	<div id="nmsdataGrid" class="userListClass">
		<div class="title1"><h4>Site Details</h4></div>
		<table  id="sitestatusGrid" cellspacing="0" width="100%" style="border: 1px solid black">
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
				<c:forEach items="${dataTableList}" var="dataTableList" varStatus="varStatus">
					<tr>
				<td width="3%" id="field0ID"> ${varStatus.index+1}  </td>
				<td width="4%" id="field1ID"> ${dataTableList.siteName}</td>
			<td width="4%" id="field1ID"> ${dataTableList.siteId}</td>
			<td width="4%" id="field1ID"> ${dataTableList.mobile1}</td>
			<td width="4%" style="background-color:${dataTableList.status}"><%--  ${dataTableList.siteStaus} --%></td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.commercialPower}"> <%-- ${dataTableList.commercialPower} --%></td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.dg}"> <%-- ${dataTableList.dg} --%></td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.loadStatus}"> <%-- ${dataTableList.loadStatus} --%></td>
			<td width="4%" id="field1ID"> ${dataTableList.batVoltage}</td>
			<td width="4%" id="field1ID"> ${dataTableList.temperature}</td>
			<td width="3%" id="field1ID" style="background-color: ${dataTableList.mainContactor}"></td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.dgContractor}"> </td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.dgBatetory}"> </td>

		
			<td width="3%" id="field1ID" style="background-color:${dataTableList.dgSafety1}"> </td>
			<td width="3%" id="field1ID" style="background-color:${dataTableList.dgSafety2}"> </td>
			<td width="4%" id="field1ID" > ${dataTableList.dgFuelLevel}</td>

			<td width="4%" id="field1ID"> ${dataTableList.dgRunHours}</td>
			<td width="4%" id="field1ID"> ${dataTableList.batRunHours}</td>
			<td width="4%" id="field1ID"> ${dataTableList.mainsRunHours}</td>
                    
						
							
							
                        
                        
                     
						
					</tr>
				 </c:forEach> 
			</tbody>

		</table>
	
	</div>
	
	<!-- Modal -->
<div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">USER FORM</h4>
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
                <div class="form">
                  <div class="row">
                    <div class="col-xs-12 col-sm-6 sidebar-offcanvas">
                       <!--  <div class="form-group">
                          <label for="userType">User Type(LOB)*</label>
                          <input type="text" class="form-control" id="userType" placeholder="Mobility" disabled value="LOB">
                        </div> -->
                        <div class="form-group">
                          <label for="userId">Login ID<r>*</r></label>
                          <input type="text" class="form-control" id=txtloginId name="txtloginId" placeholder="Login Id" maxlength="100">
                        </div>
                        <div class="form-group">
                          <label>Gender<r>*</r></label>
                          <select  class="form-control" id="selectGender" name="selectGender">
						<option value="0">--Select Gender--</option>
						<option value="M">Male</option>
						<option value="F">Female</option>
				</select>
                        </div>
                        <div class="form-group">
                          <label for="mobileNumber">Mobile No.<r>*</r></label>
                          <input type="text" class="form-control" id="txtMobile" placeholder="Mobile Number" name="txtMobile" maxlength="10"/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 sidebar-offcanvas">
                    <div class="form-group">
                          <label for="userName">User Name<r>*</r></label>
                          <input type="text" class="form-control"  id="txtUserName" name="txtUserName" placeholder="Username" maxlength="100"/>
                        </div>
                         <div class="form-group">
                          <label for="userType">Role<r>*</r></label>
                          <select class="form-control" id="selectRole" name="selectRole">
						<option value="0">--Select Role--</option>
						<s:iterator value="lstRoleTypeBean">
							<option value='<s:property value="roleTypeDesc"/>'><s:property
									value="roleTypeDesc" /></option>
						</s:iterator>
				</select>
                        </div>
                        <div class="form-group">
                          <label for="emailID">Email Id<r>*</r></label>
                          <input type="email" class="form-control" id="txtEmailId" name="txtEmailId" placeholder="Email" maxlength="100"/>
                        </div> 
                        
                    </div>
                    
                  </div>
                </div>
                <div class="controls alR">
                      <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                      <input type="button" onclick="createNewUser();" class="btn btn-primary" value="Add" />
                     </div>
                </form>
              </div>
            </section>
      </div>
      
    </div>

  </div>
</div>

<s:hidden id="interceptorParam" value="%{#session.interceptorParam}"></s:hidden>
</body>
</html>
