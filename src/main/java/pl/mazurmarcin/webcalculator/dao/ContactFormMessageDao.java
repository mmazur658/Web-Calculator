package pl.mazurmarcin.webcalculator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;

@Repository
public interface ContactFormMessageDao {

	void sendMessage(ContactFormMessage contactFormMessage);

	long getNumberOfUnreadContactFormMessage();

	Long getTotalAmountOfContactFormMessagesList(String listType);

	long getContactFormMessageAmountOfSearchResult(String hql);

	ContactFormMessage getContactFormMessage(Long contactFormMessageId);

	List<ContactFormMessage> getContactFormMessages(String listType, Integer resultStartRange, Integer resultRange);

	void addComment(Comment comment);

	void deleteComment(long commentId);

}
