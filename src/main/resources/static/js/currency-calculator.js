// * * * * global variables  * * * *
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * LOAD CURRENCY TABLE ON PAGE LOAD * * * * * 
$(document).ready(function(){
	$('#currency-table').load('currency-calculator/get-currency-table')
});

//  * * * load currency table on page load or currency first column change * * * 
$(document).ready(function(){
	
	$('#first-select-list').on('change', function() {
		$('#currency-table').load('currency-calculator/get-currency-table', {selectedCurrencyCode: $(this).val(), _csrf: csrf_token  }, function(){

		var tableRow = $("td").filter(function() {
		    return $(this).text() == $('#first-select-list').val();
		}).closest("tr");
		
		var text = tableRow[0].outerText

		var firstNumeric;
		for(var i=0; text.length ; i++){
			if($.isNumeric(text.charAt(i))){
				firstNumeric = i;
				break;
			}
		}
		var code = text.substring(0, 3);
		var mid= text.substring(firstNumeric, firstNumeric+6);
		
		$('#first-selected-header').text(code);
		$('#first-value').val(mid);

		var tableRow2 = $("td").filter(function() {
		    return $(this).text() == $('#second-select-list').val();
		}).closest("tr");
		
		var text2 = tableRow2[0].outerText;
		var firstNumeric;
		
		for(var i=0; text2.length ; i++){
			if($.isNumeric(text2.charAt(i))){
				firstNumeric = i;
				break;
			}
		}
		
		var secondCode = text2.substring(0, 3);
		var secondMid = text2.substring(firstNumeric, firstNumeric+6);	
		$('#second-selected-header').text(secondCode);
		$('#second-value').val(secondMid);		
		$('#main-header').text("1 "+ code + " = "+secondMid+" "+secondCode);
		var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
		$('#second-input').val(result);	
		});
	});
});

// * * * * * select second currency * * * * 
$(document).ready(function(){
	$('#second-select-list').on('change', function() {

		var tableRow = $("td").filter(function() {
		    return $(this).text() == $('#second-select-list').val();
		}).closest("tr");
		
		var text = tableRow[0].outerText
	
		var firstNumeric;
		for(var i=0; text.length ; i++){
			if($.isNumeric(text.charAt(i))){
				firstNumeric = i;
				break;
			}
		}
		var code = text.substring(0, 3);
		var mid = text.substring(firstNumeric, firstNumeric+6);
	
		$('#second-selected-header').text(code);
		$('#second-value').val(mid);
		$('#main-header').text("1 "+ $('#first-selected-header').text() + " = "+(1/$('#second-value').val()).toFixed(4)+" "+code);
		var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
		$('#second-input').val(result);		
	});
});

// * * * * * calculate when key is pressed * * * 
$(document).ready(function(){
	$("#first-input ").keyup(function(){
		var	result = ($("#first-input").val() / $('#second-value').val()).toFixed(2);
		$('#second-input').val(result);
	});
});

//  * * * * * change sides of selected currencies * * * 
$(document).ready(function(){
	$('#rotate-button').click(function(){
		var tempVal = $('#first-select-list').val()
		$('#first-select-list').val($('#second-select-list').val()).trigger('change');
		$('#second-select-list').val(tempVal).trigger('change');	
	});		
});