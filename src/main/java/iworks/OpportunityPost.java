package iworks;

public class OpportunityPost {
	private String title, institution, period, location, description, link;
	
	public OpportunityPost(String title, String institution, String period, String location, String description, String link) {
		this.title = title;
		this.institution = institution;
		this.period = period;
		this.location = location;
		this.description = description;
		this.link = link;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getInstitution() {
		return this.institution;
	}
	
	public String getPeriod() {
		return this.period;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getLink() {
		return this.link;
	}
}