//* * * * * * * * * * Global variables* * * * * * * * * * *
var userLang = navigator.language;

var csrf_token = $("meta[name='_csrf']").attr("content");

var monthNamesEN = ["January", "February", "March", "April", "May", "June",
	  "July", "August", "September", "October", "November", "December"	];
var monthNamesPL = ["Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
	  "Lipiec", "Sierpień", "Wrzesirń", "Październik", "Listopad", "Grudzień"	];	  

//* * * * * * * * * * Hide custom range section on start* * * * * * * * * * *
$('#customRangeSection').hide();

//* * * * * * * * * * show custom range section on radio select * * * * * * * * * * *
$('input[name=charDataRange]').change(function(){	
	var radioSelectValue = $( 'input[name=charDataRange]:checked' ).val();
	
	if (radioSelectValue == 'custom') {
		$('#customRangeSection').show(600);		
	}
});

// * * * * * * * get default chart (current day) on page load * * * * * * 
var date = new Date();
var startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
var endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
getChartForGivenDateRange(startDate, endDate, startDate, 'horizontalBar','barChart');

//* * * * * * * * Load char when date range is changed * * * * * * * *	
$('input[name=charDataRange]').change(function(){	
	var radioSelectValue = $( 'input[name=charDataRange]:checked' ).val();

	var startDate;
	var endDate;
	
	if (radioSelectValue == 'today') {
		
		var date = new Date();
		$('#customRangeSection').hide(600);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		getChartForGivenDateRange(startDate, endDate, startDate,'horizontalBar','barChart');
		
	} else if (radioSelectValue == 'yesterday'){
		
		var date = new Date();
		$('#customRangeSection').hide(600);
		date.setDate(date.getDate() - 1);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		getChartForGivenDateRange(startDate, endDate, startDate,'horizontalBar','barChart');
		
	} else if (radioSelectValue == 'week'){
		
		$('#customRangeSection').hide(600);
		var date = new Date();
		date.setDate(date.getDate() - 7);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		
		date = new Date();
		date.setDate(date.getDate() - 1);
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		var label = startDate + " - " + endDate;
		getChartForGivenDateRange(startDate, endDate, label,'horizontalBar','barChart');
		
		
	} else if (radioSelectValue == 'month'){
		
		$('#customRangeSection').hide(600);
		var date = new Date();
		date.setDate(date.getDate() - 30);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		
		date = new Date();
		date.setDate(date.getDate() - 1);
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		var label = startDate + " - " + endDate;
		getChartForGivenDateRange(startDate, endDate, label,'horizontalBar','barChart');
		
	}

});

//* * * * * * * * Load char with custom date range * * * * * * * *
$('#customDateRangeSearchButton').on('click', function(){
	
	var startDate = $('#customRangeStartDate').val();
	var endDate = $('#customRangeEndDate').val();	
	var label = startDate + " - " + endDate;
	
	getChartForGivenDateRange(startDate, endDate, label, 'horizontalBar','barChart');	
});


//* * * * * populate calculator select * * * * * * 
$(document).ready(function(){
	
	var calculatorType_PL=["Kwadrat", "Prostokąt", "Długość", "Masa", "Powierzchnia", "Waluty",	"Procenty" ];
	var calculatorType_EN=["Square", "Rectangle", "Length", "Weight", "Area", "Currency", "Percentage" ];	
	
	for (var i = 0; i < calculatorType_EN.length; i++) {	
		
		if(userLang == "pl-PL")
			$('#calculatorSelect').append('<option value="calculate' + calculatorType_EN[i] + '">' +calculatorType_PL[i] +'</option>');
		else 		    	
		    $('#calculatorSelect').append('<option value="calculate' + calculatorType_EN[i] + '">' +calculatorType_EN[i] +'</option>');
        
		$('select>option:eq(0)').prop('selected', true);
    }
});

// * * * * * load first calculator details and statistics * * * * * * * * * * *
loadGeneralStatistics("calculateSquare");

// * * * * * * * *  Load current month and load monthly chart on start * * * * * * * * * 
var date = new Date();
if(userLang == "pl-PL")
	$("#inputMonth").val(monthNamesPL[date.getMonth()]+" "+date.getFullYear());
