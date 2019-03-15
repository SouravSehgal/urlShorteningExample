package com.sourav.urlshortner.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class ShortUrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Cannot be null or empty")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
