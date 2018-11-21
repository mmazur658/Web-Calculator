// * * global variables
var csrf_token = $('input[name="_csrf"]').val();

// * * * * clear all other fields then clicked * * * * 
$("#squareInputCircuit").keypress(function(){
	clearSquareFields("#squareInputCircuit");
});
$("#squareInputField").keypress(function(){
	clearSquareFields("#squareInputField");
});
$("#squareInputSideA").keypress(function(){
	clearSquareFields("#squareInputSideA");
});
$("#squareInputDiameter").keypress(function(){
	clearSquareFields("#squareInputDiameter");
});
$("#squareInputRadius").keypress(function(){
	clearSquareFields("#squareInputRadius");
});

// * * * * * submit square calculator form * * * * 
$("#squareForm").submit(function(event) {

      event.preventDefault();

      var $form = $( this ),
          url = $form.attr( 'action' );
      
      var hasNumericValue = findNumericValue($('#squareInputRadius').val(),$('#squareInputDiameter').val(),$('#squareInputSideA').val(), $('#squareInputCircuit').val(), $('#squareInputField').val());
      
      if(!hasNumericValue){
    	  
    	clearFields("#squareInputSideA","#squareInputCircuit","#squareInputField","#squareInputDiameter","#squareInputRadius");    	  
  		showCustomAlert('error','Tylko wartości numeryczne','Niepoprawny format danych','Only numeric values','Incorrect data format');

      } else {


      if($.trim($('#squareInputSideA').val()) != ""){
    	  var posting = $.post( url, { paramName: 'squareSideA', paramValue: $('#squareInputSideA').val(), _csrf: csrf_token }, function(data) {
    		  populateSquareInputFields(data);
    	  }); 
      } else if ($.trim($('#squareInputCircuit').val()) != ""){
    	  var posting = $.post( url, { paramName: 'squareCircuit', paramValue: $('#squareInputCircuit').val(), _csrf: csrf_token }, function(data) {
    		  populateSquareInputFields(data);
    	  }); 
      } else if ($.trim($('#squareInputField').val()) != ""){
    	  var posting = $.post( url, { paramName: 'squareField', paramValue: $('#squareInputField').val(), _csrf: csrf_token }, function(data) {
    		  populateSquareInputFields(data);
    	  }); 
      } else if ($.trim($('#squareInputDiameter').val()) != ""){
    	  var posting = $.post( url, { paramName: 'squareDiameter', paramValue: $('#squareInputDiameter').val(), _csrf: csrf_token }, function(data) {
    		  populateSquareInputFields(data);
    	  }); 
      } else if ($.trim($('#squareInputRadius').val()) != ""){
    	  var posting = $.post( url, { paramName: 'squareRadius', paramValue: $('#squareInputRadius').val(), _csrf: csrf_token }, function(data) {
    		  populateSquareInputFields(data);
    	  }); 
      } else {
    	  clearFields("#squareInputSideA","#squareInputCircuit","#squareInputField","#squareInputDiameter","#squareInputRadius");
      }
      };
	
 });
   
//* * * * * clear square form * * * * 
$("#square-clear-btn").click(function(){		
	clearFields("#squareInputSideA","#squareInputCircuit","#squareInputField","#squareInputDiameter","#squareInputRadius");
});

//* * * * * clear rectangle form * * * * 
$("#rectangle-clear-btn").click(function(){		
	clearFields("#rectangleInputSideA","#rectangleInputSideB","#rectangleInputField","#rectangleInputCircuit","#rectangleInputDiameter","#rectangleInputRadius")	
});

// * * * * clear given fields
function clearFields(){	
	for(var i = 0; i < arguments.length; i++)
		$(arguments[i]).val("").focus().trigger('blur');;				
}

