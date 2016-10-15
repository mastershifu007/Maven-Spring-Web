<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload File</title>
</head>
<body>
	<h1>Please Select File to upload!!!</h1>

	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file"> 
		<input type="submit" value="Upload">Press here to upload the file!
	</form>
	
	<p>${message}</p>
	
	
	<c:choose>
            <c:when test="${not empty fileName}">
               <img src="/images/${fileName}" /> 
            </c:when>
            <c:otherwise>
                <p>Nothing to show</p>
            </c:otherwise>
   </c:choose>
	
</body>
</html>
