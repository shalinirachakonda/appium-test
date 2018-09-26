package org.ets.selenium.tests.iviewer_selenium_regression_tests;

public class ReverseString {
	static String name= "Shalini";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] nameArray= name.toCharArray();
		System.out.println("char array is "+ nameArray.length);
		int i= nameArray.length;
			for(int j= 0; j<i; j++, i--) {
				char c= nameArray[j];
				nameArray[j] = nameArray[i-1];
				nameArray[i-1]= c;
				
			}
			String nameInString= String.valueOf(nameArray);
			System.out.println("reversed string is "+nameInString);
		
				
			
	}

}
