// * * * * global variable
var csrf_token = $("meta[name='_csrf']").attr("content");

//* * * * * * * * * * Hide comment Form on start* * * * * * * * * * *
$('#addCommentDiv').hide();

//* * * * * * * * * * Show comment Form on click* * * * * * * * * * * 
$('#addCommentButton').on('click', function(){
	$('#addCommentDiv').show(600);
})

// * * * * * * * * * * Hide comment Form on click* * * * * * * * * * *
$('#cancelCommentBtn').on('click', function(){
	$('#addCommentDiv').hide(600);
	$('#commentText').val("");
})

// * * * * * * * * * * Check checkbox on row click * * * * * * * * * * 
$(function() {
    $("#message-table").on('click', 'tr', function(){    	
        if (event.target.type !== 'checkbox') 
            $(':checkbox', this).trigger('click');    
    });
});

//* * * * * * * * * * Add Comment Button * * * * * * * * * * * * * * * 
$('#addCommentForm').submit(function(event){
	
    event.preventDefault();      
  	var $form = $( this ),
    url = $form.attr( 'action' );    	
  	var commentText = $('#commentText').val();

  	$.post(url, {messageId: currentId, commentText: commentText,  _csrf: csrf_token }, function(data, status){
  		
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

//* * * * * * * * * * Next Message Button * * * * * * * * * * 
$("#nextBtn").on('click', function(){	
	
	var currentIdIndex = selectedIds.indexOf(currentId);
	
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


//* * * * * * * * * * Previous Message Button * * * * * * * * * * 
$("#previousBtn").on('click', function(){	
	
	var currentIdIndex = selectedIds.indexOf(currentId);

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

// * * * * * * * * * * Close Button * * * * * * * * * * 
$("#closeMessageModalBtn").on('click', function(){
	closeModalAndClearParameters();
});

//* * * * * * * * * * Delete Button * * * * * * * * * * 
$("#deleteMessageBtn").on('click', function(){

	var currentIdIndex = selectedIds.indexOf(currentId);
	var listType = $( 'input[name=options]:checked' ).val();
	
	$.post( "admin-action/delete-contact-form-message", { contactFormMessageId: currentId,  _csrf: csrf_token  });
	$.post( "admin-action/change-contact-form-message-read-status-to-true", {selectedCheckboxValue: currentId,  _csrf: csrf_token });
	
	if(selectedIds.length == 1)	
		selectedIds=[]
	else {		
		for(var i = 0; i < selectedIds.length-1; i++){ 
			if ( selectedIds[i] === currentId) 
				selectedIds.splice(i, 1); 						
		}			
	}	

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
 
	$('#message-list-table').fadeOut('1000', function() {				
			$('#message-list-table').load('get-contact-form-messages', { listType: listType, resultStartRange: 0 });
	}).fadeIn('1000');	
	
	showCustomAlert('success','Zrobione','Wiadomość została usunięta.','Done','The message has been deleted.');

});

//* * * * * * * * * * Change Read Status Button * * * * * * * * * * 
$("#readStatusBtn").on('click', function(){
	changeReadStatus(currentId);
});

//* * * * * * * * * * Change Replied Status Button * * * * * * * * * * 
$("#repliedStatusButton").on('click', function(){
	changeIsRepliedStatus(currentId);
});

//* * * * * * * * * * Delete Comment Button * * * * * * * * * * 
$("#deleteCommentButton").on('click', function(){
		
		var commentsIds=[];
		
		$('input[name="table-message-chbox"]:checked').each(function() {
			commentsIds.push($(this).val());
		});

		if(commentsIds.length > 0) {
			
			var url="admin-action/delete-comment";
			
			for(var i=0; i<commentsIds.length; i++)
				$.post( url, { contactFormCommentId: commentsIds[i], _csrf: csrf_token  });		
			
			getMessageModal(currentId);
		
			if(commentsIds.length > 1)				
				showCustomAlert('success','Zrobione','Komentarze zostały usunięte.','Done','The comments have been deleted.');	
			else 				
				showCustomAlert('success','Zrobione','Komentarz został usunięty','Done','The comment has been deleted.');			

		} else {	
			showCustomAlert('error','Pusty wybór','Proszę zaznaczyć więcej komentarzy.','Empty Select','Please select more comments.');
		}

});


//* * * * * * * * * *  Change isReplied status * * * * * * * * * * 
function changeIsRepliedStatus(messageId){

	var $row = $("#message-list-table").find("tr[data-id='" + messageId + "']")
	
	if($row.find("td:nth-child(8)").html() == "false"){
		
		$row.find("td:nth-child(6)").fadeOut('600', function(){
			$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
			$(this).html('<i class="far fa-check-square"></i>');
		}).fadeIn('600');
		
		if($row.find("td:nth-child(7)").html() == "false"){				
			$row.fadeOut('600', function(){
				$row.find("td:nth-child(2), td:nth-child(3), td:nth-child(4), td:nth-child(5)").removeClass( "font-weight-bold" );
			}).fadeIn('600')	
		}
		
		$row.find("td:nth-child(7)").text("true");
		$row.find("td:nth-child(8)").text("true");
	
	} else {
		
		$row.find("td:nth-child(6)").fadeOut('600', function(){
			$(this).html('<i class="far fa-square"></i>');
		}).fadeIn('600');
		
		$.post("admin-action/change-contact-form-message-replied-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
		$row.find("td:nth-child(8)").text("false");
		
	}
	
	showCustomAlert("success", "Zrobione", "Status wiadomości został zmieniony.", "Done", "The message status has been changed.")
}

//* * * * * * * * * * Show toastr alert, depends on the langauge  * * * * * * * * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}

//* * * * * * * * * * change isReaded status  * * * * * * * * * * * * * * * * * * * * * *
function changeReadStatus(messageId){
	
	var $row = $("#message-list-table").find("tr[data-id='" + messageId + "']")
	
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
	$.post("admin-action/change-contact-form-message-read-status", {selectedCheckboxValue: messageId,  _csrf: csrf_token });
	showCustomAlert("success","Zrobione","Status wiadomości został zmieniony.","Done","The message status has been changed.");
}

//* * * * * * * * * * Close modal and clear global parameters * * * * * * * * * * 
function closeModalAndClearParameters(){
	currentId=0;
	selectedIds=[];
	$('#contactFormMessageModal').modal('toggle');
}

//* * * * * * * * * * Load message content into modal body * * * * * * * * * * 
function getMessageModal(messageId){

	$('#modal-body-contect').fadeOut('1000', function() {	
		$('#modal-body-contect').load('get-message-modal', { contactFormMessageId: messageId, _csrf: csrf_token});
	}).fadeIn('1000');	
}