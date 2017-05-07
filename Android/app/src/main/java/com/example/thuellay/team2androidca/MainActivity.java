package com.example.thuellay.team2androidca;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void,Void,List<String>>(){
            @Override
            protected List<String> doInBackground(Void... params){
                return Item.listCategory();
            }
            @Override
            protected void onPostExecute(List<String> result)
            {
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.category_row,R.id.tvCategory,result);
                setListAdapter(adapter);
            }
        }.execute();

    }
    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        String cus = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("Category", cus);
        startActivity(intent);
    }

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
}
