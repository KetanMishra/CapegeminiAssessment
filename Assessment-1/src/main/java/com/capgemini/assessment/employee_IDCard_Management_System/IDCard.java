/**
 * IDCard Entity Class
 * Represents an employee ID card in the system
 * Maintains one-to-one relationship with Employee entity
 * @author Digital
 */
package com.capgemini.assessment.employee_IDCard_Management_System;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * IDCard entity mapped to 'id_card' table
 */
@Entity
@Table(name="id_card")
public class IDCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cardNumber;
	private LocalDate issueDate;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	
	// Default constructor for JPA
	public IDCard() {
		super();
	}
	
	// Constructor with card details
	public IDCard(String cardNumber, LocalDate issueDate) {
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
	}
	
	
	public int getId() {
		return id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
