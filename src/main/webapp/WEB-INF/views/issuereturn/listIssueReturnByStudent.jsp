<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All IssueReturn list Student: <c:out value="${student.firstname} ${student.lastname}"/> Batch: 
	<c:out value="${student.batch.batchYear}"></c:out> Program: <c:out value="${student.batch.program.programName}"/></div>
	<div class="panel-body">
	<c:choose>
		<c:when test="${! empty issueReturns}">
		<h5>Total Issueable Books: <c:out value="${student.issueableBooks }"></c:out> 
		</h5>
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
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${issueReturn.issuedReturnedDate}"/></td>
						<td><c:out value="${issueReturn.issueReturnStatus }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			<h4>No IssueReturns have been made by <c:out value="${student.firstname} ${student.lastname}"/></h4>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>