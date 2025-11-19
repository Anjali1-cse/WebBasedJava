<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%---Obtaining a bean of type: example.bean.Person
   with Id : currentPerson from session scope --%>
    <jsp:useBean id="currentPerson"
    class="example.bean.Person" scope="session"/>
    <%--Retrieving values of properties of bean
    and displaying them in h2 tag --%>
    <h2>Name: <jsp:getProperty name="currentPerson" property="name"/></h2>
    <h2>age: <jsp:getProperty name="currentPerson" property="age"/></h2>
    <h2>weight: <jsp:getProperty name="currentPerson" property="weight"/></h2>
</body>
</html>