<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head><!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>   
	<title><spring:message code="statistics.title"/></title>  

</head><!-- IMPORT, CSRF, TITLE, STYLE -->

<body class="bg-blue">
<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>

<!-- NAVBAR & INTRO -->
<%@ include file="parts/admin-nav.jsp" %>
<!-- NAVBAR & INTRO -->

<!-- SECTION HEADING -->
<main class="mt-5 pt-5" style="min-height: 100%">
	<div class="container bg-white mt-3 mb-5">
		<div class="row mx-3 shadow div-header">
			<div class="col-md-12 bg-orange pt-2 text-center">
				<h2 class="text-white font-weight-bold"><spring:message code="statistics.heading"/></h2>
			</div>
		</div>
<!-- SECTION HEADING -->	
<!--  SECTION PILLS -->
		<div class="row px-4 pb-5">
			<div class="nav flex-column nav-pills col-md-2 text-white" id="v-pills-tab" role="tablist" aria-orientation="vertical">
			  	<a class="nav-link active text-muted" id="v-pills-home-tab" data-toggle="pill" data-target="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"><spring:message code="statistics.home"/></a>
			 	<a class="nav-link text-muted" id="v-pills-methods-tab" data-toggle="pill" data-target="#v-pills-methods" role="tab" aria-controls="v-pills-methods" aria-selected="false"><spring:message code="statistics.calculators"/></a>
				<a class="nav-link text-muted" id="v-pills-messages-tab" data-toggle="pill" data-target="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false"><spring:message code="statistics.messages"/></a>			
			</div>
			<div class="tab-content col-md-10 br-left" id="v-pills-tabContent">
<!--  SECTION PILLS -->
<!-- SECTION HOME -->	  
				<div class="tab-pane fade show active " id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
						
						<div class="container text-muted">
<!-- SECTION HOME - GENERAL STATISTICS -->						
							<h5><spring:message code="statistics.general.statistics"/></h5><hr class="bg-orange">
							
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.available.calculators"/>: </p>
								</div>
								<div class="col-md-4">
									${generalStatisticsResultSet[0]}
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.today"/></p>
								</div>
								<div class="col-md-4">
									${ generalStatisticsResultSet[1]}
								</div>
							</div>	
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.yesterday"/></p>
								</div>
								<div class="col-md-4">
									${ generalStatisticsResultSet[2]}
								</div>
							</div>	
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.7days"/></p>
								</div>
								<div class="col-md-4">
									${ generalStatisticsResultSet[3]}
								</div>
							</div>								
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.30days"/></p>
								</div>
								<div class="col-md-4">
									${ generalStatisticsResultSet[4]}
								</div>
							</div>								
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.ever"/></p>
								</div>
								<div class="col-md-4">
									${generalStatisticsResultSet[4] }
								</div>
							</div>								
<!-- SECTION HOME - GENERAL STATISTICS -->	
<!-- SECTION HOME - CHART WITH ALL METHODS -->
							<h5 class="mt-4"><spring:message code="statistics.methods.chart"/></h5><hr class="bg-orange">
<!-- RADIO BUTTONS TO SELECT DATE RANGE AND CHART-->
							<div class="row">
								<div class="col-md-2">
									<div class="custom-control custom-radio">
										  <input value="today" type="radio" class="custom-control-input" id="radioFirstSelect" name="charDataRange" checked>
										  <label class="custom-control-label" for="radioFirstSelect"><spring:message code="statistics.today"/></label>
									 </div>
								</div>
								<div class="col-md-2">
									<div class="custom-control custom-radio">
										  <input value="yesterday" type="radio" class="custom-control-input" id="radioSecondSelect" name="charDataRange">
										  <label class="custom-control-label" for="radioSecondSelect"><spring:message code="statistics.yesterday"/></label>
									 </div>
								</div>
								<div class="col-md-2">
									<div class="custom-control custom-radio">
										  <input value="week" type="radio" class="custom-control-input" id="radioThirdSelect" name="charDataRange">
										  <label class="custom-control-label" for="radioThirdSelect"><spring:message code="statistics.7days"/></label>
									</div> 
								</div>
								<div class="col-md-2">
									<div class="custom-control custom-radio">
										  <input value="month" type="radio" class="custom-control-input" id="radioFourthSelect" name="charDataRange">
										  <label class="custom-control-label" for="radioFourthSelect"><spring:message code="statistics.30days"/></label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="custom-control custom-radio">
										  <input value="custom" type="radio" class="custom-control-input" id="radioFifthSelect" name="charDataRange">
										  <label class="custom-control-label" for="radioFifthSelect"><spring:message code="statistics.custom.range"/></label>
									</div>
								</div>
							</div>
							<div class="row" id="customRangeSection">
								<div class="col-md-5 text-center">
									<div class="md-form">
										<input class="datepicker-here text-center text-muted font-weight-bold" id="customRangeStartDate" placeholder="<spring:message code="statistics.placeholder.start.date"/>" type='text' data-position="top right" data-language='pl'/>
									</div>
								</div>
								<div class="col-md-5 text-center">
									<div class="md-form">
										<input class="datepicker-here text-center text-muted font-weight-bold" id="customRangeEndDate" type='text' placeholder="<spring:message code="statistics.placeholder.end.date"/>" data-position="top right" data-language='pl'/>
									</div>
								</div>
								<div class="col-md-2">
									<button id="customDateRangeSearchButton" type="button" class="btn btn-block bg-d-orange btn-table-spec mt-3 mb-3">
									 <i class="fa fa-search mx-3"></i> 	
									</button>
								</div>
							</div>
							<div class="row px-4 pt-0 mt-0">		
								<canvas id="barChart" height="120"></canvas>
							</div>
