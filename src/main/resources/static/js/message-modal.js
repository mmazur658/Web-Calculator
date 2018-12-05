//  * * * CSRF TOKEN * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * Hide comment form on page loading * * * 
$('#addCommentDiv').hide();

// * * * Show comment form on button click * * *
$('#addCommentButton').on('click', function(){
	$('#addCommentDiv').show(600);
})

// * * * Hide comment form on button click * * * 
$('#cancelCommentBtn').on('click', function(){
	$('#addCommentDiv').hide(600);
	$('#commentText').val("");
})

// * * * Check checkbox on row click * * * 
$(function() {
    $("#message-table").on('click', 'tr', function(){    	
        if (event.target.type !== 'checkbox') 
            $(':checkbox', this).trigger('click');    
    });
});

//* * * Add Comment on button click * * * 
$('#addCommentForm').submit(function(event){
	
	// prevent form form default action
    event.preventDefault();  
    
    // get form url
  	var $form = $( this ),
    url = $form.attr( 'action' );   
  	
  	// get input data
  	var commentText = $('#commentText').val();

  	// send data to the servier
  	$.post(url, {messageId: currentId, commentText: commentText,  _csrf: csrf_token }, function(data, status){
  		
  		// show message depending on status and hide comment section
  		if (status == "success"){  			
  			getMessageModal(currentId);	  			
  			showCustomAlert('success','','Komentarz został dodany.','','The Comment has been added.'); 			
  		} else {
  			$('#cancelCommentBtn').on('click', function(){
				$('#addCommentDiv').hide(600);
			});					
			$('#commentText').val("");   			
  			showCustomAlert('error','Błąd','Błąd dodawania komentarza, spóbuj ponownie póxniej.','Error','The Comment has not been added. Please try later.');		
  		} 	  		
  	});
});  

// * * * show next Message on button click* * *
$("#nextBtn").on('click', function(){	
	
	// get current message id
	var currentIdIndex = selectedIds.indexOf(currentId);
	
	// reload message modal
	if( (currentIdIndex + 1) > (selectedIds.length - 1) ){			
		getMessageModal(selectedIds[0]);
		currentId = selectedIds[0];
		setReadStatusTrue(currentId);	
	} else {				
		getMessageModal(selectedIds[currentIdIndex+1]);
		currentId = selectedIds[currentIdIndex+1];
		setReadStatusTrue(currentId);
	}
});


//* * * show previous Message on button click* * *
$("#previousBtn").on('click', function(){	
	
	// get current message id
	var currentIdIndex = selectedIds.indexOf(currentId);

	// reload message modal
	if( (currentIdIndex - 1) < 0 ){			
		getMessageModal(selectedIds[selectedIds.length-1]);
		currentId = selectedIds[selectedIds.length-1];
		setReadStatusTrue(currentId);							
	} else {			
		getMessageModal(selectedIds[currentIdIndex-1]);
		currentId = selectedIds[currentIdIndex-1]
		setReadStatusTrue(currentId);				
	}
});

// * * * Close modal on button click  * * *
$("#closeMessageModalBtn").on('click', function(){
	closeModalAndClearParameters();
});

// * * * Delete message on Button * * * 
$("#deleteMessageBtn").on('click', function(){

	// get current message id and list type
	var currentIdIndex = selectedIds.indexOf(currentId);
	var listType = $( 'input[name=options]:checked' ).val();
	
	// delete message
	$.post( "admin-action/delete-contact-form-message", { contactFormMessageId: currentId,  _csrf: csrf_token  });
	$.post( "admin-action/change-contact-form-message-read-status-to-true", {selectedCheckboxValue: currentId,  _csrf: csrf_token });
	
	// delete current id from ids list
	if(selectedIds.length == 1)	
		selectedIds=[]
	else {		
		for(var i = 0; i < selectedIds.length-1; i++){ 
			if ( selectedIds[i] === currentId) 
				selectedIds.splice(i, 1); 						
		}			
	}	

	// reload modal or close if there are no more ids
	if(selectedIds.length == 0 )	
		closeModalAndClearParameters();			
	else {		
		if(currentIdIndex === 0) {				
			getMessageModal(selectedIds[0]);
			currentId = selectedIds[0];
			setReadStatusTrue(currentId);		
		} else {			
			getMessageModal(selectedIds[currentIdIndex-1]);
			currentId = selectedIds[selectedIds.length-1];
			setReadStatusTrue(currentId);					
		}	
	}
 
	// reload message list
	$('#message-list-table').fadeOut('1000', function() {				
			$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange: 0 ,_csrf: csrf_token});
	}).fadeIn('1000');	
	
	// show success message
	showCustomAlert('success','Zrobione','Wiadomość została usunięta.','Done','The message has been deleted.');

});

