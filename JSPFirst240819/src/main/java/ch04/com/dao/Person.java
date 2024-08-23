package ch04.com.dao;

import java.io.Serializable;

public class Person implements Serializable{
	private int id = 20241004;
	private String name = "홍길동";
	
	public Person() {
		
	}
	public int getId() {
		return id;
   }public void setId(int id) {
	   this.id = id;
   }
   public String getName() {
	   return name;
   }

   public void setName(String name) {
	   this.name = name;
   }

}
