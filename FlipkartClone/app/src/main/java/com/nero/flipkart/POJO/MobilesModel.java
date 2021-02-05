package com.nero.flipkart.POJO;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MobilesModel implements Serializable {

	@SerializedName("name")
	private String name;

	@SerializedName("price")
	private String price;

	@SerializedName("offer")
	private String offer;

	@SerializedName("Ram")
	private String ram;

	@SerializedName("Rating")
	private String rating;

	@SerializedName("Extra")
	private String extra;

	@SerializedName("Reviews")
	private String reviews;

	@SerializedName("Warranty")
	private String warranty;

	@SerializedName("Image_1_url")
	private String image1Url;

	@SerializedName("Image_2_url")
	private String image2Url;

	@SerializedName("Image_3_url")
	private String image3Url;

	@SerializedName("Image_4_url")
	private String image4Url;

	@SerializedName("Image_5_url")
	private String image5Url;

	@SerializedName("YouTubeVideoLink")
	private String youTubeVideoLink;

	@SerializedName("Description")
	private String description;

	@SerializedName("Product Description")
	private String productDescription;

	@SerializedName("Product Description2")
	private String productDescription2;

	@SerializedName("Product Description3")
	private String productDescription3;

	@SerializedName("Product Description4")
	private String productDescription4;

	@SerializedName("Product Description5")
	private String productDescription5;

	@SerializedName("Product DescriptionImage1")
	private String productDescriptionImage1;

	@SerializedName("Product DescriptionImage2")
	private String productDescriptionImage2;

	@SerializedName("Product DescriptionImage3")
	private String productDescriptionImage3;

	@SerializedName("Product DescriptionImage4")
	private String productDescriptionImage4;

	@SerializedName("Product DescriptionImage5")
	private String productDescriptionImage5;

	@SerializedName("Question1")
	private String question1;

	@SerializedName("Ans1")
	private String ans1;

	@SerializedName("Question2")
	private String question2;

	@SerializedName("Ans2")
	private String ans2;

	@SerializedName("Question3")
	private String question3;

	@SerializedName("Ans3")
	private String ans3;

	public String getName(){
		return name;
	}

	public String getPrice(){
		return price;
	}

	public String getOffer(){
		return offer;
	}

	public String getRam(){
		return ram;
	}

	public String getRating(){
		return rating;
	}

	public String getExtra(){
		return extra;
	}

	public String getReviews(){
		return reviews;
	}

	public String getWarranty(){
		return warranty;
	}

	public String getImage1Url(){
		return image1Url;
	}

	public String getImage2Url(){
		return image2Url;
	}

	public String getImage3Url(){
		return image3Url;
	}

	public String getImage4Url(){
		return image4Url;
	}

	public String getImage5Url(){
		return image5Url;
	}

	public String getYouTubeVideoLink(){
		return youTubeVideoLink;
	}

	public String getDescription(){
		return description;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public String getProductDescription2(){
		return productDescription2;
	}

	public String getProductDescription3(){
		return productDescription3;
	}

	public String getProductDescription4(){
		return productDescription4;
	}

	public String getProductDescription5(){
		return productDescription5;
	}

	public String getProductDescriptionImage1(){
		return productDescriptionImage1;
	}

	public String getProductDescriptionImage2(){
		return productDescriptionImage2;
	}

	public String getProductDescriptionImage3(){
		return productDescriptionImage3;
	}

	public String getProductDescriptionImage4(){
		return productDescriptionImage4;
	}

	public String getProductDescriptionImage5(){
		return productDescriptionImage5;
	}

	public String getQuestion1(){
		return question1;
	}

	public String getAns1(){
		return ans1;
	}

	public String getQuestion2(){
		return question2;
	}

	public String getAns2(){
		return ans2;
	}

	public String getQuestion3(){
		return question3;
	}

	public String getAns3(){
		return ans3;
	}
}