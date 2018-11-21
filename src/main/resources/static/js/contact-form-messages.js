// * * * * * * * * * * Global variable  * * * * * * * * * * *
var selectedIds = []; // stores selected ids of selected rows
var currentId=0; // current opened message
var csrf_token = $("meta[name='_csrf']").attr("content");

//* * * * * * * * * * open message and load message content * * * * * * * * * * *
	$("#openBtn").on('click', function(event){
		
		var amountOfSelectedCheckboxs=0;
		
		$('input[name="table-chbox"]:checked').each(function() {
			amountOfSelectedCheckboxs = amountOfSelectedCheckboxs + 1;			
		});
		
		if(amountOfSelectedCheckboxs > 0) {
			
			selectedIds = [];
			currentId = 0;
					
			$('input[name="table-chbox"]:checked').each(function() {
				selectedIds.push($(this).val());
				$(this).prop('checked', false);
			});
			
			$('#contactFormMessageModal').modal('show');			
			currentId=selectedIds[0];
			
			$('#modal-body-contect').fadeOut('1000', function() {	
				$('#modal-body-contect').load('get-message-modal', { contactFormMessageId: selectedIds[0], _csrf: csrf_token });
			}).fadeIn('1000');
			
			setReadStatusTrue(currentId);			
		} else 			
			showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej wierszy.','Empty Select','Please select more items.');	
	});

// * * * * * * * * Load list of messages at the start of the page * * * * * * * *
$(document).ready(function(){
	
	$('#message-list-table').fadeOut('1000', function() {	
		$('#message-list-table').load('get-contact-form-messages', { listType: "new", _csrf: csrf_token });
	}).fadeIn('1000');
	
	$('#resultStartRange').val(0);
	$("#result-label").text("1  -  20");	
});


//* * * * * * * * Load list of messages when type of list is changed * * * * * * * *	
	$('input[name=options]').change(function(){

		var listType = $( 'input[name=options]:checked' ).val();
		$('#message-list-table').fadeOut('1000', function() {	
			$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange: $('#resultStartRange').val(), _csrf: csrf_token  });
		}).fadeIn('1000');

		$('#resultStartRange').val(0);
		$("#result-label").text("1  -  20");	
		
		$("#searchFormName").val("").focus();
  		$("#searchFormEmail").val("").focus();
  		$("#searchFormSubject").val("").focus();
  		$("#searchFormStartDate").val("").focus();
  		$("#searchFormEndDate").val("").focus().trigger('blur');		
		
		$("#setParams").text(0); 	  		
	});


//* * * * * * * * * * close modal button * * * * * * * * * * * * 
$("#close-modal-button").on('click', function(){
	currentId=0;
	selectedIds=[];
});

//* * * * * * * * * * show more results  * * * * * * * * * * * * 
	$("#more-btn").on('click', function(){

		var resultStartRange = parseInt($("#resultStartRange").val());
		var totalResults = $("#totalResults").val();
		var listType = $( 'input[name=options]:checked' ).val();
		
		if(totalResults < (resultStartRange+20)){	
			
			showCustomAlert('error','Nie ma więcej wyników','Dotarłeś do końca listy','No more results','You have reached the end of the list');		
			
		} else {	
			
			resultStartRange = resultStartRange+20;			
			
			$('#message-list-table').fadeOut('1000', function() {	
				$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange:  resultStartRange, _csrf: csrf_token });
			}).fadeIn('1000');					
			
			if(resultStartRange+20 < totalResults)
				$("#result-label").text((resultStartRange+1)+"  -  "+(resultStartRange+20));
			else 
				$("#result-label").text((resultStartRange+1)+"  -  "+totalResults);
							
			$("#resultStartRange").val(resultStartRange);
		}			
	});

