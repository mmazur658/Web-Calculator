// * * * * global variables  * * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * * clears field except of the given one * * * * *
function clearFields(clickedInputId, inputIds){	
	var i;
	for (i = 0; i < inputIds.length; i++) { 
	    if(clickedInputId!=inputIds[i]){
	    	$(inputIds[i]).val("").focus();
	    }		
	}
	$(clickedInputId).focus();
};
// * * * clear others fields on input * * * 
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

// * * * * get result set from controller	
function getResultSet(url,inputIds){

	var i;
	for (i = 0; i < inputIds.length; i++) { 
	    if($(inputIds[i]).val()!=""){

	    	if($.trim($(inputIds[i]).val()).indexOf(",") == -1){
	    		if($.isNumeric($.trim($(inputIds[i]).val()))){
	    			
	    			var posting = $.post( url, { inputId: inputIds[i], inputValue: $(inputIds[i]).val(),  _csrf: csrf_token  }, function(data) {						
	    				for (var i=0; i<data.length;i++)
	    					$(inputIds[i]).val(data[i]);	    				    				
					}); 	 
	
	    		} else 
	    			showCustomAlert('error','Tylko wartości numeryczne','Niepoprawny format danych','Only numeric values','Incorrect data format');   			
	    		
	    	} else 	    		
	    		showCustomAlert('error','','Proszę użyć kropki zamiast przecinka','','Please use dot insted of comma');
  
	    	break;
	    }		
	} 
};

//* * * * Calculate length * * * * 
$("#length-form").submit(function(event) {
    event.preventDefault();
    var $form = $( this ),
        url = $form.attr( 'action' );
    
    var inputIds = ["#length-millimeter","#length-centimeter","#length-meter","#length-kilometer","#length-inch","#length-foot","#length-yard","#length-mile", "#length-nautica-mile","#length-astronomical-unit","#length-light-year","#length-parsec"];
   
    getResultSet(url,inputIds);
    	
});
//* * * * Calculate weigth * * * * 
$("#weight-form").submit(function(event) {
    event.preventDefault();
    var $form = $( this ),
        url = $form.attr( 'action' );
    var inputIds = ["#weight-milligram","#weight-gram","#weight-dekagram","#weight-kilogram","#weight-ton","#weight-ounce","#weight-pound","#weight-short-ton","#weight-long-ton","#weight-grain","#weight-cental","#weight-carat"];    
    getResultSet(url,inputIds);	    	
});

// * * * * Calculate Area * * * * 
$("#area-form").submit(function(event) {
    event.preventDefault();
    var $form = $( this ),
        url = $form.attr( 'action' );    
    var inputIds = ["#area-millimeter","#area-centimeter","#area-decymeter","#area-meter","#area-kilometer","#area-ar","#area-hectare","#area-inch","#area-foot","#area-yard","#area-mile","#area-acre"];    
    getResultSet(url,inputIds);	   	 
});

// * * * * *  Clears Btns * * * * * * 
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


//* * * * * * * * * * Show toastr alert, depends on the langauge  * * * * * * * * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}
