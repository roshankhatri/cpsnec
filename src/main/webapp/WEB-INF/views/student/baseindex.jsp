<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Search</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<c:forEach items="${programs}" var="program">
			<h4>
				<c:out value="${program.programName}"></c:out>
			</h4>
			<c:forEach items="${program.batches}" var="batch">
				<ul>
					<li><a href='<c:url value="/Student/add/${batch.id}"></c:url>'>${batch.batchYear}
							${batch.batchIntake}</a></li>
				</ul>
			</c:forEach>
		</c:forEach>
	</div>
	<!-- panel ends  -->
</div>
<%@ include file="includes/footer.jsp"%>