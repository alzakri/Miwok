package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","jedan", R.mipmap.number_one, R.raw.one));
        words.add(new Word("two","dva", R.mipmap.number_two, R.raw.two));
        words.add(new Word("three","tri", R.mipmap.number_three, R.raw.three));
        words.add(new Word("four","četiri", R.mipmap.number_four, R.raw.four));
        words.add(new Word("five","pet", R.mipmap.number_five, R.raw.five));
        words.add(new Word("six","šest", R.mipmap.number_six, R.raw.six));
        words.add(new Word("seven","sedam", R.mipmap.number_seven, R.raw.seven));
        words.add(new Word("eight","osam", R.mipmap.number_eight, R.raw.eight));
        words.add(new Word("nine","devet", R.mipmap.number_nine, R.raw.nine));
        words.add(new Word("ten","Deset", R.mipmap.number_ten, R.raw.ten));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, words , R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "sound", Toast.LENGTH_SHORT).show();
               Word word = words.get(i);
                Log.v("NumbersActivity", "Current word: " + word);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }

    }

}
