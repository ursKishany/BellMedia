package com.BellMedia.model;

import java.util.List;

public class ItemsResponse  {

	public List<Item> Items;
	public String ItemsType;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemsResponse [items=" + Items + ", ItemsType=" + ItemsType
				+ "]";
	}
	
}
