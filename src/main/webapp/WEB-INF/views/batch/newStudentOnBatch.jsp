<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">New Student on ${program} on  Batch ${batch.batchYear }</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Batch/addStudent"
			commandName="student">
			<input type="hidden" name="batchId" value="${batchId}">
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