package com.mostafa.sna.model;

public class ReportStaticContent {
	
	private String logoPath = "static/images/spring-icon.png";
	private String heading = "ORG-PAY";
	private String subHeading = "Organization Name.";
	
	public ReportStaticContent() {
		
	}

	public ReportStaticContent(String logoPath, String heading, String subHeading) {
		super();
		this.logoPath = logoPath;
		this.heading = heading;
		this.subHeading = subHeading;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}
	
}
