package com.ericsson.parking.service;

/**
 * @author Jiarong Xu
 * @date Jun 4, 2013 1:59:51 PM
 *
 */

public interface CountdownService {

	void set(String countdown);
	
	String get();
}
