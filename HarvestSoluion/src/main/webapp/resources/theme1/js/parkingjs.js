


FIELD_EDITED=false;
$(document).ready(function() {
	try {
		$('#NumberTypesTable').DataTable();
	} catch (error) {

	}
	try {
		$('#roleListTable').DataTable(
				
				{
				 "initComplete": function(settings, json) {
		        									 hideNMSLoader();
		                                          }
				});
	} catch (error) {

	}
	try {
		$('#roleNumberMapTable').DataTable();
	} catch (error) {

	}

	
	
	
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
			
			
			if(action=="siteStatus"){
			      setTimeout(function(){
			    	  gotolink(action)
			      }, 5000); 
			      
			}
			
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











function NumberTypeBean() {
	var serialNo;
	var nmsInventoryId;
	var searchGroup;
	var invTypeDescr;
	var annotation;
	var LOB;
	var numberType;
	var kennanInventoryType;
	var kennanInventoryTypeDesc;
	var reserveReleasePeriod;
	var blockReleasePeriod;
	var vanityApplicable;
}

function makeTableEditable(e) {
	$("#circleNumberMapTable").find("a").each(
			function() {
				if ($(this).text() == 'Save') {
					var parentTr = $(this).parent().parent();
					$(parentTr).find("td#tdVanityApplicable").html(
							$(parentTr).find("td#tdVanityApplicable select")
									.val());
					$(parentTr).find("td#tdKennanInventoryType").html(
							$(parentTr).find("td#tdKennanInventoryType input")
									.val());
					$(parentTr).find("td#tdBlockReleasePeriod").html(
							$(parentTr).find("td#tdBlockReleasePeriod input")
									.val());
					$(this).text('Edit');

				}
			})

	if ($(e).text() == "Edit") {
		$(e).text("Save");
		$(e)
				.parent()
				.parent()
				.find("td")
				.each(
						function() {
							if ($(this).attr("id") == null
									|| $(this).attr("id") == undefined) {
								return;
							} else if ($(this).attr("id").trim() == "tdVanityApplicable") {
								var txt = $(this).text().trim();
								$(this)
										.html(
												"<select class='selectVanityApplicable'><option value='0'>-Select-</option><option value='YES'>YES</option><option value='NO'>NO</option></select>");
								$(this).find("select").val(txt);
							} else if ($(this).attr("id").trim() == "tdBlockReleasePeriod") {
								$(this).html(
										"<input type='text' value='"
												+ $(this).text() + "' />");
							} else if ($(this).attr("id").trim() == "tdKennanInventoryType") {
								$(this)
										.html(
												"<input id='txtInventoryChange' type='text' value='"
														+ $(this).text()
														+ "' /><input type='button' data-toggle='modal' onclick='openDialog(this)' value='Select' />");
							}
						});
	} else {
		var parentTr = $(e).parent().parent();
		var obj = new NumberTypeBean();
		obj.vanityApplicable = $(parentTr).find("td#tdVanityApplicable select")
				.val().trim();
		obj.kennanInventoryType = $(parentTr).find(
				"#tdKennanInventoryType input").val().trim();
		obj.blockReleasePeriod = $(parentTr)
				.find("#tdBlockReleasePeriod input").val().trim();
		var data = JSON.stringify(obj);

		goForAjaxCall("savecirclenumbermap", data);

		$(parentTr).find("td#tdVanityApplicable").html(obj.vanityApplicable);
		$(parentTr).find("td#tdKennanInventoryType").html(
				obj.kennanInventoryType);
		$(parentTr).find("td#tdBlockReleasePeriod")
				.html(obj.blockReleasePeriod);

		$(e).text("Edit");
	}
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

function goForAjaxCall(action, data) {
	$.ajax({
		type : 'POST',
		url : action + '.action?data=' + data,
		data : data,

		async : true,
		success : function(result) {

			$("#invSearchDiv").html(result);
		},
		error : function(data) {

			$("#invSearchDiv").html(result);
		}
	});
}

function getInventory() {
	if ($("#txtInvenSearch").val().trim() != "") {
		goForAjaxCall('getmatchinginvid', $("#txtInvenSearch").val().trim());
	}
}

function doEditNumberType(e) {

	if ($(e).html() == 'Edit') {
		$(e).html('Save');
		$(e).parent().parent().toggleClass('selected');
		var trvar = $(e).parent().parent();
		var tds = $(e).parents('tr').find("td");
		$(tds)
				.each(
						function() {
							var id = $(this).attr('id');
							if (id == 'invTypeDescr' || id == 'annotation') {
								data = $(this).text();
								console.log(data);
								$(this).html(
										'<input type="text" value="' + data
												+ '" />');
							}
							if (id == 'searchGroup') {
								var searchGrp = $(this).text();

								if ($.trim(searchGrp) == 'CUG') {
									$(this)
											.html(
													'<select id="searchGroupDL"><option value="Pilot Numbers">Pilot Numbers</option><option value="MSISDN">MSISDN</option><option value="MSISDN SERIES">MSISDN SERIES</option><option selected = "selected" value="CUG">CUG</option><option value="IMSI">IMSI</option></select>');
								}
								if ($.trim(searchGrp) == 'Pilot Numbers') {
									$(this)
											.html(
													'<select id="searchGroupDL"><option selected = "selected" value="Pilot Numbers">Pilot Numbers</option><option value="MSISDN">MSISDN</option><option value="MSISDN SERIES">MSISDN SERIES</option><option value="CUG">CUG</option><option value="IMSI">IMSI</option></select>');
								}
								if ($.trim(searchGrp) == 'MSISDN') {
									$(this)
											.html(
													'<select id="searchGroupDL"><option value="Pilot Numbers">Pilot Numbers</option><option selected = "selected" value="MSISDN">MSISDN</option><option value="MSISDN SERIES">MSISDN SERIES</option><option value="CUG">CUG</option><option value="IMSI">IMSI</option></select>');
								}
								if ($.trim(searchGrp) == 'MSISDN SERIES') {
									$(this)
											.html(
													'<select id="searchGroupDL"><option value="Pilot Numbers">Pilot Numbers</option><option value="MSISDN">MSISDN</option><option selected = "selected" value="MSISDN SERIES">MSISDN SERIES</option><option value="CUG">CUG</option><option value="IMSI">IMSI</option></select>');
								}
								if ($.trim(searchGrp) == 'IMSI') {
									$(this)
											.html(
													'<select id="searchGroupDL"><option value="Pilot Numbers">Pilot Numbers</option><option value="MSISDN">MSISDN</option><option value="MSISDNSERIES">MSISDNSERIES</option><option value="CUG">CUG</option><option selected = "selected" value="IMSI">IMSI</option></select>');
								}

							}
						});
	} else {
		$(e).html('Edit');
		// $(this).parent().parent().attr('class','');
		$(e).parent().parent().toggleClass('selected');
		var p = $(e).parent().parent();
		var searchGroup = $(p).find('#searchGroupDL').val();
		var invTypeDescr = $(p).find('#invTypeDescr input').val();
		var annotation = $(p).find('#annotation input').val();
		var nmsInventoryId = $(p).find('#nmsInventoryId').text();

		console.log("srcggrp:" + searchGroup);
		$(p).find('#searchGroup').html(searchGroup);
		$(p).find('#invTypeDescr').html(invTypeDescr);
		$(p).find('#annotation').html(annotation);

		var dataObj = {
			"searchGroup" : searchGroup,
			"invTypeDescr" : invTypeDescr,
			"annotation" : annotation,
			"nmsInventoryId" : nmsInventoryId
		};
		var JSONdata = JSON.stringify(dataObj);
		console.log("JSON:" + JSONdata);
		$.ajax({
			type : 'POST',
			url : 'updatenumbertypes.action?numberTypeJsonData=' + JSONdata,
			data : JSONdata,
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {
				// alert("success");
			}
		});
	}
}

function CircleBean(){
	var circleName;
	var circleId;
}

function RoleTypeBean(){
	var roleType;
	var roleTypeDesc;
}






function openLokupsForm(){  
	
    
if(FIELD_EDITED)
{
changeMessage('Kindly save data first or reload screen');
return false;
}
else{
document.getElementById("modalAddButton").click();
}
    
}



function addRole(action){  
	
    
if(FIELD_EDITED)
{
changeMessage('Kindly save data first or reload screen');
return false;
}
else{
	getGraphData(action);
document.getElementById("modalAddButton").click();
}
    
}



function openGraph(action){  
	
    
if(FIELD_EDITED)
{
changeMessage('Kindly save data first or reload screen');
return false;
}
else{
	getGraphData(action);
document.getElementById("modalAddButton").click();
}
    
}


function getGraphData(action) {
	//alert(action);
	hideNMSMessages();
	$('.loader').show();
	$('#loader-overlay').show();
	var data = new FormData();
	
	$.ajax({
		type : "POST",
		url : action,
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		async : true,
		success : function(result) {
			$("#graphdatadiv").html(result);
			
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



function saleChannel(){  
    
	if(FIELD_EDITED)
	{
	changeMessage('Kindly save data first or reload screen');
	return false;
	}
	else{
	document.getElementById("modalAddButton").click();
	}
	    
	}


function doEditRoleList(e) {
	

	
	if ($(e).html() == 'Edit') {
		
		if(FIELD_EDITED)
		{
		changeMessage('Kindly save data first or reload screen');
		return false;
		}
	else
		{
		FIELD_EDITED=true;
		}
		hideMessage();
		$(e).html('Save');
		$(e).parent().parent().toggleClass('selected');
		var trvar = $(e).parent().parent();
		var tds = $(e).parents('tr').find("td");
		var resourceArray = [];
		$(tds).each(
				function() {
					var id = $(this).attr('id');
					console.log("ids:" + id);
					if (id == 'roleDesc') {
						data = $(this).text().trim();
						// console.log(data);
						$(this).html(
								'<input type="text" value="' + data + '" maxlength="100" />');
					}

					if (id == 'list') {
						var divs = $(this).find("div");
						var selectedText = new Array();
						$(divs).each(function() {
							var div = $(this).attr('id');
							
							$(this).find("span").each(function(){
								selectedText.push($(this).text().trim());
							})

							if (div == 'menuList') {								
								resourceArray = $(this).text();
								$(this).hide();
							}
							if (div == 'resourceList') {
								$("#resourceList select").html($("#selectResource").html());
								$(this).show();
							}
						});
						
						
						
						$(this).find("#resourceList select option").each(function() {
							
						if (jQuery.inArray( $(this).text().trim(), selectedText) > -1) {
							$(this).attr("selected","selected");
							}
						else{
							$(this).removeAttr("selected");
						}
						});		
					}

				});
	} else {
		var vars = {};
		var resourceArray = [];
		var resourceList = [];

		var p = $(e).parent().parent();
		var roleDesc = $.trim($(p).find('#roleDesc input').val());
		var roleLevelName = $.trim($(p).find('#roleLevelName').text());
		var roleName = $.trim($(p).find('#roleName').text());

		if (roleDesc == "") {
			changeMessage("Role Description cannot be blank ..!!");
			return false;
		}
		if(hasSpecialCharactors(roleDesc))
		{
		changeMessage("Role Description contains illegal characters.");
		return false;
		
		}
		/*else if(!alphanumeric(roleDesc)){
			changeMessage("Special characters are not allowed in Role Description");
			return false;
		}*/
		var flag = false;
		var divs = $(p).find('#list').find("div");

		$(divs).each(function() {
			var div = $(this).attr('id');
			

			if (div == 'resourceList') {
				resourceArray = $(this).find('#resourceListDL').val();
				if (resourceArray.length >= 1) {
					flag = true;
				}
				console.log("array:" + resourceArray);
				if (flag == true) {
					$(this).hide();
				}
			}
			if (div == 'menuList' && flag == true) {
				$(this).show();
			}

		});
		if (flag == false) {
			changeMessage("Select atleast one Resource ..!!");
			return false;
		}

		$(e).html('Edit');
		// $(this).parent().parent().attr('class','');
		$(e).parent().parent().toggleClass('selected');

		$.each(resourceArray, function(index, value) {
			var resourceObj = {};
			var encodedVal = encodeURIComponent(value);
			resourceObj['menuLabel'] = encodedVal;
			console.log("list:" + resourceObj['menuLabel']);
			resourceList.push(resourceObj);
		});
		

		$(p).find('#roleDesc').html(roleDesc);
		$(p).find('#roleLevelName').html(roleLevelName);
		var dataObj = {
			"roleDesc" : roleDesc,
			"roleLevelName" : roleLevelName,
			"roleName" : roleName,
			"menuList" : resourceList,
			"circleList" : []
		};
		$("#resourceList select").html($("#selectResource").html());
		FIELD_EDITED=false;
		submitJSON(dataObj, 'updateroles');
	//$("a[onclick]").each(function(){if($(this).attr("onclick") == "gotolink('rolemgmt')") $(this).trigger("click")});
		/*var JSONdata = JSON.stringify(dataObj);
		console.log("JSON:" + JSONdata);
		$.ajax({
			type : 'POST',
			url : 'updateroles.action?roleJsonData=' + JSONdata,
			data : JSONdata,
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {
				// alert("success");
			}
		});*/
	}

}

function doEditRoleNumberType(e) {

	if ($(e).html() == 'Edit') {
		if ($(e).html() == 'Edit') {
			var numbertype = [];
			$(e).html('Save');
			$(e).parent().parent().toggleClass('selected');
			var tds = $(e).parents('tr').find("td");

			$(tds)
					.each(
							function() {
								var id = $(this).attr('id');
								if (id == 'numberTypeList') {
									data = $(this).text();

									console.log(data);
									$(this)
											.html(
													'<select id="numberTypeListDL" size = "6" multiple = "multiple" name = "numbertypeDL[]"><option value="MSISDN">MSISDN</option><option value="Employee MSISDN">Employee MSISDN</option><option value="Prepaid MSISDN">Prepaid MSISDN</option><option value="FCT MSISDN">FCT MSISDN</option><option value="SIM Number">SIM Number</option><option value="CUG ID">CUG ID</option><option value="VIP">VIP</option><option value="VANITY MSISDN">VANITY MSISDN</option><option value="JK Prepaid Activation">JK Prepaid Activation</option><option value="Employee MSISDN">Employee MSISDN</option><option value="TELEMARKETER MSISDN">TELEMARKETER MSISDN</option><option value="Employe activation">Employe activation</option><option value="National Accounts">National Accounts</option><option value="DATA MSISDN NUMBER">DATA MSISDN NUMBER</option><option value="FAX MSISDN NUMBER">FAX MSISDN NUMBER</option><option value="FWP MSISDN">FWP MSISDN</option><option value="Switch MSISDN">Switch MSISDN</option><option value="Insta MSISDN">Insta MSISDN</option><option value="Series MSISDN">Series MSISDN</option><option value="IMSI Number">IMSI Number</option></select>');

								}
							});
		}
	} else {
		var numberTypeArray = [];
		var numberTypeList = [];
		$(e).html('Edit');
		$(e).parent().parent().toggleClass('selected');
		var p = $(e).parent().parent();
		numberTypeArray = $(p).find('#numberTypeListDL').val();
		var roleName = $.trim($(p).find('#roleName').text());
		console.log("numberTypeArray:" + numberTypeArray)

		$(p).find('#numberTypeList').html(numberTypeArray);
		console.log(numberTypeArray.length);

		$.each(numberTypeArray, function(index, value) {
			var numberTypeObj = {};
			console.log(value);
			numberTypeObj['numberType'] = value;
			console.log("list:" + numberTypeObj['numberType']);
			numberTypeList.push(numberTypeObj);

		});

		var dataObj = {
			"roleName" : roleName,
			"numberTypeList" : numberTypeList
		};

		var JSONdata = JSON.stringify(dataObj);
		console.log("JSON:" + JSONdata);
		$.ajax({
			type : 'POST',
			url : 'updaterolenumbermap.action?roleNumberMapJsonData='
					+ JSONdata,
			data : JSONdata,
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {
				// alert("success");
			}
		});

	}
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

function resetUserDetails() {
	// alert(34234);
	document.getElementById("userDetailsForm").reset();
}



/*function doEditVanityPattern(e){
	if($(e).html() == 'Edit'){
    	$(e).html('Save');
    	$(e).parent().parent().toggleClass('selected');       	
    	var trvar=$(e).parent().parent();
    	var tds = $(e).parents('tr').find("td");
    	
    	$(tds).each(function(){
    		var id = $(this).attr('id');
    		console.log("ids:"+id);
    		
    		if(id=='vanityCode'){
    			data = $(this).text();
    			//console.log(data);
    			$(this).html('<input type="text" value="'+data+'" />');
    		}
    		
    	});  	
    }        	
    else{
    	$(e).html('Edit');
    	//$(this).parent().parent().attr('class','');
    	$(e).parent().parent().toggleClass('selected');
    	var p = $(e).parent().parent();       	
    	var vanityPattern = $(p).find('#vanityPattern').text().trim();
    	var vanityCode = $(p).find('#vanityCode input').val().trim();
    	var shortDisplay = $(p).find('#shortDisplay').text().trim();
    	var displayValue = $(p).find('#displayValue').text().trim();
    	var price = $(p).find('#price').text().trim();

    	$(p).find('#vanityCode').html(vanityCode);
    	
    	var dataObj = {     		   
    		"vanityPattern": vanityPattern,
    		"vanityCode": vanityCode,
    		"displayValue" : displayValue,
    		"shortDisplay" : shortDisplay,
    		"price" : price
    	};
    	var JSONdata = JSON.stringify(dataObj);
    	console.log("JSON:" + JSONdata);
       	
       	$.ajax({
	      		type: 'POST',
	       		url: 'updateVanityPatternConfig.action?vanityJsonData='+JSONdata,
	       		data: JSONdata,
	       		dataType : 'json',
	        	contentType: 'application/json',
	       		async: true,
	        	success: function (data){
	          		//alert("success");
	        		
	      		}
	       	}); 
       
       	$($("#accordion div")[2]).find("a").each(function(){
       		if($(this).attr("onclick") == "gotolink('VanityPatternConfig')")
       			$(this).click()
       		})
       
    }		

}
*/

/*
Bulk Search Function :start
*/

function bulkSearchFileUpload() {
	
	//$('.loader').show();
	 showNMSLoader();
	var data = new FormData();
		jQuery.each(jQuery('#file')[0].files, function(i, file) 
				{
				data.append('file1', file);
		
				});
	
		

		if ($('#batchTypeCode').val()) {
			data.append('batchTypeCode', $('#batchTypeCode').val());
		}
		
		
		if ($('#fileUploadPathKey').val()) {
			data.append('fileUploadPathKey', $('#fileUploadPathKey').val());
		}
		
		
		

	$.ajax({
		url : 'fileUpload',
		type : 'POST',
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		
		success : function(data) {
			$('.loader').hide();
			bulkSearchGrid(data);
			//alert(data)
			//$('#action_message').html(data);

		},
		error : function(result) {
			$('.loader').hide();
			changeMessage(result.responseText);
			
		}

	});

}

function bulkSearchGrid(data)
{
	//alert("ss:"+data);
	var jsonData = $.parseJSON(data);
	var len = jsonData.length;
    var txt = '<table id="bulkSearchTable" class="display" cellspacing="0" width="100%" >';
   txt=txt+"<thead><tr > <tr><th >External Id</th><th >Status</th><th >CAF Number</th><th >Vanity</th>" +
   		"<th>FSO Code</th><th >User Id</th><th >Change Date</th><th>Comments</th>" +
   		"<th >MNP Flag</th><th >Location</th><th>HLR</th>\<th >SIM Number</th><th >IMSI</th> </tr></thead>";
    console.log(jsonData);
    if(len > 0){
    	
    	txt += '<tbody>';
    	for(var i=0;i<len;i++)
        {
    		txt += '<tr> ';
    		
            if(jsonData[i].externalId)
            {
                txt += '<td>'+jsonData[i].externalId+'</td>';
               
            } else
            	{
            	txt += '<td></td>';
            	}
             if(jsonData[i].status)
            {
                txt += '<td>'+jsonData[i].status+'</td>';
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].cafNumber)
            {
                txt += '<td>'+jsonData[i].cafNumber+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].vanity)
            {
                txt += '<td>'+jsonData[i].vanity+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].fsoCode)
            {
                txt += '<td>'+jsonData[i].fsoCode+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].userId)
            {
                txt += '<td>'+jsonData[i].userId+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            
            if(jsonData[i].changeDate)
            {
                txt += '<td>'+jsonData[i].changeDate+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            
            if(jsonData[i].comments)
            {
                txt += '<td>'+jsonData[i].comments+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            if(jsonData[i].mnpFlag)
            {
                txt += '<td>'+jsonData[i].mnpFlag+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            
            if(jsonData[i].location)
            {
                txt += '<td>'+jsonData[i].location+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].networkDevice)
            {
                txt += '<td>'+jsonData[i].networkDevice+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].serialNumber)
            {
                txt += '<td>'+jsonData[i].serialNumber+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            if(jsonData[i].networkDevice)
            {
                txt += '<td>'+jsonData[i].networkDevice+'</td>';
               
            }
            else
            	{
            	txt += '<td></td>';
            	}
            
            txt += '</tr>';
        }
    	txt += '</tbody></table>';
        if(txt != ""){
        	hideMessage();
        	$("#bulkSearchTablediv").html(txt);
        	//$("#mytable > tbody").html("");
           // $("#bulkSearchTable").append(txt);
           // $("#bulkSearchTable").hide();
        	
            setTimeout(function() {
            	//alert("1");
            	
            	$('#bulkSearchTable').DataTable();
            	$("#bulkSearchTablediv").show();
            	//alert("2");
            	}, 500);
            
        }
    	
    }
    

}

//Bulk Search Function : End


/*
Audit Trail Function :start
*/

function auditTrailFileUpload() {
	
	$('.loader').show();
	$('#loader-overlay').show();
	$("#auditTrailTableBulk").hide();
	hideNMSMessages();
	var data = new FormData();
		jQuery.each(jQuery('#file')[0].files, function(i, file) 
				{
				data.append('file1', file);
		
				});
	
		

		if ($('#batchTypeCode').val()) {
			data.append('batchTypeCode', $('#batchTypeCode').val());
		}else{
			changeMessage("Some problem ocurred while uploading file. Please try again..");
			return false;
}
		
		
		if ($('#fileUploadPathKey').val()) {
			data.append('fileUploadPathKey', $('#fileUploadPathKey').val());
		}else{
			changeMessage("Some problem ocurred while uploading file. Please try again..");
		return false;	
		}
		
		
		data.append('interceptorParam', $('#interceptorParam').val());

	$.ajax({
		url : 'fileUpload',
		type : 'POST',
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		
		success : function(data) {
			
			
			
             var jsonString= JSON.parse(data);
			

				if("error"==jsonString.messageType)
				{
					
					changeErrorMessage(jsonString.message);
					$('.loader').hide();
					$('.loader-overlay').hide();
				}
				else
					
					{
					
			//
			$('.loader').hide();
			$('#loader-overlay').hide();
			auditTrailGrid(data);
			//
			
					}
			
			
		},
		error : function(result) {
			$('.loader').hide();
			$('#loader-overlay').hide();
			changeErrorMessage(result.responseText);
			
		}

	});

}

function auditTrailGrid(data)
{
	var jsonData = $.parseJSON(data);
    var txt = "";
    if(jsonData != undefined){
    	txt += '<thead><tr role="row"><th class="sorting">File Name</th><th class="sorting">Download</th></tr></thead><tbody>';
    	txt += '<tr role="row" class="odd"> ';
		
        if(jsonData.fileName && jsonData.batchTypeCode)
        {
            txt += '<td>'+jsonData.fileName+'</td>';
            if(jsonData.batchTypeCode)
            {
                txt += '<td style="width:40%"><a target="_blank" href="auditResultDownload.action?batchTypeCode='+jsonData.batchTypeCode+'&path='+jsonData.fileName+'" >Download</a></td>';//'+jsonData.filePath+'
            }
           
        }
        else
        	txt+="<td class='odd' colspan='2' align='center'>No data found..</td>";
        txt+="</tr>";      
        
    	
    	txt += '</tbody>';
        if(txt != ""){
            $("#auditTrailTableBulk").html(txt).attr("class","dataTable no-footer").attr("role","grid").show();
            
            
            $("#file").val("");
        }
    	
    }
    

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


function openLogs(applicationName, fileName,fileType){
	 
	 if(fileName.indexOf("/")>-1 || fileName.indexOf("\\")>-1 )
	{
	return false;
	}
	var params = { "applicationName" :applicationName, "fileName":fileName,"fileType":fileType}; 
	var winName='Logs';
	 window.open('',winName);

	 var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "openLogsFile.action");
	    form.setAttribute("target", winName);
	   
	     
	    //Hidden Field
	    var hiddenField1 = document.createElement("input");
	    var hiddenField2 = document.createElement("input");
	      var hiddenField3 = document.createElement("input");

	    //Login ID
	    hiddenField1.setAttribute("type", "hidden");
	    hiddenField1.setAttribute("id", "applicationName");
	    hiddenField1.setAttribute("name", "applicationName");
	    hiddenField1.setAttribute("value", applicationName);

	    //Password
	    hiddenField2.setAttribute("type", "hidden");
	    hiddenField2.setAttribute("id", "fileName");
	    hiddenField2.setAttribute("name", "fileName");
	    hiddenField2.setAttribute("value", fileName);
	    
	     hiddenField3.setAttribute("type", "hidden");
	    hiddenField3.setAttribute("id", "fileType");
	    hiddenField3.setAttribute("name", "fileType");
	    hiddenField3.setAttribute("value", fileType);
	 
	    form.appendChild(hiddenField1);
	    form.appendChild(hiddenField2);
	     form.appendChild(hiddenField3);

	    document.body.appendChild(form);
	    form.submit(); 
	   
	     
	   }

function doEditUserWorkflow(e) {
	

	
	if ($(e).html() == 'Edit') {
		
		if(FIELD_EDITED)
		{
		changeMessage('Kindly save data first or reload screen');
		return false;
		}
	else
		{
		FIELD_EDITED=true;
		}
		hideMessage();
		$(e).html('Save');
		$(e).parent().parent().toggleClass('selected');
		var trvar = $(e).parent().parent();
		var tds = $(e).parents('tr').find("td");
		var resourceArray = [];
		$(tds).each(
				function() {
					var id = $(this).attr('id');
					console.log("ids:" + id);
					if (id == 'tdEmailId'||id == 'tdUserName') {
						data = $(this).text().trim();
						// console.log(data);
						$(this).html(
								'<input type="text" value="' + data + '" maxlength="100" />');
						
					}
					if (id == 'tdMobileNo') {
						data = $(this).text().trim();
						// console.log(data);
						$(this).html(
								'<input type="text" value="' + data + '" maxlength="10" />');
						
					}
					
				});
	}
	
	else {
		var vars = {};
		var tdLoginId;
		var tdGender;
		var tdUserRoles;
		var tdStatus;
		
		var tds = $(e).parents('tr').find("td");
		$(tds).each(
				function() {
		var id = $(this).attr('id');
		if(id == 'tdLoginId'){
			tdLoginId = $(this).text().trim();
		}
		if(id == 'tdUserRoles'){
			tdUserRoles= $(this).text().trim();
		}
		if(id == 'tdStatus'){
			tdStatus= $(this).text().trim();
		}
		
		if(id == 'tdGender'){
			tdGender= $(this).text().trim();
			
			
		}
		
		
				});
		
		var p = $(e).parent().parent();
		var tdEmailId = $.trim($(p).find('#tdEmailId input').val());
		var tdMobileNo = $.trim($(p).find('#tdMobileNo input').val());
		var tdUserName = $.trim($(p).find('#tdUserName input').val());
		
		
		// alert(tdEmailId);
		
		if (tdEmailId == "") {
			changeMessage("Email Id cannot be blank ..!!");
			return false;
		}
		if(!tdEmailId == ""){
			var atpos = tdEmailId.indexOf("@");
		    var dotpos = tdEmailId.lastIndexOf(".");
		    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=tdEmailId.length) {
		    	changeMessage("Not a valid e-mail Id..!!");  
			    return false;
			}
		 }		
		if (tdMobileNo == "") {
			changeMessage("Mobile number cannot be blank..!!");
			return false;
		}
		
		if(tdMobileNo.charAt(0)=="0") {
			changeMessage("Mobile number Can not Start with Zero..!!");
		    return false;
		}
		if (tdMobileNo.length != parseInt(10)) {
			changeMessage("Mobile number can be of 10 digits only..!!");
			return false;
		}
		if(isNaN(tdMobileNo)){
			changeMessage("Enter mobile number in digits only..!!");
			return false;
		}
		if (tdUserName == "") {
			changeMessage("User Name cannot be blank..!!");
			return false;
		}
		
		/*if (tdEmailId == "") {
			changeMessage("Email Id cannot be blank..!!");
			return false;
		}
		
		if (tdMobileNo == "") {
			changeMessage("MobileNo cannot be blank..!!");
			return false;
		}
		if(hasSpecialCharactors(tdMobileNo))
		{
		changeMessage("MobileNo contains illegal characters.");
		return false;
		}
		if (tdUserName == "") {
			changeMessage("UserName cannot be blank ..!!");
			return false;
		}
		if(hasSpecialCharactors(tdUserName))
		{
		changeMessage("User Name contains illegal characters.");
		return false;
		}
		*/

		$(e).html('Edit');
		// $(this).parent().parent().attr('class','');
		$(e).parent().parent().toggleClass('selected');

		
		var dataObj = {
		//	"userId" : userId,
			"userName" : tdUserName,
			"loginId" : tdLoginId,
			"status" : tdStatus,
			"emailId" : tdEmailId,
			"mobileNo" : tdMobileNo,
			"gender" : tdGender.substring(0, 1),
			"userRoles" : tdUserRoles
		};
		
		
		/*alert(JSON.stringify(dataObj));*/
		FIELD_EDITED=false;
		submitJSON(dataObj, 'userwfupdate');


}
}

function hideMessageCustom(div1){
	setTimeout(function() {
		$("#isa_success").fadeOut(10);
		$("#isa_error").fadeOut(10);
		$("#isa_warning").fadeOut(10);
		$("#"+div1).fadeOut(10);
		$("#isa_success_file_upload").fadeOut(10);
	}, 10);
}	


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


