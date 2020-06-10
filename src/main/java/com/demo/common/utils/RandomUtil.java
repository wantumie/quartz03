package com.demo.common.utils;

import java.util.Random;

public class RandomUtil {

	public static int randomNumber(int minNum,int maxNum){
		  Random rand = new Random();
		  int randomNum = rand.nextInt(maxNum);
		  randomNum = randomNum%(maxNum-minNum+1)+minNum;
		  return randomNum;
		 }
}