// * * * Change isRead status on button click* * * 
$("#readStatusBtn").on('click', function(){
	changeReadStatus(currentId);
});

// * * * Change isReplied status on button click* * * 
$("#repliedStatusButton").on('click', function(){
	changeIsRepliedStatus(currentId);
});

// * * * Delete Comment on button click * * * 
$("#deleteCommentButton").on('click', function(){
		
		// get selected comment ids
		var commentsIds=[];		
		$('input[name="table-message-chbox"]:checked').each(function() {
			commentsIds.push($(this).val());
		});

		if(commentsIds.length > 0) {
			
			// delete all selected comments
			for(var i=0; i<commentsIds.length; i++)
				$.post( "admin-action/delete-comment", { contactFormCommentId: commentsIds[i], _csrf: csrf_token  });		
			
			// reload modal
			getMessageModal(currentId);
		
			// show success messages 
			if(commentsIds.length > 1)				
				showCustomAlert('success','Zrobione','Komentarze zostały usunięte.','Done','The comments have been deleted.');	
			else 				
				showCustomAlert('success','Zrobione','Komentarz został usunięty','Done','The comment has been deleted.');			

		} else {	
			
			// show error message
			showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej komentarzy.','Empty Select','Please select more comments.');
		}
});

// * * *  Change isReplied status * * * 
function changeIsRepliedStatus(messageId){

	// get row for given id
	var $row = $("#message-list-table").find("tr[data-id='" + messageId + "']")
	
	if($row.find("td:nth-child(8)").html() == "false"){
		
		// change checkbox icon and row style
		$row.find("td:nth-child(6)").fadeOut('600', function(){						
			$(this).html('<i class="far fa-check-square"></i>');
		}).fadeIn('600');
		
		if($row.find("td:nth-child(7)").html() == "false"){				
			$row.fadeOut('600', function(){
				$row.find("td:nth-child(2), td:nth-child(3), td:nth-child(4), td:nth-child(5)").removeClass( "font-weight-bold" );
			}).fadeIn('600')	
		}
		
		// send changes to the server
		$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
		
		// update row status
		$row.find("td:nth-child(7)").text("true");
		$row.find("td:nth-child(8)").text("true");
	
	} else {
		// change checkbox icon
		
		$row.find("td:nth-child(6)").fadeOut('600', function(){
			$(this).html('<i class="far fa-square"></i>');
		}).fadeIn('600');
		
		// send changes to the server		
		$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
		
		// update row status
		$row.find("td:nth-child(8)").text("false");
	}	
	showCustomAlert("success", "Zrobione", "Status wiadomości został zmieniony.", "Done", "The message status has been changed.")
}

// * * * Show toastr alert depending on the langauge  * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}

// * * * change isReaded status  * * * 
function changeReadStatus(messageId){
	
	// get row for given id
	var $row = $("#message-list-table").find("tr[data-id='" + messageId + "']")
	
	// change row status
	if($row.find("td:nth-child(7)").html() == "true"){
		$row.fadeOut('600', function(){
			$row.find("td:nth-child(2), td:nth-child(3), td:nth-child(5), td:nth-child(4) ").addClass( "font-weight-bold" );
			$row.find("td:nth-child(7)").text("false");			
		}).fadeIn('600')
	} else {
		$row.fadeOut('600', function(){
			$row.find("td:nth-child(2), td:nth-child(3), td:nth-child(4), td:nth-child(5)").removeClass( "font-weight-bold" );
			$row.find("td:nth-child(7)").text("true");
		}).fadeIn('600')
	}
	
	// send changes to the server and show success message
	$.post("admin-action/change-contact-form-message-read-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
	showCustomAlert("success","Zrobione","Status wiadomości został zmieniony.","Done","The message status has been changed.");
}

// * * * Close modal and clear global parameters * * * 
function closeModalAndClearParameters(){
	currentId=0;
	selectedIds=[];
	$('#contactFormMessageModal').modal('toggle');
}

// * * *  Load message content into modal body * * * 
function getMessageModal(messageId){
	$('#modal-body-contect').fadeOut('1000', function() {	
		$('#modal-body-contect').load('get-message-modal', { contactFormMessageId: messageId, _csrf: csrf_token});
	}).fadeIn('1000');	
}