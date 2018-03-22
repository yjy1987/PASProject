package com.app.pas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public class FileCommand {

	private String title;
	private MultipartFile f;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getF() {
		return f;
	}
	public void setF(MultipartFile f) {
		this.f = f;
	}
}