<!-- RADIO BUTTONS TO SELECT DATE RANGE AND CHART-->
<!-- SECTION HOME - CHART WITH ALL METHODS -->
						</div>
				</div>
<!-- SECTION HOME -->	
<!-- SECTION METHODS -->	  
				 <div class="tab-pane fade " id="v-pills-methods" role="tabpanel" aria-labelledby="v-pills-methods-tab">
				 	<div class="container text-muted">
					 	<select id="calculatorSelect" class="custom-select text-muted">
						  		
						  		<!--  Select is populated by JS -->
						  		
						</select>
					 	
					 	<hr class="bg-orange">
					 	
					 		<h5><spring:message code="statistics.general.statistics"/></h5><hr class="bg-orange">
							
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.first.use"/>: </p>
								</div>
								<div class="col-md-4">
									<span id="calculatorfirstUse"></span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.today"/></p>
								</div>
								<div class="col-md-4">
									<span id="calculatorToday"></span>
								</div>
							</div>	
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.yesterday"/></p>
								</div>
								<div class="col-md-4">
									<span id="calculatorYesterday"></span>
								</div>
							</div>	
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.7days"/></p>
								</div>
								<div class="col-md-4">
									<span id="calculator7Days"></span>
								</div>
							</div>								
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.30days"/> </p>
								</div>
								<div class="col-md-4">
									<span id="calculator30Days"></span>
								</div>
							</div>								
							<div class="row">
								<div class="col-md-6">
									<p><spring:message code="statistics.sum.of.operations"/>: <spring:message code="statistics.ever"/></p>
								</div>
								<div class="col-md-4">
									<span id="calculatorEver"></span>
								</div>
							</div>								
							<hr class="bg-orange my-0 py-0">
							<div class="row ">
								<div class="col-md-7">
									<h5 class="pt-4"> <spring:message code="statistics.monthly.chart"/>: </h5>
								</div>
								<div class="col-md-5">
									<div class="md-form my-3">
										<input type="text" id="inputMonth" class="datepicker-here" data-language='pl' data-min-view="months"data-view="months"data-date-format="MM yyyy" value=""/>
										<button id="getMonthlyChart" type="button" class="btn bg-d-orange btn-table-spec my-0">
											<i class="fas fa-arrow-right"></i>
										</button>
									</div>								
								</div>								
							</div>
							<hr class="bg-orange my-0 py-0">
							<div class="row px-4 pt-0 mt-0">		
								<canvas id="monthlyChart" height="120"></canvas>
							</div>			
				 	</div>
				 </div>
<!-- SECTION METHODS -->
<!-- SECTION MESSAGES -->	  
				 <div class="tab-pane fade " id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
				 	<div class="container text-muted">
					 
<!--  under construction -->
					 <div class="row">
					 	<div class="col-md-12 text-center text-muted font-weight-bold">
					 		<h3 class="my-3"><spring:message code="under.construction.module"/></h3>			 		
					 	</div>
					 </div>
					 <div class="row">
					 	<div class="col-md-12">
					 		<img class="img-fluid" src="<%=request.getContextPath()%>/img/page-under-construction.png"/>			 		
					 	</div>
					 </div>
<!--  under construction -->			
				 	</div>
				 </div>
<!-- SECTION METHODS -->		    
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/statistics.js"></script>

</body>
</html>