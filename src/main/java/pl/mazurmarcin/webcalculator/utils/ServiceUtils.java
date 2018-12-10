package pl.mazurmarcin.webcalculator.utils;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

/**
 * Interface used to perform operations for service classes
 * 
 * @author Marcin Mazur
 *
 */
public interface ServiceUtils {

	/**
	 * Creates and returns a ContactFormMessage with given email, name, text and
	 * subject.
	 * 
	 * @param senderEmail
	 *            The String containing the email of the sender
	 * @param senderName
	 *            The String containing the name of the sender
	 * @param messageText
	 *            The String containing the text of the message
	 * @param messageSubject
	 *            The String containing the subject of the message
	 * @return A ContactFormMessage representing the ContactFormMessage with given
	 *         parameters
	 */
	ContactFormMessage createContactFormMessage(String senderEmail, String senderName, String messageText,
			String messageSubject);

	/**
	 * Returns the HQL Statement with given parameters. <br>
	 * The hqlType should contain "FROM" word, the name of the entity and the space
	 * char as a last character of the string.
	 * 
	 * @param hqlType
	 *            The String containing the begging of the HQL
	 * @param listType
	 *            The String containing the type of the list
	 * @return A String representing the created HQL
	 */
	String prepareHqlDependsOnListType(String hqlType, String listType);

	/**
	 * Creates and returns the Comment with given text and associated
	 * ContactFormMessage.
	 * 
	 * @param commentText
	 *            The String containing the text of the Comment
	 * @param contactFormMessage
	 *            The ContactFormMessage associated with the Comment
	 * @return A Comment representing the Comment with given text and associated
	 *         ContactFormMessage
	 */
	Comment createComment(String commentText, ContactFormMessage contactFormMessage);

	/**
	 * Changes the isActive and isReaded status of given ContactFormMessage
	 * 
	 * @param contactFormMessage
	 *            The ContactFormMessage object
	 */
	void changeIsActiveAndIsReadedStatus(ContactFormMessage contactFormMessage);

	/**
	 * Changes the isReplied status of given ContactFormMessage
	 * 
	 * @param contactFormMessage
	 *            The ContactFormMessage object
	 */
	void changeIsRepliedStatus(ContactFormMessage contactFormMessage);

	/**
	 * Changes the IsRead status of given ContactFormMessage
	 * 
	 * @param contactFormMessage
	 *            The ContactFormMessage object
	 */
	void changeIsReadStatus(ContactFormMessage contactFormMessage);

}
