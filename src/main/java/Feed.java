
public class Feed {
	protected String title;
	protected String content;
	protected String user;
	protected String date;
	
	public Feed(String title, String content, String user, String date) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
