<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->
	
 	<%@ include file="parts/head.jsp" %>  
  	<title><spring:message code="geometry.calculator.title"/></title>

	<style> 
	#intro {background: url("/img/geometry-calculator-background.png") no-repeat center ; }
	header{	height: 45%;}
	</style>

</head><!-- IMPORT, CSRF, TITLE, STYLE -->

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
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="0.6s"><spring:message code="geometry.calculator.heading"/></h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->	

</header>
<main class="mt-5">

	<div class="container">
		<div class="md-accordion accordion" id="accordionEx" role="tablist" aria-multiselectable="true">
<!-- SECTION 1 -->
 			 <div class="card wow fadeInLeft" data-wow-delay="0.0s">
<!-- SECTION 1 HEADING -->
			      <div class="card-header text-center"  role="tab" id="headingOne">
			          <a id="folder-1" data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			              <button type="button" class="btn btn-warning btn-block br-10">
			               <h4 class="mt-1 mb-0">
			              	 <span class="font-weight-bold text-white"><spring:message code="geometry.calculator.triangle.heading"/></span>
			              	</h4>
			              </button>
			          </a>
			      </div>
<!-- SECTION 1 HEADING -->
<!-- SECTION 1 CONTENT -->
			      <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
			          <div class="card-body">
						<div class="text-center">
							<h3 class="text-white font-weight-bold"><spring:message code="under.construction.module"/></h3>
							<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			
						</div>
			          </div>
			      </div>
<!-- SECTION 1 CONTENT -->
  		   	</div>
<!-- SECTION 1 -->
<!-- SECTION 2 -->
  			<div class="card wow fadeInRight" data-wow-delay="0.0s">
<!-- SECTION 2 HEADING -->
      			<div class="card-header text-center" role="tab" id="headingTwo">
			    	<a id="folder-2" data-toggle="collapse" data-parent="#accordionEx" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
			            <button type="button" class="btn btn-warning btn-block br-10">
			               <h4 class="mt-1 mb-0">
			              	 	<span class="font-weight-bold text-white"><spring:message code="geometry.calculator.square.heading"/></span>
			              	</h4>
			             </button>
			        </a>
			    </div>
<!-- SECTION 2 HEADING -->
<!-- SECTION 2 CONTENT -->
			    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
			        <div class="card-body">
				        <div class="row justify-content-center">
	          				<div class="col-md-7 justify-content-center">	      
	          					<h4 class="h4-responsive font-weight-bold text-center mb-1 item-dark-blue"><spring:message code="geometry.calculator.square.text"/></h4>
					          		<form:form method="POST" id="squareForm" class="px-5 py-2" action="geometry-calculator/calculate-square">	
					          			<div class="md-form form-lg">
										  <input type="text" id="squareInputSideA" class="form-control form-control-lg" name="squareSideA">
										  <label class="text-white" for="squareInputSideA"><spring:message code="geometry.calculator.square.side.a"/></label>
										</div>					          	
					          			<div class="md-form form-lg">
										  <input type="text" id="squareInputCircuit" class="form-control form-control-lg" name="squareCircuit">
										  <label class="text-white" for="squareInputCircuit"><spring:message code="geometry.calculator.square.circuit"/></label>
										</div>									
										 <div class="md-form form-lg">
										  <input type="text" id="squareInputField" class="form-control form-control-lg" name="squareField">
										  <label class="text-white" for="squareInputField"><spring:message code="geometry.calculator.square.field"/></label>
										</div>									
										<div class="md-form form-lg">
										  <input type="text" id="squareInputDiameter" class="form-control form-control-lg" name="squareDiameter">
										  <label class="text-white" for="squareInputDiameter"><spring:message code="geometry.calculator.square.diameter"/></label>
										</div>	
										<div class="md-form form-lg">
										  <input type="text" id="squareInputRadius" class="form-control form-control-lg" name="squareRadius">
										  <label class="text-white" for="squareInputRadius"><spring:message code="geometry.calculator.square.radius"/></label>
										</div>					          		

										<button type="submit" class="btn btn-block btn-deep-orange mb-2"><spring:message code="btn.calculate"/></button>
										<a id="square-clear-btn" class="btn btn-block btn-deep-orange"><spring:message code="btn.clear"/></a>
									</form:form>	  	
	          					</div> 	          	
					          	<div class="col-md-5 justify-content-center">
					          		<img class="img-fluid" src="<%=request.getContextPath()%>/img/square.png" alt="Square" height="384px" width="384px"/>
					          	</div>   	          
	          				</div>
         				 </div>
     				 </div>
