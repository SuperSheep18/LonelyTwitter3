package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class AbstractTweet {
	
		public Date tweetDate;
		public String tweetBody;

		public AbstractTweet(Date tweetDate, String tweetBody) {
			this.tweetDate = tweetDate;
			this.tweetBody = tweetBody;
		}

		public Date getTweetDate() {
			return tweetDate;
		}

		public void setTweetDate(Date tweetDate) {
			this.tweetDate = tweetDate;
		}

		public String getTweetBody() {
			return tweetBody;
		}

		public void setTweetBody(String tweetBody) {
			this.tweetBody = tweetBody;
		}

		//public String toString() {
		//	return "\u2605"+tweetBody;
		//}
	}

