<%@ include file="../includes/header.jsp"%>
<!--panel starts  -->
<div class="panel panel-primary">
	<div class="panel-heading">Program Information</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Program/add"
			commandName="program">
			<div class="form-group">
				<form:label path="programName">Program Name</form:label>
				<form:input path="programName" cssClass="form-control" />
				<div class="top">
					<form:errors path="programName" cssClass="alert alert-info"
						element="div" />
				</div>
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