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
				<form:label path="subject">Subject</form:label>
				<form:select path="subject" cssClass="selectpicker" data-width="75%" data-header="Select a Subject">
					<c:forEach items="${courses}" var="course">
						<option value="${course.id}"><c:out value="${course.courseTitle}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="grade">Grade</form:label>
				<form:select path="grade" cssClass="selectpicker show-menu-arrow" items="${grades}" data-width="75%" data-header="Select Grade"/>
			</div>
			<div class="form-group">
				<form:label path="enteredDate">Entered Date</form:label>
				<form:input path="enteredDate" cssClass="form-control" id="popupDatepicker" placeholder="Select date"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
			<!-- form ends here -->
		</form:form>
		
		<c:choose>
		<c:when test="${! empty examResults}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Course Code</th>
					<th>Course Credit</th>
					<th>Course Title</th>
					<th>Semester</th>
					<th>Grade</th>
					<th>Entered On</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${examResults}" var="examResult" varStatus="thecount"> 
					<tr>
						<td><c:out value="${thecount.count}" /></td>
						<td><c:out value="${examResult.code}"/></td>
						<td><c:out value="${examResult.credit}"/></td>
						<td><c:out value="${examResult.subject}"/></td>
						<td><c:out value="${examResult.semseter}"/></td>
						<td><c:out value="${examResult.grade}"/></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${examResult.enteredDate}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
		<h4>No Exam Results Added for<c:out value="${student.firstname} ${student.lastname}"></c:out> 
		</h4>	
	</c:otherwise>
	</c:choose>
	
	<!--panel body ends here  -->
	</div>
	
	<!-- panel ends  -->
</div>
<%@ include file="../includes/footer.jsp"%>