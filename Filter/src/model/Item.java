package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String iName;
	private Integer price;
	private Integer quantity;
	private String mDate;
	private String eDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public Item() {
		super();
	}
	public Item(Integer id, String iName, Integer price, Integer quantity, String mDate, String eDate) {
		super();
		this.id = id;
		this.iName = iName;
		this.price = price;
		this.quantity = quantity;
		this.mDate = mDate;
		this.eDate = eDate;
	}
	
	
}
