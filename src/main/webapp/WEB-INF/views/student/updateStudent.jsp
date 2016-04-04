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
				<form:input path="firstname" cssClass="form-control" value="${student.firstname}"/>
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:input path="lastname" cssClass="form-control" value="${student.lastname}"/>
			</div>
			<div class="form-group">
				<form:label path="payableAmount">Payable Amount</form:label>
				<form:input path="payableAmount" cssClass="form-control" value="${student.payableAmount }"/>
			</div>
			<div class="form-group">
				<form:label path="issueableBooks">Issueable Books</form:label>
				<form:input path="issueableBooks" cssClass="form-control" value="${student.issueableBooks }"/>
			</div>
			<div class="form-group">
				<form:label path="address.zone">Zone</form:label>
				<form:select path="address.zone" cssClass="selectpicker" items="${zones}" selected="${address.zone}"/>
			</div>
			<div class="form-group">
				<form:label path="address.district">District</form:label>
				<form:input path="address.district" cssClass="form-control" value="${addresss.district}"/>
			</div>
			<div class="form-group">
				<form:label path="address.locality">Locality</form:label>
				<form:input path="address.locality" cssClass="form-control" value="${address.locality }"/>
			</div>
			<div class="form-group">
				<form:label path="contact.mobile">Mobile Number</form:label>
				<form:input path="contact.mobile" cssClass="form-control" value="${contact.mobile}"/>
			</div>
			<div class="form-group">
				<form:label path="contact.landline">Landline</form:label>
				<form:input path="contact.landline" cssClass="form-control" value="${contact.landline}"/>
			</div>
			<div class="form-group">
				<form:label path="contact.mail">Email</form:label>
				<form:input path="contact.mail" cssClass="form-control" value="${contact.mail}"/>
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