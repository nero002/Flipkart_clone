package com.nero.flipkart.POJO;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MobileModel implements Serializable {

	@SerializedName("Mobiles Products")
	private List<MobilesProductsModel> mobilesProducts;

	public List<MobilesProductsModel> getMobilesProducts(){
		return mobilesProducts;
	}
}