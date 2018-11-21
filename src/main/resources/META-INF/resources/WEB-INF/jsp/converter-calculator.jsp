<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>  
  	<title><spring:message code="converter.calculator.title"/></title>

	<style>
	#intro {background: url("/img/converter-calculator-background.png") no-repeat center ; }
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
	                    <h2 class="display-4 font-weight-bold white-text pt-5 mb-2 wow fadeIn" data-wow-delay="1s">${converterCalculatorHeading}</h2>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<!-- NAVBAR & INTRO -->
</header>
<main class="mt-5">

<div class="container bg-blue px-3 py-3 mb-5">
<!--  SECTION HEADING -->
	 <button type="button" class="btn btn-warning btn-block br-10">
	 	<h4 class="mt-1 mb-0"><span class="font-weight-bold text-white"><spring:message code="converter.calculator.heading"/></span></h4>	
	 </button>
<!--  SECTION HEADING -->
<!--  SECTION PILLS -->
	<div class="row px-4 pb-5">
		<div class="nav flex-column nav-pills col-md-2 text-white" id="v-pills-tab" role="tablist" aria-orientation="vertical">
		  <a class="nav-link active " id="v-pills-length-tab" data-toggle="pill" data-target="#v-pills-length" role="tab" aria-controls="v-pills-home" aria-selected="true"><h5><spring:message code="converter.calculator.length"/></h5></a>
		  <a class="nav-link" id="v-pills-weight-tab" data-toggle="pill" data-target="#v-pills-weight" role="tab" aria-controls="v-pills-profile" aria-selected="false"><h5><spring:message code="converter.calculator.weight"/></h5></a>
		  <a class="nav-link" id="v-pills-area-tab" data-toggle="pill" data-target="#v-pills-area" role="tab" aria-controls="v-pills-messages" aria-selected="false"><h5><spring:message code="converter.calculator.area"/></h5></a>
		  <a class="nav-link" id="v-pills-volume-tab" data-toggle="pill" data-target="#v-pills-volume" role="tab" aria-controls="v-pills-settings" aria-selected="false"><h5><spring:message code="converter.calculator.valume"/></h5></a>
		</div>
		<div class="tab-content col-md-10" id="v-pills-tabContent">
<!--  SECTION PILLS -->
<!-- SECTION LENGTH -->	  
			<div class="tab-pane fade show active " id="v-pills-length" role="tabpanel" aria-labelledby="v-pills-length-tab">
				<form id="length-form" action="converter-calculator/calculate-length">		  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">mm</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-millimeter" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.milimeter"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">cm</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-centimeter" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.centimeter"/></div>		  	
				  	</div>			  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">m</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-meter" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.meter"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">km</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-kilometer" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.kilometer"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">in</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-inch" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.inch"/></div>		  	
				  	</div>			  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">ft</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-foot" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.foot"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">yd</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-yard" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.yard"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">mi</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-mile" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.mile"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">nmi</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-nautica-mile" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.nautic.mile"/></div>		  	
				  	</div>				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">au</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-astronomical-unit" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.astronom.unit"/></div>		  	
				  	</div>  				 
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">ly</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-light-year" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.light.year"/></div>		  	
				  	</div>				  				  				  	
				  	<div class="row text-white mb-2">
				  		<div class="col-md-2 pt-1 text-right font-weight-bold">pc</div>
				  		<div class="col-md-8"><input class="form-control" type="text" id="length-parsec" /></div>
				  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.parsec"/></div>		  	
				  	</div>			
				  	<div class="row">
				  		<div class="col-md-2"></div>
				  		<div class="col-md-8">
				  			<button type="submit" class="btn btn-block btn-deep-orange mb-2"><spring:message code="btn.calculate"/></button>
				  		</div>
				  		<div class="col-md-2"></div>			  			  				  				
				  	</div>	  
				  	<div class="row">
				  		<div class="col-md-2"></div>
				  		<div class="col-md-8">
				  			<a id="length-clear-btn" class="btn btn-block btn-deep-orange"><spring:message code="btn.clear"/></a>
				  		</div>
				  		<div class="col-md-2"></div>			  			  				  				
				  	</div>	  
			  	</form>
		  	</div>
