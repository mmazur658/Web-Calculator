// * * *  Basic, Advanced and Science Calculator * * * 
$(document).ready(function(){
	var currentEntry;
	var buttonPressed;
	
	// read which button has been pressed and current entry
	  $(".calc-btn").on('click', function() {
		  buttonPressed = $(this).val();
		  currentEntry =  $("#screen-input").val();		 
		  	  
	// get currentEntry and split it on parts
		  var startIndex;
		  var endIndex;
		  var operatorIndex;
		  var operator;
		  var firstNumber;
		  var secondNumber;

		  // find operator index. Part before operator is a first number and part after operator is a second number 
		  for(var i=1; i < currentEntry.length; i++){			  
			  var character = currentEntry.charAt(i);			  
			  if(character == "/" || character == "+" || character == "-" || character == "*" || character == "p" || character == "r"){
				operator = character;
			  	operatorIndex = i;
 			  	break; 	
			  }
		  }		  
		
		// if current entry doesn`t contain operator then firstNumber = currentEntry
		// if currentEntry ends with dot then delete this dot
		if(operator==null){			
			if($.isNumeric(currentEntry.charAt(currentEntry.length-1)))
				firstNumber = currentEntry;
		} else {					
			if($.isNumeric(currentEntry.charAt(operatorIndex-1))){
				firstNumber = currentEntry.substring(0,operatorIndex);
				if(firstNumber.charAt(firstNumber.length-1) == "."){
					firstNumber = firstNumber.substring(0, firstNumber.length-1);
				}
			} else 
				firstNumber = null;
			
			// if currentEntry ends with dot then delete this dot
			if(operator != null){
				if($.isNumeric(currentEntry.charAt(operatorIndex+1))){
					secondNumber = currentEntry.substring(operatorIndex+1,currentEntry.length);
					if(secondNumber.charAt(secondNumber.length-1) == ".")
						secondNumber = secondNumber.substring(0, secondNumber.length-1);						
				} else 
					secondNumber = null;				
			} else 
				secondNumber = null;			
		}  		
		
		// transform comma into dot
		if(buttonPressed == "." || buttonPressed == ","){	  		
			if(buttonPressed == ",")
	  			buttonPressed = ".";	  		
			
			// if currentEntry ends with dot then do nothing
			if(currentEntry.charAt(currentEntry.length-1) != ".")
				currentEntry = currentEntry+buttonPressed; 			  		
		}			
		
		// verify if pressed button is a number
		if(isNumber(buttonPressed) ) 
				currentEntry = currentEntry+buttonPressed;  				
		
		// make calculation if = button has been pressed
		if(buttonPressed == "="){	
			if( firstNumber != null && secondNumber != null && operator != null)
				currentEntry =  operate(firstNumber, secondNumber, operator);			
		}
		
		// if button pressed is an operator
		if(isOperator(buttonPressed)){
			if( firstNumber != null && secondNumber != null && operator != null)		
				currentEntry =  operate(firstNumber, secondNumber, operator) + buttonPressed;				
			else if(firstNumber != null && secondNumber == null && operator != null)
				currentEntry = firstNumber+buttonPressed;
			else if(firstNumber != null && secondNumber == null && operator == null)
				currentEntry = firstNumber+buttonPressed;			
		}
		
		// make operation depends which special button has been pressed
		if(isSpecialOperator(buttonPressed)){ 			
			var tempResult;
			if( firstNumber != null && secondNumber != null && operator != null)			
				tempResult =  operate(firstNumber, secondNumber, operator);
			else if(firstNumber != null && secondNumber == null && operator != null)
				tempResult = firstNumber;
			else if(firstNumber != null && secondNumber == null && operator == null)
				tempResult = firstNumber;
			
			
			var result;
			
			if (buttonPressed === 'sin')
				result = Math.sin(tempResult * Math.PI / 180).toFixed(8);
			else if (buttonPressed === 'cos') 
				result = Math.cos(tempResult * Math.PI / 180).toFixed(8);
			else if (buttonPressed === 'tg') 
				result = Math.tan(tempResult * Math.PI / 180).toFixed(8);
			else if (buttonPressed === 'ctg') 
				result = (1 / Math.tan(tempResult * Math.PI / 180).toFixed(8));
			else if (buttonPressed === 'ln')                
				result = Math.log(tempResult).toFixed(8);
			else if (buttonPressed === 'log') 
				result = Math.log10(tempResult).toFixed(8);	
			else if (buttonPressed === 'arcsin') 
				result = Math.asin(tempResult).toFixed(8);
			else if (buttonPressed === 'arccos') 
				result = Math.acos(tempResult).toFixed(8);
			else if (buttonPressed === 'arctg') 	
				result = Math.atan(tempResult).toFixed(8);
			else if (buttonPressed === 'arcctg' ) 
				result = (Math.PI / 2 - Math.atan(tempResult)).toFixed(8);
			else if (buttonPressed === 'n!') 
				result = silnia(tempResult);				
			else if (buttonPressed ===  'fn' ) 	
				result = fib(tempResult);				
			else if (buttonPressed ==='+/-') 	
					result = tempResult * -1;		
			else if (buttonPressed ==='squareroot')	
				result = Math.sqrt(tempResult);
			else if (buttonPressed ==='cuberoot') 
				result = Math.cbrt(tempResult);
			else if (buttonPressed ==='1/x') 	
				result = 1 / tempResult;
			else if (buttonPressed === 'pow2')
				result = Math.pow(tempResult,2);
			else if (buttonPressed ==='pow3')
				result = Math.pow(tempResult, 3);
					
			currentEntry = result;      
		}
		
		// C - clear last entry
		if(buttonPressed == "C"){	 	 					
			if(secondNumber != null)
				currentEntry = firstNumber+operator;
			else if (operator != null) 
				currentEntry = firstNumber;
			else
				currentEntry = '';			
		}

		// CE - clear all entry
		if(buttonPressed == "CE"){		
			firstNumber=0;
			secondNumber=0;
			operator=0;
			currentEntry = '';			
		}

		// BACK - clear last input
		if(buttonPressed == "back"){			
			if(currentEntry.length > 0)
				currentEntry = currentEntry.substring(0, currentEntry.length-1);			
		} 
		
		// % - percentage calculations of all sentence
		if(buttonPressed == "%"){ 
			if( firstNumber != null && secondNumber != null && operator != null){
				var tempResult = firstNumber * (secondNumber / 100);
				currentEntry =  operate(firstNumber, tempResult, operator)
			}			
		}
		
		updateScreen(currentEntry);
	});	
});

