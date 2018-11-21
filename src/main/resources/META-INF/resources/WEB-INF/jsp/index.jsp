<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->
	
	<%@ include file="parts/head.jsp" %>   
	<title><spring:message code="index.title"/></title>   

</head> <!-- IMPORT, CSRF, TITLE, STYLE -->

<body>
<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>

<header>
<!-- NAVBAR & INTRO -->
	<%@ include file="parts/main-nav.jsp" %> 
	<div id="intro" class="view" style="position: relative;"></div>
	<div class="container" style=" z-index: 1;">
		<a href="#calculator" class="btn text-white px-5" style="top: -140px; left: 40%;">
			<i class="fas fa-calculator fa-4x mb-3"></i><br>
			<h4 class="font-weight-bold"><spring:message code="index.start"/></h4>
		</a>
	</div>
<!-- NAVBAR & INTRO -->
</header>
<main class="mt-5">

<!-- CALCULATOR-->
<section id="calculator">
	<div class="container justify-content-center">
		<div class="card wow fadeIn" data-wow-delay="0.3s">
			<div class="card-body">  
				<div class="btn-group btn-block" role="group" aria-label="Basic example">
					<button id="basic-calc" type="button" class="btn btn-light-blue btn-block"><spring:message code="index.basic.calculator"/></button>
				  	<button id="advanced-calc" type="button" class="btn btn-light-blue btn-block"><spring:message code="index.advanced.calculator"/></button>
				 	<button id="science-calc" type="button" class="btn btn-light-blue btn-block"><spring:message code="index.science.calculator"/></button>
				</div>
			</div>	  			 
		</div>		
	</div>
	<div id="calculator-placeholder" class="container wow fadeIn mh-100" data-wow-delay="0.5s">
	</div>	
</section>
<!-- CALCULATOR-->
<hr class="my-5">
<!-- CATEGORY-->
<div class="container" >
<section id="category" class="text-center py-5">
	<h2 class="h1-responsive font-weight-bold mb-5 wow fadeIn" data-wow-delay="0.1s"><spring:message code="index.categories.calculator"/></h2>
        <div class="row text-center">   
<!-- PERCENTAGE CALCULATOR -->     
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow">
                    <img src="<%=request.getContextPath()%>/img/percent-calculator.png" class="img-fluid shadow" alt="Percentage Calculator">
                    <a href="${pageContext.request.contextPath}/percentage-calculator">
                    <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/percentage-calculator" class="btn btn-deep-orange btn-block shadow br-15"><spring:message code="index.percentage.calculator"/> </a> 
                </div>
            </div>
<!-- PERCENTAGE CALCULATOR -->
<!-- TRIGONOMETRY CALCULATOR -->
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow ">
                    <img src="<%=request.getContextPath()%>/img/trigonometry-calculator.png" class="img-fluid shadow" alt="Trigonometry Calculator">
                    <a href="${pageContext.request.contextPath}/trigonometry-calculator">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/trigonometry-calculator" class="btn btn-deep-orange btn-block shadow br-15" ><spring:message code="index.trigonometry.calculator"/></a> 
                </div>
            </div>
<!-- TRIGONOMETRY CALCULATOR -->
<!-- CONVERTER CALCULATOR -->
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow ">
                    <img src="<%=request.getContextPath()%>/img/converter-calculator.png" class="img-fluid shadow" alt="Converter Calculator">
                    <a href="${pageContext.request.contextPath}/converter-calculator">
                       <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/converter-calculator"class="btn btn-deep-orange btn-block shadow br-15"><spring:message code="index.converter.calculator"/></a> 
                </div>
            </div>
<!-- CONVERTER CALCULATOR -->
<!-- COMBINATORICS CALCULATOR -->            
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow ">
                    <img src="<%=request.getContextPath()%>/img/combinatorics-calculator.png" class="img-fluid shadow" alt="Combinatorics Calculator">
                    <a href="${pageContext.request.contextPath}/combinatorics-calculator"> 
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/combinatorics-calculator" class="btn btn-deep-orange btn-block shadow br-15"><spring:message code="index.combinatorics.calculator"/></a> 
                </div>
            </div>
<!-- COMBINATORICS CALCULATOR -->
<!-- CURRENCY CALCULATOR -->            
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow ">
                    <img src="<%=request.getContextPath()%>/img/currency-calculator.png" class="img-fluid shadow" alt="Currency Calculator">
                    <a href="${pageContext.request.contextPath}/currency-calculator">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/currency-calculator" class="btn btn-deep-orange btn-block shadow br-15"><spring:message code="index.currency.calculator"/></a> 
                </div>
            </div> 
<!-- CURRENCY CALCULATOR -->
<!-- GEOMETRY CALCULATOR -->                       
            <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight" data-wow-delay="0.1s">
                <div class="view overlay z-depth-1 shadow ">
                    <img src="<%=request.getContextPath()%>/img/geometric-calculator.png" class="img-fluid shadow" alt="Geomeric Calculator">
                    <a href="${pageContext.request.contextPath}/geometry-calculator">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
                <div class="card-body pb-0 mb-3">
                    <a href="${pageContext.request.contextPath}/geometry-calculator" class="btn btn-deep-orange btn-block shadow br-15"><spring:message code="index.geometric.calculator"/></a> 
                </div>
            </div>
<!-- GEOMETRY CALCULATOR -->            
        </div>
</section>
</div>
<!--CATEGORY-->
<!--CONTACT-->
<%@ include file="parts/contact.jsp" %> 
<!--CONTACT-->
</main>
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->
<!-- SCRIPTS IMPORT-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/send-message-form.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/load-calculator.js"></script>     
<script type="text/javascript" src="<%=request.getContextPath()%>/js/calculator.js"></script>

</body>
</html>