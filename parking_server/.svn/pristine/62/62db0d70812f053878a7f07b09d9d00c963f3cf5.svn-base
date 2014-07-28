package com.ericsson.parking.controller;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericsson.parking.service.HistoryService;
import com.ericsson.parking.util.CalendarUtil;
import com.ericsson.parking.util.Constant;

/**
 * @author Jiarong Xu
 * @date May 9, 2013 11:22:20 AM
 *
 */

@Controller
@RequestMapping("/history")
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public void show(@RequestParam String start, @RequestParam String end, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Calendar startCalendar = CalendarUtil.parseDate(start);
		Calendar endCalendar = CalendarUtil.parseDate(end);

		if (startCalendar == null || endCalendar == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if (request.getSession().getServletContext().getAttribute(Constant.HISTORY_ATTR) == null) {
			request.getSession().getServletContext().setAttribute(Constant.HISTORY_ATTR, historyService.get());
		}
		Map<String, String> historyMap = (Map<String, String>)request.getSession().getServletContext().getAttribute(Constant.HISTORY_ATTR);
		
		endCalendar.add(Calendar.DATE, 1);
		String result = "";
		for (Calendar calendar = startCalendar; calendar.before(endCalendar); ) {
			String calStr = CalendarUtil.toString(calendar);
			if (historyMap.containsKey(calStr)) {
				result += historyMap.get(calStr) + ",";
			}
			calendar.add(Calendar.DATE, 1);
		}
		
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}

		response.getWriter().print(result);
		response.getWriter().flush();
        return;
	}
}
