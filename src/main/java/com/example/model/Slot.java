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
@Table(name = "slot_dtls")

public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long plotId;
	
	private boolean slotAssigned;
	
	private boolean irrigationDone;

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

	public Long getPlotId() {
		return plotId;
	}

	public void setPlotId(Long plotId) {
		this.plotId = plotId;
	}

	public boolean isIrrigationReq() {
		return irrigationDone;
	}

	public void setIrrigationReq(boolean irrigationReq) {
		this.irrigationDone = irrigationReq;
	}

	public boolean isSlotAssigned() {
		return slotAssigned;
	}

	public void setSlotAssigned(boolean slotAssigned) {
		this.slotAssigned = slotAssigned;
	}

	public boolean isIrrigationDone() {
		return irrigationDone;
	}

	public void setIrrigationDone(boolean irrigationDone) {
		this.irrigationDone = irrigationDone;
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
		return Objects.hash(createTime, id, irrigationDone, plotId, slotAssigned, updateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		return Objects.equals(createTime, other.createTime) && Objects.equals(id, other.id)
				&& irrigationDone == other.irrigationDone && Objects.equals(plotId, other.plotId)
				&& slotAssigned == other.slotAssigned && Objects.equals(updateTime, other.updateTime);
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", plotId=" + plotId + ", slotAssigned=" + slotAssigned + ", irrigationDone="
				+ irrigationDone + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	
}
