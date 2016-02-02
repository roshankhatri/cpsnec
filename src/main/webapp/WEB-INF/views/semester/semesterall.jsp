<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Batch: ${batch.batchYear}</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${!empty semesters}"> 
				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Semester Year</th>
							<th>Semester Session</th>
							<th>Add Course</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${semesters}" var="semester" varStatus="thecount">
							<tr>
								<td><c:out value="${thecount.count}" /></td>
								<td><c:out value="${semester.semesterYear}" /></td>
								<td><c:out value="${semester.semesterSession}" /></td>
								<td><a href='<spring:url value="/Course/newCourse/${semester.id}"></spring:url>'>Add Course</a>
								</td>
						</c:forEach>
					</tbody>
				</table>
			 </c:when>
			<c:otherwise>
				<div class="container">
					<h4>No Semesters Found</h4>
				</div>
			</c:otherwise>
		</c:choose> 
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>