package com.nero.flipkart.POJO;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MobilesProductsModel implements Serializable {

	@SerializedName("Mobiles")
	private List<MobilesModel> mobiles;

	public List<MobilesModel> getMobiles(){
		return mobiles;
	}
}