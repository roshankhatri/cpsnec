<%@ include file="../includes/header.jsp" %>
<div class="panel panel-primary">
<div class="panel-heading">All Students list on ${program} Batch: ${batch.batchYear} </div>
<div class="panel-body">
<c:choose>
<c:when test="${!empty students}">
 <table class="table table-striped">
    <thead>
      <tr>
        <th>S.No</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Add Account</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student" varStatus="thecount">
      <tr>
      <td><c:out value="${thecount.count}"/></td>
      <td><c:out value="${student.firstname}"/></td>
      <td><c:out value="${student.lastname}"/></td>
      <td><a href='<spring:url value="/Account/newAccount/${student.id}"></spring:url>'>Create Account</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
 </c:when>
 <c:otherwise>
 	<h4>No Students Enrolled</h4>
 </c:otherwise>
 </c:choose>
 </div>
</div>
<%@ include file="../includes/footer.jsp" %>