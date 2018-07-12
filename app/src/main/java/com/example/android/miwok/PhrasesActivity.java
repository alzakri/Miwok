package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Hello", "Zdravo!"));
        words.add(new Word("Hello", "Dobar dan!"));
        words.add(new Word("How are you", "Kako ste?"));
        words.add(new Word("Do you have kids?", "Imate li djece?"));
        words.add(new Word("Make yourself comfortable!", "Raskomotite se!"));
        words.add(new Word("Where are you from?", "Odakle ste?"));
        words.add(new Word("People are friendly here", "Vrlo dobro. Ljudi su dragi."));
        words.add(new Word("Vere good view", "I krajolik mi se također dopada"));
        words.add(new Word("What is your name?", "kako se zoves"));
        words.add(new Word("My name is...", "Moje ime je..."));
        words.add(new Word("I’m feeling good.", "dobro sam"));
        words.add(new Word("Are you coming?", "dolazis li?"));
        words.add(new Word("I’m coming.", "dolazim"));
        words.add(new Word("Let’s go.", "idemo"));
        words.add(new Word("Come here.", "dodi ovamo"));
        words.add(new Word("good bay.", "Ćao!"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
