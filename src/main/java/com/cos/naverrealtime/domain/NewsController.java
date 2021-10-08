package com.cos.naverrealtime.domain;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NewsController {

	private final NewsRepository newsRepository;
	@CrossOrigin 

	//SSE
	@GetMapping(value = "/news",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNews>findAll(){
		return newsRepository.mfindAll()
				.subscribeOn(Schedulers.boundedElastic()); 
	}
	
	@PostMapping("/news")
	public Mono<NaverNews> save(@RequestBody NaverNews naverNews){
		return newsRepository.save(naverNews);
	}
}
