package com.newspaper.reader.Model;

import com.rometools.rome.feed.synd.SyndEntry;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Entry {
	private String title;
	private String category;
	private String description;
	private String uri;
	private String link;
	private Date date;

	public Entry(SyndEntry syndEntry) {
		this.title = syndEntry.getTitle();
		this.category = syndEntry.getCategories().size() > 0 ? syndEntry.getCategories().get(0).getName():"";
		this.description = syndEntry.getDescription().getValue();
		this.uri = syndEntry.getUri();
		this.link = syndEntry.getLink();
		this.date = syndEntry.getPublishedDate();
	}
}
