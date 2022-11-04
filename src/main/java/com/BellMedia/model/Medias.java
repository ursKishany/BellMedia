package com.BellMedia.model;

import java.io.Serializable;
import java.util.List;

public class Medias implements Serializable{

	public int Id;
	public String Name;
	public String Desc;
	public String ShortDesc;
	public List<Images> Images;
	public List<Genres> Genres;
}
