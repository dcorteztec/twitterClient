package br.com.twitterClient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.twitterClient.vo.Tweets;

public interface ITweetRepository extends MongoRepository<Tweets, Long> {

	@Query("{ 'text' : ?0 }")
	List<Tweets> findByTweets(String text);

}

