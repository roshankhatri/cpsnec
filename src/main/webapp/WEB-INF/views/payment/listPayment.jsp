<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Payments list</div>
	<div class="panel-body">
	<c:choose>
	<c:when test="${! empty payments}">
		<a href='<spring:url value="/Program/"></spring:url>'><button
				type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus"></span>Add Payments
			</button></a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Paid Amount</th>
					<th>Paid Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payments}" var="payment" varStatus="thecount">
					<tr>
						<td><c:out value="${thecount.count}" />
						<td><c:out value="${payment.paidAmount}" /></td>
						<td><c:out value="${payment.paidDate}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			<h4>No Payment has been added to the System</h4>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>