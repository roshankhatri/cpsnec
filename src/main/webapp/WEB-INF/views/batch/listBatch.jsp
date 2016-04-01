<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Batches List</div>
	<div class="panel-body">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Batch Year</th>
					<th>Batch Intake</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${batches}" var="batch">
					<tr>
						<td><c:out value="${batch.id}" /></td>
						<td><c:out value="${batch.batchYear}" /></td>
						<td><c:out value="${batch.batchIntake}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>