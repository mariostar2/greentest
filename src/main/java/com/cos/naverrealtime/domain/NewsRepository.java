package com.cos.naverrealtime.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NewsRepository extends ReactiveMongoRepository<NaverNews, String> {

	@Tailable
	@Query("{}")
	Flux<NaverNews>mfindAll();

	}

