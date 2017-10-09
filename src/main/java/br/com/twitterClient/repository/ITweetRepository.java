package br.com.twitterClient.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.twitterClient.vo.Tweets;

public interface ITweetRepository extends CrudRepository<Tweets, Long> {

    @Query("SELECT t FROM Tweets t where t.text LIKE :busca%") 
	List<Tweets> findByTweets(@Param("busca")String busca);

}

