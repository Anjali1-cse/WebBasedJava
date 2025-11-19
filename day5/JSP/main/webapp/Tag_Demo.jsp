<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.LocalDate, java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TagDemo</title>
</head>
<body>
<h2>Welcome to the demo of JSP tags</h2>

<%--Including the resource:background.html --%>
<%@ include file= "background.html" %>
<%---declaring some variable and defining some method --%>
<%!
  int num= 15;
  public String sayWelcome(String name){
	  return "Weclome "+ name;
  }
%>
<%--Accessing the variable and method --%>
<h2>Square of <%=num %> is <%=(num*num) %></h2>
<h2>Reply from method is <%=sayWelcome("anjali") %></h2>
<%--Displaying hello message 5 time usig h2 heading --%>
   <%
     for(int x = 1; x<=5;x++){
    %>
         <h2>Hello</h2>
    <% 
      }
      %>
 <%--Displaying System data and time --%>     
     <%
       LocalDate today= LocalDate.now();
       LocalTime now = LocalTime.now();
     %>
     
     <h2>today's date is <%=today %></h2>
      <h2>current time is <%=now %></h2>
</body>
</html>