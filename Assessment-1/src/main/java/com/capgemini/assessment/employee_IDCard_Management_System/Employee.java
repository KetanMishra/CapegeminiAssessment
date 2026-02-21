/**
 * Employee Entity Class
 * Represents an employee in the ID Card Management System
 * This class maintains a one-to-one relationship with IDCard entity
 * @author Digital
 */
package com.capgemini.assessment.employee_IDCard_Management_System;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Employee entity mapped to 'employee' table in database
 */
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	private IDCard idCard;
	
	// Default constructor required by JPA
	public Employee() {
		super();
	}
	
	// Parameterized constructor for easy object creation
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public IDCard getIdCard() {
		return idCard;
	}
	
	// Setter maintains bidirectional relationship
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
		if(idCard != null) {
			idCard.setEmployee(this);
		}
	}
	
}
