<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>   
	<title><spring:message code="trigonometry.calculator.title"/></title>  
  
	<style>
		#intro {background: url("/img/trigonometry-calculator-background.png") no-repeat center ; }
		header{	height: 45%;}
	</style>

</head> <!-- IMPORT, CSRF, TITLE, STYLE -->

<body>
<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>

<header >
<!-- NAVBAR & INTRO -->
	<%@ include file="parts/sub-nav.jsp" %>	
	<div id="intro" class="view">
		<div class="mask">
			<div class="container-fluid d-flex align-items-center h-100">
	            <div class="row d-flex text-center">
	            	<div class="col-md-10 ml-5">
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="1s"><spring:message code="trigonometry.calculator.heading"/></h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->

</header>
<main class="mt-5">

<div class="container bg-blue px-3 py-3 mb-5">
<!-- SECTION HEADER -->
  <button type="button" class="btn btn-warning btn-block br-10">
  	<h4 class="mt-1 mb-0"><span class="font-weight-bold text-white"><spring:message code="trigonometry.calculator.heading"/></span></h4>	
  </button>
<!-- SECTION HEADER -->
<!-- SECTION CONTENT -->
	<div class="text-center">
		<h3 class="text-white font-weight-bold"><spring:message code="under.construction.site"/></h3>
		<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			
	</div>
<!-- SECTION CONTENT -->

</div>
</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  

</body>
</html>