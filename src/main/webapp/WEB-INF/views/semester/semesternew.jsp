<%@ include file="../includes/header.jsp"%>
<!--panel starts  -->
<div class="panel panel-primary">
	<div class="panel-heading">Semester Information Program:
		${programName}</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Batch/addSemester"
			commandName="semester">
			<div class="form-group">
				<form:label path="semesterYear">Semester Year</form:label>
				<form:input path="semesterYear" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="semesterSession">Semester Session</form:label>
				<form:input path="semesterSession" cssClass="form-control" />
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