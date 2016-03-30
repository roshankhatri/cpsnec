<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Search: ${program.programName}</div>
	<!--panel body starts here-->
	<div class="panel-body">
	<c:forEach items="${batches}" var="batch">
			<a href='<c:url value="/Student/add/${batch.id}"></c:url>'>${batch.batchYear}
				${batch.batchIntake}</a>
	</c:forEach>
	</div>
</div>
<!-- panel ends  -->
<%@ include file="includes/footer.jsp"%>