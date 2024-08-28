package edu.mvcproduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService {
	HashMap<String , Product> products = 
	         new HashMap<>() ;
	         //new HashMap<String , Product>() ;
	   public ProductService()
	   {
	      Product p = new Product("101", 
	         "애플사과폰12", "애플전자", 
	         1200000, "22.12.12");
	      products.put("101", p);
	      p = new Product("102","삼전우주폰 21",
	            "삼전전자",1300000,"2021.2.2");
	      products.put("102", p);
	      p = new Product("103","엘스듀얼폰",
	            "엘스전자",1500000,"2021.3.2");
	      products.put("103", p);
	   }
	   
	   public List<Product>  findAll()
	   //public List<Product>  findAll() //가능함
	   {
	      return new ArrayList<>(products.values()) ;
	   }
	   
	   public Product find(String id)
	   {
	      return  products.get(id);
	   }
}
