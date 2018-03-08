package com.sam.ams.entity;

public class ChartData {

	private String month; 
    private int faults=0;
    private int tickets=0;
    private int ATS=0;
    
    public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getFaults() {
		return faults;
	}
	public void setFaults(int faults) {
		this.faults = faults;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public int getATS() {
		return ATS;
	}
	public void setATS(int aTS) {
		ATS = aTS;
	}
}
