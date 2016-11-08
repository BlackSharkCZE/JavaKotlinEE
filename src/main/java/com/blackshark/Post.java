package com.blackshark;

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 26.10.16<br/>
 * Time: 22:06<br/>
 */
public class Post {

	private Long userId;
	private Long id;
	private String title;
	private String body;

	@Override
	public String toString() {
		return "Post{" +
				"userId=" + userId +
				", id=" + id +
				", title='" + title + '\'' +
				'}';
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
