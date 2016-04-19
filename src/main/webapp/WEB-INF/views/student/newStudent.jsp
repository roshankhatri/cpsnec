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
		<form:form method="POST" action="/neccps/Student/add"
			commandName="student">
			<input type="hidden" name="batchId" value="${batch.id}">
			<div class="form-group">
				<form:label path="firstname">First Name</form:label>
				<form:input path="firstname" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:input path="lastname" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="parent.fathername">Father Name</form:label>
				<form:input path="parent.fathername" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="parent.mothername">Mother Name</form:label>
				<form:input path="parent.mothername" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="payableAmount">Payable Amount</form:label>
				<form:input path="payableAmount" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="issueableBooks">Issueable Books</form:label>
				<form:input path="issueableBooks" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="degree.lastdegree">Last Degree</form:label>
				<form:input path="degree.lastdegree" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="degree.university">University</form:label>
				<form:input path="degree.university" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="address.zone">Zone</form:label>
				<form:select path="address.zone" cssClass="selectpicker" items="${zones}"/>
			</div>
			<div class="form-group">
				<form:label path="address.district">District</form:label>
				<form:input path="address.district" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="address.locality">Locality</form:label>
				<form:input path="address.locality" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.mobile">Mobile Number</form:label>
				<form:input path="contact.mobile" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.landline">Landline</form:label>
				<form:input path="contact.landline" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.mail">Email</form:label>
				<form:input path="contact.mail" cssClass="form-control" />
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