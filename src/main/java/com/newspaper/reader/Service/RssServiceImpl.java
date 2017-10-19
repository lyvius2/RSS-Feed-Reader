package com.newspaper.reader.Service;

import com.newspaper.reader.Model.Entry;
import com.newspaper.reader.Model.FeedEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RssServiceImpl implements RssService {
	@Override
	public FeedEntry readRss(String uri) throws MalformedURLException, IOException, FeedException {
		SyndFeed syndFeed = new SyndFeedInput().build(new XmlReader(new URL(uri)));
		FeedEntry feedEntry = new FeedEntry(syndFeed);
		List<Entry> entries = new ArrayList<>();
		syndFeed.getEntries().stream()
				.filter(e -> !StringUtils.isEmpty(e.getTitle()))
				.forEach(e -> {
					entries.add(new Entry(e));
				});
		feedEntry.setEntries(entries);
		if (StringUtils.isEmpty(feedEntry.getUri())) feedEntry.setUri(uri);
		return feedEntry;
	}
}
