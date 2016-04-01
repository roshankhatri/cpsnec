<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Programs List</div>
	<div class="panel-body">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Program Name</th>
					<th>Batches</th>
					<th>show batches</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${batches}" var="batch">
					<tr>
						<td><c:out value="${batch.id}" /></td>
						<td><c:out value="${batch.batchYear}" /></td>
						<td><c:out value="${batch.batchIntake}" /></td>
						<td><a href='<c:url value="addbatch/${program.id}"></c:url>'>Add
								Batch</a></td>
						<td><a href='<c:url value="showbatch"></c:url>'>Show
								Batch</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>