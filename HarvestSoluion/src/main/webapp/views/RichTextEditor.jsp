
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>RichText</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.12.3.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


   <link href="<c:url value="/resources/dist/summernote.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/dist/summernote.js" />"></script>

 <script>
    $(document).ready(function() {
    	$('#summernote').summernote({
    		  height: 300,                 // set editor height
    		  minHeight: null,             // set minimum height of editor
    		  maxHeight: null,             // set maximum height of editor
    		  focus: true                  // set focus to editable area after initializing summernote
    		});
    });
    
    function getValue(){
    	
    	var markupStr = $('#summernote').summernote('code');
    	alert(markupStr);
    }
    
function setValue(){
    	
	var markupStr = 'hello world';
	$('#summernote').summernote('code', markupStr);
    }
  </script>
</head>
<body>
  <div id="summernote"></div>
  
  
  <input type="button" onclick="getValue()" value="GetText">
  <input type="button" onclick="setValue()" value="SetText">
  
</body>
</html>