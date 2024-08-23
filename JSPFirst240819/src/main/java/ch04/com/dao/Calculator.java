package ch04.com.dao;

import java.io.Serializable;

public class Calculator implements Serializable {
	public Calculator() {
		
	} public int process(int n) {
		return n * n * n ;
	}

}
