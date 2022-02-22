<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "EditNameServlet" method="post">

<input type ="text" name = "store" value= "${itemToEdit.familyName}"><br />


<input type = "text" name = "item"  value= "${itemToEdit.givenName}"><br />

<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item" class="btn btn-primary">
</form>
</body>
</html>