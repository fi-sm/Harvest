<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/parkingcss.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/style-4g.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.3.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
     <script src="<c:url value="/resources/js/parkingjs.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#userListTable').DataTable(
		
		{
		 "initComplete": function(settings, json) {
        									 hideNMSLoader();
                                          }
		});

	});
	
	
	
	function userDetailEditClick(e){
		if($(e).text() == "Edit"){
			$(e).text("Save");
			var PAR = $(e).parent().parent();
			$(PAR).find("td").each(function(){
				if($(this).attr("id") != null){
					if($(this).attr("id").trim() == "tdUserName" || $(this).attr("id").trim() == "tdEmailId" || $(this).attr("id").trim() == "tdMobileNo"){
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
	
	
	
	 function doCleanaddForm(){
		$("#frmlookups").find("input").each(function(){
			$(this).val("");
		});
		$("#frmlookups").find("select").each(function(){
			$(this).val(0);
		});
	}
	
	
	//Added by Gopal for Adduser
	
	
	function createNewLookups(action){
	//changeMessage("Mobile number cannot be blank..!!");
	
	var memberTypeCode=$("#memberCode").val().trim();
	var memberName=$("#name").val().trim();
	var EmailId=$("#email").val().trim();
	var MobileNo=$("#mobile").val().trim();
	
	
	
	    if (memberTypeCode == "") {
			warningMessageOnDialog("Member  Code cannot be blank...");
			return false;
		}
	    if (memberName == "") {
			warningMessageOnDialog("Member  Name cannot be blank...");
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
	
		
	submitForm('frmlookups',action);
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
	<div id="lookupdataGrid" class="userListClass">
		<div class="title1"><h4>Customer</h4></div>
		<table id="userListTable" class="display" cellspacing="0" width="100%" >
			<thead align="center">
				<tr>
				<th width="3%">Customer ID</th>
                <th width="9%">Customer Code</th>
               <th width="9%">Customer Name</th>
                <th width="14%">Father Name</th>
                <th width="14%">Mobile</th>
                <th width="14%">Email</th>
                  <th width="14%">Address</th>
                 <th width="3%">Created By</th>
               <th width="3%">Edit </th> 
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${dataTableList}" var="dataTableList" varStatus="varStatus">
					<tr>
						<td width="3%" id="tdsrNoId"><c:out value="${dataTableList.customerID}"/></td>
						<td  width="9%" id="tdfield2"><c:out value="${dataTableList.memberCode}"/></td>

						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.name}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.fatherName}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.mobile}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.email}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.address}"/></td>
						<td width="3%" id="tdfield5"><c:out value="${dataTableList.createdBy}"/></td>
						
                        <td width="3%"></td>
                    
						
							
							
                        
                        
                     
						
					</tr>
				 </c:forEach> 
			</tbody>
     <tfoot>
       	<tr>
       		<td colspan="9" align="right">
  
       			<a id="modalAddButton" class="btn btn-primary"
		           href="javascript:void(0)"  none" data-toggle="modal" data-target="#myModal">Add</a>
        		
       		
       		</td>
       	</tr>
       </tfoot>
		</table>
	
	</div>
	
	<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Customer</h4>
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
        <section id="lookupsForm">
              <div class="common-container">
                <form action="" method="post" id="frmlookups">
                <div class="form">
                  <div class="row">
                    <div class="col-xs-12 col-sm-6 sidebar-offcanvas">
                       
                        <div class="form-group">
                          <label for="customerCode">Customer Code<r>*</r></label>
                          <input type="text" class="form-control" id="memberCode" name="memberCode" placeholder="Customer Code" maxlength="100">
                        </div>
                        <div class="form-group">
                          <label for="Name">Customer Name<r>*</r></label>
                          <input type="text" class="form-control" id="name" name="name" placeholder="Customer Name" maxlength="100">
                        </div>
                        <div class="form-group">
                          <label for="FName">Father Name<r>*</r></label>
                          <input type="text" class="form-control" id="fatherName" name="fatherName" placeholder="Father Name" maxlength="100">
                        </div>
                        
                    </div>
                    <div class="col-xs-12 col-sm-6 sidebar-offcanvas">
                   <div class="form-group">
                          <label for="mobile">Mobile<r>*</r></label>
                          <input type="text" class="form-control" id="mobile" placeholder="Mobile" name="mobile" maxlength="100"/>
                        </div>
                           <div class="form-group">
                          <label for="email">Email<r>*</r></label>
                          <input type="text" class="form-control" id="email" placeholder="Email" name="email" maxlength="100"/>
                        </div>
  <div class="form-group">
                          <label for="address">Address<r>*</r></label>
                          <input type="text" class="form-control" id="address" placeholder="address" name="address" maxlength="200"/>
                        </div>
                      
                        
                    </div>
                    
                  </div>
                </div>
                <div class="controls alR">
                      <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                      <input type="button" onclick="createNewLookups('addCustomerr');" class="btn btn-primary" value="Add" />
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
