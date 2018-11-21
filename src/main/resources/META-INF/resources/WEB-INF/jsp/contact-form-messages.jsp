<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">

<head> <!-- IMPORT, CSRF, TITLE, STYLE -->

	<%@ include file="parts/head.jsp" %>   
	<title><spring:message code="contact.form.messages.title"/></title>  

</head> <!-- IMPORT, CSRF, TITLE, STYLE -->

<body class="bg-blue">

<!-- ADD CLASS 'fade-out' TO BODY TO GET SMOOTH PAGE LOADING EFFECT -->
<script>document.body.className += ' fade-out';</script>

<!-- NAVBAR & INTRO -->
	<%@ include file="parts/admin-nav.jsp" %>
<!-- NAVBAR & INTRO -->

<main class="mt-100" style="min-height: 100%;">
<div class="container bg-white"> 
<!-- TABLE HEADER WITH ACTION BUTTONS -->
		<div id="table-header" class="row mx-3 shadow">
<!-- DELETE - OPEN - CHANGE STATUS - REPLY -->			
			<div class="col-md-4 bg-orange pt-2">		
				<button id="deleteBtn" type="button" class="btn bg-d-orange btn-table-spec">
					<i class="fas fa-trash-alt"></i>
				</button>		
				<button id="openBtn" type="button" class="btn bg-d-orange btn-table-spec" data-toggle="modal" data-target="">
					<i class="fas fa-book-open"></i>
				</button>				
				<button id="readBtn" type="button" class="btn bg-d-orange btn-table-spec">
					<i class="fas fa-check"></i>
				</button>				
				<button id="changeReplyStatusBtn" type="button" class="btn bg-d-orange btn-table-spec">
					<i class="fas fa-reply"></i>
				</button>
			</div>
<!-- DELETE - OPEN - CHANGE STATUS - REPLY -->				
<!-- NEWS - ARCHiVE - ALL -->
			<div class="col-md-5 bg-orange text-center pt-2">
				<div class="btn-group btn-group-toggle my-2" data-toggle="buttons">
				  <label class="btn btn-r-custom bg-d-orange active">
				    <input type="radio" name="options" autocomplete="off" value="new" checked> <spring:message code="contact.form.messages.new"/>
				  </label>
				  <label class="btn btn-r-custom bg-d-orange">
				    <input type="radio" name="options" autocomplete="off" value="archive"> <spring:message code="contact.form.messages.archive"/> 
				  </label>
				  <label class="btn btn-r-custom bg-d-orange">
				    <input type="radio" name="options" autocomplete="off" value="all"> <spring:message code="contact.form.messages.all"/> 
				  </label>
				</div>
			</div>
<!-- NEWS - ARCHiVE - ALL -->		
<!-- SEARCH MODAL -->			
			<div class="col-md-3 bg-orange">	
<!-- MODAL TRIGGER -->		
				<button type="button" class="btn btn-block bg-d-orange btn-table-spec mt-3 mb-3" data-toggle="modal" data-target="#searchContactFormMessageBtn">
				 <span><spring:message code="btn.search"/></span>  <i class="fa fa-search mx-3"></i><span class="badge badge-warning ml-2" id="setParams">0</span> 	
				</button>	
