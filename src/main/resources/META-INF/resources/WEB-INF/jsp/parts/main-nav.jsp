<%@ page pageEncoding="UTF-8"%>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
<!-- MAIN-PAGE NAVBAR -->	
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar wow fadeIn" data-wow-delay="1.0s">
	    <div class="collapse navbar-collapse" id="mainNav">
<!-- LINKS -->		
			<ul class="navbar-nav mr-auto smooth-scroll">
			    <li class="nav-item">
			        <a class="nav-link" href="#intro"><spring:message code="nav.start"/></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="#calculator"><spring:message code="nav.calculator"/></a>
				</li>
			    <li class="nav-item">
			        <a class="nav-link" href="#category"><spring:message code="nav.categories"/></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="#contact"><spring:message code="nav.contact"/></a>
			    </li>
			</ul>
<!-- LINKS -->	
<!-- SOCIAL MEDIA AND LANGUAGE -->	
			<ul class="navbar-nav nav-flex-icons">			
			    <li class="nav-item">
			        <a class="nav-link"><i class="fab fa-facebook-f"></i></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link"><i class="fab fa-linkedin-in"></i></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link"><i class="fab fa-github"></i></a>
			    </li>
			    
			    <li class="nav-item mt-2 mx-2">
					<a href="${pageContext.request.contextPath}/?lang=en_us">
	    				<img class="mb-3" style="opacity: 0.7;" src="<%=request.getContextPath()%>/img/united-kingdom-flag.png" alt="United Kingdom Flag" >
	    			</a>
				</li>
				<li class="nav-item mt-2 mr-2">
					<a href="${pageContext.request.contextPath}/?lang=pl_pl">
	    				<img class="mb-3" style="opacity: 0.7;" src="<%=request.getContextPath()%>/img/poland-flag.png" alt="Poland Flag" >
	    			</a>
				</li>		
			</ul>
<!-- SOCIAL MEDIA AND LANGUAGE -->	
		</div>	
	</nav>
<!-- MAIN-PAGE NAVBAR -->	