<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head><!-- IMPORT, CSRF, TITLE, STYLE -->
 
	<%@ include file="parts/head.jsp" %>  
  	<title><spring:message code="percentage.calculator.title"/></title>

	<style>
	#intro {background: url("/img/percentage-calculator-background.png") no-repeat center ; }
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
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="1s"><spring:message code="percentage.calculator.heading"/></h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->
</header>
<main class="mt-5">

<div class="container bg-blue px-3 py-3 mb-5">
<!-- SECTIONS HEADING -->	
  	<button type="button" class="btn btn-warning btn-block br-10">
  		<h4 class="mt-1 mb-0"><span class="font-weight-bold text-white"><spring:message code="percentage.calculator.heading"/></span></h4>	
  	</button>
<!-- SECTIONS HEADING -->
<!-- SECTION 101 -->	  
	<form  id="percentage-calc-101" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">		
			<input type="hidden" id=operationNumber name="operationNumber" value="101">
			<div class="col-md-3 align-self-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.101.first.word"/></h6>
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param101Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 ">%</h6>
					</div>
				</div>				
			</div>
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"> <spring:message code="percentage.calculator.101.secend.word"/></h6>
			</div>				
			<div class="col-md-2 align-self-center justify-content-center">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param101Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>
			</div>						
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>	
			<div class="col-md-2 bg-dark-blue px-2 py-2 my-2 shadow">
				<div class="btn-br text-center pt-1 proc-calc-custom-div">
					<span id="result101" class="font-weight-bold font-s-20"></span>
				</div>	
			</div>			
		</div>
	</form>
<!--  SECTION 101 -->		
<!--  SECTION 102 -->	
	<form  id="percentage-calc-102" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">			
			<input type="hidden" id=operationNumber name="operationNumber" value="102">		
			<div class="col-md-3 align-self-center justify-content-center text-center">	
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.102.first.word"/></h6>
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param102Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>			
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.102.secend.word"/></h6>	
			</div>						
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param102Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>			
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>				
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result102" class="font-weight-bold font-s-20"></span>
				</div>	
			</div>											
		</div>
	</form>
<!--  SECTION 102 -->	
<!--  SECTION 103 -->	
	<form  id="percentage-calc-103" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">			
			<input type="hidden" id=operationNumber name="operationNumber" value="103">			
			<div class="col-md-3 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.103.first.word"/></h6>
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param103Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>			
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.103.secend.word"/></h6>	
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param103Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>				
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>				
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result103" class="font-weight-bold font-s-20"></span>
				</div>	
			</div>					
		</div>
	</form>
<!--  SECTION 103 -->	
<!--  SECTION 104 -->	
	<form  id="percentage-calc-104" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">		
			<input type="hidden" id=operationNumber name="operationNumber" value="104">			
			<div class="col-md-3 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.104.first.word"/></h6>
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param104Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>			
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.104.secend.word"/> </h6>	
			</div>					
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param104Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 ">%</h6>
					</div>
				</div>				
			</div>				
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>			
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result104" class="font-weight-bold font-s-20"></span>
				</div>	
			</div>					
		</div>
	</form>
<!--  SECTION 104 -->	
<!--  SECTION 105 -->	
	<form  id="percentage-calc-105" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">			
			<input type="hidden" id=operationNumber name="operationNumber" value="105">		
			<div class="col-md-3 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.105.first.word"/></h6>
			</div>		
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param105Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>		
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.105.secend.word"/></h6>	
			</div>					
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param105Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 ">%</h6>
					</div>
				</div>				
			</div>				
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>				
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result105" class="font-weight-bold font-s-20" ></span>
				</div>	
			</div>					
		</div>
	</form>
<!--  SECTION 105 -->	
<!--  SECTION 106 -->	
	<form  id="percentage-calc-106" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">			
			<input type="hidden" id=operationNumber name="operationNumber" value="106">			
			<div class="col-md-3 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.106.first.word"/></h6>
			</div>		
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param106Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>			
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.106.secend.word"/> </h6>	
			</div>					
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param106Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>				
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>				
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result106" class="font-weight-bold font-s-20" ></span>
				</div>	
			</div>					
		</div>
	</form>
<!--  SECTION 106 -->	
<!--  SECTION 107 -->	
	<form  id="percentage-calc-107" class="" action="percentage-calculator/calculate-percentage">
		<div class="row pr-4">			
			<input type="hidden" id=operationNumber name="operationNumber" value="107">			
			<div class="col-md-3 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.107.first.word"/>: </h6>
			</div>			
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param107Value1" class="form-control shadow" name="paramValue1" >
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>		
			<div class="col-md-2 align-self-center justify-content-center text-center">
				<h6 class="text-white font-weight-bold mt-2"><spring:message code="percentage.calculator.107.secend.word"/>: </h6>	
			</div>					
			<div class="col-md-2 align-self-center text-center ">
				<div class="row">
					<div class="col-md-9">
						<input type="text" id="param107Value2" class="form-control shadow" name="paramValue2">
					</div>
					<div class="col-md-3">
						<h6 class="text-white font-weight-bold mt-2 "></h6>
					</div>
				</div>				
			</div>				
			<div class="col-md-1 align-self-center justify-content-center my-2">
				<button type="submit" class="btn btn-sm btn-block btn-deep-orange ">=</button>
			</div>				
			<div class="col-md-2 bg-dark-blue px-2 py-2 btn-br my-2 shadow align-self-center">
				<div class="btn-br text-center pt-2 proc-calc-custom-div">
					<span id="result107" class="font-weight-bold font-s-20" ></span>
				</div>	
			</div>					
		</div>
	</form>
<!--  SECTION 107 -->	
	<div class="row pr-4">
		<div class="col-md-10"></div>
		<div class="col-md-2">
			<button id="clear-btn" class="btn btn-sm btn-block btn-deep-orange "><spring:message code="btn.clear"/></button>
		</div>
	</div>
</div>


</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/percentage-calculator.js"></script>  

</body>
</html>