//* * * * * * * * * * show less results  * * * * * * * * * * * * 

	$("#less-btn").on('click', function(){

		var resultStartRange = parseInt($("#resultStartRange").val());
		var totalResults = $("#totalResults").val();
		var listType = listType = $( 'input[name=options]:checked' ).val();	
		
		if((resultStartRange - 20) < 0)			
			showCustomAlert('error','Nie ma mniej wyników','Dotarłeś do początku listy','No less results','You have reached the start of the list');
		
		else {
			$('#message-list-table').fadeOut('1000', function() {	
				$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange: (resultStartRange-20), _csrf: csrf_token  });
			}).fadeIn('1000');	
			
			resultStartRange=resultStartRange-20;	
			$("#result-label").text((resultStartRange+1)+"  -  "+(resultStartRange+20));		
			$("#resultStartRange").val(resultStartRange);
		}			
	});

//* * * * * * * * * * Check is read status  * * * * * * * * * * 

	$("#readBtn").on('click', function(){

		var amountOfSelectedCheckboxs=0;
		
		$('input[name="table-chbox"]:checked').each(function() {
			amountOfSelectedCheckboxs = amountOfSelectedCheckboxs + 1;			
		});
		
		if(amountOfSelectedCheckboxs > 0) {
			
			$('input[name="table-chbox"]:checked').each(function() {

				var checkboxValue = $(this).val();		
				var $row = $(this).closest("tr");       
			    	
			    	if($row.find("td:nth-child(7)").html() == "true"){
			    		$row.fadeOut('600', function(){
			    			$row.find("td:nth-child(2), td:nth-child(3), td:nth-child(4), td:nth-child(5)").addClass( "font-weight-bold" );
			    			$row.find("td:nth-child(7)").text("false");
			    		}).fadeIn('600')

			    	} else {
			    		$row.fadeOut('600', function(){
			    			$row.find("td:nth-child(2),td:nth-child(3),td:nth-child(4), td:nth-child(5)").removeClass( "font-weight-bold" );
			    			$row.find("td:nth-child(7)").text("true");			    			
			    		}).fadeIn('600')
			    	}
	    			$.post("admin-action/change-contact-form-message-read-status", {selectedCheckboxValue: checkboxValue,  _csrf: csrf_token });
			    	$(this).prop('checked', false);
			});			
			showCustomAlert('success','Zrobione','Status wiadomości został zmieniony.','Done','The message status has been changed.');			
		} else 			
			showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej wierszy.','Empty Select','Please select more items.');	
	});


//* * * * * * * * * * Check is replied status * * * * * * * * * * 

	$("#changeReplyStatusBtn").on('click', function(){

			var amountOfSelectedCheckboxs=0;
			
			$('input[name="table-chbox"]:checked').each(function() {
				amountOfSelectedCheckboxs = amountOfSelectedCheckboxs + 1;			
			});
			
			if(amountOfSelectedCheckboxs > 0) {
				$('input[name="table-chbox"]:checked').each(function() {
					
					var checkboxValue = $(this).val();		
					var $row = $(this).closest("tr");      
					
					if($row.find("td:nth-child(8)").html() == "false"){
						
						$row.find("td:nth-child(6)").fadeOut('600', function(){
							$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: checkboxValue,  _csrf: csrf_token });
							$(this).html('<i class="far fa-check-square"></i>');
						}).fadeIn('600');
						
						if($row.find("td:nth-child(7)").html() == "false"){				
							$row.fadeOut('600', function(){
								$row.find("td:nth-child(2),td:nth-child(3),td:nth-child(4),td:nth-child(5)").removeClass( "font-weight-bold" );
							}).fadeIn('600')	
						}						
						$row.find("td:nth-child(7), td:nth-child(8)").text("true");
					
					} else {
						
						$row.find("td:nth-child(6)").fadeOut('600', function(){
							$(this).html('<i class="far fa-square"></i>');
						}).fadeIn('600');						
						$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: checkboxValue, _csrf: csrf_token });
						$row.find("td:nth-child(8)").text("false");						
					}						
					$(this).prop('checked', false);
					
				});				
				showCustomAlert('success','Zrobione','Status wiadomości został zmieniony.','Done','The message status has been changed.');
	
			} else 
				showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej wierszy.','Empty Select','Please select more items.');	
	});


