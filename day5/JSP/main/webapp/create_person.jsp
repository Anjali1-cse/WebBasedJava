<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>details added</title>
</head>
<body>
<%--instantiating a java bean person from package: example.bean 
and putting it into SESSION scope --%>
    <jsp:useBean id="currentPerson"
    class="example.bean.Person" scope="session"/>
    <%--Assigning values to all the properties of bean --%>
    <jsp:setProperty property="*" name="currentPerson"/>
  
    <h2>Adding a new person. Please
    <a href="show_person.jsp"> Click her</a>  
      to view the details</h2>
</body>
</html>