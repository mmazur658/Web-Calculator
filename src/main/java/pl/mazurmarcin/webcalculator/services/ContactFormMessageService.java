package pl.mazurmarcin.webcalculator.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

/**
 * Interface for managing contact form messages.
 * 
 * @author Marcin Mazur
 *
 */
@Service
public interface ContactFormMessageService {

	/**
	 * Creates and sends the contact form message with given parameters. <br>
	 * <br>
	 * The ServiceUtils interface is using to create a contact form message
	 * 
	 * @param senderEmail
	 *            The String containing the sender's email
	 * @param senderName
	 *            The String containing the sender's name
	 * @param messageText
	 *            The String containing the text of the message
	 * @param messageSubject
	 *            The String containing the subject of the message
	 */
	void sendMessage(String senderEmail, String senderName, String messageText, String messageSubject);

	/**
	 * Returns the number of all unread contact form message
	 * 
	 * @return A long representing the number of all unread contact form message
	 */
	long getNumberOfUnreadContactFormMessage();

	/**
	 * Returns the list of ContactFormMessage for given list type
	 * 
	 * @param listType
	 *            The String containing the type of the list.
	 * @param resultStartRange
	 *            The Integer containing the first returning index
	 * @param resultRange
	 *            The Integer containing the number of results
	 * @return A List&lt;ContactFormMessage&gt; representing the list of contact
	 *         form messages
	 */
	List<ContactFormMessage> getContactFormMessages(String listType, Integer resultStartRange, Integer resultRange);

	/**
	 * Deletes the contact form messages with given id
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message to be deleted
	 */
	void deleteContactFormMessage(long contactFormMessageId);

	/**
	 * Changes the isRead status of the contact form message with given id
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message which status to be
	 *            changed
	 */
	void changeContactFormMessageReadStatus(long contactFormMessageId);

	/**
	 * Changes the isReplied status of the contact form message with given id
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message which status to be
	 *            changed
	 */
	void changeContactFormMessageRepliedStatus(long contactFormMessageId);

	/**
	 * Returns the list of ContactFormMessage for given search parameters
	 * 
	 * @param searchParameters
	 *            The Array of the Strings containing the search parameters
	 * @param startResult
	 *            The int containing the first returning index
	 * @param resultRange
	 *            The int containing the number of results
	 * @return A List&lt;ContactFormMessage&gt; representing the list of contact
	 *         form messages
	 */
	List<ContactFormMessage> getContactFormMessageSearchResult(String[] searchParameters, int startResult,
			Integer resultRange);

	/**
	 * Returns the ContactFormMessage with given id
	 * 
	 * @param contactFormMessageId
	 *            The Long containing the id of the message
	 * 
	 * @return A ContactFormMessage representing the contact form message with given
	 *         id
	 */
	ContactFormMessage getContactFormMessage(Long contactFormMessageId);

	/**
	 * Changes the isRead status of the message to TRUE
	 * 
	 * @param contactFormMessageId
	 *            The long containing the id of the message which status to be
	 *            changed
	 */
	void setContactFormMessageReadStatusTrue(long contactFormMessageId);

	/**
	 * Creates and saves the comment with given text
	 * 
	 * @param messageId
	 *            The long containing the id of the message associated with the
	 *            comment
	 * @param commentText
	 *            The String containing the text of the comment
	 */
	void addComment(long messageId, String commentText);

	/**
	 * Deletes the comment with given id
	 * 
	 * @param commentId
	 *            The long containing the id of the comment to be deleted
	 */
	void deleteComment(long commentId);

	/**
	 * Returns the number of the contact form messages for given list type.
	 * 
	 * @param listType
	 *            The String containing the type of the list
	 * @return A long representing the number of the contact form messages
	 */
	long getNumberOfAllContactFormMessages(String listType);

	/**
	 * Returns the number of the contact form messages for given search parameters.
	 * 
	 * @param searchParametersValue
	 *            The String[] containing the search parameters
	 * @return A long representing the number of the contact form messages
	 */
	long getNumberOfContactFormMessagesForGivenSearchParams(String[] searchParametersValue);

}
