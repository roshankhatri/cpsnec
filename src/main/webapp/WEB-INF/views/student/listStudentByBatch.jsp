<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Students list Batch: <c:out value="${batch.batchYear}"/> Program: <c:out value="${batch.program.programName}"></c:out>
	</div>
	<div class="panel-body">
	<c:choose>
		<c:when test="${! empty students}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Name</th>
					<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
					<th>Option</th>
					</sec:authorize>
					<th>Payment</th>
					<th>Issue Return</th>
					<th>ExamResult</th>
					<th>Thesis</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student" varStatus="thecount">
					<tr>
						<td><c:out value="${thecount.count}" /></td>
						<td><c:out value="${student.firstname} ${student.lastname}" /></td>
						<td>
						<a href='<spring:url value="/Student/detail/${student.id}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
						<sec:authorize access="hasRole('SECRET') or hasRole('ADMIN')">
							<a href='<spring:url value="/Student/update/${student.id}"></spring:url>'><span class="glyphicon glyphicon-edit"></span></a>
						</sec:authorize>
						</td>
						<td>
							<sec:authorize access="hasRole('PAY') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>	
						</td>
						<td>
							<sec:authorize access="hasRole('IR') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>
							</td>			
						<td>
							<sec:authorize access="hasRole('EXAM') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>				
							</sec:authorize></td>
						<td>
							<sec:authorize access="hasRole('THESIS') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>
						</td>					
										
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h4>No Student have been added to the Batch: <c:out value="${batch.batchYear}"/> Intake: <c:out value="${batch.batchIntake}"/>
		</h4>
	</c:otherwise>
	</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>