<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
input[type=text], input[type=password], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

input[type=submit], input[type=reset] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #00afff;
}

input[type=reset]:hover {
	background: #ffa0a0
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"
	name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
</head>
<body>

	<div align="center">
		<form:form action="register" method="post"
			commandName="myCustomerForm">
			<table border="0">

				<tr>
					<td>First Name:</td>
					<td><form:input path="firstname" /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastname" /></td>
				</tr>

				<tr>
					<td>gender</td>
					<td><form:radiobuttons path="gender" items="${genders}" /></td>
				</tr>

				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Mobile/Phone:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:textarea path="address" /></td>
				</tr>

				<tr>
					<td><input type="reset" /></td>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
		${success}
	</div>
</body>
</html>