<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- FOOTER -->
<footer class="page-footer font-small pt-4">
<!-- SOCIAL MEDIA ICONS -->
	<div class="container">
		 <ul class="list-unstyled list-inline text-center">
	        <li class="list-inline-item wow fadeInLeftBig" data-wow-delay="0.5s">
	          	<a href="https://www.facebook.com/marcin.mazur.1024.2" class="btn-floating btn-fb mx-1">
	            	<i class="fab fa-facebook-f fa-4x pr-4 "> </i>
	          	</a>
	        </li>
	        <li class="list-inline-item wow fadeInLeftBig" data-wow-delay="0.3s">
		      	<a href="https://www.linkedin.com/in/marcin-mazur-1024/" class="btn-floating btn-linkedin mx-1">
	               <i class="fab fa-linkedin-in fa-4x pr-4"> </i>
	            </a>
	        </li>
	        <li class="list-inline-item wow fadeInLeftBig" data-wow-delay="0.1s">
	          	<a href="https://github.com/mmazur658" class="btn-floating btn-github mx-1">
	            	<i class="fab fa-github fa-4x"> </i>
	          	</a>
	        </li>
	      </ul>
	 </div>
<!-- SOCIAL MEDIA ICONS -->
<!-- FOOTER TRIGGER -->	
<a data-toggle="modal" data-target="#footerModal"> 
	<div class="footer-copyright py-2 text-center bg-blue" >© 2018 Copyright: Marcin Mazur</div>
</a>
<!-- FOOTER TRIGGER -->		
	 
<!-- FOOTER MODAL -->
<div class="modal fade right" id="footerModal" tabindex="-1" role="dialog" aria-labelledby="footerModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-side modal-bottom-right" role="document">
		<div class="modal-content bg-blue">
			<div class="modal-header bg-orange">
				<h5 class="modal-title" id="footerModalLabel">Marcin Mazur</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		<div class="modal-body">
			<div class="row">
				<div class="col-md-12 text-center">
					<img class="mb-1" src="<%=request.getContextPath()%>/img/mazur.png" height="156px" width="156px" ></img>
					<h5>Marcin Mazur</h5>
					<h4></h4>
				
				</div>
			</div>
			<div class="row my-2">
				<div class="col-md-12">
					<p class="text-justify">
						<spring:message code="footer.copyright.info"/>:
						<a href="https://getbootstrap.com/" target="_blank">Bootstrap</a>,
						<a href="https://mdbootstrap.com/" target="_blank">MdBootstrap</a>,
						<a href="https://fontawesome.com/" target="_blank">Font Awesome</a>,
						<a href="http://t1m0n.name/air-datepicker/docs/" target="_blank">Air DatePicker</a>,
						<a href="https://lokesh-coder.github.io/pretty-checkbox/" target="_blank">Pretty Checkbox</a>,
						<a href="http://faviconit.com/" target="_blank">Faviconit</a>.
					</p>
					<h6 class="text-center"><spring:message code="footer.info"/></h6>
				</div>
			</div>
			 
			        
			<div class="row">
				<div class="col-md-12">
					<button type="button" class="btn btn-block bg-d-orange"><spring:message code="footer.btn.portfolio"/></button>
				</div>
			</div>
			<div class="row my-2">
				<div class="col-md-12">
					<button type="button" class="btn btn-block bg-d-orange" data-dismiss="modal"><spring:message code="btn.close"/></button>
				</div>
			</div>

		</div>   
		        
		</div>
	</div>
</div>
<!-- FOOTER MODAL -->
</footer>
<!-- FOOTER -->