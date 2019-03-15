package com.sourav.urlshortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourav.urlshortner.model.ShortUrlMapping;

@Repository
public interface UrlShortenerRepository extends JpaRepository<ShortUrlMapping, Long>{

}
