/**
 * 
 */
package com.suse.www.util;

import java.util.Random;

/**
 * @ClassName: TestOne.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 3:01:12 PM
 */
public class TestOne {

	public void calculate(){
		float one = 0;
		float two = 0;
		one = new Random().nextFloat();
		two = new Random().nextFloat();
		System.out.println(one+"+"+two+"="+(one+two));
	}
}
