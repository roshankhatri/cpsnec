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
							<th>Option</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${batches}" var="batch" varStatus="thecount">
							<tr>
								<td><c:out value="${thecount.count}" /></td>
								<td><c:out value="${batch.batchYear}" /></td>
								<td><c:out value="${batch.batchIntake}" /></td>
								<td>
								<sec:authorize access="hasRole('SECRET') or hasRole('ADMIN')">
									<a href='<c:url value="/Student/add/${batch.id}"></c:url>'><span class="glyphicon glyphicon-plus"></span></a>
								</sec:authorize>
								<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
									<a href='<c:url value="/Student/view/${batch.id}"></c:url>'><span class="glyphicon glyphicon-list"></span></a>
								</sec:authorize>
								</td><td>
								<sec:authorize access="hasRole('COORD') or hasRole('ADMIN')">
									<a href='<c:url value="/Batch/update/${batch.id}"></c:url>'><span class="glyphicon glyphicon-edit"></span></a>
								</sec:authorize>												
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="container">
					<h4>No Batches Found in <c:out value="${program.programName}"/>
					</h4>
				</div>
			</c:otherwise>
		</c:choose>
		<a href='<spring:url value="/Program/"></spring:url>' class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>