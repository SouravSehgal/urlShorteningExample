package com.sourav.urlshortner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.sourav.urlshortner.dao.UrlShortenerRepository;
import com.sourav.urlshortner.entity.ShortUrl;
import com.sourav.urlshortner.model.ShortUrlMapping;
import com.sourav.urlshortner.util.Base62Conversion;

@Service
public class UrlShortenerService {

	private UrlShortenerRepository urlShortenerRepository;
	
	public UrlShortenerService(@NonNull UrlShortenerRepository urlShortenerRepository) {
		this.urlShortenerRepository = urlShortenerRepository;
	}
	
	public String createShortUrls(ShortUrl shortUrl) {
		final ShortUrlMapping shortUrlMapping = new ShortUrlMapping();
		shortUrlMapping.setUrl(shortUrl.getUrl());
		shortUrlMapping.setId(0);
		urlShortenerRepository.save(shortUrlMapping);
		StringBuilder convertedString = new StringBuilder();
		final long id = shortUrlMapping.getId();
		if(id > 0) {
			final List<Integer> base62string = Base62Conversion.getBase62Conversion(id);
			for(int i=0; i<base62string.size(); i++) {
				Base62Conversion.getBase62Number(convertedString, base62string.get(i));
			}
		}
		return convertedString.reverse().toString();
	}
	
	public ShortUrl getOriginalUrl(String base62Id) {
		ShortUrl shortUrl = null;
		long id = 0; int position = 0;
		for(int i= base62Id.length() - 1  ; i >= 0; i--) {
			id = Base62Conversion.getDecimalNumber(id, base62Id.charAt(i), position);
		}
		final Optional<ShortUrlMapping> shortUrlMapping = urlShortenerRepository.findById(id);
		if(shortUrlMapping.isPresent()) {
			shortUrl = new ShortUrl();
			shortUrl.setUrl(shortUrlMapping.get().getUrl());
		}
		return shortUrl;
	}
}
