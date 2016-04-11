<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Detail</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${! empty student}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td><h4>Student Details</h4></td>
						</tr>
					</thead>
					<tbody>
						<tr>
						<tr>
							<td>Name</td>
							<td><c:out value="${student.firstname} ${student.lastname}" /></td>
						</tr>
						<tr>
							<td>Program</td>
							<td><c:out value="${student.batch.program.programName}" /></td>
						</tr>
						<tr>
							<td>Batch</td>
							<td><c:out value="${student.batch.batchYear}" /></td>
						</tr>
						<tr>
							<td>Payable Amount</td>
							<td><c:out value="${student.payableAmount}" /></td>
						</tr>
						<tr>
							<td>Issueable Books</td>
							<td><c:out value="${student.issueableBooks}" /></td>
						</tr>
						<tr>
							<td>Zone</td>
							<td><c:out value="${student.address.zone}" /></td>
						</tr>
						<tr>
							<td>District</td>
							<td><c:out value="${student.address.district}" /></td>
						</tr>
						<tr>
							<td>Locality</td>
							<td><c:out value="${student.address.locality}" /></td>
						</tr>
						<tr>
							<td>Mobile No</td>
							<td><c:out value="${student.contact.mobile}" /></td>
						</tr>
						<tr>
							<td>Landline Number</td>
							<td><c:out value="${student.contact.landline}" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><c:out value="${student.contact.mail}" /></td>
						</tr>
						<tr>
							<td>Thesis</td>
							<td><c:out value="${student.thesis.thesisName}" /></td>
						</tr>
						<c:forEach items="${student.payments}" var="pay">
						<tr>
							<td>Payments</td>
							<td><c:out value="${pay.paidAmount}" /> <c:out value="${pay.paidDate}"></c:out></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h4>No Student Detail available</h4>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>