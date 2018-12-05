// * * * LOAD BASIC CALCULATOR ON PAGE LOADING * * *
$(document).ready(function(){
	$('#calculator-placeholder').load('basic-calculator')
});

// * * *  basic calculator * * *
$('#basic-calc').click(function() {
	$('#calculator-placeholder').fadeOut('slow', function(){
		$('#calculator-placeholder').load('basic-calculator', function(){
    	    $('#calculator-placeholder').fadeIn('slow');
    	});
    });   	
});

// * * * advanced calculator * * * 
$('#advanced-calc').click(function() {
    $('#calculator-placeholder').fadeOut('slow', function(){
    	$('#calculator-placeholder').load('advanced-calculator', function(){
    	    $('#calculator-placeholder').fadeIn('slow');
    	});
    });   
});

// * * * science calculator * * *  
$('#science-calc').click(function() {
    $('#calculator-placeholder').fadeOut( function(){
    	$('#calculator-placeholder').load('science-calculator', function(){
    		$('#calculator-placeholder').fadeIn();
    	});
 	});
});
