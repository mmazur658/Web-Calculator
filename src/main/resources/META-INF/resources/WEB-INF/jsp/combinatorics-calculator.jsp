<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>  

	<title><spring:message code="combinatorics.calculator.title"/></title>
	
	<style>
		#intro {background: url("/img/combinatorics-calculator-background.png") no-repeat center ; }
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
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="1s"><spring:message code="combinatorics.calculator.heading"/></h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->
</header>
<main class="mt-5">
<div class="container">
<!-- SECTIONS 1-->
	<div class="md-accordion accordion" id="accordionEx" role="tablist" aria-multiselectable="true">
<!-- SECTION 1 HEADING-->
 		 <div class="card wow fadeInLeft" data-wow-delay="0.6s">	 
      		<div class="card-header text-center"  role="tab" id="headingOne">

		          <a id="folder-1" data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		              <button type="button" class="btn btn-warning btn-block br-10">
		               <h4 class="mt-1 mb-0">
		              	 <span class="font-weight-bold text-white"><spring:message code="combinatorics.calculator.section.1"/></span>
		              	</h4>
		              </button>
		          </a>
      		</div>
<!-- SECTION 1 HEADING-->	
<!-- SECTION 1 CONTENT-->
      		<div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
	          <div class="card-body">
				<div class="text-center">
					<h3 class="text-white font-weight-bold"><spring:message code="under.construction.module"/></h3>
					<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			
				</div>
	          </div>
	      </div>
  		</div>
<!-- SECTION 1 CONTENT-->
<!-- SECTION 1 -->
<!-- SECTION 2 -->
  		<div class="card wow fadeInRight" data-wow-delay="0.6s">
<!-- SECTION 2 HEADING-->  
     		 <div class="card-header text-center" role="tab" id="headingTwo">
          		<a id="folder-2" data-toggle="collapse" data-parent="#accordionEx" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
              		<button type="button" class="btn btn-warning btn-block br-10">
	               		<h4 class="mt-1 mb-0">
	              			<span class="font-weight-bold text-white"><spring:message code="combinatorics.calculator.section.2"/></span>
	             		 </h4>
              		</button>
          		</a>
      		 </div>
<!-- SECTION 2 HEADING-->  
<!-- SECTION 2 CONTENT-->
		      <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
		          <div class="card-body">
			        <div class="text-center">
						<h3 class="text-white font-weight-bold"><spring:message code="under.construction.module"/></h3>
						<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			
					</div>   	
	       	  </div>
     		</div>
<!-- SECTION 2 CONTENT-->	      
   		</div>
<!-- SECTIONS 2-->   
	</div>
</div>


</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 


</body>

</html>
