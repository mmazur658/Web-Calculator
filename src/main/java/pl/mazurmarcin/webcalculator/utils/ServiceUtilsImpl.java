package pl.mazurmarcin.webcalculator.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

@Component
public class ServiceUtilsImpl implements ServiceUtils {

	@Override
	public ContactFormMessage createContactFormMessage(String senderEmail, String senderName, String messageText,
			String messageSubject) {

		ContactFormMessage contactFormMessage = new ContactFormMessage();

		contactFormMessage.setSenderEmail(senderEmail);
		contactFormMessage.setSenderName(senderName);
		contactFormMessage.setMessageText(messageText);
		contactFormMessage.setMessageSubject(messageSubject);
		contactFormMessage.setIsReplied(false);
		contactFormMessage.setDate(new Date());
		contactFormMessage.setIsActive(true);
		contactFormMessage.setIsReaded(false);

		return contactFormMessage;
	}

	@Override
	public String prepareHqlDependsOnListType(String hqlType, String listType) {

		StringBuilder sb = new StringBuilder();
		sb.append(hqlType);
		if (listType.equals("new"))
			sb.append("where isActive=true ");
		else if (listType.equals("archive"))
			sb.append("where isActive=false ");

		sb.append("ORDER BY id DESC");

		return sb.toString();
	}

	@Override
	public Comment createComment(String commentText, ContactFormMessage contactFormMessage) {

		Comment comment = new Comment();
		comment.setDate(new Date());
		comment.setCommentText(commentText);
		comment.setContactFormMessage(contactFormMessage);

		return comment;
	}

	@Override
	public void changeIsActiveAndIsReadedStatus(ContactFormMessage contactFormMessage) {
		if (contactFormMessage.getIsActive()) {
			contactFormMessage.setIsActive(false);
			contactFormMessage.setIsReaded(true);
		} else {
			contactFormMessage.setIsActive(true);
			contactFormMessage.setIsReaded(true);
		}
	}

	@Override
	public void changeIsRepliedStatus(ContactFormMessage contactFormMessage) {
		if (contactFormMessage.getIsReplied())
			contactFormMessage.setIsReplied(false);
		else {
			contactFormMessage.setIsReplied(true);
			contactFormMessage.setIsReaded(false);
		}
	}

	@Override
	public void changeIsReadedStatus(ContactFormMessage contactFormMessage) {
		if (contactFormMessage.getIsReaded())
			contactFormMessage.setIsReaded(false);
		else
			contactFormMessage.setIsReaded(true);
	}
}