package com.indra.identity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int employee_id;
	private Date start_date;
	
	
	public JobHistoryId() {
		
	}
	
	
	public JobHistoryId(int employee_id, Date start_date) {
		super();
		this.employee_id = employee_id;
		this.start_date = start_date;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobHistoryId other = (JobHistoryId) obj;
		if (employee_id != other.employee_id)
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}
	
	
	
	
	
}
