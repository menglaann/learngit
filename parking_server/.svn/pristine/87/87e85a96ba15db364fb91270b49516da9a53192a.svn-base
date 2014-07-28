package com.ericsson.parking.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Jiarong Xu
 * @date May 9, 2013 11:36:24 AM
 *
 */

public class FileUtil {

	public static void write(String fileName, String count) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(count);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static String read(String fileName) {
		String result = null;
        File file = new File(fileName);
        if (file.exists()) {
        	BufferedReader input = null;
			try {
				input = new BufferedReader (new FileReader(file));
				result = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (input != null)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
        }
        return result;
	}
}
