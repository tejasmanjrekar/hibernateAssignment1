package courseTodo;

public class Course {
	private int courseId;
	private String title;
	private int duration;
	private String provider;
	private double cost;
		
	public Course() {
		
	}
	public Course(int courseId, String title, int duration, String provider, double cost) {
		super();
		this.courseId=courseId;
		this.title = title;
		this.duration = duration;
		this.provider = provider;
		this.cost = cost;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", duration=" + duration + ", provider=" + provider
				+ ", cost=" + cost + "]";
	}
	
}
