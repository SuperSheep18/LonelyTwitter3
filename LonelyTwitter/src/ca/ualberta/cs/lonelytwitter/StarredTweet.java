package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class StarredTweet extends AbstractTweet{
		
		public StarredTweet(Date tweetDate, String tweetBody) {
			super(tweetDate, tweetBody);
		}
		public String toString() {
			return "\u2605"+tweetBody;
		}
	}