<!-- MODAL TRIGGER -->				
<!-- MODAL CONTENT -->
				<div class="modal fade" id="searchContactFormMessageBtn" tabindex="-1" role="dialog" aria-labelledby="#searchContactFormMessageTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered" role="document">
				    <div class="modal-content">
				      <div class="modal-header bg-orange">
					        <h6 class="modal-title text-white font-weight-bold" id="searchContactFormMessageTitle"><spring:message code="contact.form.messages.search.modal.form"/></h6>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
				      </div>				      
				      <div class="modal-body bg-blue mt--5 mb--5" >
					       <form id="searchForm" class="text-white" action="">	
								<div class="md-form">
									<input id="searchFormName" class="form-control text-white font-weight-bold" type="text" name="" value = "">
									<label class="text-white" for="searchFormName"><spring:message code="contact.form.sender"/></label>
								</div>
								<div class="md-form">
									<input id="searchFormEmail" class="form-control text-white font-weight-bold" type="text" name="" value = "">	
						 			<label class="text-white" for="searchFormEmail"><spring:message code="contact.form.email"/></label>	
								</div>
								<div class="md-form">
									<input id="searchFormSubject" class="form-control text-white font-weight-bold" type="text" name="" value = "">
									<label class="text-white" for="searchFormSubject"><spring:message code="contact.form.subject"/></label>
								</div>
								<div class="row">
									<div class="col-md-6 text-center">
										<div class="md-form">
											<input class="datepicker-here text-center text-white font-weight-bold" id="searchFormStartDate" placeholder="Początek" type='text' data-position="top right" data-language='pl'/>
										</div>
									</div>
									<div class="col-md-6 text-center">
										<div class="md-form">
											<input class="datepicker-here text-center text-white font-weight-bold" id="searchFormEndDate" type='text' placeholder="Koniec" data-position="top right" data-language='pl'/>
										</div>
									</div>
								</div>						
								<div class="row">
									<div class="col-md-6 text-center">										
										<button type="submit" id="submitBtn" class="btn btn-block bg-d-orange shadow "><spring:message code="btn.search"/></button>		
									</div>
									<div class="col-md-6 text-center">									
										<a id="clearSearchParametersBtn" class="btn btn-block bg-d-orange shadow"><spring:message code="btn.clear"/></a>
									</div>
								</div>
							</form>
						 </div>		     
				    </div>
				  </div>
				</div>
<!-- MODAL CONTENT -->
			</div>
<!-- SEARCH MODAL -->	
		</div>	
<!-- TABLE HEADER WITH ACTION BUTTONS -->
<!-- MESSAGES TABLE -->
	<table id="message-list-table" class="table table-sm table-striped table-hover mh-100">
<!-- * * * * * * * * * * * * * * * * * -->			      
<!-- * * * MESSAGES TABLE CONTENT * *  -->				      		
<!-- * * * * * * * * * * * * * * * * * -->
	</table>
<!-- MESSAGES TABLE -->
	<input type="hidden" id="resultStartRange" value="">
<!-- PAGINATION -->
			<nav aria-label="Page navigation example">	
				<ul class="pagination justify-content-end ">
					<li class="page-item mb-2"><button id="less-btn" class="btn btn-sm bg-orange page-link text-white font-weight bold p-1 mt-1" > <<< </button></li>
					<li class="page-item mb-2"><h6 class="text-muted font-weight-bold px-3 mt-1" id="result-label" ></h6></li>
					<li class="page-item mb-2"><button id="more-btn" class="btn btn-sm bg-orange page-link text-white font-weight bold p-1 mt-1"> >>> </button></li>
				</ul>
			</nav>
<!-- PAGINATION -->
<!-- MESSAGE MODAL -->
				<div class="modal fade" id="contactFormMessageModal" tabindex="-1" role="dialog" aria-labelledby="#contactFormMessageModalTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
				    <div class="modal-content">
				      <div class="modal-header bg-orange">
					        <h6 class="modal-title text-white font-weight-bold" id="contactFormMessageModalTitle"><spring:message code="contact.form.messages.message.modal.title"/> </h6>
					        <button id="close-modal-button" type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
				      </div>
				      
				      <div id="modal-body-contect" class="modal-body bg-blue mt--5 mb--5">				      
<!-- * * * * * * * * * * * * * * * * * -->			      
<!-- * * * * * MODAL CONTENT * * * * * -->				      		
<!-- * * * * * * * * * * * * * * * * * -->
					 </div>		     
				 </div>
			</div>
		</div>			
<!-- MESSAGE MODAL -->

</div>

</main>-
<!-- FOOTER -->
<%@ include file="parts/footer.jsp" %> 
<!-- FOOTER -->

<!-- SCRIPTS PACKAGE-->
<%@ include file="parts/footer-scripts.jsp" %> 
<!--  MORE SCRIPTS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/contact-form-messages.js"></script>

</body>

</html>
