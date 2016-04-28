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
						<th>Semester</th>
						<th>Paid Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${payments}" var="payment" varStatus="thecount">
							<tr>
								<td><c:out value="${thecount.count}" /></td>
								<td><c:out value="${payment.paidAmount}" /></td>
								<td><c:out value="${payment.semester}"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${payment.paidDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${student.account.installmentOne==0}">
					<button class="btn btn-primary"> Semester One <span class="glyphicon glyphicon-ok"> </span></button>
				</c:if>
				<c:if test="${student.account.installmentTwo==0}">
					<button class="btn btn-primary"> Semester Two <span class="glyphicon glyphicon-ok"> </span></button>
				</c:if>
				<c:if test="${student.account.installmentThree==0}">
					<button class="btn btn-primary"> Semester Three <span class="glyphicon glyphicon-ok"> </span></button>
				</c:if>
				<c:if test="${student.account.installmentFour==0}">
					<button class="btn btn-primary"> Semester Four <span class="glyphicon glyphicon-ok"> </span></button>
				</c:if>
			</c:when>
			<c:otherwise>
				<h4>
					No Payments have been made by
					<c:out value="${student.firstname} ${student.lastname}" />
				</h4>
			</c:otherwise>
		</c:choose>
		<a href='<spring:url value="/Student/"></spring:url>' class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>