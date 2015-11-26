package com.cuong.futurenav.model.wiki.img;

import java.util.ArrayList;

public class Page {
	private String pageid;
	ArrayList<Image> images;
	ArrayList<Imageinfo> imageinfo;
	
	public ArrayList<Imageinfo> getImageinfo() {
		return imageinfo;
	}
	public void setImageinfo(ArrayList<Imageinfo> imageinfo) {
		this.imageinfo = imageinfo;
	}
	public String getPageid() {
		return pageid;
	}
	public void setPageid(String pageid) {
		this.pageid = pageid;
	}
	public ArrayList<Image> getImages() {
		return images;
	}
	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}
	
	
}
