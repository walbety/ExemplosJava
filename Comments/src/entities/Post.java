package entities;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private String content;
	private Integer likes;
	private Date moment;
	private List<Comments> comments = new ArrayList<Comments>();

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Post(String content, Integer likes, Date moment) {
		super();
		this.content = content;
		this.likes = likes;
		this.moment = moment;
	}

	public void addComment(Comments comment) {
		this.comments.add(comment);
	}

	public void removeComment(Comments comment) {
		this.comments.remove(comment);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.content + "\n");
		sb.append("Likes: " + this.likes + "\n");
		sb.append(DATE_FORMAT.format(this.moment) + "\n");
		sb.append("comments: \n");

		for (Comments comments2 : this.comments) {
			sb.append(comments2.getText() + "\n");
		}
		return sb.toString();
	}

}
