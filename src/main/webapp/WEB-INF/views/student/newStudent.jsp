<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Information Batch <c:out value="${batch.batchYear}"/> Program <c:out value="${batch.program.programName}"/></div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Student/add" commandName="student">
			<input type="hidden" name="batchId" value="${batch.id}"> 
			<div class="form-group">
				<form:label path="firstname">First Name</form:label>
				<form:input path="firstname" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:input path="lastname" cssClass="form-control" />
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