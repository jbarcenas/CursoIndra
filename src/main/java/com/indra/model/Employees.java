package com.indra.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;





@Entity
@Table(name="EMPLOYEES")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name = "c_generator", sequenceName = "EMPLOYEES_SEQ", allocationSize=1)
	@Column (name="EMPLOYEE_ID")
	private int employeeId;
	
	@NotEmpty
	@Column (name="FIRST_NAME")
	private String firstName;
	
	@NotEmpty
	@Column (name="LAST_NAME")
	private String lastName;
	
	@NotEmpty
	@Email
	@Column (name="EMAIL")
	private String email;
	
	@Column (name="PHONE_NUMBER")
	private String phoneNumber;
	
	

	@Column (name="HIRE_DATE")
	private Date hireDate;
	//private String job_id;
//	private Integer department_id;
	
	
	@ManyToOne
	@JoinColumn(name="JOB_ID",nullable=false)
	private Jobs jobs;
	
	
	public List<JobHistory> getListaJobs() {
		return listaJobs;
	}



	public void setListaJobs(List<JobHistory> listaJobs) {
		this.listaJobs = listaJobs;
	}



	@Column (name="SALARY")
	private Double salary;
	
	
	
	@Column (name="COMMISSION_PCT")
	private Double commissionPct;
	
	@Column (name="MANAGER_ID")
	private Integer managerId;

	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID",nullable=false)
	private Departaments depas;
	
		
	@OneToMany(cascade= CascadeType.ALL, mappedBy="employes",fetch =FetchType.LAZY)
	private List<JobHistory> listaJobs;
	
	public Employees () {
		
	}

	

	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}



	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}



	public Integer getManagerId() {
		return managerId;
	}



	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}



	public Departaments getDepas() {
		return depas;
	}

	public void setDepas(Departaments depas) {
		this.depas = depas;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}


	
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobs=" + jobs
				+ ", salary=" + salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", depas="
				+ depas + "]";
	}
	

}
