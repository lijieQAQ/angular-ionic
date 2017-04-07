package com.culture.util;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test("googleeeggg");
	}
	public static void test(String s){
		int count=0;
		ArrayList<Integer> List = new ArrayList(); 
		if(1>s.length()||s.length()>1000){
			return;
		}else{
			char[] charArray = s.toCharArray();
			for(int i=0;i<charArray.length;i++){
				for(int j=0;j<charArray.length;j++){
					if(i!=j){
						if(charArray[i]==charArray[j]){
							if(List.contains(j)){
								break;
							}else{
								List.add(i);
								count++;
								break;
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}

}
