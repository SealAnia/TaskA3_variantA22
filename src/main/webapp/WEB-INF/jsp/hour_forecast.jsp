<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import = "java.io.*,java.util.*" %>

<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ page import = "java.sql.Timestamp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENERGY MARKET INFORMATION SYSTEM</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/NewStyle.css"/>' 
type="text/css"/>

</head>
<body>

Date: 
<jsp:useBean id="today" class="java.util.Date" scope="page"/>
<fmt:formatDate type="time" value="${today}" pattern="yyyy-MM-dd"/>

		<table>
	    	<tr>
		        <th>
		        Hour 
		        
		        <th>Electricity Generation</th>
		        <th>Conventional</th>
		        <th>Total</th>
		    </tr>
		<c:forEach items = "${forecast}" var = "item">
		
		<c:if test = "${Integer.parseInt(today.getHours().toString()) <= Integer.parseInt(item.startTime.getHours().toString()) == true}">
		
			<tr class = "forecast">
				<td>
				
<c:out value = "${Integer.parseInt(today.getHours().toString()) > Integer.parseInt(item.endTime.getHours().toString())}"/>
				
				<fmt:formatDate pattern = "HH:mm" value = "${item.startTime}"></fmt:formatDate>-
				<fmt:formatDate pattern = "HH:mm" value = "${item.endTime}"></fmt:formatDate>
				</td>
				
				<td>${String.format("%.3f",item.electricityGeneration)}</td>
				<td>${String.format("%.3f",item.conventional)}</td>

				<td>${String.format("%.3f",item.total)}</td>
			</tr>
			
			</c:if>
			
			<c:if test = "${Integer.parseInt(today.getHours().toString()) <= Integer.parseInt(item.startTime.getHours().toString()) == false}">
		
			<tr>
				<td>
				
<c:out value = "${Integer.parseInt(today.getHours().toString()) > Integer.parseInt(item.endTime.getHours().toString())}"/>
				
				<fmt:formatDate pattern = "HH:mm" value = "${item.startTime}"></fmt:formatDate>-
				<fmt:formatDate pattern = "HH:mm" value = "${item.endTime}"></fmt:formatDate>
				</td>

				<td>${String.format("%.3f",item.electricityGeneration)}</td>
				<td>${String.format("%.3f",item.conventional)}</td>

				<td>${String.format("%.3f",item.total)}</td>
			</tr>
			
			</c:if>
			
			</c:forEach>
			
			<tr>
				<td>total:</td>
				<td>${String.format("%.3f",generation)}</td>
				<td>${String.format("%.3f",conventional)}</td>
				<td>${String.format("%.3f", totalForDay)}</td>
			</tr>
		</table>

</body>
</html>