
public class Details {
	protected String discussion;
	protected String time;
	
	public Details(String discussion, String time) {
		super();
		this.discussion = discussion;
		this.time = time;
	}
	public String getDiscussion() {
		return discussion;
	}
	
	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}
	public String getTime() {
		return time;
	}
	public void	setTime(String time) {
		this.time = time;
	}

}
