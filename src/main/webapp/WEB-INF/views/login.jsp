<%@ include file="includes/header_signin.jsp"%>
 <div class="container">
 	<c:url var="loginUrl" value="/login" />
      <form class="form-signin" action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${param.error!=null}">
 			<h4>Username and Password Invalid</h4>
 		</c:if>
 		<c:if test="${param.logout!=null }">
 			<h4>You have logged Out</h4>
 		</c:if>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="inputEmail" name="ssoId" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> 
<%@ include file="includes/footer.jsp"%>
