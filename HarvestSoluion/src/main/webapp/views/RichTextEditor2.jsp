<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title> RichText  </title>


<script src="<c:url value="/resources/richtext/scripts/jquery.min.js" />"></script>
<link href="<c:url value="/resources/richtext/styles/simditor.css" />" rel="stylesheet">
<link href="<c:url value="/resources/richtext/styles/editor.scss" />" rel="stylesheet">
<script src="<c:url value="/resources/richtext/scripts/module.js" />"></script>
<script src="<c:url value="/resources/richtext/scripts/hotkeys.js" />"></script>
<script src="<c:url value="/resources/richtext/scripts/uploader.js" />"></script>
<script src="<c:url value="/resources/richtext/scripts/simditor.js" />"></script>



<script type="text/javascript">


$( document ).ready(function() {
	
	
	var editor = new Simditor({
		  textarea: $('#editor')
		  //optional options
		});
});


</script>


</head>
  <body>
  
  
  

<textarea id="editor" placeholder="Balabala" autofocus></textarea>
  
  
  </body>
</html>