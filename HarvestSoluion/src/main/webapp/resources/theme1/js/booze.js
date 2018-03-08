


FIELD_EDITED=false;
$(document).ready(function() {

	
	
	
	$("#sidebar .panel-body li a").click(function(){
		
		$("#sidebar .panel-body li a").removeClass('active');
		$(this).addClass('active');
	});
	//Custom SelectBox 

	//Iterate over each select element


});


function changeMessage(messsage)
{	
	$("#message_placeholder_warning").html(messsage);
	$("#isa_warning").fadeIn(400);
	$("#isa_warning").show(400);
}


function changeErrorMessage(messsage)
{
	
	$("#message_placeholder_error").html(messsage);
//	$("#isa_error").html(messsage);
	$("#isa_error").fadeIn(400);	
}
function changeFileUploadMessage(messsage)
{
	
	$("#message_placeholder_fileupload_success").html(messsage);
//	$("#isa_success_file_upload").html(messsage);
	$("#isa_success_file_upload").fadeIn(100);	
}



function changeSuccessMessage(messsage)
{
	
	$("#message_placeholder_success").html(messsage);
	$("#isa_success").fadeIn(400);	
}
function warningMessageOnDialog(messsage)
{
	
	$("#message_placeholder_warning_dialog").html(messsage);
	$("#isa_warning_dialog").fadeIn(400);	
}

function hideMessage()
{
	
	setTimeout(function() {
		$("#isa_success").fadeOut(10);
		$("#isa_error").fadeOut(10);
		$("#isa_warning").fadeOut(10);
		$("#isa_warning_dialog").fadeOut(10);
		$("#isa_success_file_upload").fadeOut(10);
	}, 10);
	
	
}

//without timeout
function hideNMSMessages(){
	$("#isa_success").fadeOut(10);
	$("#isa_error").fadeOut(10);
	$("#isa_warning").fadeOut(10);
	$("#isa_warning_dialog").fadeOut(10);
	$("#isa_success_file_upload").fadeOut(10);
}

function showLoader()
{	
$('.loader').show();
}

function hideNMSLoader()
{	
	$('.loader').hide();
	$('#loader-overlay').hide();	
}

function showNMSLoader()
{	
	$('.loader').show();
	$('#loader-overlay').show();	
}
function nmsfileuploader(action) {
	$('.loader').show();
	$('#loader-overlay').show();
	var data = new FormData();
		jQuery.each(jQuery('#file')[0].files, function(i, file) 
				{
				data.append('file1', file);
		
				});
	
		//alert("$('#file1').val():"+$('#file1').val())
		if ($('#file1').val()) 
		{
			jQuery.each(jQuery('#file1')[0].files, function(i, file) 
			{
			data.append('file2', file);
			});
	
		}
		if ($('#webProvidedUploadPath').val()) {
			data.append('webProvidedUploadPath', $('#webProvidedUploadPath')
					.val());
		}

		if ($('#batchTypeCode').val()) {
			data.append('batchTypeCode', $('#batchTypeCode').val());
		}
		
		
		if ($('#fileUploadPathKey').val()) {
			data.append('fileUploadPathKey', $('#fileUploadPathKey').val());
		}
		
		
		if ($('#switchTypeId').val()) {
			data.append('switchTypeId', $('#switchTypeId').val());
		}
		
		if ($('#simTypeId').val()) {
			data.append('simTypeId', $('#simTypeId').val());
		}
	
		data.append('interceptorParam', $('#interceptorParam').val());
		
		//alert($('#interceptorParam').val());
	$.ajax({
		url : 'fileUpload',
		type : 'POST',
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		async : true,
		success : function(data) {
			
			var jsonString= JSON.parse(data);
			
			if("success"==jsonString.messageType)
				{
				
				gotolink(action);
				changeFileUploadMessage(jsonString.message);
				}
			else
				if("error"==jsonString.messageType)
				{
					
					changeErrorMessage(jsonString.message);
					$('.loader').hide();
					$('.loader-overlay').hide();
				}
			
			

		},
		error : function(result) {
		//	alert(result['message']);
			//alert(result.responseText);
			if(result.responseText=='SESSION_EXPIRED')
				{
				$('#errorRedirectfrm').submit();
				}
			changeErrorMessage(result.responseText);
			$('.loader').hide();
			$('.loader-overlay').hide();
			
		}

	});

}

