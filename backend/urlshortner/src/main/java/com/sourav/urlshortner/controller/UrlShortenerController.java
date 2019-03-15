package com.sourav.urlshortner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.urlshortner.entity.ResponseMessage;
import com.sourav.urlshortner.entity.ShortUrl;
import com.sourav.urlshortner.service.UrlShortenerService;

@RestController
@RequestMapping(path = "/api/urlshortener")
public class UrlShortenerController {
	
	private static final String baseUrl = "/urlshortener/url/";
	private UrlShortenerService urlShortenerService;
	
	@Autowired
	public UrlShortenerController(@NonNull UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseMessage<String>> urlShortener(@Valid @RequestBody ShortUrl shortUrl, @NonNull BindingResult bindingResult) {
		final ResponseMessage<String> responseMessage = new ResponseMessage<>();
		if(bindingResult.hasErrors()) {
			responseMessage.setStatus(400);
			responseMessage.setMessage("Validation Error");
			responseMessage.setResult(bindingResult.getFieldError("url").getDefaultMessage());
			return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
		}
		else {
			final String base62String = urlShortenerService.createShortUrls(shortUrl);
			if(base62String != null && !base62String.isEmpty()) {
				responseMessage.setStatus(200);
				responseMessage.setMessage("Success");
				responseMessage.setResult(baseUrl + base62String);
			}
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseMessage<String>> getOriginalUrl(@PathVariable("id") String id) {
		final ResponseMessage<String> responseMessage = new ResponseMessage<>();
		if(id == null || id.isEmpty()) {
			responseMessage.setStatus(400);
			responseMessage.setMessage("Invalid Id sent");
			responseMessage.setResult("Invalid Id sent");
			return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
		}
		else {
			final ShortUrl shortUrl = urlShortenerService.getOriginalUrl(id);
			if(shortUrl != null) {
				responseMessage.setStatus(200);
				responseMessage.setMessage("Success");
				responseMessage.setResult(shortUrl.getUrl());
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);
			}
			else {
				responseMessage.setStatus(400);
				responseMessage.setMessage("Id doesn't exist");
				responseMessage.setResult("Id doesn't exist");
				return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
			}
		}
	}
}
