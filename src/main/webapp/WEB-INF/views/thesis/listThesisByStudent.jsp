<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Thesis Details : <c:out value="${student.firstname} ${student.lastname}"></c:out></div>
	<div class="panel-body">
	<h4>Thesis Name: <c:out value="${student.thesism.thesisName }"/></h4>
	<c:choose>
		<c:when test="${! empty thesises}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Thesis Year</th>
					<th>Thesis State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thesises}" var="thesis" varStatus="thecount"> 
					<tr>
						<td><c:out value="${thecount.count}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${thesis.thesisYear}" /></td>
						<td><c:out value="${thesis.thesisState}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			<h4>No thesis Found For <c:out value="${student.firstname} ${studnet.lastname}"/></h4>
		</c:otherwise>
	</c:choose>
	<a href='<spring:url value="/Student/"></spring:url>' class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>