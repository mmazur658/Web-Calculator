<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- CONTACT FORM -->
<section id="contact" class="py-5" style="background-color: #6BB2C2;">
    <div class="container">
<!-- CONTACT FORM HEADER AND TEXT-->    
        <h2 class="h1-responsive font-weight-bold text-center mb-5 wow fadeIn item-dark-blue" data-wow-delay="0.3s"><spring:message code="contact.form.heading"/></h2>
        
        <p class="text-center w-responsive mx-auto mb-5 wow fadeIn item-dark-blue" data-wow-delay="0.3s"><spring:message code="contact.form.text"/></p>
<!-- CONTACT FORM HEADER AND TEXT-->    
        <div class="row ">
<!-- CONTACT FORM INPUTS -->          
            <div class="col-md-9 mb-md-0 mb-5 wow fadeInLeft" data-wow-delay="0.6s">
            	<form:form id="contact-form" action="/contact-form-message/sent-message">            	
                	<div class="row">
		                <div class="col-md-6">
		                    <div class="md-form mb-0">
		                    <input type="text" id="contact-name" class="form-control">
		                    <label for="contact-name" class="item-dark-blue"><spring:message code="contact.form.sender"/></label>
		                    </div>
		                </div>
		                <div class="col-md-6">
		                    <div class="md-form mb-0">
		                    <input type="email" id="contact-email" class="form-control">
		                    <label for="contact-email" class="item-dark-blue"><spring:message code="contact.form.email"/></label>
		                    </div>
		                </div>
                	</div>  
                	<div class="row">
		                <div class="col-md-12">
		                    <div class="md-form mb-0">
		                    <input type="text" id="contact-subject" class="form-control">
		                    <label for="contact-Subject" class="item-dark-blue"><spring:message code="contact.form.subject"/></label>
		                    </div>
		                </div>		                
               		 </div> 
                	<div class="row">
		                <div class="col-md-12">
		                    <div class="md-form">
			                    <textarea type="text" id="contact-message" class="form-control md-textarea" rows="3"></textarea>
			                    <label class="item-dark-blue" for="contact-message"><spring:message code="contact.form.message"/></label>
		                    </div>
		                </div>
				    </div>				    
                <div class="text-center text-md-left wow fadeInUp" data-wow-delay="1.0s">
                	<button type="submit" class="btn btn-md bg-dark-blue text-white"><spring:message code="contact.form.send"/></button>
            	</div>
            	
            </form:form>
       </div>
<!-- CONTACT FORM INPUTS --> 
<!-- CONTACT INFORMATION --> 
       <div class="col-md-3 text-center">
            <ul class="list-unstyled mb-0">
                <li class="wow fadeInRight" data-wow-delay="0.8s">
	                <i class="fa fa-map-marker fa-3x item-dark-blue"></i>
	                <p class="item-dark-blue">Wrocław, <spring:message code="contact.form.poland"/></p>
                </li>
                <li class="wow fadeInRight" data-wow-delay="0.8s">
	                <i class="fa fa-phone fa-3x mt-4 item-dark-blue"></i>
	                <p class="item-dark-blue">+48 690 372 851</p>
                </li>
                <li class="wow fadeInRight" data-wow-delay="0.8s">
	                <i class="fa fa-envelope fa-3x mt-4 item-dark-blue"></i>
	                <p class="mb-0 item-dark-blue">marcin.mazur1024@gmail.com</p>
                </li>
            </ul>
       </div>
 <!-- CONTACT INFORMATION -->       
	</div>
 </div>
</section>
<!-- CONTACT FORM -->