<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Program: ${program.programName}</div>
	<div class="panel-body">
		<c:if test="${!empty batches}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>S.No</th>
						<th>Program Name</th>
						<th>Batches</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${batches}" var="batch">
						<tr>
							<td><c:out value="${batch.id}" /></td>
							<td><c:out value="${batch.batchYear}" /></td>
							<td><c:out value="${batch.batchIntake}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<h4 align="center"> No Batches Found </h4>
	</div>
</div>

<%@ include file="includes/footer.jsp"%>