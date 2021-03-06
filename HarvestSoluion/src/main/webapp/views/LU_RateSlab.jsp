<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>RateSlab</title>
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
	
	
	function createNewRateSalb(){
	//changeMessage("Mobile number cannot be blank..!!");
	
	var rateCode=$("#rateCode").val().trim();
	var rateValue=$("#rateValue").val().trim();
	
	
	    if (rateCode == "") {
			warningMessageOnDialog("Rate Code cannot be blank...");
			return false;
		}
		if (rateValue == "") {
			warningMessageOnDialog("Rate cannot be blank...");
			return false;
		}
		
		if(isNaN(rateValue)){
			warningMessageOnDialog("Enter Rate in digits only...");
			return false;
		}
		/* if (Gender == "0") {
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
		 }	 */
	
		
	submitForm('frmlookups','addRateSlab');
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
		<div class="title1"><h4>Rate Slab</h4></div>
		<table id="userListTable" class="display" cellspacing="0" width="100%" >
			<thead align="center">
				<tr>
				<th width="3%">Rate ID</th>
                <th width="9%">Rate Code</th>
                <th width="3%">Rate Value</th>
                <th width="14%">Rate Desc</th>
                <th width="14%">Valid From</th>
                <th width="14%">Valid To</th>
                 <th width="3%">Created By</th>
               <th width="3%">Edit </th> 
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${dataTableList}" var="dataTableList" varStatus="varStatus">
					<tr>
						<td width="3%" id="tdsrNoId"><c:out value="${dataTableList.rateId}"/></td>
						<td  width="9%" id="tdfield2"><c:out value="${dataTableList.rateCode}"/></td>
						<td  width="3%" id="tdfield3"><c:out value="${dataTableList.rateValue}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.rateDescription}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.validFrom}"/></td>
						<td  width="9%" id="tdfield4"><c:out value="${dataTableList.validTo}"/></td>
						<td width="9%" id="tdfield5"><c:out value="${dataTableList.createdBy}"/></td>
						
                        <td width="3%"></td>
                    
						
							
							
                        
                        
                     
						
					</tr>
				 </c:forEach> 
			</tbody>
     <tfoot>
       	<tr>
       		<td colspan="8" align="right">
  
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
        <h4 class="modal-title">Rate Slab</h4>
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
                          <label for="rateCode">Rate Code<r>*</r></label>
                          <input type="text" class="form-control" id=rateCode name="rateCode" placeholder="Rate Code" maxlength="100">
                        </div>
                         <div class="form-group">
                          <label for="rateValue">Rate Value<r>*</r></label>
                          <input type="text" class="form-control" id=rateValue name="rateValue" placeholder="Price in rupees" maxlength="100">
                        </div>
                        
                          <div class="form-group">
                          <label for="rateDesc">Rate Desc<r>*</r></label>
                          <input type="text" class="form-control" id="rateDesc" placeholder="Rate Description" name="rateDescription" maxlength="100"/>
                        </div>
                        
                    </div>
                    <div class="col-xs-12 col-sm-6 sidebar-offcanvas">
                   <div class="form-group">
                          <label for="datefrom">Valid From<r>*</r></label>
                          <input type="text" class="form-control" id="validFrom" placeholder="Valid From" name="validFrom" maxlength="100"/>
                        </div>

   <div class="form-group">
                          <label for="dateTo">Valid To<r>*</r></label>
                          <input type="text" class="form-control" id="validTo" placeholder="Valid To" name="validTo" maxlength="100"/>
                        </div>

                      
                        
                    </div>
                    
                  </div>
                </div>
                <div class="controls alR">
                      <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                      <input type="button" onclick="createNewRateSalb();" class="btn btn-primary" value="Add" />
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
