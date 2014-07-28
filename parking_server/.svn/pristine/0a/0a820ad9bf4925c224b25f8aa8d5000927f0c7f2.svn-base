package com.ericsson.parking.service.impl;

import org.springframework.stereotype.Service;

import com.ericsson.parking.service.DeviceService;
import com.ericsson.parking.util.FileUtil;

/**
 * @author Jiarong Xu
 * @date Jun 4, 2013 3:39:17 PM
 *
 */

@Service
public class DeviceServiceImpl implements DeviceService {

	private static final String FILE_NAME = "/opt/user.data";
	
	@Override
	public boolean authorize(String deviceId) {
		String userId = FileUtil.read(FILE_NAME);
		return deviceId.equals(userId);
	}
}
