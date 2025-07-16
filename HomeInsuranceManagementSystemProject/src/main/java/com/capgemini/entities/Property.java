package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Property")
public class Property {
	@Id
	private int propertyId;
	@Column(name = "market_Value")
	private int marketValue;
	@Column(name = "year_Built")
	private int yearBuilt;
	@Column(name = "square_Footage")
	private int squareFootage;
	@Column(name = "dwelling_Style")
	private double dwellingStyle;
	@Column(name = "roof_Material")
	private String roofMaterial;
	@Column(name = "garage_Type")
	private String garageType;
	@Column(name = "full_BathCount")
	private int fullBathCount;
	@Column(name = "Half_BathCount")
	private int halfBathCount;
	@Column(name = "has_SwimmingPool")
	private boolean hasSwimmingPool;

	
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public int getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getDwellingStyle() {
		return dwellingStyle;
	}

	public void setDwellingStyle(double dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}

	public String getRoofMaterial() {
		return roofMaterial;
	}

	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}

	public String getGarageType() {
		return garageType;
	}

	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}

	public int getFullBathCount() {
		return fullBathCount;
	}

	public void setFullBathCount(int fullBathCount) {
		this.fullBathCount = fullBathCount;
	}

	public int getHalfBathCount() {
		return halfBathCount;
	}

	public void setHalfBathCount(int halfBathCount) {
		this.halfBathCount = halfBathCount;
	}

	public boolean isHasSwimmingPool() {
		return hasSwimmingPool;
	}

	public void setHasSwimmingPool(boolean hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", marketValue=" + marketValue + ", yearBuilt=" + yearBuilt
				+ ", squareFootage=" + squareFootage + ", dwellingStyle=" + dwellingStyle + ", roofMaterial="
				+ roofMaterial + ", garageType=" + garageType + ", fullBathCount=" + fullBathCount + ", halfBathCount="
				+ halfBathCount + ", hasSwimmingPool=" + hasSwimmingPool + "]";
	}
}
