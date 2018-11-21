// * * * * * * global variables * * * * * 
var csrf_token = $("meta[name='_csrf']").attr("content");

// * * * * * * * * * * contact form message - send message * * * * * * * * * * * * 

$(document).ready(function(){
	$('#contact-form').submit(function(event){
						
		event.preventDefault();
		
	    var $form = $( this ),
	    	url = $form.attr( 'action' );
		
		if($.trim($('#contact-name').val()) == "" || $.trim($('#contact-email').val()) == "" ||	 $.trim($('#contact-subject').val()) == "" ||
		   $.trim($('#contact-message').val()) == "" ){
			
			showCustomAlert('error','Niewypełnione pola','Proszę wypełnić wszystkie pola w formularzu kontaktowym','Blank fields','Please fill in all fields in contact form');
			
		} else {
			
			var posting = $.post( url, { senderName: $('#contact-name').val(), senderEmail: $('#contact-email').val(), 
				messageSubject: $('#contact-subject').val(), messageText: $('#contact-message').val(), _csrf: csrf_token }, function(data, status) { 
					
					if (status == "success"){
						
						showCustomAlert('success','','Wiadomość została wysłana.','','The message has been sent.');
						$("#contact-name").val("").focus();
						$("#contact-email").val("").focus();
						$("#contact-subject").val("").focus();
						$("#contact-message").val("").focus().trigger('blur');
						
					} else 						
						showCustomAlert('error','','Błąd wysyłania wiadomości.','','Error: The message has not been sent.');
			});			
		}			
	});
});

//* * * * * * * * * * Show toastr alert, depends on the langauge  * * * * * * * * * * 
function showCustomAlert(type, titlePL, textPL, titleEN, textEN){
	
	var userLang = document.documentElement.lang;

	if(userLang == "pl_PL")
    	showToastrAlert(type, textPL ,titlePL);
    else 
    	showToastrAlert(type, textEN , titleEN);
}