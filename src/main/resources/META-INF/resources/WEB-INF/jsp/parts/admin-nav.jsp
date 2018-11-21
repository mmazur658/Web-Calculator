<%@ page pageEncoding="UTF-8"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
<!-- ADMINISTRATOR PANEL NAVBAR -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark-blue">  
	    <div class="collapse navbar-collapse" id="mainNav">	
<!-- LINKS -->    
			<ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href=""><h4>WEB CALCULATOR</h4></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link pt-2" href="${pageContext.request.contextPath}/administrator-panel/dashboard">DASHBOARD</a>
				</li>
			    <li class="nav-item">
			        <a class="nav-link pt-2" href="${pageContext.request.contextPath}/administrator-panel/statistics"><spring:message code="nav.stats"/></a>
			    </li>
			</ul>
<!-- LINKS --> 
<!-- MESSAGES AND NOTIFICATIONS --> 	
			<ul class="navbar-nav nav-flex-icons">
			    <li class="nav-item">
			       <a class="nav-link" href="${pageContext.request.contextPath}/administrator-panel/contact-form-messages">
			       		<i class="fas fa-comment-alt px-2 pt-3"></i>	
			       		<span class="badge badge-warning">${numberOfUnreadContactFormMessage}</span>		       
			       </a>			       
			    </li>
			    <li class="nav-item">
			        <a class="nav-link">
			        	<i class="fas fa-envelope px-2 pt-3"></i>	
			        	<span class="badge badge-warning">55</span>	
			        	<i class="fas fa-ban fa-3x" style="position: absolute; z-index: 1; top: 6px; left: 5px; color: #E04B26"  ></i>	        	
			        </a>			        
			    </li>
			    <li class="nav-item mr-1">
			        <a class="nav-link">
			        	<i class="fas fa-bell px-2 pt-3"></i>
			        	<span class="badge badge-warning">1250</span>		
			        	<i class="fas fa-ban fa-3x" style="position: absolute; z-index: 1; top: 6px; left: 5px; color: #E04B26"  ></i>	        
			        </a>			        		
			    </li>
			</ul>
<!-- MESSAGES AND NOTIFICATIONS --> 
<!-- PROFILE AND LANGUAGE --> 	  	
			    <div class="dropdown pt-1">
				    <a id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
				    	<img class="mb-1" src="<%=request.getContextPath()%>/img/mazur.png" height="48px" width="48px" ></img>
				    </a>
				    <div class="dropdown-menu dropdown-menu-right mt-3" style="width: 256px; border-radius: 0px;  padding-top: 0; padding-bottom: 0;">
				    	<div class="dropdown-item text-center shadow bg-d-orange mt-0">
				    		<img class="img-fluid mt-2 shadow-lg" src="<%=request.getContextPath()%>/img/mazur.png" height="128px" width="128px" style="border-radius: 50%;"></img>
				    		<h3 class="text-white" >Marcin Mazur</h3>
				    		<h6 class="text-white" >Administrator</h6>
				    		<a href="${pageContext.request.contextPath}/administrator-panel/dashboard?lang=pl_pl">
				    			<img class="mb-3" style="opacity: 0.7;" src="<%=request.getContextPath()%>/img/poland-flag.png" alt="Poland Flag" >
				    		</a>
				    		<a href="${pageContext.request.contextPath}/administrator-panel/dashboard?lang=en_us">
			    				<img class="mb-3" style="opacity: 0.7;" src="<%=request.getContextPath()%>/img/united-kingdom-flag.png" alt="United Kingdom Flag" >
			    			</a>
				    	</div>
					    <div class="bg-white">
						    <a class="dropdown-item" href="#"><spring:message code="nav.profile"/></a>						    
						    <form:form name="logoutForm" action="${pageContext.request.contextPath}/logout" method="POST">
						      	 <a class="dropdown-item" onclick="logoutForm.submit();"><spring:message code="nav.logout"/></a>
						     </form:form>
					    </div>	
				    </div>
				 </div>
<!-- PROFILE AND LANGUAGE --> 	
		</div>	
	</nav>
<!-- ADMINISTRATOR PANEL NAVBAR -->	
	