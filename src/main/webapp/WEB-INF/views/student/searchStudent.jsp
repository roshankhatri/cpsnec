<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Search</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<form:form method="POST" action="/neccps/Student/search"
			commandName="student" cssClass="form-inline">
			<div class="form-group">
				<form:input path="firstname" cssClass="form-control" placeholder="Enter name to search" id="input"/>
			</div>
			 <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-search"></span></button>
			<!-- form ends here -->
		</form:form>
		</div>
	<!-- panel ends  -->
</div>
<%@ include file="../includes/footer.jsp"%>