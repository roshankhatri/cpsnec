<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">
		All Payments List Student:
		<c:out value="${student.firstname} ${student.lastname}" />
		Batch:
		<c:out value="${student.batch.batchYear}"></c:out>
		Program:
		<c:out value="${student.batch.program.programName}" />
	</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${! empty payments}">
			<h5>Total Receivable: <c:out value="${student.payableAmount}"/></h5>
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
								<td><c:out value="${thecount.count}" /></td>
								<td><c:out value="${payment.paidAmount}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${payment.paidDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h4>
					No Payments have been made by
					<c:out value="${student.firstname} ${student.lastname}" />
				</h4>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>