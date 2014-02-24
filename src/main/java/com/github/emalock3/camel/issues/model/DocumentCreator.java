package com.github.emalock3.camel.issues.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentCreator {
	
	public static final DocumentCreator INSTANCE = new DocumentCreator();
	
	public Document from(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
}