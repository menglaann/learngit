package com.ericsson.parking.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericsson.parking.service.CountdownService;
import com.ericsson.parking.service.DeviceService;
import com.ericsson.parking.service.HistoryService;
import com.ericsson.parking.util.Constant;
import com.ericsson.parking.util.NumberUtil;

/**
 * @author Jiarong Xu
 * @date May 9, 2013 11:22:20 AM
 *
 */

@Controller
@RequestMapping("/countdown")
public class CountdownController {

	@Autowired
	private CountdownService countdownService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/gfgADSFDF", method = RequestMethod.POST)
	public void update(@RequestParam Integer count, @RequestBody String deviceId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (count == null || count < 0 || deviceId == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if (!deviceService.authorize(deviceId)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		request.getSession().getServletContext().setAttribute(Constant.COUNT_DOWN_ATTR, count);
		countdownService.set(String.valueOf(count));
		if (count == 0) {
			if (historyService.add())
				request.getSession().getServletContext().setAttribute(Constant.HISTORY_ATTR, historyService.get());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void show(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 7 || Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 18) {
			response.getWriter().print(-1);
			response.getWriter().flush();
	        return;
		}
		
		Integer count ;
		Object countObj = request.getSession().getServletContext().getAttribute(Constant.COUNT_DOWN_ATTR);
		if (countObj == null) {
			countObj = countdownService.get();
			request.getSession().getServletContext().setAttribute(Constant.COUNT_DOWN_ATTR, countObj);
		}
		
		if (countObj == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		count = NumberUtil.parseInt(countObj);
		if (count == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		if (count < 0)
			count = 0;
		
		response.getWriter().print(count);
		response.getWriter().flush();
        return;
	}
}
