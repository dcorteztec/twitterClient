package br.com.twitterClient.vo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


public class Tweets implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idTweet;
	private String text;
	private String userName;
	private Long idUser;
	private String location;
	private String url;
	
	public Long getIdTweet() {
		return idTweet;
	}
	public void setIdTweet(Long idTweet) {
		this.idTweet = idTweet;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
