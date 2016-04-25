<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Batches List</div>
	<div class="panel-body">
	<c:choose>
		<c:when test="${!empty batches}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Program</th>
					<th>Batch Year</th>
					<th>Batch Intake</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${batches}" var="batch" varStatus="b">
					<tr>
						<td><c:out value="${b.count}" /></td>
						<td><c:out value="${batch.program.programName}"/></td>
						<td><c:out value="${batch.batchYear}" /></td>
						<td><c:out value="${batch.batchIntake}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			<h4>No batches have been added to the System</h4>
		</c:otherwise>
	</c:choose>
	<a href='<spring:url value="/Program/"></spring:url>' class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>