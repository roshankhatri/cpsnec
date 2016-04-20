<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Thesis Details : <c:out value="${student.firstname} ${student.lastname}"></c:out></div>
	<div class="panel-body">
	<c:choose>
		<c:when test="${! empty thesises}">
	<a href='<spring:url value="/Thesis/"></spring:url>'><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Update Thesis State</button></a>
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
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>