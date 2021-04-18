package com.data;

public class MyMath {
	
	public int sum(int arr[]) {
		int total = 0;
		for(int x : arr) {
			total += x;
		}
		return total;
	}
}