// returns value of given place
fib = function(n){
	if ((n==1)||(n==2)){
		return 1;
	} else {
		return fib(n-1) + fib(n-2);
	}
}
// returns silnia of given number
silnia = function(i){
	if (i < 1) {
		return 1;
	} else {
		return i * silnia(i - 1);
	}
}
// update screen after calculation
updateScreen = function(displayValue) {
	  var displayValue = displayValue.toString();
	  $("#screen-input").val(displayValue)
};

// check if input is number
isNumber = function(value) {
	  return !isNaN(value);
};

// check if input is operator
isOperator = function(value) {
	return value === '/' || value === '*' || value === '+' || value === '-' || value === 'p' || value === 'r';
};

//check if input is special operator
isSpecialOperator = function(value) {
	return value === 'sin' || value === 'cos' || value === 'tg' || value === 'ctg' || value === 'ln' || value === 'log' || value === 'arcsin' || value === 'arccos' || value === 'arctg' || value === 'arcctg' || value === 'n!' || value === 'fn' || value === '+/-' || value === 'squareroot' || value === 'cuberoot' || value === '1/x' || value === 'pow2' || value === 'pow3' ;
}

// basics operations
operate = function(firstNumber, secondNumber, operator) {
	  a = parseFloat(firstNumber);
	  b = parseFloat(secondNumber);
	  if (operator === '+') return a + b;
	  if (operator === '-') return a - b;
	  if (operator === '*') return a * b;
	  if (operator === '/') return a / b;
	  if (operator === 'r') return "Err"; // finish it later  
	  if (operator === 'p') return result = Math.pow(a,b);	  
};
