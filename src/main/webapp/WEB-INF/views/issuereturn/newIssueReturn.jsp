<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">New Issue Return Information Student:<c:out value="${student.firstname} ${student.lastname}"/> Batch: 
	<c:out value="${student.batch.batchYear}"></c:out> Program: <c:out value="${student.batch.program.programName}"/></div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/IssueReturn/add" commandName="issueReturn">
			<input type="hidden" name="studentId" value="${student.id}"> 
			<div class="form-group">
				<form:label path="issuedReturned">Issued Returned</form:label>
				<form:input path="issuedReturned" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="issuedReturnedDate">Issue Return Date</form:label>
				<form:input path="issuedReturnedDate" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="issueReturnStatus">Issue Return Status</form:label>
				<form:radiobuttons path="issueReturnStatus" items="${checks}"/>
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