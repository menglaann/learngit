package com.ericsson.parking.service.impl;

import org.springframework.stereotype.Service;

import com.ericsson.parking.service.CountdownService;
import com.ericsson.parking.util.FileUtil;

/**
 * @author Jiarong Xu
 * @date Jun 4, 2013 2:23:58 PM
 *
 */

@Service
public class CountdownServiceImpl implements CountdownService {
	
	private static final String FILE_NAME = "/opt/count.data";
	
	@Override
	public void set(String countdown) {
		FileUtil.write(FILE_NAME, countdown);
	}
	
	@Override
	public String get() {
		return FileUtil.read(FILE_NAME);
	}
}
