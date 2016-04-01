<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Programs List</div>
	<div class="panel-body">
	<a href='<spring:url value="/Program/add"></spring:url>'><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Add Programs</button></a>
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
						<td><a href='<c:url value="/Batch/add/${program.id}"></c:url>'>Add
								Batch</a></td>
						<td>
						<c:choose>
							<c:when test="${!empty program.batches}">
								<a
									href='<c:url value="/Batch/view/${program.id}"></c:url>'>Show
										Batch</a>
							</c:when>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>