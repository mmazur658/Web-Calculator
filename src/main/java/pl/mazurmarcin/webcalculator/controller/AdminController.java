package pl.mazurmarcin.webcalculator.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.mazurmarcin.webcalculator.entity.Comment;
import pl.mazurmarcin.webcalculator.entity.ContactFormMessage;
import pl.mazurmarcin.webcalculator.services.CalculatorStatService;
import pl.mazurmarcin.webcalculator.services.ContactFormMessageService;

@Controller
@RequestMapping("/administrator-panel")
public class AdminController {

	private ContactFormMessageService contactFormMessageService;
	private CalculatorStatService calculatorStatService;

	@Autowired
	public AdminController(ContactFormMessageService contactFormMessageService,
			CalculatorStatService calculatorStatService) {
		this.contactFormMessageService = contactFormMessageService;
		this.calculatorStatService = calculatorStatService;
	}

	@RequestMapping("/dashboard")
	public String showDashboard(Model theModel, Locale locale) {

		long numberOfUnreadContactFormMessage = contactFormMessageService.getNumberOfUnreadContactFormMessage();
		theModel.addAttribute("numberOfUnreadContactFormMessage", numberOfUnreadContactFormMessage);
		
		return "dashboard";
	}

	@RequestMapping("/contact-form-messages")
	public String showContactFormMessages(Model theModel) {

		long numberOfUnreadContactFormMessage = contactFormMessageService.getNumberOfUnreadContactFormMessage();
		theModel.addAttribute("numberOfUnreadContactFormMessage", numberOfUnreadContactFormMessage);

		return "contact-form-messages";
	}

	@RequestMapping("/get-contact-form-messages")
	public String geContactFormMessageList(@RequestParam(name = "listType") String listType, Model theModel,
			@RequestParam(required = false, name = "resultStartRange") Integer resultStartRange) {

		Integer resultRange = 20;
		resultStartRange = (resultStartRange == null || resultStartRange == 0) ? 0 : resultStartRange;

		List<ContactFormMessage> contactFormMessageList = contactFormMessageService.getContactFormMessages(listType,
				resultStartRange, resultRange);
		Long totalResults = contactFormMessageService.getTotalAmountOfContactFormMessagesList(listType);

		theModel.addAttribute("totalResults", totalResults);
		theModel.addAttribute("contactFormMessageList", contactFormMessageList);

		return "parts/contact-form-message-table";
	}

	@RequestMapping("/get-search-contact-form-messages")
	public String getSearchContactFormMessageList(@RequestParam(name = "listType") String listType, Model theModel,
			@RequestParam(required = false, name = "searchFormName") String searchFormName,
			@RequestParam(required = false, name = "searchFormEmail") String searchFormEmail,
			@RequestParam(required = false, name = "searchFormSubject") String searchFormSubject,
			@RequestParam(required = false, name = "searchFormStartDate") String searchFormStartDate,
			@RequestParam(required = false, name = "searchFormEndDate") String searchFormEndDate) {

		Integer resultRange = 20;
		searchFormEndDate = (searchFormEndDate != "") ? searchFormEndDate + " 23:59:59.0" : "";
		searchFormStartDate = (searchFormStartDate != "") ? searchFormStartDate + " 00:00:00.0" : "";

		String[] searchParametersValue = { searchFormName.trim(), searchFormEmail.trim(), searchFormSubject.trim(),
				searchFormStartDate.trim(), searchFormEndDate.trim(), listType.trim() };

		List<ContactFormMessage> contactFormMessageList = contactFormMessageService
				.getContactFormMessageSearchResult(searchParametersValue, 0, resultRange);
		Long totalResults = contactFormMessageService.getContactFormMessageAmountOfSearchResult(searchParametersValue);

		theModel.addAttribute("totalResults", totalResults);
		theModel.addAttribute("contactFormMessageList", contactFormMessageList);

		return "parts/contact-form-message-table";
	}

	@RequestMapping("/get-message-modal")
	public String getAdminMessageModal(@RequestParam(name = "contactFormMessageId") Long contactFormMessageId,
			Model theModel) {

		ContactFormMessage contactFormMessage = contactFormMessageService.getContactFormMessage(contactFormMessageId);
		contactFormMessage.getCommentsList().sort(Comparator.comparing(Comment::getId).reversed());

		theModel.addAttribute("commentsList", contactFormMessage.getCommentsList());
		theModel.addAttribute("contactFormMessage", contactFormMessage);

		return "parts/message-modal";
	}

	@RequestMapping("/statistics")
	public String showStatisticsPage(Model theModel) {
		
		long[] generalStatisticsResultSet = calculatorStatService.getGeneralStatisticsResultSet();		
	
		theModel.addAttribute("generalStatisticsResultSet", generalStatisticsResultSet);

		return "statistics";
	}
}
