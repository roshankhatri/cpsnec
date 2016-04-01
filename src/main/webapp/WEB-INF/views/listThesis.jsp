<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">All Thesis list</div>
	<div class="panel-body">
	<a href='<spring:url value="/Program/"></spring:url>'><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Add IssueReturn</button></a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Thesis Name</th>
					<th>Thesis Year</th>
					<th>Thesis State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thesises}" var="thesis" varStatus="thecount"> 
					<tr>
						<td><c:out value="${thecount.count}" /></td>
						<td><c:out value="${thesis.thesisName}" /></td>
						<td><c:out value="${thesis.thesisYear}"/></td>
						<td><c:out value="${thesis.thesisState}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>