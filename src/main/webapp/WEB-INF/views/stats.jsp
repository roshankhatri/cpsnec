<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">System Statistics</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<table class="table table-striped">
					<thead>
						<tr>
							<td><h4>System Statistics</h4></td>
						</tr>
					</thead>
					<tbody>
						<tr>
						<tr>
							<td>No. of Programs</td>
							<td><c:out value="${programs}" /></td>
						</tr>
						<tr>
							<td>No.of Batches</td>
							<td><c:out value="${batches}" /></td>
						</tr>
						<tr>
							<td>No. of Students</td>
							<td><c:out value="${students}" /></td>
						</tr>
						<tr>
							<td>No. of Payment Transactions </td>
							<td><c:out value="${payments}" /></td>
						</tr>
						<tr>
							<td>No. of Exam Results</td>
							<td><c:out value="${exams}" /></td>
						</tr>
						<tr>
							<td>No. of Issue Return Transactions</td>
							<td><c:out value="${irs}" /></td>
						</tr>
						<tr>
							<td>No. of Thesis</td>
							<td><c:out value="${thesis}" /></td>
						</tr>
					</tbody>
				</table>
		<!--panel body ends here  -->
	</div>
	<!-- panel ends  -->
</div>
<%@ include file="includes/footer.jsp"%>