package com.newspaper.reader.Model;

import com.rometools.rome.feed.synd.SyndFeed;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
public class FeedEntry extends Entry {
	private String feedType;
	private String docs;
	private String generator;
	private List<Entry> entries;

	public FeedEntry(SyndFeed syndFeed) {
		this.setTitle(syndFeed.getTitle());
		this.setDescription(syndFeed.getDescription());
		this.setUri(syndFeed.getUri());
		this.setLink(syndFeed.getLink());
		this.setDate(syndFeed.getPublishedDate());
		this.feedType = syndFeed.getFeedType();
		this.docs = syndFeed.getDocs();
		this.generator = syndFeed.getGenerator();
	}
}
