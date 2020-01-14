<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="update">
<br>
User Name:<input type="text" name="username" value=<%= request.getAttribute("userName")%>/><br>

Age:<input type="number" name="age" value=<%= request.getAttribute("userAge")%>/><br>
Email Id:<input type="text" name="emailid" value=<%= request.getAttribute("emailId")%>/><br>

Password: <input type="password" name="password" value=<%= request.getAttribute("userPassword")%>/><br>

Gender:
<input type="radio" id="male"name="gender" value="MALE">MALE
<br>
<input type="radio" id="female"name="gender" value="FEMALE">FEMALE
<br>
Mobile Number:<input type="number" name="mobilenumber" value=<%= request.getAttribute("userMobileNumber")%>/>
<br>
AddressLine1:<input type="text" name="addressline1" value=<%= request.getAttribute("addressLine1")%>/>
<br>
AddressLine2:<input type="text" name="addressline2" value=<%= request.getAttribute("addressLine1")%>/>
<br>
AddressLine3:<input type="text" name="addressline3" value=<%= request.getAttribute("addressLine1")%>/>
<br>
<input type="submit" name="submit" value="UPDATE PROFILE"/>
    <br>   
</form>
<form method="post" action="logout"> 
<br>
<input type="submit" name="submit" value="LOGOUT"/>
</form>
</body>
</html>