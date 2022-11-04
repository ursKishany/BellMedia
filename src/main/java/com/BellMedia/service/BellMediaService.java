package com.BellMedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BellMedia.model.Images;
import com.BellMedia.model.Item;
import com.BellMedia.model.ItemsResponse;
import com.BellMedia.model.Medias;

@Service
public class BellMediaService {

	@Autowired
	RestTemplate restTemplate;
	
	private String mediaUrl = "https://capi.9c9media.com/destinations/se_atexace/platforms/desktop/medias";
	
	public List<Item> getMediaList(int number){
		
		ResponseEntity<ItemsResponse> response = restTemplate.getForEntity(mediaUrl + "?$top="+number, ItemsResponse.class);
		return response.getBody().Items;
		
	}
	
		private Medias getMedia(int id){
		
		return restTemplate.getForObject(mediaUrl + "/"+id, Medias.class);
		
	}

		public List<Medias> getMediaDetailList(int count) {
			List<Item> items=getMediaList(count);
			List<Medias> medias=new ArrayList<Medias>();
			for(Item item: items){
				medias.add(getMedia(item.Id));
			}
			return medias;
		}

		public Medias getMediaDetail(int id, String type) {
			Medias medias=getMedia(id);
			List<Images> images=medias.Images.stream().filter(x->x.Type.equalsIgnoreCase(type)).collect(Collectors.toList());
			medias.Images=images;
			return medias;
		}
		
	
}
