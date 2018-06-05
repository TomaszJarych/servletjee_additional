package pl.coderslab.filter.entities;

import java.sql.Date;

public class FilterInfo {
	private Long id;
	private String browserInfo;
	private Date dateTime;
	private String parameters;
	private Long executionTime;
	public Long getId() {
		return id;
	}
	public String getBrowserInfo() {
		return browserInfo;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public String getParameters() {
		return parameters;
	}
	public Long getExecutionTime() {
		return executionTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}
	
	

}
