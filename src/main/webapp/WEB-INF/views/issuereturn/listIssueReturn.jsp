<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All IssueReturn list</div>
	<div class="panel-body">
	<c:choose>
		<c:when test="${!empty issueReturns}">
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
			<h4>No IssueReturn have been added to the System</h4>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>