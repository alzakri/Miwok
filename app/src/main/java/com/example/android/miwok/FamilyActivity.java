package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "otac", R.mipmap.family_father));
        words.add(new Word("mother", "majka", R.mipmap.family_mother));
        words.add(new Word("son", "sin", R.mipmap.family_son));
        words.add(new Word("daughter", "kćerka", R.mipmap.family_daughter));
        words.add(new Word("uncle", "daižda", R.mipmap.family_father));
        words.add(new Word("brother", "brat", R.mipmap.family_older_brother));
        words.add(new Word("sister", "sestra", R.mipmap.family_older_sister));
        words.add(new Word("He And She", "on i ona"));
        words.add(new Word("Me And you", "ja i ti"));
        words.add(new Word("We are family ", "Mi smo porodica", R.mipmap.family_family2));
        words.add(new Word("grandfather", "djed", R.mipmap.family_grandfather));
        words.add(new Word("Man", "muškarac", R.mipmap.family_father));
        words.add(new Word("Woman", "žena", R.mipmap.family_mother));
        words.add(new Word("child", "dijete", R.mipmap.family_child));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
