<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Payment Information Student:<c:out value="${student.firstname} ${student.lastname}"/> Batch: 
	<c:out value="${student.batch.batchYear}"></c:out> Program: <c:out value="${student.batch.program.programName}"/></div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Payment/add" commandName="payment">
			<input type="hidden" name="studentId" value="${student.id}"> 
			<div class="form-group">
				<form:label path="paidAmount">Paid Amount</form:label>
				<form:input path="paidAmount" cssClass="form-control" />
			</div>
				<div class="form-group">
				<form:label path="semester">Paid for Semester</form:label>
				<form:input path="semester" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="paidDate">Paid Date</form:label>
				<form:input path="paidDate" cssClass="form-control" id="popupDatepicker" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
			<!-- form ends here -->
		</form:form>
		<!--panel body ends here  -->
	</div>
	<!-- panel ends  -->
</div>
<%@ include file="../includes/footer.jsp"%>