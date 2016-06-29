<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All ExamResult list Student:<c:out value="${student.firstname} ${student.lastname}"/> Batch: 
	<c:out value="${student.batch.batchYear}"></c:out> Program: <c:out value="${student.batch.program.programName}"/></div>
	<div class="panel-body">
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
		<h4>No Exam Results Found for <c:out value="${student.firstname} ${student.lastname}"></c:out> 
		</h4>	
	</c:otherwise>
	</c:choose>
	<a href='<spring:url value="/Student/"></spring:url>' class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>
	<a href='<spring:url value="/ExamResult/add/${student.id}"></spring:url>' class="btn btn-success">Add Result <span class="glyphicon glyphicon-arrow-right"></span></a>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>