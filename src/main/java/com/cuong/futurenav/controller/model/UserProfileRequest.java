package com.cuong.futurenav.controller.model;

public class UserProfileRequest {
	private String displayName;
	private String email;
	private String photoUrl;
	private String networkGroup;
	private String authToken;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getNetworkGroup() {
		return networkGroup;
	}
	public void setNetworkGroup(String networkGroup) {
		this.networkGroup = networkGroup;
	}
	
}