//* * * * * * * * * * delete message button  * * * * * * * * * * 

	$("#deleteBtn").on('click', function(){

		var messagesIds=[];		
		$('input[name="table-chbox"]:checked').each(function() {
			messagesIds.push($(this).val());
		});

		if(messagesIds.length > 0){
			
			var url="admin-action/delete-contact-form-message";
			
			for(var i=0; i<messagesIds.length; i++){
				$.post( url, { contactFormMessageId: messagesIds[i], _csrf: csrf_token  });
			}
					
			var listType = $( 'input[name=options]:checked' ).val();
			
			$('#message-list-table').fadeOut('1000', function() {				
				$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange: 0, _csrf: csrf_token  });
			}).fadeIn('1000');
			
			$("#setParams").text(0); 

			if(messagesIds.length > 1)
				showCustomAlert('success','Zrobione','Wiadomości zostały usunięte.','Done','The messages have been deleted.');
			 else 
				showCustomAlert('success','Zrobione','Wiadomość została usunięta.','Done','The message has been deleted.');
		} else 			
			showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej wierszy.','Empty Select','Please select more items.');
	});


//* * * * * * * * * * clear search parameters  * * * * * * * * * * 

	$('#clearSearchParametersBtn').on('click', function() {
    	$("#searchFormName").val("").focus();
  		$("#searchFormEmail").val("").focus();
  		$("#searchFormSubject").val("").focus();
  		$("#searchFormStartDate").val("").focus();
  		$("#searchFormEndDate").val("").focus().trigger('blur');	
	});


//* * * * * * * * * * Get Search results * * * * * * * * * * 
	$('#searchForm').submit(function(event){
			
		    event.preventDefault();      
		  	var $form = $( this ),
		    url = $form.attr( 'action' );  
		  	
		  	var searchFormName = $("#searchFormName").val();
	  		var searchFormEmail = $("#searchFormEmail").val();
	  		var searchFormSubject = $("#searchFormSubject").val();
	  		var searchFormStartDate = $("#searchFormStartDate").val();
	  		var searchFormEndDate = $("#searchFormEndDate").val();
	  		
			var listType = $( 'input[name=options]:checked' ).val();
			
			$('#message-list-table').fadeOut('1000', function() {				
				$('#message-list-table').load('get-search-contact-form-messages', { listType: listType, searchFormName: searchFormName,
					searchFormEmail: searchFormEmail, searchFormSubject: searchFormSubject,	searchFormStartDate: searchFormStartDate,
					searchFormEndDate: searchFormEndDate, _csrf: csrf_token  });
			}).fadeIn('1000');
			
			$("#resultStartRange").val(0);
			
			var count = 0 ;
			$('input[type=text]').each(function(){
			   if($(this).val() != "")
				   count = count + 1;
			})			
			
			$("#setParams").text(count);
			$('#searchContactFormMessageBtn').modal('toggle');			
	});	


//* * * * * * * * * * Check checkbox on row click * * * * * * * * * * 
$(function() {
    $("#message-list-table").on('click', 'tr', function(){    	
        if (event.target.type !== 'checkbox') 
            $(':checkbox', this).trigger('click');    
    });
});

//* * * * * * * * * * Change read status * * * * * * * * * * * * * * * 
function setReadStatusTrue(messageId){

	var $row = $("#message-list-table").find("tr[data-id='" + messageId + "']")

	$row.fadeOut('600', function(){
		$row.find("td:nth-child(2),td:nth-child(3),td:nth-child(4),td:nth-child(5)").removeClass( "font-weight-bold" );
		$row.find("td:nth-child(7)").text("true");
		$.post("admin-action/change-contact-form-message-read-status-to-true", {selectedCheckboxValue: messageId, _csrf: csrf_token });
	}).fadeIn('600')		
}

//* * * * * * * * * * Show toastr alert, depends on the langauge  * * * * * * * * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}