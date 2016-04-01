<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Program: ${program.programName}</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${!empty batches}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Batch Year</th>
							<th>Batch Intake</th>
							<th>Student</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${batches}" var="batch" varStatus="thecount">
							<tr>
								<td><c:out value="${thecount.count}" /></td>
								<td><c:out value="${batch.batchYear}" /></td>
								<td><c:out value="${batch.batchIntake}" /></td>
								<td><a
									href='<c:url value="/Student/view/${batch.id}"></c:url>'><span class="glyphicon glyphicon-search"></span></a></td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="container">
					<h4>No Batches Found</h4>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>