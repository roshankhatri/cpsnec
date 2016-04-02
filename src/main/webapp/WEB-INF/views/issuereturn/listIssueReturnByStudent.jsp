<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All IssueReturn list Student: <c:out value="${student.firstname} ${student.lastname}"/> Batch: 
	<c:out value="${student.batch.batchYear}"></c:out> Program: <c:out value="${student.batch.program.programName}"/></div>
	<div class="panel-body">
	<a href='<spring:url value="/Program/"></spring:url>'><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Add IssueReturn</button></a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>IssueReturned</th>
					<th>Issued Return Date</th>
					<th>Issue return</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${issueReturns}" var="issueReturn" varStatus="thecount"> 
					<tr>
						<td><c:out value="${thecount.count}" /></td>
						<td><c:out value="${issueReturn.issuedReturned}" /></td>
						<td><c:out value="${issueReturn.issuedReturnedDate}"/></td>
						<td><c:out value="${issueReturn.issueReturnStatus }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>