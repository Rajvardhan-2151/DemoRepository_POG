package study.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Grocery")
public class Grocery {

	@Id
	@Column
	private int product_id;
	@Column
	private String product_name;
	@Column
	private String product_desc;
	@Column
	private int unit;
	@Column
	private float cost;
	@Column
	private Date expiry_date ;
	
	
	
	public Grocery() {
		System.out.println("inside parameterless");
	}
	
	public Grocery(int product_id, String product_name, String product_desc, int unit, float cost, Date expiry_date) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.unit = unit;
		this.cost = cost;
		this.expiry_date = expiry_date;
	}
	
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	@Override
	public String toString() {
		return "Grocery [product_id=" + product_id + ", product_name=" + product_name + ", product_desc=" + product_desc
				+ ", unit=" + unit + ", cost=" + cost + ", expiry_date=" + expiry_date + "]";
	}
	
	
	
 
	
}


