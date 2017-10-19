package com.newspaper.reader.Controller;

import com.google.gson.Gson;
import com.newspaper.reader.Model.FeedEntry;
import com.newspaper.reader.Service.RssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@Slf4j
public class RssController {

	@Autowired
	private Gson gson;

	@Autowired
	private RssService rssService;

	/**
	 * メインビュー
	 * @return
	 */
	@RequestMapping(value = "/")
	public String main() {
		return "main";
	}

	/**
	 * RSSフィードをJSONタイプでリターン
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity readFeed(@RequestParam("uri") String uri) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		try {
			FeedEntry feedEntry = rssService.readRss(uri);
			result.put("success", true);
			result.put("feed", feedEntry);
		} catch (Exception e) {
			result.put("success", false);
			result.put("error", e.toString());
		}
		return new ResponseEntity(gson.toJson(result), HttpStatus.OK);
	}
}
