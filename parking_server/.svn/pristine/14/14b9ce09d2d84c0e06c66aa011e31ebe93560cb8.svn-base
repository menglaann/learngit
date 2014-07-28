package com.ericsson.parking.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ericsson.parking.service.HistoryService;
import com.ericsson.parking.util.CalendarUtil;
import com.ericsson.parking.util.FileUtil;

/**
 * @author Jiarong Xu
 * @date Jun 4, 2013 2:23:58 PM
 *
 */

@Service
public class HistoryServiceImpl implements HistoryService {

	private static final String FILE_NAME = "/opt/history.data";
	
	@Override
	public Map<String, String> get() {
		String historyStr = FileUtil.read(FILE_NAME);
		return getHistoryMap(historyStr);
	}
	
	private Map<String, String> getHistoryMap(String str) {
		Map<String, String> historyMap = new HashMap<String, String>();
		if (str != null) {
			String[] histories = str.split(",");
			for (String history : histories) {
				if (history.length() == 12) {
					historyMap.put(history.substring(0, 8), history);
				}
			}
		}
		return historyMap;
	}

	@Override
	public boolean add() {
		Map<String, String> historyMap = get();
		String historyStr = "";
		Calendar calendar = Calendar.getInstance();
		
		if (historyMap.containsKey(CalendarUtil.toString(calendar))) {
			return false;
		}
		
		historyMap.put(CalendarUtil.toString(calendar), CalendarUtil.toString(calendar, CalendarUtil.DEFAULT_TIME_FORMAT));
		for (String key : historyMap.keySet()) {
			historyStr += historyMap.get(key) + ",";
		}
		if (historyStr.length() > 0) {
			historyStr = historyStr.substring(0, historyStr.length() - 1);
		}
		FileUtil.write(FILE_NAME, historyStr);
		return true;
	}
}
