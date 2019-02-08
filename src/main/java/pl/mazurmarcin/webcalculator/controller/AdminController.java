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

/**
 * The controller class is used to return the view depending on the user
 * request. This controller contains the views of: <br>
 * <ul>
 * <li>"dashboard"</li>
 * <li>"parts/contact-form-message-table"</li>
 * <li>"parts/message-modal"</li>
 * <li>"statistics"</li>
 * </ul>
 * 
 * @author Marcin Mazur
 *
 */
@Controller
@RequestMapping("/administrator-panel")
public class AdminController {

	private final String START_TIME = " 00:00:00.0";
	private final String END_TIME = " 23:59:59.9";

	/**
	 * The number of the results to be returned
	 */
	private final int NUMBER_OF_RESULTS = 20;
	/**
	 * The ContactFormMessageService interface
	 */
	private ContactFormMessageService contactFormMessageService;

	/**
	 * The CalculatorStatService interface
	 */
	private CalculatorStatService calculatorStatService;

	/**
	 * Constructs an AdminController with the ContactFormMessageService and
	 * CalculatorStatService
	 * 
	 * @param contactFormMessageService
	 *            The ContactFormMessageService interface
	 * @param calculatorStatService
	 *            The CalculatorStatService interface
	 */
	@Autowired
	public AdminController(ContactFormMessageService contactFormMessageService,
			CalculatorStatService calculatorStatService) {
		this.contactFormMessageService = contactFormMessageService;
		this.calculatorStatService = calculatorStatService;
	}

	/**
	 * Returns the view of "dashboard" with model attribute:<br>
	 * <ul>
	 * <li>numberOfUnreadContactFormMessage - The number of unread contact form
	 * messages</li>
	 * </ul>
	 * 
	 * @param theModel
	 *            The Model containing the data passed to the view
	 * @param locale
	 *            The Locale containing the user`s locale
	 * @return The String representing the name of the view
	 * 
	 */
	@RequestMapping("/dashboard")
	public String showDashboard(Model theModel, Locale locale) {

		long numberOfUnreadContactFormMessage = contactFormMessageService.getNumberOfUnreadContactFormMessage();
		theModel.addAttribute("numberOfUnreadContactFormMessage", numberOfUnreadContactFormMessage);

		return "dashboard";
	}

	/**
	 * Returns the view of "contact-form-messages"
	 * 
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/contact-form-messages")
	public String showContactFormMessages() {
		return "contact-form-messages";
	}

	/**
	 * Returns the view of "parts/contact-form-message-table" with model attributes:
	 * <br>
	 * <ul>
	 * <li>contactFormMessageList - The list of contact form messages</li>
	 * <li>totalResults - The length of the list</li>
	 * </ul>
	 * 
	 * @param listType
	 *            The String containing the type of the list ( new - archive - all )
	 * @param theModel
	 *            The Model containing the data passed to the view
	 * @param resultStartRange
	 *            The Integer containing the number of results to be returned
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/get-contact-form-messages")
	public String geContactFormMessageList(@RequestParam(name = "listType") String listType, Model theModel,
			@RequestParam(required = false, name = "resultStartRange") Integer resultStartRange) {

		resultStartRange = (resultStartRange == null || resultStartRange == 0) ? 0 : resultStartRange;

		List<ContactFormMessage> contactFormMessageList = contactFormMessageService.getContactFormMessages(listType,
				resultStartRange, NUMBER_OF_RESULTS);
		long totalResults = contactFormMessageService.getNumberOfAllContactFormMessages(listType);

		theModel.addAttribute("totalResults", totalResults);
		theModel.addAttribute("contactFormMessageList", contactFormMessageList);

		return "parts/contact-form-message-table";
	}

	/**
	 * Returns the view of "parts/contact-form-message-table" limited by search
	 * parameters and given date range with model attributes: <br>
	 * 
	 * <ul>
	 * <li>contactFormMessageList - The list of contact form messages</li>
	 * <li>totalResults - The length of the list</li>
	 * </ul>
	 * 
	 * @param listType
	 *            The String containing the type of the list ( new - archive - all )
	 * @param theModel
	 *            The String containing the The Model containing the data passed to
	 *            the view
	 * @param searchFormName
	 *            The String containing the name of the sender
	 * @param searchFormEmail
	 *            The String containing the email of the sender
	 * @param searchFormSubject
	 *            The String containing the subject of the message
	 * @param searchFormStartDate
	 *            The String containing the first day of the range
	 * @param searchFormEndDate
	 *            The String containing the last day of the range
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/get-search-contact-form-messages")
	public String getSearchContactFormMessageList(@RequestParam(name = "listType") String listType, Model theModel,
			@RequestParam(required = false, name = "searchFormName") String searchFormName,
			@RequestParam(required = false, name = "searchFormEmail") String searchFormEmail,
			@RequestParam(required = false, name = "searchFormSubject") String searchFormSubject,
			@RequestParam(required = false, name = "searchFormStartDate") String searchFormStartDate,
			@RequestParam(required = false, name = "searchFormEndDate") String searchFormEndDate) {

		searchFormEndDate = (searchFormEndDate != "") ? searchFormEndDate + END_TIME : "";
		searchFormStartDate = (searchFormStartDate != "") ? searchFormStartDate + START_TIME : "";

		String[] searchParametersValue = { searchFormName.trim(), searchFormEmail.trim(), searchFormSubject.trim(),
				searchFormStartDate.trim(), searchFormEndDate.trim(), listType.trim() };

		List<ContactFormMessage> contactFormMessageList = contactFormMessageService
				.getContactFormMessageSearchResult(searchParametersValue, 0, NUMBER_OF_RESULTS);
		long totalResults = contactFormMessageService
				.getNumberOfContactFormMessagesForGivenSearchParams(searchParametersValue);

		theModel.addAttribute("totalResults", totalResults);
		theModel.addAttribute("contactFormMessageList", contactFormMessageList);

		return "parts/contact-form-message-table";
	}

	/**
	 * Returns the view of "parts/message-modal" with model attributes: <br>
	 * <ul>
	 * <li>commentsList - The list of Comments</li>
	 * <li>contactFormMessage - The ContactFormMessage object</li>
	 * </ul>
	 * 
	 * @param contactFormMessageId
	 *            The Long containing the id of the message.
	 * @param theModel
	 *            The Model containing the data passed to the view
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/get-message-modal")
	public String getAdminMessageModal(@RequestParam(name = "contactFormMessageId") Long contactFormMessageId,
			Model theModel) {

		ContactFormMessage contactFormMessage = contactFormMessageService.getContactFormMessage(contactFormMessageId);
		contactFormMessage.getCommentsList().sort(Comparator.comparing(Comment::getId).reversed());

		theModel.addAttribute("commentsList", contactFormMessage.getCommentsList());
		theModel.addAttribute("contactFormMessage", contactFormMessage);

		return "parts/message-modal";
	}

	/**
	 * Returns the view of "statistics" with model attribute: <br>
	 * <ul>
	 * <li>generalStatisticsResultSet - The result set of general statistics</li>
	 * </ul>
	 * 
	 * @param theModel
	 *            The Model containing the data passed to the view
	 * @return The String representing the name of the view
	 */
	@RequestMapping("/statistics")
	public String showStatisticsPage(Model theModel) {

		long[] generalStatisticsResultSet = calculatorStatService.getGeneralStatisticsResultSet();

		theModel.addAttribute("generalStatisticsResultSet", generalStatisticsResultSet);

		return "statistics";
	}
}
