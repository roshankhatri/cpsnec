<%@ include file="includes/header.jsp" %>
<div class="panel panel-primary">
<div class="panel-heading">All Programs List</div>
<div class="panel-body">
 <table class="table table-striped">
    <thead>
      <tr>
        <th>S.No</th>
        <th>Program Name</th>
        <th>Batches</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${programs}" var="program">
      <tr>
      <td><c:out value="${program.id}"/></td>
      <td><c:out value="${program.programName}"/></td>
      <td><a href='<c:url value="addbatch/${program.id}"></c:url>'>Add Batch</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
 </div>
</div>
<%@ include file="includes/footer.jsp" %>