//* * * * * submit rectangle form * * * * 
$("#rectangleForm").submit(function(event) {

	 event.preventDefault();

     var $form = $( this ),
         url = $form.attr( 'action' );
	
     var hasNumericValue = findNumericValue($('#rectangleInputRadius').val(),$('#rectangleInputDiameter').val(),$('#rectangleInputCircuit').val(),$('#rectangleInputField').val(),$('#rectangleInputSideB').val(),$('#rectangleInputSideA').val());
     
     if(!hasNumericValue){
   	  
    	clearFields("#rectangleInputSideA","#rectangleInputSideB","#rectangleInputField","#rectangleInputCircuit","#rectangleInputDiameter","#rectangleInputRadius") 	  
 		showCustomAlert('error','Tylko wartości numeryczne','Niepoprawny format danych','Only numeric values','Incorrect data format');

     } else {
	
    	 if($.trim($('#rectangleInputSideA').val()) != "" && $.trim($('#rectangleInputSideB').val()) != "" && $.trim($('#rectangleInputCircuit').val()) == "" && $.trim($('#rectangleInputField').val()) == "" ) {
    		 var posting = $.post( url, { paramName: 'sideA-sideB', paramValue1: $('#rectangleInputSideA').val(), paramValue2: $('#rectangleInputSideB').val(), _csrf: csrf_token  }, function(data) {
    			 populateRectangleInputFields(data)
    		 });
    	 } else if ($.trim($('#rectangleInputSideA').val()) != "" && $.trim($('#rectangleInputField').val()) != "" && $.trim($('#rectangleInputSideB').val()) == "" && $.trim($('#rectangleInputCircuit').val()) == "") {
    		 var posting = $.post( url, { paramName: 'sideA-field', paramValue1: $('#rectangleInputSideA').val(), paramValue2: $('#rectangleInputField').val(), _csrf: csrf_token  }, function(data) {
    			 populateRectangleInputFields(data)
    		 });
    	 } else if ($.trim($('#rectangleInputSideB').val()) != "" && $.trim($('#rectangleInputField').val()) != "" && $.trim($('#rectangleInputSideA').val()) == "" && $.trim($('#rectangleInputCircuit').val()) == "" ) {
    		 var posting = $.post( url, { paramName: 'sideB-field', paramValue1: $('#rectangleInputSideB').val(), paramValue2: $('#rectangleInputField').val(), _csrf: csrf_token  }, function(data) {
    			 populateRectangleInputFields(data)
    		 });
    	 } else if ($.trim($('#rectangleInputSideA').val()) != "" && $.trim($('#rectangleInputCircuit').val()) != "" && $.trim($('#rectangleInputSideB').val()) == "" && $.trim($('#rectangleInputField').val()) == "" ) {	 
    		 var posting = $.post( url, { paramName: 'sideA-circuit', paramValue1: $('#rectangleInputSideA').val(), paramValue2: $('#rectangleInputCircuit').val(), _csrf: csrf_token  }, function(data) {
    			 populateRectangleInputFields(data)
    		 });
    	 } else if ($.trim($('#rectangleInputSideB').val()) != "" && $.trim($('#rectangleInputCircuit').val()) != "" && $.trim($('#rectangleInputSideA').val()) == "" && $.trim($('#rectangleInputField').val()) == "" ) {	
    		 var posting = $.post( url, { paramName: 'sideB-circuit', paramValue1: $('#rectangleInputSideB').val(), paramValue2: $('#rectangleInputCircuit').val(), _csrf: csrf_token  }, function(data) {
    			 populateRectangleInputFields(data)
    		 });
    	 } else {    		 
    		clearFields("#rectangleInputSideA","#rectangleInputSideB","#rectangleInputField","#rectangleInputCircuit","#rectangleInputDiameter","#rectangleInputRadius")
    	 	showCustomAlert('error','','Nie można wykonać obliczeń na podstawie podanych parametrów.','','There`s no result for given parameters.');
    	 }
     }
});	

// * * * * * * * * * * Show toastr alert, depends on the langauge  * * * * * * * * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}

//* * * clear square fields except the given one * * * 
function clearSquareFields(clickedInputId){
	var inputIds = ["#squareInputSideA","#squareInputCircuit","#squareInputField","#squareInputDiameter","#squareInputRadius"];
	var i;
	for (i = 0; i < inputIds.length; i++) { 
	    if(clickedInputId!=inputIds[i])
	    	$(inputIds[i]).val("").focus();	    	
	}
	$(clickedInputId).focus();
}

//* * * * * check if any of the given parameters is numeric
function findNumericValue(){
	
	var hasNumericValue = false;
	
	for(var i = 0; i < arguments.length; i++){
		if ($.isNumeric($.trim(arguments[i])))
			hasNumericValue	= true;
	}
	
	return hasNumericValue;	
}

//* * * * * populate sqaure input field * * * *
function populateSquareInputFields(data){
	  $("#squareInputSideA").val(data[0]).focus();
      $("#squareInputCircuit").val(data[1]).focus();
      $("#squareInputField").val(data[2]).focus();
      $("#squareInputDiameter").val(data[3]).focus();
      $("#squareInputRadius").val(data[4]).focus();
}

//* * * * * populate rectangle input field * * * *
function populateRectangleInputFields(data){
	$("#rectangleInputSideA").val(data[0]).focus();
	$("#rectangleInputSideB").val(data[1]).focus();
	$("#rectangleInputField").val(data[2]).focus();
	$("#rectangleInputCircuit").val(data[3]).focus();
	$("#rectangleInputDiameter").val(data[4]).focus();
	$("#rectangleInputRadius").val(data[5]).focus();
}