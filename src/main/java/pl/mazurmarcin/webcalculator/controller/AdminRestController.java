package pl.mazurmarcin.webcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.ContactFormMessageService;

@RestController
@RequestMapping("/administrator-panel/admin-action")
public class AdminRestController {

	private ContactFormMessageService contactFormMessageService;

	@Autowired
	public AdminRestController(ContactFormMessageService contactFormMessageService) {
		this.contactFormMessageService = contactFormMessageService;

	}

	@RequestMapping("/delete-contact-form-message")
	void deleteContactFormMessage(@RequestParam(name = "contactFormMessageId") long contactFormMessageId) {
		contactFormMessageService.deleteContactFormMessage(contactFormMessageId);
	}

	@RequestMapping("/change-contact-form-message-read-status")
	void changeContactFormMessageReadStatus(@RequestParam(name = "selectedCheckboxValue") long selectedCheckboxValue) {
		contactFormMessageService.changeContactFormMessageReadStatus(selectedCheckboxValue);
	}

	@RequestMapping("/change-contact-form-message-replied-status")
	void changeContactFormMessageRepliedStatus(
			@RequestParam(name = "selectedCheckboxValue") long selectedCheckboxValue) {
		contactFormMessageService.changeContactFormMessageRepliedStatus(selectedCheckboxValue);
	}

	@RequestMapping("/change-contact-form-message-read-status-to-true")
	void setContactFormMessageReadStatusTrue(@RequestParam(name = "selectedCheckboxValue") long selectedCheckboxValue) {
		contactFormMessageService.setContactFormMessageReadStatusTrue(selectedCheckboxValue);
	}

	@RequestMapping("/add-comment")
	void addComment(@RequestParam(name = "messageId") long messageId,
			@RequestParam(name = "commentText") String commentText) {
		contactFormMessageService.addComment(messageId, commentText);
	}

	@RequestMapping("/delete-comment")
	void deleteComment(@RequestParam(name = "contactFormCommentId") long commentId) {
		contactFormMessageService.deleteComment(commentId);
	}

}
