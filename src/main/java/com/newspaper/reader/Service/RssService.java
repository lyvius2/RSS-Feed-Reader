package com.newspaper.reader.Service;

import com.newspaper.reader.Model.FeedEntry;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface RssService {
	FeedEntry readRss(String url) throws MalformedURLException, IOException, FeedException;
}