function gotolink(action) {
	//alert(action);
	hideNMSMessages();
	$('.loader').show();
	$('#loader-overlay').show();
	var data = new FormData();
	data.append('interceptorParam', $('#interceptorParam').val());
	$.ajax({
		type : "POST",
		url : action,
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		async : true,
		success : function(result) {
			$("#getAjaxdataDiv").html(result);
			$("#getAjaxdataDiv1").html(result);
			$("#getAjaxdataDiv2").html(result);
			$("#getAjaxdataDiv3").html(result);
			$('.loader').hide();
			$('.loader-overlay').hide();
			
			
		},
		error : function(result) {
			$('.loader').hide();
			$('.loader-overlay').hide();
			$("#getAjaxdataDiv").html(result);
		}
	});
}

function submitForm(frmId, action) {
	//alert("ssss"+$("#" + frmId).serialize());
	$('.loader').show();
    $('#loader-overlay').show();
    params=$("#" + frmId).serialize()+'&interceptorParam='+$('#interceptorParam').val();
   // alert("params:"+params);
	$.ajax({
		type : "POST",
		url : action + ".action",
		data : params,
		cache : false,
		async : true,
		success : function(result) {

			
			$("#getAjaxdataDiv").html(result);
			$('.loader').hide();
            $('#loader-overlay').hide();
		},
		error : function(result) {
			
			$('.loader').hide();
            $('#loader-overlay').hide();
            $('#errorRedirectfrm').submit();
		}
	});
}


function openDialog(e) {
	// gotolink("invsearchdialog");

	$("#invSearchDiv").show();
	$("#invSearchDiv").dialog();
	$.ajax({
		type : "GET",
		url : "invsearchdialog.action",
		data : "do=getInfo",
		cache : false,
		async : false,
		success : function(result) {

			// alert("result");
			$("#invSearchDiv").html(result);

		},
		error : function(data) {
			$("#invSearchDiv").html(result);
		}
	});

}




function submitJSON(data, action) {
	$('.loader').show();
    $('#loader-overlay').show();
	var JSONdata = JSON.stringify(data);
	var dataForm = new FormData();
	dataForm.append('data', JSONdata);
	dataForm.append('interceptorParam', $('#interceptorParam').val());
	$.ajax({
		type : 'POST',
		url : action + '.action?',
		data : dataForm,
		cache : false,
		contentType : false,
		processData : false,
		async : true,
		success : function(result) {
		//	alert(result);
			
			$("#getAjaxdataDiv").html(result);
			$('.loader').hide();
            $('#loader-overlay').hide();

		},
		error : function(error) {
			$('#errorRedirectfrm').submit();
			$('.loader').hide();
            $('#loader-overlay').hide();
		}
	});
}


//Audit Trail Function : End

function hasSpecialCharactors(inputText)
{
	
	if(/^[a-zA-Z0-9- ]*$/.test(inputText) == false) {
	    return true;
	}	
	else
		{
		return false;
		}
}

//alphanumeric check
function alphanumeric(inputtxt)  
{  debugger
	  //alert("checked")
 var letterNumber =/^[0-9a-zA-Z\.\-\_]+$/;// /^[0-9a-zA-Z]$/;  
//alert("again ckeck")
 if(letterNumber.test(inputtxt) == true)   
  {  
   return true;  
  }  
else  
  {      
   return false;   
  }  
  }  

//alphanumeric check

//numeric check
function numeric(inputtxt)  
{  
	  
 var letterNumber = /^[0-9]+$/;  
 if(inputtxt.match(letterNumber))   
  {  
   return true;  
  }  
else  
  {      
   return false;   
  }  
  }  

//numeric check

//hide msg on search or length dropdown change
function hideAllMessages(){
	$("input[type=search]").keydown(function(){
		$(".isa_success").hide();
		$(".isa_error").hide();
		$(".isa_warning").hide();
	});
	$("select[name*='_length']").change(function(){
		$(".isa_success").hide();
		$(".isa_error").hide();
		$(".isa_warning").hide();
	});
	
	}
//hide msg on search or length dropdown change

function reloadBulkGrid(action){

	hideNMSMessages();
	gotolink(action); 
}



//**


function logingOut()
{
	
	
	$('.loader').show();
    $('#loader-overlay').show();
	var dataForm = new FormData();
	$.ajax({
		type : 'POST',
		url : 'logOut.action?',
		data : dataForm,
		cache : false,
		contentType : false,
		processData : false,
		async : true,
		success : function(result) {
	
			$('.loader').hide();
            $('#loader-overlay').hide();
            window.top.close();
		},
		error : function(error) {
			//$('#errorRedirectfrm').submit();
			$('.loader').hide();
            $('#loader-overlay').hide();
            window.top.close();
            
		}
	});
	

}


