<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- CONTACT FORM MESSAGE MODAL -->
<!-- MESSAGE HEADER: NAME, EMAIL, DATE, SUBJECT -->
<div class="row" class="">
	<div class="col-md-2 text-white py-1 mx-3 border-bottom pl-2"><spring:message code="contact.form.sender"/>:</div>
	<div class="col-md-9 text-white py-1 ml-2 border-bottom">${contactFormMessage.senderName}</div>
</div>
				      		
<div class="row" class="">
	<div class="col-md-2 text-white py-1 mx-3 border-bottom pl-2"><spring:message code="contact.form.email"/>:</div>		
	<div class="col-md-9 text-white py-1 ml-2 border-bottom">${contactFormMessage.senderEmail}</div>
</div>
				      		
<div class="row" class="">
	<div class="col-md-2 text-white py-1 mx-3 border-bottom pl-2"><spring:message code="contact.form.date"/>:</div>
	<div class="col-md-9 text-white py-1 ml-2 border-bottom">${contactFormMessage.date}</div>
</div>
				      		
<div class="row" class="">
	<div class="col-md-2 text-white py-1 mx-3 border-bottom pl-2"><spring:message code="contact.form.subject"/>:</div>
	<div class="col-md-9 text-white py-1 ml-2 border-bottom">${contactFormMessage.messageSubject}</div>
</div>
<!-- MESSAGE HEADER: NAME, EMAIL, DATE, SUBJECT -->
 <!-- MESSAGE MODAL NAVIGATION BUTTONS --> 			
<div class="row">
	<div class="col-md-6 align-left text-left" style="height: 0px;">
		<button id="previousBtn" class="left-angle-button bg-transparent border-0 p-4"><i class="fas fa-angle-left fa-10x text-white"></i></button>
	</div>
	
	<div class="col-md-6 align-right text-right" style="height: 0px;">
		<button id="nextBtn" class="right-angle-button bg-transparent border-0 p-4"><i class="fas fa-angle-right fa-10x text-white"></i></button>
	</div>
</div>	
<!-- MESSAGE MODAL NAVIGATION BUTTONS --> 		      		
<!-- MESSAGE TEXT -->     
<div class="row">
	<div class="col-md-12 mt-3 pr-4">
		<div class="container border p-3 text-justify text-white" style="min-height: 250px;">
			<span>${contactFormMessage.messageText}</span>
		</div>
	</div>
</div>
<!-- MESSAGE TEXT --> 
<!-- MESSAGE ACTION BUTTONS -->   				      		
<div class="row mt-3">
	<div class="col-md-4">
		<button id="deleteMessageBtn" type="button" class="btn bg-d-orange btn-table-spec shadow">
			<i class="fas fa-trash-alt"></i>
		</button>
									
		<button id="readStatusBtn" type="button" class="btn bg-d-orange btn-table-spec shadow">
			<i class="fas fa-check"></i>
		</button>
									
		<button id="repliedStatusButton" type="button" class="btn bg-d-orange btn-table-spec shadow">
			<i class="fas fa-reply"></i>
		</button>
	</div>
<!-- MESSAGE ACTION BUTTONS -->   
<!-- COMMENTS ACTION BUTTONS -->   	
	<div class="col-md-3 text-center">	
		<button id="addCommentButton" type="button" class="btn bg-d-orange btn-table-spec shadow">
			<i class="fas fa-plus"></i>
		</button>
									
		<button id="deleteCommentButton" type="button" class="btn bg-d-orange btn-table-spec shadow">
			<i class="fas fa-minus"></i>
		</button>
	</div>
<!-- COMMENTS ACTION BUTTONS --> 
<!-- SEND EMAIL AND CLOSE BUTTON -->
	<div class="col-md-1 "></div>
	<div class="col-md-2 ">
		<a target="_blank" href="mailto:${contactFormMessage.senderEmail}" id="sendEmailButton" class="mt-1 btn btn-block bg-d-orange btn-table-spec text-white"><spring:message code="contact.form.email"/></a>
	</div>

	<div class="col-md-2 pr-4">									
		<button id="closeMessageModalBtn" class="mt-1 btn btn-block bg-d-orange btn-table-spec text-white"><spring:message code="btn.close"/></button>
	</div>
<!-- SEND EMAIL AND CLOSE BUTTON -->
</div>
<!-- ADD COMMENT SECTION -->
<div id="addCommentDiv" class="container bg-white px-2 py-2 mt-2">
	<form id="addCommentForm" action="admin-action/add-comment">
		<div class="row mx-0 pt-3">
<!-- ADD/CANCEL COMMENT BUTTONS -->
			<div class="col-md-2 mx-0 px-0">
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-block bg-d-orange text-white">
							<i class="fas fa-check fa-2x"></i>
						</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<a id="cancelCommentBtn" class="btn btn-block bg-d-orange text-white">
							<i class="fas fa-times fa-2x"></i>
						</a>
					</div>
				</div>
			</div>
<!-- ADD/CANCEL COMMENT BUTTONS -->
<!-- COMMENT TEXT -->			
			<div class="col-md-10 mx-0 px-0">
				<div class="form-group">
				  <textarea class="form-control" rows="4" id="commentText"></textarea>
				</div>
			</div>
<!-- COMMENT TEXT -->			
		</div>
	</form>
</div>
<!-- ADD COMMENT SECTION -->
<!-- COMMENTS SECTION -->				      						      		
<div class="container bg-white mx-0 px-0 mt-2" style="overflow: hidden; overflow-y: scroll; max-height: 250px;">		      		
	<table id="message-table" class="table table-sm table-striped table-hover pr-2" >
<!-- COMMENTS TABLE HEADER-->		
		<thead>
			<tr>
				<th width="7%" scope="col" class="text-center">#</th>
				<th width="13%"scope="col"><spring:message code="contact.form.date"/></th>
				<th width="80%" scope="col"><spring:message code="contact.comment"/></th>
				<th style="display: none;"> 
			</tr>
		</thead>
<!-- COMMENTS TABLE HEADER-->	
<!-- COMMENTS TABLE BODY-->	
		<tbody>		
			<c:forEach var="tempComment" items="${commentsList}">	
				<tr id="table-row" class="text-muted" data-id="${tempComment.id}">
					<td scope="row" class="text-center">      
						<div class="pretty p-default p-smooth px-0 mr-0">
							<input name="table-message-chbox" type="checkbox" value="${tempComment.id}" /> 
							<div class="state p-danger mr-0 px-0">
								<label></label>
							</div>
						</div>
					</td>								
					<td class=""><fmt:formatDate value="${tempComment.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>		
					<td class="text-justify">${tempComment.commentText}</td>
				<tr>					
			</c:forEach>
		</tbody>
<!-- COMMENTS TABLE BODY-->	
	</table>			      		
</div>
<!-- COMMENTS SECTION -->	
<!-- SCRIPTS IMPORT -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/message-modal.js"></script>
<!-- SCRIPTS IMPORT -->
<!-- CONTACT FORM MESSAGE MODAL -->