<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="jt" %>

<%@include file="../includes/header.jsp"%>

<h1>Welcome</h1>

<button type="button" class="pull-right">
	<a href="/msg/send" class="btn btn-primary">메시지 작성하기</a>
</button>
<h1>${param.mid} 받은 메시지함</h1>
<table class="table table-striped">
	<thead>
		<tr>
			<th>MNO</th>
			<th>who</th>
			<th>content</th>
			<th>regdate</th>
		</tr>
	</thead>
	<tbody>
	
	
	<c:forEach items="${rlist}" var="msg">
		<tr>
			<td>${msg.mno}</td>
			<td>${msg.who}</td>
			<td>${msg.content}</td>
			<td><jt:format value="${msg.regdate }" style="MS"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<h1>보낸 메시지함</h1>
<table class="table table-striped">
	<thead>
		<tr>
			<th>MNO</th>
			<th>whom</th>
			<th>who</th>
			<th>content</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${slist}" var="msg">
		<tr>
			<td>${msg.mno}</td>
			<td>${msg.whom}</td>
			<td>${msg.who}</td>
			<td>${msg.content}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@include file="../includes/footer.jsp"%>
