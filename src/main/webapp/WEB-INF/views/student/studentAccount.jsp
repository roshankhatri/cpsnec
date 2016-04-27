<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">
		Student Information Batch
		<c:out value="${batch.batchYear}" />
		Program
		<c:out value="${batch.program.programName}" />
	</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Student/addAccount"
			commandName="account">
			<input type="hidden" name="studentId" value="${student.id}">
			<div class="form-group">
				<form:label path="semesterOne">Semester</form:label>
				<form:input path="semesterOne" cssClass="form-control" value="1"/>
			</div>
			<div class="form-group">
				<form:label path="installmentOne">Installment One</form:label>
				<form:input path="installmentOne" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="semseterTwo">Semester</form:label>
				<form:input path="semseterTwo" cssClass="form-control" value="2"/>
			</div>
			<div class="form-group">
				<form:label path="installmentTwo">Installment One</form:label>
				<form:input path="installmentTwo" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="semesterThree">Semester</form:label>
				<form:input path="semesterThree" cssClass="form-control" value="3"/>
			</div>
			<div class="form-group">
				<form:label path="installmentThree">Installment One</form:label>
				<form:input path="installmentThree" cssClass="form-control" />
			</div>	
			<div class="form-group">
				<form:label path="semesterFour">Semester</form:label>
				<form:input path="semesterFour" cssClass="form-control" value="4"/>
			</div>
			<div class="form-group">
				<form:label path="installmentFour">Installment One</form:label>
				<form:input path="installmentFour" cssClass="form-control" />
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