<!-- SECTION 2 CONTENT -->
 				 </div>
<!-- SECTION 2 -->
<!-- SECTION 3 -->
  				<div class="card wow fadeInLeft" data-wow-delay="0.0s">
<!-- SECTION 3 HEADING -->
				      <div class="card-header text-center" role="tab" id="headingThree">
				          <a id="folder-3" data-toggle="collapse" data-parent="#accordionEx" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
				              <button type="button" class="btn btn-warning btn-block br-10">
					              <h4 class="mt-1 mb-0">
					              	 	<span class="font-weight-bold text-white"><spring:message code="geometry.calculator.rectangle.heading"/></span>
					              </h4>
				              </button>
				          </a>
				      </div>
<!-- SECTION 3 HEADING -->
<!-- SECTION 3 CONTENT -->
				  <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
			        <div class="card-body">
				        <div class="row justify-content-center">
				        <h4 class="h4-responsive font-weight-bold text-center mb-1 item-dark-blue"><spring:message code="geometry.calculator.rectangle.text"/></h4>
	          				<div class="col-md-7 justify-content-center">	      
					          		<form:form method="POST" id="rectangleForm" class="px-5 py-2" action="geometry-calculator/calculate-rectangle">	
					          			<div class="md-form form-lg">
										  <input type="text" id="rectangleInputSideA" class="form-control form-control-lg" name="rectabgleSideA">
										  <label class="text-white" for="rectangleInputSideA"><spring:message code="geometry.calculator.rectangle.side.a"/></label>
										</div>		
										<div class="md-form form-lg">
										  <input type="text" id="rectangleInputSideB" class="form-control form-control-lg" name="rectabgleSideB">
										  <label class="text-white" for="rectangleInputSideB"><spring:message code="geometry.calculator.rectangle.side.b"/></label>
										</div>		
					          			<div class="md-form form-lg">
										  <input type="text" id="rectangleInputCircuit" class="form-control form-control-lg" name="rectangleCircuit">
										  <label class="text-white" for="rectangleInputCircuit"><spring:message code="geometry.calculator.rectangle.circuit"/></label>
										</div>											
										 <div class="md-form form-lg">
										  <input type="text" id="rectangleInputField" class="form-control form-control-lg" name="rectangleField">
										  <label class="text-white" for="rectangleInputField"><spring:message code="geometry.calculator.rectangle.field"/></label>
										</div>							
										<div class="md-form form-lg">
										  <input type="text" id="rectangleInputDiameter" class="form-control form-control-lg" name="rectangleDiameter">
										  <label class="text-white" for="rectangleInputDiameter"><spring:message code="geometry.calculator.rectangle.diameter"/></label>
										</div>					          												
							          	<div class="md-form form-lg">
										  <input type="text" id="rectangleInputRadius" class="form-control form-control-lg" name="rectangleRadius">
										  <label class="text-white" for="rectangleInputRadius"><spring:message code="geometry.calculator.rectangle.radius"/></label>
										</div>														
										<button type="submit" class="btn btn-block btn-deep-orange mb-2"><spring:message code="btn.calculate"/></button>
										<a id="rectangle-clear-btn" class="btn btn-block btn-deep-orange"><spring:message code="btn.clear"/></a>
									</form:form>	  	
	          					</div> 	          	
					          	<div class="col-md-5 justify-content-center">
					          		<img class="img-fluid" src="<%=request.getContextPath()%>/img/rectangle.png" alt="Square" height="324px" width="384px"/>					          	
					          	</div>   	          
	          				</div>
         				 </div>
     				 </div>
  				</div>
<!-- SECTION 3 CONTENT -->
<!-- SECTION 3 -->
			</div>
	</div>
</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/geometry-calculator.js"></script>  

</body>
</html>