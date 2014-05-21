package com.vmobs.alerts;

public class Alert {

	public Alert(String title, String description, int severity) {
		super();
		this.title = title;
		this.description = description;
		this.severity = severity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	private String title;
	private String description;
	private int severity;
	
}
