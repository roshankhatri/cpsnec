<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Students list</div>
	<div class="panel-body">
	<c:choose><c:when test="${! empty students}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
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
						<td><c:out value="${student.firstname}" /></td>
						<td><c:out value="${student.lastname}" /></td>
						<td>
							<sec:authorize access="hasRole('PAY') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-search"></span></a>
							</sec:authorize>	
						</td>
						<td>
							<sec:authorize access="hasRole('IR') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-search"></span></a>
							</sec:authorize>
							</td>			
						<td>
							<sec:authorize access="hasRole('EXAM') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-search"></span></a>				
							</sec:authorize></td>
						<td>
							<sec:authorize access="hasRole('THESIS') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-search"></span></a>
							</sec:authorize>
						</td>					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			<h4>No Students have been added to the System</h4>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>