package br.com.twitterClient.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tweets implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TWEET")
	private Long idTweet;
	@Column(name="TEXT")
	private String text;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_ID")
	private Long idUser;
	@Column(name="LOCATION")
	private String location;
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
	
	
	
}
