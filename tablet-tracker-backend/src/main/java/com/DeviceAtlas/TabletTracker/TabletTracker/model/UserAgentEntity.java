package com.DeviceAtlas.TabletTracker.TabletTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity

@Table(name = "user_agents")
public class UserAgentEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonProperty("primaryHardwareType")
	    private String primaryHardwareType;

	    @JsonProperty("osVersion")
	    private String osVersion;

	    @JsonProperty("vendor")
	    private String vendor;

	    @JsonProperty("browserVersion")
	    private String browserVersion;

	    @JsonProperty("browserName")
	    private String browserName;

	    @JsonProperty("model")
	    private String model;

	    @JsonProperty("osName")
	    private String osName;

	    @JsonProperty("browserRenderingEngine")
	    private String browserRenderingEngine;

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getPrimaryHardwareType() {
	        return primaryHardwareType;
	    }

	    public void setPrimaryHardwareType(String primaryHardwareType) {
	        this.primaryHardwareType = primaryHardwareType;
	    }

	    public String getOsVersion() {
	        return osVersion;
	    }

	    public void setOsVersion(String osVersion) {
	        this.osVersion = osVersion;
	    }

	    public String getVendor() {
	        return vendor;
	    }

	    public void setVendor(String vendor) {
	        this.vendor = vendor;
	    }

	    public String getBrowserVersion() {
	        return browserVersion;
	    }

	    public void setBrowserVersion(String browserVersion) {
	        this.browserVersion = browserVersion;
	    }

	    public String getBrowserName() {
	        return browserName;
	    }

	    public void setBrowserName(String browserName) {
	        this.browserName = browserName;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public String getOsName() {
	        return osName;
	    }

	    public void setOsName(String osName) {
	        this.osName = osName;
	    }

	    public String getBrowserRenderingEngine() {
	        return browserRenderingEngine;
	    }

	    public void setBrowserRenderingEngine(String browserRenderingEngine) {
	        this.browserRenderingEngine = browserRenderingEngine;
	    }
	    
}
