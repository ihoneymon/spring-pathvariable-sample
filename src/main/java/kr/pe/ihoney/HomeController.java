package kr.pe.ihoney;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import kr.pe.ihoney.type.CodeDescriptionOrderEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/enum/{enumCode}", method=RequestMethod.GET)
	public String enumPathVariable(@PathVariable("enumCode") CodeDescriptionOrderEnum codeDescriptionOrderEnum, Model model) {
		String message = "";
		switch (codeDescriptionOrderEnum) {
		case FIRST:
			message = "First is 1st";
			break;
		case SECOND:
			message = "SECOND is 2nd";
			break;
		case THIRD:
			message = "THIRD is 3rd";
			break;
		case FOURTH:
			message = "FOURTH is 4th";
			break;
		case FIFTH:
			message = "FIFTH is 5th";
			break;

		default:
			message = "Unknown!!";
			break;
		}
		
		model.addAttribute("enumType", codeDescriptionOrderEnum.getCode());
		model.addAttribute("message", message );
		return "home";
	}
	
}
