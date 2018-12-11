package pl.mazurmarcin.webcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mazurmarcin.webcalculator.services.ContactFormMessageService;

/**
 * The rest controller class is used to perform actions depending on the user
 * request.
 * 
 * @author Marcin Mazur
 *
 */
@RestController
@RequestMapping("/administrator-panel/admin-action")
public class AdminRestController {

	/**
	 * The ContactFormMessageService interface
	 */
	private ContactFormMessageService contactFormMessageService;

	/**
	 * Constructs a AdminRestController with the ContactFormMessageService.
	 * 
	 * @param contactFormMessageService
	 *            The ContactFormMessageService interface
	 */
	@Autowired
	public AdminRestController(ContactFormMessageService contactFormMessageService) {
		this.contactFormMessageService = contactFormMessageService;

	}

	/**
	 * Deletes the contact form message with given id.
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message
	 */
	@RequestMapping("/delete-contact-form-message")
	void deleteContactFormMessage(@RequestParam(name = "contactFormMessageId") long contactFormMessageId) {
		contactFormMessageService.deleteContactFormMessage(contactFormMessageId);
	}

	/**
	 * /** Changes the isRead status of the contact form message
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message
	 */
	@RequestMapping("/change-contact-form-message-read-status")
	void changeContactFormMessageReadStatus(@RequestParam(name = "selectedCheckboxValue") long contactFormMessageId) {
		contactFormMessageService.changeContactFormMessageReadStatus(contactFormMessageId);
	}

	/**
	 * Changes the isReplied status of the contact form message
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message
	 */
	@RequestMapping("/change-contact-form-message-replied-status")
	void changeContactFormMessageRepliedStatus(
			@RequestParam(name = "selectedCheckboxValue") long contactFormMessageId) {
		contactFormMessageService.changeContactFormMessageRepliedStatus(contactFormMessageId);
	}

	/**
	 * Sets the isRead status of the contact form message to TRUE
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message
	 */
	@RequestMapping("/change-contact-form-message-read-status-to-true")
	void setContactFormMessageReadStatusTrue(@RequestParam(name = "selectedCheckboxValue") long contactFormMessageId) {
		contactFormMessageService.setContactFormMessageReadStatusTrue(contactFormMessageId);
	}

	/**
	 * Adds a comment to the message with given id.
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message
	 * @param commentText
	 *            The long containing the id of the comment
	 */
	@RequestMapping("/add-comment")
	void addComment(@RequestParam(name = "messageId") long contactFormMessageId,
			@RequestParam(name = "commentText") String commentText) {
		contactFormMessageService.addComment(contactFormMessageId, commentText);
	}

	/**
	 * Deletes the comment with given id
	 * 
	 * @param commentId
	 *            The long containing the id of the comment
	 */
	@RequestMapping("/delete-comment")
	void deleteComment(@RequestParam(name = "contactFormCommentId") long commentId) {
		contactFormMessageService.deleteComment(commentId);
	}

}
