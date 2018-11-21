<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head><!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>   
	<meta name="_csrf" content="${_csrf.token}"/>
	<title><spring:message code="dashboard.title"/></title>  
	
	<style>
	.bg-image{
	  background-image: url('/img/under-construction-10-6.png');
	  width:100%;
	  height:100%;
	  background-repeat:no-repeat;
	  background-size:cover;
	  z-index: -1;
	}
	</style>

</head> <!-- IMPORT, CSRF, TITLE, STYLE -->

<body class="bg-blue">
<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>
<!-- NAVBAR & INTRO -->
	<%@ include file="parts/admin-nav.jsp" %>
<!-- NAVBAR & INTRO -->

<main class="mt-5">
<div class="container" >
<!-- FIRST ROW -->
	<div class="row">
<!-- FIRST CARD -->	
		<div class="col-md-4 mt-5">		
			<div class="card" >
				<div class="card-body px-0 pb-0">
					<div class="row pb-3">
						<div class="col-md-7">
							<h3 class="card-title text-muted pl-3 counter-count">${numberOfUnreadContactFormMessage}</h3>
					        <p class="card-text text-muted pl-3"><spring:message code="dashboard.new.messages"/></p>
						</div>
						<div class="col-md-5 text-center">
							<i id="card-icon" class="fas fa-comment-alt fa-3x text-muted align-middle"></i>
						</div>
					</div>
			        <a href="${pageContext.request.contextPath}/administrator-panel/contact-form-messages" class="btn btn-warning btn-block py-2"><spring:message code="btn.more"/></a>
			      </div>
			    
			</div>
		</div>
<!-- SECOND CARD -->
		<div class="col-md-4 mt-5" >		
			<div class="card" style="position: relative;">			
				<div class="card-body px-0 pb-0">
					<div class="row pb-3">
						<div class="col-md-7">
							<h3 class="card-title text-muted pl-3 counter-count">
				
								27
							</h3>
					        <p class="card-text text-muted pl-3"><spring:message code="dashboard.new.emails"/></p>
						</div>
						<div class="col-md-5 text-center">
							<i id="card-icon" class="fas fa-envelope fa-3x text-muted align-middle"></i>
						</div>
					</div>
			        <a href="#!" class="btn btn-warning btn-block py-2"><spring:message code="btn.more"/>}</a>
			      </div>			 
<!-- UNDER CONSTRUCTION -->			  
			       	  <img src="<%=request.getContextPath()%>/img/long-caution-tape.png" style=" z-index: 1; position: absolute;" width="100%" height="25px"/>
				      <img src="<%=request.getContextPath()%>/img/constr-sign.png" style=" z-index: 1; position: absolute; max-width: 50%; max-height: 50%; left: 35%; top:25%"/>			   
				      <img src="<%=request.getContextPath()%>/img/long-caution-tape.png" style=" z-index: 1; position: absolute; bottom:0;" width="100%" height="25px"/>  
<!-- UNDER CONSTRUCTION -->					
			</div>
		</div>
<!-- SECOND CARD -->	
<!-- THIRD CARD -->		
		<div class="col-md-4 mt-5">		
			<div class="card" style="position: relative;">
				<div class="card-body px-0 pb-0">
					<div class="row pb-3">
						<div class="col-md-7">
							<h3 class="card-title text-muted pl-3 counter-count">50</h3>
					        <p class="card-text text-muted pl-3"><spring:message code="dashboard.notifications"/></p>
						</div>
						<div class="col-md-5 text-center">
							<i id="card-icon" class="fas fa-bell fa-3x text-muted align-middle"></i>
						</div>
					</div>
			        <a href="#!" class="btn btn-warning btn-block py-2"><spring:message code="btn.more"/></a>
			      </div>
<!-- UNDER CONSTRUCTION -->					      
			      	  <img src="<%=request.getContextPath()%>/img/long-caution-tape.png" style=" z-index: 1; position: absolute;" width="100%" height="25px"/>
				      <img src="<%=request.getContextPath()%>/img/constr-sign.png" style=" z-index: 1; position: absolute; max-width: 50%; max-height: 50%; left: 35%; top:25%"/>			   
				      <img src="<%=request.getContextPath()%>/img/long-caution-tape.png" style=" z-index: 1; position: absolute; bottom:0;" width="100%" height="25px"/>
<!-- UNDER CONSTRUCTION -->					      
			</div>
		</div>
<!-- THIRD CARD -->			
	</div>
<!-- FIRST ROW -->
<!-- SECOND ROW -->
	<div class="row mb-5 ">
<!-- CHART -->
		<div class="col-md-12 mt-4">	
			<div class="card" style="position: relative;">
				<div class="card-body px-0 pb-0">
				
				<div class="row">
					<div class="col-md-4">
						<h4 class="card-title text-muted pl-3"><spring:message code="dashboard.statistic.heading"/></h4>
					</div>
					<div class="col-md-8">
					
					<div class="row">
						<div class="col-md-2">
							<div class="custom-control custom-radio">
								  <input value="today" type="radio" class="custom-control-input" id="radioFirstSelect" name="charDataRange" checked>
								  <label class="custom-control-label" for="radioFirstSelect"><spring:message code="dashboard.statistic.today"/></label>
							 </div>
						</div>
						<div class="col-md-2">
							<div class="custom-control custom-radio">
								  <input value="yesterday" type="radio" class="custom-control-input" id="radioSecondSelect" name="charDataRange">
								  <label class="custom-control-label" for="radioSecondSelect"><spring:message code="dashboard.statistic.yesterday"/></label>
							 </div>
						</div>
						<div class="col-md-3">
							<div class="custom-control custom-radio">
								  <input value="week" type="radio" class="custom-control-input" id="radioThirdSelect" name="charDataRange">
								  <label class="custom-control-label" for="radioThirdSelect"><spring:message code="dashboard.statistic.7days"/></label>
							</div> 
						</div>
						<div class="col-md-3">
							<div class="custom-control custom-radio">
								  <input value="month" type="radio" class="custom-control-input" id="radioFourthSelect" name="charDataRange">
								  <label class="custom-control-label" for="radioFourthSelect"><spring:message code="dashboard.statistic.30days"/></label>
							</div>
						</div>					
					</div>	
					</div>
				</div>
				<div class="row px-4 pt-0 mt-0">		
						<canvas id="barChart" height="120"></canvas>
				</div>
			        <a href="#!" class="btn btn-warning btn-block py-2"><spring:message code="btn.more"/></a>
			 </div>	   			      		  
		</div>
	</div>
<!-- CHART -->		
	</div>
<!-- SECOND ROW -->
</div>

</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->

<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dashboard.js"></script>  

</body>
</html>