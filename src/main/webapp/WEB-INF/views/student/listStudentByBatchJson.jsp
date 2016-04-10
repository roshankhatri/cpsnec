<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Students list Batch: <c:out value="${batch.batchYear}"/> Program: <c:out value="${batch.program.programName}"></c:out>
	</div>
	<div class="panel-body" ng-app="myApp" ng-controller="myCtrl">
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
     			 <input ng-model="q" type="text" placeholder="Filter by" autofocus>
					<tr ng-repeat="student in arr | filter: q | orderBy: 'firstname'">				
						<td>{{$index+1}}</td>
						<td>{{student.firstname}} {{student.lastname}}</td>
						<td>
						<a href='<spring:url value="/Student/detail/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
						<sec:authorize access="hasRole('SECRET') or hasRole('ADMIN')">
							<a href='<spring:url value="/Student/update/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-edit"></span></a>
						</sec:authorize>
						</td>
						<td>
							<sec:authorize access="hasRole('PAY') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/add/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Payment/view/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>	
						</td>
						<td>
							<sec:authorize access="hasRole('IR') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/add/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/IssueReturn/view/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>
							</td>			
						<td>
							<sec:authorize access="hasRole('EXAM') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/add/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/ExamResult/view/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>				
							</sec:authorize></td>
						<td>
							<sec:authorize access="hasRole('THESIS') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/add/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-plus"></span></a>
							</sec:authorize>
							<sec:authorize access="hasRole('VIEW') or hasRole('ADMIN')">
							<a href='<spring:url value="/Thesis/view/{{student.id}}"></spring:url>'><span class="glyphicon glyphicon-list"></span></a>
							</sec:authorize>
						</td>									
					</tr>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>