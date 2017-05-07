package com.example.thuellay.team2androidca;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends ListActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent addItemIntent = new Intent(this, AddItemActivity.class);
            startActivity(addItemIntent);

            return true;
        }
        if (id == R.id.action_home) {
            Intent addItemIntent = new Intent(this, MainActivity.class);
            startActivity(addItemIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_item);

        final String category = getIntent().getExtras().getString("Category");
        new AsyncTask<Item,Void,List<Item>>(){
            @Override
            protected List<Item> doInBackground(Item... params){
                  return Item.getCategoryItems(category);
            }
            @Override
            protected void onPostExecute(List<Item> result)
            {
                MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.item_row, result);
                setListAdapter(adapter);
               }
        }.execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        Item cus =  (Item)getListAdapter().getItem(position);
        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra("Id", cus.get("Id"));
        startActivityForResult(intent, 567);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 567) {
            recreate();
        }
    }
}
