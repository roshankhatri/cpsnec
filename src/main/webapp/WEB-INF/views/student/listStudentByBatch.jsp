<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Students list</div>
	<div class="panel-body">
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
						<td><a href='<spring:url value="/Payment/add/${student.id}"></spring:url>'>Payment</a></td>
						<td><a href='<spring:url value="/IssueReturn/add/${student.id}"></spring:url>'>IssueReturn</a></td>				
						<td><a href='<spring:url value="/ExamResult/add/${student.id}"></spring:url>'>ExamResult</a></td>					
						<td>
							<a href='<spring:url value="/Thesis/add/${student.id}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							<a href='<spring:url value="/Thesis/view/${student.id}"></spring:url>'><span class="glyphicon glyphicon-search"></span></a>
						</td>					
										
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>