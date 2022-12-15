package com.example.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "plot_dtls")

public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "registeredOwner")
	private String registeredOwner;

	@Column(name = "registeredBuyer")
	private String registeredBuyer;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "area_ha")
	private double area_ha;

	@Column(name = "unit_price")
	private double unit_price;

	@Column(name = "irrigationReq")
	private boolean irrigationReq;

	@CreationTimestamp
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime;

	@UpdateTimestamp
	@Column(name = "update_time")
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegisteredOwner() {
		return registeredOwner;
	}

	public void setRegisteredOwner(String registeredOwner) {
		this.registeredOwner = registeredOwner;
	}

	public String getRegisteredBuyer() {
		return registeredBuyer;
	}

	public void setRegisteredByer(String registeredBuyer) {
		this.registeredBuyer = registeredBuyer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getArea_ha() {
		return area_ha;
	}

	public void setArea_ha(double area_ha) {
		this.area_ha = area_ha;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public boolean isIrrigationReq() {
		return irrigationReq;
	}

	public void setIrrigationReq(boolean irrigationReq) {
		this.irrigationReq = irrigationReq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area_ha, city, createTime, district, id, registeredBuyer, registeredOwner, state,
				unit_price, irrigationReq, updateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		return Double.doubleToLongBits(area_ha) == Double.doubleToLongBits(other.area_ha)
				&& Objects.equals(city, other.city) && Objects.equals(createTime, other.createTime)
				&& Objects.equals(district, other.district) && Objects.equals(id, other.id)
				&& Objects.equals(registeredBuyer, other.registeredBuyer)
				&& Objects.equals(registeredOwner, other.registeredOwner) && Objects.equals(state, other.state)
				&& Double.doubleToLongBits(unit_price) == Double.doubleToLongBits(other.unit_price)
				&& Objects.equals(irrigationReq, other.irrigationReq) && Objects.equals(updateTime, other.updateTime);
	}

	@Override
	public String toString() {
		return "Plot [id=" + id + ", registeredOwner=" + registeredOwner + ", registeredBuyer=" + registeredBuyer
				+ ", city=" + city + ", district=" + district + ", state=" + state + ", area_ha=" + area_ha
				+ ", unit_price=" + unit_price + ", irrigationReq = " + irrigationReq + ",  createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
