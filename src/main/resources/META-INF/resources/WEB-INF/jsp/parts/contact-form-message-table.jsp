<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<!-- CONTACT FORM MESSAGES TABLE --> 
<!-- HIDDEN INPUT FOR TOTAL RESULT VALUE -->
<input type="hidden" id="totalResults" value="${totalResults}">
<!-- HIDDEN INPUT FOR TOTAL RESULT VALUE -->
 <!-- TABLE HEADER -->
   <thead>
    <tr>
      <th width="5%" scope="col" class="text-center">#</th>
      <th width="11%"scope="col"><spring:message code="contact.form.date"/></th>
      <th width="18%" scope="col"><spring:message code="contact.form.sender"/></th>
      <th width="24%" scope="col"><spring:message code="contact.form.email"/></th>
      <th width="34%"scope="col"><spring:message code="contact.form.subject"/></th>
      <th width="8%"scope="col"><spring:message code="contact.form.reply"/></th>
      <th style="display: none;">
      <th style="display: none;">      
    </tr>
  </thead>
<!-- TABLE HEADER -->  
<!-- TABLE BODY -->
  <tbody>
  	<c:forEach var="tempMessage" items="${contactFormMessageList}">
   		<tr id="table-row" class="text-muted" data-id="${tempMessage.id}">    
		    <td scope="row" class="text-center">      
				<div class="pretty p-default p-smooth px-0 mr-0">
				   <input name="table-chbox" type="checkbox" value="${tempMessage.id}" /> 
				     <div class="state p-danger mr-0 px-0">
				       <label></label>
				      </div>
				 </div>
		    </td>    
		    <c:choose>
				<c:when test="${tempMessage.isReaded != 'true'}">
					<td class="font-weight-bold"><fmt:formatDate value="${tempMessage.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td class="font-weight-bold">${tempMessage.senderName}</td>
					<td class="font-weight-bold">${tempMessage.senderEmail}</td>
					<td class="font-weight-bold">${tempMessage.messageSubject}</td>
				</c:when>
				<c:otherwise>					
					<td><fmt:formatDate value="${tempMessage.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${tempMessage.senderName}</td>
					<td>${tempMessage.senderEmail}</td>
					<td>${tempMessage.messageSubject}</td>
				</c:otherwise>
			</c:choose>
	  	
			<c:choose>
				<c:when test="${tempMessage.isReplied == 'true'}">
					<td><i class="far fa-check-square"></i></td>		 
				</c:when>
				<c:otherwise>					
					<td><i class="far fa-square"></i></td>
				</c:otherwise>
			</c:choose>
	
		  	<td style="display: none;">${tempMessage.isReaded}</td>
		  	<td style="display: none;">${tempMessage.isReplied}</td>
		  	
  		</tr>
  </c:forEach>   
</tbody>
<!-- TABLE BODY -->
<!-- CONTACT FORM MESSAGES TABLE --> 
