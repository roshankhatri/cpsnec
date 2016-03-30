<%@ include file="includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Student Search</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<select class="selectpicker">
			<c:forEach items="${programs}" var="program">
				<option value="<c:out value="${program.id}"/>"><c:out
						value="${program.programName}" /></option>
			</c:forEach>
		</select>
		<c:forEach items="${programs}" var="program">
			<a href='<c:url value="/Batch/batch/${program.id}"></c:url>'>${program.programName }</a>
		</c:forEach>
	</div>
	<!-- panel ends  -->
</div>
<%@ include file="includes/footer.jsp"%>