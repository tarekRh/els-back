package com.els.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "salaries")
public class Salaried {

	@Id
	@JsonIgnore
	private String id;

	private String salariedId;

	private String firstName;

	private String lastName;

	private String tel;

	public Salaried() {
		super();
	}

	public Salaried(String id, String salariedId, String firstName, String lastName, String tel) {
		super();
		this.id = id;
		this.salariedId = salariedId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSalariedId() {
		return salariedId;
	}

	public void setSalariedId(String salariedId) {
		this.salariedId = salariedId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(salariedId).append(firstName).append(lastName).append(tel)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Salaried rhs = (Salaried) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, rhs.id).append(salariedId, rhs.salariedId)
				.append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(tel, rhs.tel).isEquals();
	}

	@Override
	public String toString() {
		return "Salaried [id=" + id + ", salariedId=" + salariedId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", tel=" + tel + "]";
	}

}
