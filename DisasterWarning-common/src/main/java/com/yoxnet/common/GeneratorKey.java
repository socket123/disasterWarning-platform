/**
 * 
 */
package com.yoxnet.common;

import java.util.UUID;

/**
 * @author 
 */
public class GeneratorKey {

	public static synchronized  String genaraId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
		genaraId();
	}
}
