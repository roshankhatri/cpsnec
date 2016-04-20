<%@ include file="../includes/header.jsp"%>
<div class="panel panel-primary">
	<div class="panel-heading">Update Thesis:</div>
	<!--panel body starts here-->
	<div class="panel-body">
		<!--form starts here-->
		<form:form method="POST" action="/neccps/Thesis/update" commandName="thesis">
			<input type="hidden" name="id" value="${thesis.id}"> 
			<div class="form-group">
				<form:label path="thesisYear">Thesis Year</form:label>
				<fmt:formatDate value="${thesis.thesisYear}" pattern="yyyy-MM-dd" var="fmtthesisyear"/>
				<form:input path="thesisYear" cssClass="form-control" value="${fmtthesisyear}" />
			</div>
			<div class="form-group">
				<form:label path="thesisState">Thesis State</form:label>
				<form:select path="thesisState" cssClass="selectpicker" items="${states}" selected="${thesis.thesisState}"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
			<!-- form ends here -->
		</form:form>
		<!--panel body ends here  -->
	</div>
	<!-- panel ends  -->
</div>
<%@ include file="../includes/footer.jsp"%>