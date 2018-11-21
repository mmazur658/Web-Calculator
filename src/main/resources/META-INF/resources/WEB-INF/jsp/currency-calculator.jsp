<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>  
  	<title><spring:message code="currency.calculator.title"/></title>
  	
	<style>
		#intro {background: url("/img/currency-calculator-background.png") no-repeat center ; }
		header{	height: 45%;}
		.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {  background-color: #F99D33;  opacity: 0.8;}
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
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="1s"><spring:message code="currency.calculator.heading"/></h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->
</header>
<main class="mt-5">

<div class="container bg-blue px-3 py-3 mb-3">
<!-- SECTION HEADER -->
	  <button type="button" class="btn btn-warning btn-block br-10">
	  	<h4 class="mt-1 mb-0"><span class="font-weight-bold text-white"><spring:message code="currency.calculator.heading"/></span></h4>	
	  </button>
<!-- SECTION HEADER -->
<!-- FIRST COLUMN -->  
 	  <div class="container">
	  	<div class="row">
	  		<div class="col-md-4 py-3 px-3 br-14 bg-white">	
		  		<select id="first-select-list" class="custom-select custom-select-lg ">
			  		<option value="PLN" selected="selected"><spring:message code="currency.calculator.polish.currency"/></option>
				</select>
				<input type="hidden" id="first-value" value="1"/>
			 	<hr>
				<input id="first-input" class="form-control form-control-lg" type="text" placeholder="0">
	  		</div>
<!-- FIRST COLUMN -->  
<!-- SECOND COLUMN -->
	  		<div class="col-md-4 px-3">
	  			<div class="row px-3">
		  			<div class="col-md-6">
		  				<h4 id="first-selected-header" class="text-white font-weight-bold text-center">PLN</h4>	
		  				<hr>	
		  			</div>
		  			<div class="col-md-6">
		  				<h4 id="second-selected-header" class="text-white font-weight-bold text-center">PLN</h4>
		  				<hr>
		  			</div>
	  			</div>
	  			<div class="row px-3">
		  			<div class="col-md-12">
		  				<h6 id="main-header" class="text-white font-weight-bold text-center"> 1 PLN = 1.0000 PLN </h6>	
		  				<hr class="">
					</div>
	  			</div>
	  			<button id="rotate-button" class="btn btn-sm btn-block btn-deep-orange "><i class="fa fa-sync-alt fa-3x"></i></button>
	  		</div>
<!-- SECOND COLUMN -->    
<!-- THIRD COLUMN -->    
	  		<div class="col-md-4 py-3 px-3 bg-white br-14 ">
			  	<select id="second-select-list" class="custom-select custom-select-lg ">
				  	<option value="PLN" selected="selected"><spring:message code="currency.calculator.polish.currency"/></option>
				</select>
				<input type="hidden" id="second-value" value="1"/>
			  	<hr>
				<input id="second-input" class="form-control form-control-lg" type="text" placeholder="0">	
	  		</div>
  		</div>
  	</div>	
<!-- THIRD COLUMN -->    	
<!-- CURRENCY TABLE -->
	<div class="container p-3 mt-3 bg-white br-10">
		<table id="currency-table" class="table table-sm table-striped table-hover"></table>
	</div>
<!-- CURRENCY TABLE -->
</div>
</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/populate-currency-table.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/currency-calculator.js"></script> 


</body>
</html>