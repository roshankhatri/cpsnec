<%@ include file="includes/header.jsp"%>
<!--panel starts  -->
<div class="panel panel-primary">
	<div class="panel-heading">Batch Information</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/savepg" commandName="batch">
			<div class="form-group">
				<form:label path="batchYear">Batch Year</form:label>
				<form:input path="batchYear" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="batchIntake">Batch Intake</form:label>
				<form:input path="batchIntake" cssClass="form-control" />
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
<%@ include file="includes/footer.jsp"%>