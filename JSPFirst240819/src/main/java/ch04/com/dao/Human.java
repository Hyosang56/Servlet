package ch04.com.dao;

import java.io.Serializable;

public class Human implements Serializable{
	private   int  id = 12345678;
	   private String name = "류현진" ;
	   
	   public Human() {  }

	   public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	

}