else 
	$("#inputMonth").val(monthNamesEN[date.getMonth()]+" "+date.getFullYear());

$("a[data-target='#v-pills-methods']").on('shown.bs.tab', function () {
	var resultSet = prepareDataToCreateChart($("#inputMonth").val());	
	getChartWithMonthlyData(resultSet[0], resultSet[1], resultSet[2], 'bar', 'monthlyChart',resultSet[3])
}); 

//* * * * * * * * Load monthly chart on button click* * * * * * * * * * * * * * 
$('#getMonthlyChart').on('click', function(){
	
	var resultSet = prepareDataToCreateChart($("#inputMonth").val());	
	getChartWithMonthlyData(resultSet[0], resultSet[1], resultSet[2], 'bar', 'monthlyChart',resultSet[3])
	
});
//* * * * * * * * Load monthly chart and general statistics on calculator change * * * * * * * * * * 
$('#calculatorSelect').on('change', function (e) {
    var optionSelected = $("option:selected").val();
    
    loadGeneralStatistics(optionSelected);
	var resultSet = prepareDataToCreateChart($("#inputMonth").val());	
	getChartWithMonthlyData(resultSet[0], resultSet[1], resultSet[2], 'bar', 'monthlyChart',resultSet[3])
	
});

// * * * * * * * * * * * * * * * * * * * * * * * * * * FUNCTIONS * * * * * * * * * * * * * * * * * * * * * * * * * *
//* * * * * * monthly chart * * * * * * * 
var myChart;

function getChartWithMonthlyData(startDate, endDate, label, barType, chartLocationId, monthLength){
	
	$.post("calculator-stats/get-selected-calculator-monthly-data", {	
		startDate: startDate,
		endDate: endDate,
		calculatorName: $('#calculatorSelect').val(),
		monthLength: monthLength,
		_csrf: csrf_token
	}, function(data){	
		
		// destroy previous char if exists to prevent unexpected behaviour
		if(myChart)
			myChart.destroy();			
		
		// extract data from data and populate arrays which fill chart with data
		var labelArray = new Array();
		var dataArray = new Array();
		var backgroundColorArray = new Array();
		var borderColor = new Array();
		var tempArray = new Array();
		
		for(var i=0;i< data.length; i++){			
			tempArray=data[i];			
			labelArray.push(i+1);
			dataArray.push(tempArray[1]);
			
			if (i%2==0){
				backgroundColorArray.push('rgba(224, 75, 38, 0.2)');
				borderColor.push('rgba(224, 75, 38, 1)')
			} else {
				backgroundColorArray.push('rgba(107, 178, 194, 0.2)');
				borderColor.push('rgba(107, 178, 194, 1)')				
			}	
		}
		// chart options
		  var ctxB = document.getElementById(chartLocationId).getContext('2d');
		  myChart = new Chart(ctxB, {
		    type: barType,
		    data: {
		      labels: labelArray,
		      datasets: [{
		        label: label,
		        data: dataArray,
		        backgroundColor: backgroundColorArray,
		        borderColor: borderColor,
		        borderWidth: 1
		      }]
		    },
		    options: {
		      scales: {
		        yAxes: [{
		          ticks: {
		            beginAtZero: true
		          }
		        }]
		      }
		    }
		  });	
	});	
}
//* * * * * * * *  prepare data to create chart * * * * * * * * * * * * 
function prepareDataToCreateChart(inputMonthValue){	
	
	// extract year and monthName from inputMonthValue
	var startIndex = 0;
	for(var i=0; i<inputMonthValue.length ; i++ ){
		if($.isNumeric(inputMonthValue.charAt(i))){
			startIndex = i;
			break;
		}
	}
	
	var selectedMonthName = inputMonthValue.substring(0,startIndex-1);
	var selectedYear = inputMonthValue.substring(startIndex,inputMonthValue.length);
	
	// get month index based on month name
	var selectedMonthIndex=-1;
	
	for(var i=0 ; i < 12 ; i++) {
		if(monthNamesPL[i] ==  selectedMonthName || monthNamesEN[i] == selectedMonthName){
			selectedMonthIndex=i;
			break;
		}
	}
	
	// create startDate, endDate and monthLength based on extracted values
	var tempDate = new Date();
	tempDate.setFullYear(selectedYear);
	tempDate.setMonth(selectedMonthIndex);
	
	var tempStartDate = new Date(tempDate.getFullYear(), tempDate.getMonth(), 1);
	var tempEndDate = new Date(tempDate.getFullYear(), tempDate.getMonth() + 1, 0);
	
	var startDate = tempStartDate.getFullYear()+'-'+(tempStartDate.getMonth() + 1)+'-'+tempStartDate.getDate();
	var endDate = tempEndDate.getFullYear()+'-'+(tempEndDate.getMonth() + 1)+'-'+tempEndDate.getDate();
	
	var monthLength = tempEndDate.getDate();
	
	var resultSet = [startDate, endDate, selectedMonthName, monthLength]
	
	return resultSet;
}

