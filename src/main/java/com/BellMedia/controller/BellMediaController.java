package com.BellMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BellMedia.model.Item;
import com.BellMedia.model.Medias;
import com.BellMedia.service.BellMediaService;

@RestController
public class BellMediaController {

	@Autowired
	BellMediaService service;
	
	@GetMapping(value = "/medias/{count}")
	public ResponseEntity<List<Item>> getMediasList(@PathVariable("count") int count) {
		
		if(count>0 && count <=10)
			return new ResponseEntity<List<Item>>( service.getMediaList(count), HttpStatus.OK);
		else
			return new ResponseEntity<>( (List<Item>)null, HttpStatus.BAD_REQUEST);
	   }
	
	@GetMapping(value = "/MediaDetailList//{count}")
	 public ResponseEntity<List<Medias>> getMediaDetailList(@PathVariable("count") int count) {
		if(count>0 && count <=10)
			return new ResponseEntity<List<Medias>>(  service.getMediaDetailList(count), HttpStatus.OK);
		else
			return new ResponseEntity<>( (List<Medias>)null, HttpStatus.BAD_REQUEST);
	   }
	
	@GetMapping(value = "/MediaDetail//{id}/{type}")
	 public Medias getMediaDetail(@PathVariable("id") int id,@PathVariable("type") String type ) {
	     return service.getMediaDetail(id,type);
	   }
}
