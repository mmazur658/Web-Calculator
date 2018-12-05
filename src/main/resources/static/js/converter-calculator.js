//  * * * CSRF TOKEN * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * clears field except of the given one * * * 
function clearFields(clickedInputId, inputIds){	
	var i;
	for (i = 0; i < inputIds.length; i++) { 
	    if(clickedInputId!=inputIds[i]){
	    	$(inputIds[i]).val("").focus();
	    }		
	}
	$(clickedInputId).focus();
};
// * * * clear others fields   * * * 
$("#length-millimeter, #length-centimeter, #length-meter, #length-kilometer, #length-inch, #length-foot, #length-yard, #length-mile, #length-nautica-mile, #length-astronomical-unit, #length-light-year, #length-parsec").keypress(function(){
	var inputIds = ["#length-millimeter","#length-centimeter","#length-meter","#length-kilometer","#length-inch","#length-foot","#length-yard","#length-mile", "#length-nautica-mile","#length-astronomical-unit","#length-light-year","#length-parsec"];
	clearFields('#'+$(this).attr("id"),inputIds);	
});
$("#weight-milligram, #weight-gram, #weight-dekagram, #weight-kilogram, #weight-ton, #weight-ounce, #weight-pound, #weight-short-ton, #weight-long-ton, #weight-grain, #weight-cental, #weight-carat").keypress(function(){
	var inputIds = ["#weight-milligram","#weight-gram","#weight-dekagram","#weight-kilogram","#weight-ton","#weight-ounce","#weight-pound","#weight-short-ton","#weight-long-ton","#weight-grain","#weight-cental","#weight-carat"];
	clearFields('#'+$(this).attr("id"),inputIds);	
});
$("#area-millimeter, #area-centimeter, #area-decymeter, #area-meter, #area-kilometer, #area-ar, #area-hectare, #area-inch, #area-foot, #area-yard, #area-mile, #area-acre").keypress(function(){
	var inputIds = ["#area-millimeter","#area-centimeter","#area-decymeter","#area-meter","#area-kilometer","#area-ar","#area-hectare","#area-inch","#area-foot","#area-yard","#area-mile","#area-acre"];
	clearFields('#'+$(this).attr("id"),inputIds);	
});

// * * * get result set * * * 
function getResultSet(url,inputIds){

	// find not null input
	for (var i = 0; i < inputIds.length; i++) { 
	    if($(inputIds[i]).val()!=""){

	    	// check input if contains only numeric value and doesn`t contain commas
	    	if($.trim($(inputIds[i]).val()).indexOf(",") == -1){
	    		if($.isNumeric($.trim($(inputIds[i]).val()))){
	    			
	    			// get result set from server and populate fields
	    			$.post( url, { inputId: inputIds[i], inputValue: $(inputIds[i]).val(),  _csrf: csrf_token  }, function(data) {						
	    				for (var i=0; i<data.length;i++)
	    					$(inputIds[i]).val(data[i]);	    				    				
					}); 	 
	
	    		} else 
	    			// show message if input contains non numeric value
	    			showCustomAlert('error','Tylko wartości numeryczne','Niepoprawny format danych','Only numeric values','Incorrect data format');   			
	    		
	    	} else 	    
	    		// show message if input contains commas
	    		showCustomAlert('error','','Proszę użyć kropki zamiast przecinka','','Please use dot insted of comma');
  
	    	break;
	    }		
	} 
};

// * * * Calculate length * * * 
$("#length-form").submit(function(event) {
	
	// prevent form form default action
    event.preventDefault();
    
    // get form url
    var $form = $( this ),
    url = $form.attr( 'action' );
    
    // input names
    var inputIds = ["#length-millimeter","#length-centimeter","#length-meter","#length-kilometer","#length-inch","#length-foot","#length-yard","#length-mile", "#length-nautica-mile","#length-astronomical-unit","#length-light-year","#length-parsec"];
   
    // get result set
    getResultSet(url,inputIds);
    	
});
// * * * Calculate weigth * * *
$("#weight-form").submit(function(event) {
	
	// prevent form form default action
    event.preventDefault();
    
    // get form url
    var $form = $( this ),
    url = $form.attr( 'action' );
    
    // input names
    var inputIds = ["#weight-milligram","#weight-gram","#weight-dekagram","#weight-kilogram","#weight-ton","#weight-ounce","#weight-pound","#weight-short-ton","#weight-long-ton","#weight-grain","#weight-cental","#weight-carat"];    
    
    // get result set
    getResultSet(url,inputIds);	    	
});

// * * * Calculate Area * * * 
$("#area-form").submit(function(event) {
	
	// prevent form form default action
    event.preventDefault();
    
    // get form url
    var $form = $( this ),
    url = $form.attr( 'action' );  
    
    // input names
    var inputIds = ["#area-millimeter","#area-centimeter","#area-decymeter","#area-meter","#area-kilometer","#area-ar","#area-hectare","#area-inch","#area-foot","#area-yard","#area-mile","#area-acre"];    
    
    // get result set
    getResultSet(url,inputIds);	   	 
});

// * * * Clear Buttons * * *
$('#weight-clear-btn').on('click', function() {
	var inputIds = ["#weight-milligram","#weight-gram","#weight-dekagram","#weight-kilogram","#weight-ton","#weight-ounce","#weight-pound","#weight-short-ton","#weight-long-ton","#weight-grain","#weight-cental","#weight-carat"];
	clearFields("xxx",inputIds)
});
$('#length-clear-btn').on('click', function() {
	var inputIds = ["#length-millimeter","#length-centimeter","#length-meter","#length-kilometer","#length-inch","#length-foot","#length-yard","#length-mile", "#length-nautica-mile","#length-astronomical-unit","#length-light-year","#length-parsec"];
	clearFields("xxx",inputIds)
});
$('#area-clear-btn').on('click', function() {
	var inputIds = ["#area-millimeter","#area-centimeter","#area-decymeter","#area-meter","#area-kilometer","#area-ar","#area-hectare","#area-inch","#area-foot","#area-yard","#area-mile","#area-acre"];
	clearFields("xxx",inputIds)
});


// * * *  Show toastr alert depending on the langauge  * * *
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}
