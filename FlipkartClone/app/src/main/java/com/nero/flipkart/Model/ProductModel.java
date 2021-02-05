package com.nero.flipkart.Model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProductModel implements Serializable {

	@SerializedName("image")
	private String image;

	public ProductModel(int id, String title, Object price, String description, String category, String image) {
		this.image = image;
		this.price = price;
		this.description = description;
		this.id = id;
		this.title = title;
		this.category = category;
	}

	@SerializedName("price")
	private Object price;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("category")
	private String category;

	public String getImage(){
		return image;
	}

	public Object getPrice(){
		return price;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"ProductModel{" + 
			"image = '" + image + '\'' + 
			",price = '" + price + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}