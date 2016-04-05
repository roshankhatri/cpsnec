<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Programs List</div>
	<div class="panel-body">
	<sec:authorize access="hasRole('COORD') OR hasRole('ADMIN')">
		<a href='<spring:url value="/Program/add"></spring:url>'><button
				type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus"></span>Add Programs
			</button></a>
	</sec:authorize>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Program Name</th>
					<th>Batches</th>
					<th>Show Batches</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${programs}" var="program">
					<tr>
						<td><c:out value="${program.id}" /></td>
						<td><c:out value="${program.programName}" /></td>
						<td>
						<sec:authorize access="hasRole('COORD') or hasRole('ADMIN')">
						<a
							href='<c:url value="/Batch/add/${program.id}"></c:url>'> <span
								class="glyphicon glyphicon-plus"></span></a>
						</sec:authorize>
						</td>
						<td><c:choose>
								<c:when test="${!empty program.batches}">
									<a href='<c:url value="/Batch/view/${program.id}"></c:url>'><span
										class="glyphicon glyphicon-search"></span></a>
								</c:when>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>