<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">
		Exam Result Information Student:
		<c:out value="${student.firstname} ${student.lastname}" />
		Batch:
		<c:out value="${student.batch.batchYear}"></c:out>
		Program:
		<c:out value="${student.batch.program.programName}" />
	</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/ExamResult/add"
			commandName="examResult">
			<input type="hidden" name="studentId" value="${student.id}">
			<div class="form-group">
				<form:label path="year">Year</form:label>
				<form:input path="year" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="semseter">Semester</form:label>
				<form:input path="semseter" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="subject">Subject</form:label>
				<form:select path="subject" cssClass="selectpicker">
					<c:forEach items="${courses}" var="course">
						<option value="${course.id}"><c:out value="${course.courseTitle}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="grade">Grade</form:label>
				<form:input path="grade" cssClass="form-control" />
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