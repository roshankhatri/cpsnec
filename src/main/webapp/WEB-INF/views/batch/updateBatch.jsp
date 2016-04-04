<%@ include file="../includes/header.jsp"%>
<!--panel starts  -->
<div class="panel panel-primary">
	<div class="panel-heading">Batch Information Update: ${batch.program.programName}</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Batch/update" commandName="batch">
			<input type="hidden" name="id" value="${batch.id}">
			<div class="form-group">
				<form:label path="batchYear">Batch Year</form:label>
				<form:input path="batchYear" cssClass="form-control" value="${batch.batchYear}"/>
			</div>
			<div class="form-group">
				<form:label path="batchIntake">Batch Intake</form:label>
				<form:input path="batchIntake" cssClass="form-control" value="${batch.batchIntake}"/>
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