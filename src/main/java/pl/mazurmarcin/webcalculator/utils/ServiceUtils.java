package pl.mazurmarcin.webcalculator.utils;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

public interface ServiceUtils {

	ContactFormMessage createContactFormMessage(String senderEmail, String senderName, String messageText,
			String messageSubject);

	String prepareHqlDependsOnListType(String hqlType, String listType);

	Comment createComment(String commentText, ContactFormMessage contactFormMessage);

	void changeIsActiveAndIsReadedStatus(ContactFormMessage contactFormMessage);

	void changeIsRepliedStatus(ContactFormMessage contactFormMessage);

	void changeIsReadedStatus(ContactFormMessage contactFormMessage);

}