<!-- SECTION LENGTH -->	  	
<!-- SECTION WEIGHT -->	  
			  <div class="tab-pane fade " id="v-pills-weight" role="tabpanel" aria-labelledby="v-pills-weight-tab">
			  	<form id="weight-form" action="converter-calculator/calculate-weight">					  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">mg</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-milligram" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.milligram"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">g</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-gram" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.gram"/></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">dkg</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-dekagram" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.decagram"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">kg</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-kilogram" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.kilogram"/></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">t</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-ton" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.ton"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">oz</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-ounce" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.ounce"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">lb</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-pound" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.pound"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">tonUS</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-short-ton" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.short.ton"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">tonUK</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-long-ton" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.long.ton"/></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">gr</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-grain" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.grain"/></div>		  	
					  	</div>				  				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">q</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-cental" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.cental"/></div>		  	
					  	</div>				  				  				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">ct</div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="weight-carat" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.carat"/></div>		  	
					  	</div>			
					  	<div class="row">
					  		<div class="col-md-2"></div>
					  		<div class="col-md-8">
					  			<button type="submit" class="btn btn-block btn-deep-orange mb-2"><spring:message code="btn.calculate"/></button>
					  		</div>
					  		<div class="col-md-2"></div>			  			  				  				
					  	</div>	  
					  	<div class="row">
					  		<div class="col-md-2"></div>
					  		<div class="col-md-8">
					  			<a id="weight-clear-btn" class="btn btn-block btn-deep-orange"><spring:message code="btn.clear"/></a>
					  		</div>
					  		<div class="col-md-2"></div>			  			  				  				
					  	</div>	  
				  	</form>
			  </div>
<!-- SECTION WEIGHT -->	  
<!-- SECTION AREA -->
			  <div class="tab-pane fade" id="v-pills-area" role="tabpanel" aria-labelledby="v-pills-area-tab">
			  	<form id="area-form" action="converter-calculator/calculate-area">					  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">mm<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-millimeter" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.millimeter"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">cm<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-centimeter" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.centimeter"/><sup>2</sup></div>		  	
					  	</div>					  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">dm<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-decymeter" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.decimeter"/><sup>2</sup></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">m<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-meter" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.meter"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">km<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-kilometer" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.kilometer"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">a<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-ar" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.ar"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">ha<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-hectare" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.hectare"/><sup>2</sup></div>		  	
					  	</div>				  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">in<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-inch" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.inch"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">ft<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-foot" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.foot"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">yd<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-yard" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.yard"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">mi<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-mile" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.mile"/><sup>2</sup></div>		  	
					  	</div>			  	
					  	<div class="row text-white mb-2">
					  		<div class="col-md-2 pt-1 text-right font-weight-bold">ac<sup>2</sup></div>
					  		<div class="col-md-8"><input class="form-control" type="text" id="area-acre" /></div>
					  		<div class="col-md-2 pt-1 font-weight-bold"><spring:message code="converter.calculator.square.acre"/><sup>2</sup></div>		  	
					  	</div>		  				  			
					  	<div class="row">
					  		<div class="col-md-2"></div>
					  		<div class="col-md-8">
					  			<button type="submit" class="btn btn-block btn-deep-orange mb-2"><spring:message code="btn.calculate"/></button>
					  		</div>
					  		<div class="col-md-2"></div>			  			  				  				
					  	</div>	  
					  	<div class="row">
					  		<div class="col-md-2"></div>
					  		<div class="col-md-8">
					  			<a id="area-clear-btn" class="btn btn-block btn-deep-orange"><spring:message code="btn.clear"/></a>
					  		</div>
					  		<div class="col-md-2"></div>			  			  				  				
					  	</div>	  
				  	</form>
			  </div>
<!-- SECTION AREA -->
<!-- SECTION VOLUME -->
			  <div class="tab-pane fade" id="v-pills-volume" role="tabpanel" aria-labelledby="v-pills-volume-tab">
			  	<div class="text-center">
						<h3 class="text-white font-weight-bold"><spring:message code="under.construction.module"/></h3>
						<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			
				</div>
			  </div>
<!-- SECTION VOLUME -->
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/converter-calculator.js"></script> 

</body>
</html>