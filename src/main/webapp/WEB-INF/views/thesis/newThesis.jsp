<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">new Thesis: <c:out value="${student.firstname}"></c:out></div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Thesis/add" commandName="thesis">
			<input type="hidden" name="studentId" value="${student.id}"> 
			<div class="form-group">
				<form:label path="thesisName">Thesis Name</form:label>
				<form:input path="thesisName" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="thesisYear">Thesis Year</form:label>
				<form:input path="thesisYear" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="thesisState">Thesis State</form:label>
				<form:select path="thesisState" cssClass="selectpicker" items="${states}"/>
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