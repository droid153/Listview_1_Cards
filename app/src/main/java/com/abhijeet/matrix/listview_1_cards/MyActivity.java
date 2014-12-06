package com.abhijeet.matrix.listview_1_cards;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;



public class MyActivity extends Activity {

    String[] mDataTitle = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] mDataDesc = {"Month 1", "Month 2", "Month 3", "Month 4", "Month 5", "Month 6", "Month 7", "Month 8", "Month 9", "Month 10", "Month 11", "Month 12"};
    int[] mIcon = {R.drawable.jan, R.drawable.feb, R.drawable.mar, R.drawable.apr, R.drawable.may, R.drawable.jun, R.drawable.jul, R.drawable.aug, R.drawable.sep, R.drawable.oct, R.drawable.nov, R.drawable.dec};
    ListView list;

    ArrayList<Card> cards = new ArrayList<Card>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        for(int i=0; i<mDataTitle.length; i++) {
            Card card = new Card(this,R.layout.row_card);
            CardHeader header = new CardHeader(this);
            CardThumbnail thumb = new CardThumbnail(this);

            header.setTitle(mDataTitle[i]);
            card.setTitle(mDataDesc[i]);
            thumb.setDrawableResource(R.drawable.ic_launcher);

            card.addCardHeader(header);
            card.addCardThumbnail(thumb);
            cards.add(card);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,cards);
        CardListView cardListView = (CardListView) this.findViewById(R.id.myList);
        if (cardListView != null) {
            cardListView.setAdapter(mCardArrayAdapter);
        }




//        list = (ListView) findViewById(R.id.myList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDataTitle);
//        list.setAdapter(adapter);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
