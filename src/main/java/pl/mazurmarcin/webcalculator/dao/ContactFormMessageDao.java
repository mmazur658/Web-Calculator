package pl.mazurmarcin.webcalculator.dao;

import java.util.List;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

/**
 * Interface for performing database operations on ContactFormMessage objects.
 * 
 * @author Marcin Mazur
 *
 */
public interface ContactFormMessageDao {

	/**
	 * Saves the ContactFormMessage object in the database.
	 * 
	 * @param contactFormMessage
	 *            The ContactFormMessage the be saved
	 */
	void sendMessage(ContactFormMessage contactFormMessage);

	/**
	 * Returns the number of all unread contact form messages
	 * 
	 * @return A long representing the number of all unread contact form messages
	 */
	long getNumberOfUnreadContactFormMessage();

	/**
	 * Returns the ContactFormMessage with given id
	 * 
	 * @param contactFormMessageId
	 *            The Long containing the id of contactFormMessage
	 * @return A ContactFormMessage with given id
	 */
	ContactFormMessage getContactFormMessage(Long contactFormMessageId);

	/**
	 * Returns the list of ContactFormMessage objects for given list type (new -
	 * archive - all)
	 * 
	 * @param listType
	 *            A String containing the type of the list
	 * @param resultStartRange
	 *            An Integer containing the first returning index
	 * @param resultRange
	 *            An Integer containing the number of results
	 * @return A List&lt;ContactFormMessage&gt; representing the list of
	 *         contactFormMessages
	 */
	List<ContactFormMessage> getContactFormMessages(String listType, Integer resultStartRange, Integer resultRange);

	/**
	 * Saves the comment in the database
	 * 
	 * @param comment
	 *            The Comment to be saved
	 */
	void addComment(Comment comment);

	/**
	 * Deletes the comment with the given id
	 * 
	 * @param commentId
	 *            The long containing the id of the comment to be deleted
	 */
	void deleteComment(long commentId);

	/**
	 * Returns the number of the contact form messages for given HQL Statement
	 * 
	 * @param hql
	 *            The String containing the HQL Statement to be executed
	 * @return An int representing the number of the contact form messages
	 */
	long getNumberOfAllContactFormMessages(String hql);


}
