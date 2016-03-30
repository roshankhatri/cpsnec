<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Program Information</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Payment/add" commandName="payment">
			<input type="text" name="studentId" value="${student.id}"> 
			<div class="form-group">
				<form:label path="paidAmount">paidAmount</form:label>
				<form:input path="paidAmount" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="paidDate">Paid Date</form:label>
				<form:input path="paidDate" cssClass="form-control" />
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