package com.job.portals.RozgarBazar.dto;

public class JobDto {
    private Long jobId;
    private String title;
    private String description;
    private String location;
    private Double payRate;
    private String shiftTimings;

    // Constructors
    public JobDto() {}

    public JobDto(Long jobId, String title, String description, String location, Double payRate, String shiftTimings) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.payRate = payRate;
        this.shiftTimings = shiftTimings;
    }

    // Getters and Setters
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getPayRate() { return payRate; }
    public void setPayRate(Double payRate) { this.payRate = payRate; }

    public String getShiftTimings() { return shiftTimings; }
    public void setShiftTimings(String shiftTimings) { this.shiftTimings = shiftTimings; }
}
