package foxman.ufo;

public class UFOSighting {

	private String sightedAt;
	private String reportedAt;
	private String location;
	private String shape;
	private String duration;
	private String description;

	public UFOSighting(String sightedAt, String reportedAt, String location,
			String shape, String duration, String description) {
		this.sightedAt = sightedAt;
		this.reportedAt = reportedAt;
		this.location = location;
		this.shape = shape;
		this.duration = duration;
		this.description = description;
	}

	public String getLocation() {
		return this.location.trim();
	}

}