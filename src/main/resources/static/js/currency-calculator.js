//  * * * CSRF TOKEN * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * LOAD CURRENCY TABLE ON PAGE LOADING * * * 
$(document).ready(function(){
	$('#currency-table').load('currency-calculator/get-currency-table')
});

//  * * * load currency table on page load or currency first column change * * * 	
$('#first-select-list').on('change', function() {
	
	// load table for selected currency
	$('#currency-table').load('currency-calculator/get-currency-table', {selectedCurrencyCode: $(this).val(), _csrf: csrf_token  }, function(){

	// get firstColumn row text
	var tableRow = $("td").filter(function() {
	    return $(this).text() == $('#first-select-list').val();
	}).closest("tr");		
	var text = tableRow[0].outerText

	// find numeric index to extract currency mid
	var firstNumeric;
	for(var i=0; text.length ; i++){
		if($.isNumeric(text.charAt(i))){
			firstNumeric = i;
			break;
		}
	}
	
	// get currency mid and code from text
	var code = text.substring(0, 3);
	var mid= text.substring(firstNumeric, firstNumeric+6);
	
	// set first column data
	$('#first-selected-header').text(code);
	$('#first-value').val(mid);

	// get secondColumn row text
	var tableRow2 = $("td").filter(function() {
	    return $(this).text() == $('#second-select-list').val();
	}).closest("tr");		
	var text2 = tableRow2[0].outerText;
	
	// find numeric index to extract currency mid
	var firstNumeric;		
	for(var i=0; text2.length ; i++){
		if($.isNumeric(text2.charAt(i))){
			firstNumeric = i;
			break;
		}
	}
	
	// extract second code value and code
	var secondCode = text2.substring(0, 3);
	var secondMid = text2.substring(firstNumeric, firstNumeric+6);	
	
	// set second column data
	$('#second-selected-header').text(secondCode);
	$('#second-value').val(secondMid);		
	$('#main-header').text("1 "+ code + " = "+secondMid+" "+secondCode);
	var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
	$('#second-input').val(result);	
	
	});
});

// * * * select second currency * * *
$('#second-select-list').on('change', function() {

	// get row text
	var tableRow = $("td").filter(function() {
	    return $(this).text() == $('#second-select-list').val();
	}).closest("tr");		
	var text = tableRow[0].outerText
	
	// find numeric index to extract currency mid
	var firstNumeric;
	for(var i=0; text.length ; i++){
		if($.isNumeric(text.charAt(i))){
			firstNumeric = i;
			break;
		}
	}
	
	// get currency mid and code from text
	var code = text.substring(0, 3);
	var mid = text.substring(firstNumeric, firstNumeric+6);
	
	// set column data
	$('#second-selected-header').text(code);
	$('#second-value').val(mid);
	$('#main-header').text("1 "+ $('#first-selected-header').text() + " = "+(1/$('#second-value').val()).toFixed(4)+" "+code);
	var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
	$('#second-input').val(result);	
	
});


// * * * calculate when key is pressed * * *
$("#first-input ").keyup(function(){
	var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
	$('#second-input').val(result);
});


//  * * * change sides of selected currencies * * * 
$('#rotate-button').click(function(){
	var tempVal = $('#first-select-list').val()
	$('#first-select-list').val($('#second-select-list').val()).trigger('change');
	$('#second-select-list').val(tempVal).trigger('change');	
});		
