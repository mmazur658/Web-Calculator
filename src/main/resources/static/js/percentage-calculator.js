//  * * * CSRF TOKEN * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * make culculations depending on calculation type * * * 
$('#percentage-calc-101').submit(function(event) {		
	event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param101Value1', '#param101Value2', '#result101', '101', url)	   
});
$('#percentage-calc-102').submit(function(event) {		
	 event.preventDefault();      
	 var $form = $( this ),
	 url = $form.attr( 'action' );      
	 getPercentageResult('#param102Value1', '#param102Value2', '#result102', '102', url)	   
});
$('#percentage-calc-103').submit(function(event) {		
	event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param103Value1', '#param103Value2', '#result103', '103', url)
});
$('#percentage-calc-104').submit(function(event) {		
	event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param104Value1', '#param104Value2', '#result104', '104', url)   
});
$('#percentage-calc-105').submit(function(event) {	
    event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param105Value1', '#param105Value2', '#result105', '105', url)	   
});
$('#percentage-calc-106').submit(function(event) {	
	event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param106Value1', '#param106Value2', '#result106', '106', url)	   
});
$('#percentage-calc-107').submit(function(event) {		
	event.preventDefault();      
	var $form = $( this ),
	url = $form.attr( 'action' );      
	getPercentageResult('#param107Value1', '#param107Value2', '#result107', '107', url)	   
});

// * * * get results * * *
function getPercentageResult(paramValue1Id, paramValue2Id, resultId, operationCode, url){
	
	// check if input data contains commas
	if($.trim($(paramValue1Id).val()).indexOf(",") != -1 || $.trim($(paramValue2Id).val()).indexOf(",") != -1){		
		showCustomAlert('error','','Proszę użyć kropki zamiast przecinka','','Please use dot insted of comma');
	} else {
		
		// check if all required fields are not null
		if(!$.isNumeric($.trim($(paramValue1Id).val())) || !$.isNumeric($.trim($(paramValue2Id).val()))){
			showCustomAlert('error','Puste Pola','Proszę wypełnić oba pola','Blank fields','Please fill all two fields');	
		} else {
			
			// get result
			$.post( url, { operationNumber: operationCode, paramValue1: $(paramValue1Id).val(), paramValue2: $(paramValue2Id).val(), _csrf: csrf_token  }, function(data) {
				$(resultId).text(data);
			}); 	  
		}; 
	}
}

// * * * clear all fields on button click * * * 
$(document).ready(function(){
	$("#clear-btn").click(function(){
		$("input").val("");
		$("#result101, #result102, #result103, #result104, #result105, #result106, #result107").text("");
	});
});

// * * * Show toastr alert depending on the langauge  * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}