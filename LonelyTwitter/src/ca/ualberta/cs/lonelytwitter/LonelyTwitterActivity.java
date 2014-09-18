package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.data.datamanager;
import ca.ualberta.cs.lonelytwitter.data.iDataManager;

public class LonelyTwitterActivity extends Activity {

	private datamanager dataManager;
	
	private iDataManager iDataManager;
	
	private EditText bodyText;
	
	private datamanager datamanager;
	
	private ArrayList<AbstractTweet> tweets;
	
	private ArrayAdapter<AbstractTweet> tweetsViewAdapter;
	
	private ListView oldTweetsList;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		// --------> Wha..?
		//If statements to act depending on if device is phone or watch.
		datamanager = new datamanager();
		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		tweets = datamanager.loadTweets();
		tweetsViewAdapter = new ArrayAdapter<AbstractTweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}
	
	public void save(View v) {
		
		String text = bodyText.getText().toString();

		if (text.contains("*")) {
			StarredTweet sTweet = new StarredTweet(new Date(), text);
			tweets.add(sTweet);
		}
		else{
			Tweet tweet = new Tweet(new Date(), text);
			tweets.add(tweet);	
		}
		tweetsViewAdapter.notifyDataSetChanged();
		bodyText.setText("");
		datamanager.saveTweets(tweets);
	}
	
	public void clear(View v) {
		
		tweets.clear();
		tweetsViewAdapter.notifyDataSetChanged();
		datamanager.saveTweets(tweets);
	}
}