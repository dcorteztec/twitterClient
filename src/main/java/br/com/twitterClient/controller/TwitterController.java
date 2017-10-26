package br.com.twitterClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.twitterClient.repository.ITweetRepository;
import br.com.twitterClient.vo.Tweets;

@RestController
@RequestMapping(TwitterController.TWITTER_CAPTAR_URI)
public class TwitterController {

	public static final String TWITTER_CAPTAR_URI =  "api/tweet/captar";
	
	
	@Autowired
	private Twitter twitter;
	
	@Autowired 
    private ITweetRepository tweetRepository;

	@RequestMapping(value="{hashTag}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweet(@PathVariable("hashTag") final String hastag){
		 List<Tweet> ret = null;
		 ret = twitter.searchOperations().search(hastag,100).getTweets();
		 for (Tweet tweet : ret) {
			Tweets t = new Tweets();
			t.setIdTweet(tweet.getId());
			t.setIdUser(tweet.getToUserId());
			t.setText(tweet.getText());
			t.setUserName(tweet.getUser().getName());
			t.setLocation(tweet.getUser().getLocation());
			try {
				tweetRepository.save(t);
			}catch (Exception e) {
				System.out.println();
			}
		}
		 return ret;
	}

	
}
