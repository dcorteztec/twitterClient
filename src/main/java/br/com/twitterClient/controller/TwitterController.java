package br.com.twitterClient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Trends;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.twitterClient.helpVO.TwitterTrend;
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

	@RequestMapping(value="{hashTag}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Tweets> getTweet(@PathVariable("hashTag") final String hastag){
		 List<Tweet> ret = null;
		 List<Tweets> tweetRet = new ArrayList<Tweets>();
		 ret = twitter.searchOperations().search("#"+hastag,100).getTweets();
		 for (Tweet tweet : ret) {
			Tweets t = new Tweets();
			t.setIdTweet(tweet.getId());
			t.setIdUser(tweet.getToUserId());
			t.setText(tweet.getText());
			t.setUserName(tweet.getUser().getName());
			t.setLocation(tweet.getUser().getLocation());
			if(tweet.getEntities().getUrls()!=null&&tweet.getEntities().getUrls().size()>0) {
				t.setUrl(tweet.getEntities().getUrls().get(0).getUrl());
				
			}
			tweetRet.add(t);	
			tweetRepository.save(t);
		}
		 return tweetRet;
	}

	@RequestMapping(value = "listTrending", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TwitterTrend> getTrending() throws Exception {
	    Trends ret = null;
		ret = twitter.searchOperations().getLocalTrends(Long.parseLong("1"));
		return process(ret);
	}
	
	private List<TwitterTrend> process(Trends trends) throws Exception {
	    List<TwitterTrend> twitterTrends = null;
	    TwitterTrend twitterTrend = null;
	    if (trends != null && trends.getTrends() != null && trends.getTrends().size() > 0) {
	       twitterTrends = new ArrayList<TwitterTrend>();
	         for (int index = 0; index < trends.getTrends().size(); index++) {
	             twitterTrend = new TwitterTrend();
	             twitterTrend.setName(trends.getTrends().get(index).getName());
	             twitterTrend.setQuery(trends.getTrends().get(index).getQuery());
	             twitterTrend.setTime(trends.getTime());
	             twitterTrends.add(twitterTrend);
	      }
	    }
	    return twitterTrends;
	  }
	}

