/**
 * Main Application Class for Employee ID Card Management System
 * This application demonstrates JPA/Hibernate implementation with One-to-One relationship
 * @author Digital
 * @version 1.0
 */
package com.capgemini.assessment.employee_IDCard_Management_System;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Application entry point
 */
public class App {
	public static void main(String[] args) {
		// Initialize EntityManagerFactory and EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("idEmpPU");
		EntityManager em = emf.createEntityManager();
		
		// Begin transaction
		em.getTransaction().begin();
		
		// Create new employee object
		Employee employee = new Employee("Sarah Johnson","sarah.johnson@company.com");
		
		// Create ID card with unique card number and current date
		IDCard employeeCard = new IDCard("EMP-2026-001",LocalDate.now());
		
		// Establish bidirectional relationship
		employee.setIdCard(employeeCard);
		
		// Persist employee (cascade will persist ID card as well)
		em.persist(employee);
		
		// Commit the transaction
		em.getTransaction().commit();
		
		System.out.println("=== Employee Record Created Successfully ===");
		System.out.println("Database entry completed at: " + LocalDate.now());
		System.out.println();
		
		Employee fetchEmp = em.find(Employee.class, 1);
		
		System.out.println("Employee Details: ");
		System.out.println("ID: "+fetchEmp.getId());
		System.out.println("Name: "+fetchEmp.getName());
		System.out.println("Email: "+fetchEmp.getEmail());
		
		System.out.println("\nID Card Details: ");
		System.out.println("Card Number: "+fetchEmp.getIdCard().getCardNumber());
		System.out.println("Issue Date: "+fetchEmp.getIdCard().getIssueDate());
		
		em.close();
		emf.close();
	}
}
