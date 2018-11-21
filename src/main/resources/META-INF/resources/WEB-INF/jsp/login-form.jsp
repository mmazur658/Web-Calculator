<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>   
	<title><spring:message code="login.form.title"/></title>  

</head> <!-- IMPORT, CSRF, TITLE, STYLE -->

<body>
<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>

<main class="bg-blue" style="min-height: 100%;">

<!-- LOGIN FORM -->
	<div class="container pt-5 " style="max-width: 600px;">	
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" class="border border-light p-5 bg-white shadow">
		
			<p class="h4 mb-4 text-center text-muted"><spring:message code="login.form.heading"/></p>	
			
			<c:if test="${param.error != null }">
				<div class="alert alert-danger text-center" role="alert">
				  <p class="my-2"><spring:message code="login.form.error.message"/></p>
				</div>
			</c:if>			
			<c:if test="${param.logout != null }">
				<div class="alert alert-success text-center" role="alert">
				  	<p class="my-2"><spring:message code="login.form.success.message"/></p>
				</div>
			</c:if>	
					    
    		<input name="username" type="text" id="textInput" class="form-control mb-2 shadow-sm" placeholder="Login">    	
   			<input name="password" type="password" id="passwdInput" class="form-control mb-4 shadow-sm" placeholder="Hasło">
    		
    		<button class="btn bg-orange btn-block my-2" type="submit"><spring:message code="btn.login"/></button>
    		<a class="btn bg-orange btn-block mb-4" href="${pageContext.request.contextPath}/"><spring:message code="login.form.back.to.main.page"/></a>		
    		
		</form:form>	
	</div>
<!-- LOGIN FORM -->	
</main>

<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->

<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/send-message-form.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/load-calculator.js"></script>     

</body>
</html>