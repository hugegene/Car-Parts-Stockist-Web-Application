package nus.iss.sa45.team13.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="productdata")
public class Product {
	@Id
	@Min(value=1)
	@NotNull
	@Column(name = "partnumber")
	private int partNumber;
	
	@Column(name = "partname")
	private String partName;
	
	@Column(name = "unitprice")
	private Double unitPrice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "dimension")
	private Double dimension;
	
	@Column(name = "supplierid")
	private Integer supplierId;
	
	@Column(name = "reorderpoint")
	private Integer reorderPoint;
	
	@Column(name = "minorder")
	private Integer minOrder;
	
	@Column(name = "shelflocation")
	private String shelfLocation;
	
	@Column(name = "category")
	private String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int partNumber, String partName, Double unitPrice, String description, String color,
			Double dimension, Integer supplierid, Integer reorderpoint, Integer minorder, String shelfLocation, String category) {
		super();
		this.partNumber = partNumber;
		this.partName = partName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.color = color;
		this.dimension = dimension;
		this.supplierId = supplierid;
		this.reorderPoint = reorderpoint;
		this.minOrder = minorder;
		this.shelfLocation = shelfLocation;
		this.category = category;
	}



	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getDimension() {
		return dimension;
	}

	public void setDimension(Double dimension) {
		this.dimension = dimension;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public Integer getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(Integer minOrder) {
		this.minOrder = minOrder;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [partnumber=" + partNumber + ", partName=" + partName + ", unitPrice=" + unitPrice
				+ ", description=" + description + ", color=" + color + ", dimension=" + dimension + ", supplierid="
				+ supplierId + ", reorderpoint=" + reorderPoint + ", minorder=" + minOrder + ", shelfLocation="
				+ shelfLocation + ", category=" + category + "]";
	}

	
}
