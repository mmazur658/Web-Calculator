//  * * * CSRF TOKEN * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * Counter * * *
$('.counter-count').each(function () {
        $(this).prop('Counter',0).animate({
            Counter: $(this).text()
        }, {
            duration: 3000,
            easing: 'swing',
            step: function (now) {
                $(this).text(Math.ceil(now));
            }
        });
   });


// * * *  get default chart (current day) on page load * * *  
var date = new Date();
var startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
var endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
getChartForGivenDateRange(startDate, endDate, startDate);

// * * *  Load char when date range is changed * * * 
$('input[name=charDataRange]').change(function(){	
	var radioSelectValue = $( 'input[name=charDataRange]:checked' ).val();
	
	// date variables
	var startDate;
	var endDate;
	
	// load chart for given date range
	if (radioSelectValue == 'today') {
		
		var date = new Date();
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		getChartForGivenDateRange(startDate, endDate, startDate);
		
	} else if (radioSelectValue == 'yesterday'){
		
		var date = new Date();
		date.setDate(date.getDate() - 1);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		getChartForGivenDateRange(startDate, endDate, startDate);			
		
	} else if (radioSelectValue == 'week'){
		
		var date = new Date();
		date.setDate(date.getDate() - 7);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		
		date = new Date();
		date.setDate(date.getDate() - 1);
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		var label = startDate + " - " + endDate;
		getChartForGivenDateRange(startDate, endDate, label);		
		
	} else if (radioSelectValue == 'month'){
		
		var date = new Date();
		date.setDate(date.getDate() - 30);
		startDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		
		date = new Date();
		date.setDate(date.getDate() - 1);
		endDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		var label = startDate + " - " + endDate;
		getChartForGivenDateRange(startDate, endDate, label);		
	}
});
// * * * FUNCTIONS * * *
// * * * get chart for given date range * * *
var myBarChart;

function getChartForGivenDateRange(startDate, endDate, label){

	// get data to populate chart
	$.post("calculator-stats/get-calculator-stats-for-given-range", {	
		startDate: startDate,
		endDate: endDate,	
		resultRange: 5,
		_csrf: csrf_token
	}, function(data){	
		
		// destroy chart if exists to prevent unexpected behavior
		if(myBarChart){
			myBarChart.destroy();
		}		
		
		
		// populate chart with data
		var labels =" ";		
		  var ctxB = document.getElementById("barChart").getContext('2d');
		  myBarChart = new Chart(ctxB, {
		    type: 'bar',
		    data: {
		      labels: [data[0][0], data[1][0] ,data[2][0] ,data[3][0] ,data[4][0] ],
		      datasets: [{
		        label: label,
		        data: [data[0][1], data[1][1] ,data[2][1] ,data[3][1] ,data[4][1] ],
		        backgroundColor: [
		          'rgba(224, 75, 38, 0.2)',
		          'rgba(107, 178, 194, 0.2)',
		          'rgba(224, 75, 38, 0.2)',
		          'rgba(107, 178, 194, 0.2)',
		          'rgba(224, 75, 38, 0.2)'	        
		        ],
		        borderColor: [
			          'rgba(224, 75, 38, 1)',
			          'rgba(107, 178, 194, 1)',
			          'rgba(224, 75, 38, 1)',
			          'rgba(107, 178, 194, 1)',
			          'rgba(224, 75, 38, 1)'	       
		        ],
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