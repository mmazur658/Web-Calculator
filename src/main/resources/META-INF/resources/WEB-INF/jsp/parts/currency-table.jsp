<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- CURRENCY TABLE -->
<!-- TABLE HEADER-->
 <thead>
	<tr>
		<th class="font-weight-bold" scope="col"><spring:message code="currency.code"/></th>
		<th class="font-weight-bold" scope="col"><spring:message code="currency.name"/></th>
		<th class="font-weight-bold" scope="col"><spring:message code="currency.price"/></th>
		<th class="font-weight-bold" scope="col"><spring:message code="currency.change"/></th>
		<th class="font-weight-bold" scope="col"><spring:message code="currency.change.percentage"/></th>
	</tr>
</thead>
<!-- TABLE HEADER-->
<!-- TABLE BODY-->
<tbody>
	<c:forEach var="tempCurrency" items="${currencyList}">
		<tr>
			<td class="font-weight-bold" >${tempCurrency.code }</td>
			<td class="font-weight-bold" >${tempCurrency.currencyName }</td>
			<td class="font-weight-bold" >${tempCurrency.mid }</td>			
			
			<c:choose>
				<c:when test="${tempCurrency.status eq 'minus'}">
					<td class="font-weight-bold" style="color: #c60303;">${tempCurrency.change }</td>
					<td class="font-weight-bold" style="color: #c60303;">${tempCurrency.percentageChange }</td>
				</c:when>
				<c:otherwise>
					<td class="font-weight-bold" style="color: #0d8709;">+${tempCurrency.change }</td>
					<td class="font-weight-bold" style="color: #0d8709;">+${tempCurrency.percentageChange }</td>
				</c:otherwise>
			</c:choose>		
		
		</tr>			
	</c:forEach>		  
</tbody>
<!-- TABLE BODY-->
<!-- CURRENCY TABLE -->