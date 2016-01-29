<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Account Information</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<spring:url value="/Account/newAccount" var="newAccountUrl"/>
		<h4>Account Information for ${student.firstname} ${student.lastname}</h4>
		<form:form method="POST" action="${newAccountUrl}" commandName="account">
			<input type="hidden" name="studentId" value="${student.id}"> 
			<div class="form-group">
				<form:label path="payableDues">Payable Dues</form:label>
				<form:input path="payableDues" cssClass="form-control" />
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