//* * * * * get chart for given date range * * * * *  barType: horizontalBar, bar
var myBarChart;

function getChartForGivenDateRange(startDate, endDate, label, barType, chartLocationId){

	$.post("calculator-stats/get-calculator-stats-for-given-range", {	
		startDate: startDate,
		endDate: endDate,	
		resultRange: 999, // set result range=999 to get all calculators
		_csrf: csrf_token
	}, function(data){	
		
		// destroy previous char if exists to prevent unexpected behaviour
		if(myBarChart)
			myBarChart.destroy();		
		
		// extract data from data and populate arrays which fill chart with data
		var labelArray = new Array();
		var dataArray = new Array();
		var backgroundColorArray = new Array();
		var borderColor = new Array();
		var tempArray = new Array();
		
		for(var i=0;i< data.length; i++){			
			tempArray=data[i];			
			labelArray.push(tempArray[0]);
			dataArray.push(tempArray[1]);
			
			if (i%2==0){
				backgroundColorArray.push('rgba(224, 75, 38, 0.2)');
				borderColor.push('rgba(224, 75, 38, 1)')
			} else {
				backgroundColorArray.push('rgba(107, 178, 194, 0.2)');
				borderColor.push('rgba(107, 178, 194, 1)')				
			}	
		}
		
		// chart options
		  var ctxB = document.getElementById(chartLocationId).getContext('2d');
		  myBarChart = new Chart(ctxB, {
		    type: barType,
		    data: {
		      labels: labelArray,
		      datasets: [{
		        label: label,
		        data: dataArray,
		        backgroundColor: backgroundColorArray,
		        borderColor: borderColor,
		        borderWidth: 1
		      }]
		    },
		    options: {
		      scales: {
		        yAxes: [{
		          ticks: {
		            beginAtZero: true
		          }
		        }]
		      }
		    }
		  });	
	});	
}

//* * * * * * * * load general statistics * * * * * * * * * * * * *
function loadGeneralStatistics(calculatorName){
	
	// load general statistics based on calculator name
	var url = "calculator-stats/get-selected-calculator-general-statistics"		
		$.post(url,{calculatorName: calculatorName, _csrf: csrf_token}, function(data){
			
			$('#calculatorfirstUse').fadeOut('1000', function() {				
				$('#calculatorfirstUse').text(data[0]);
			}).fadeIn('1000');	
			$('#calculatorToday').fadeOut('1000', function() {				
				$('#calculatorToday').text(data[1]);
			}).fadeIn('1000');	
			$('#calculatorYesterday').fadeOut('1000', function() {				
				$('#calculatorYesterday').text(data[2]);
			}).fadeIn('1000');	
			$('#calculator7Days').fadeOut('1000', function() {				
				$('#calculator7Days').text(data[3]);
			}).fadeIn('1000');	
			$('#calculator30Days').fadeOut('1000', function() {				
				$('#calculator30Days').text(data[4]);
			}).fadeIn('1000');	
			$('#calculatorEver').fadeOut('1000', function() {				
				$('#calculatorEver').text(data[5]);
			}).fadeIn('1000');	
			
		});
}
		