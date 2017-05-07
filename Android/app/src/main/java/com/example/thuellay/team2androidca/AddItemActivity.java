package com.example.thuellay.team2androidca;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends Activity {
    //    final static int []view = {R.id.edtAddItemName, R.id.edtAddItemDesc, R.id.edtAddItemPrice,R.id.edtAddItemCategory, R.id.edtAddItemSeller};
//    final static String []key = {"Name", "Description", "Price", "Category","Seller"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button btnAdd = (Button) findViewById(R.id.btnAddItem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /* Item item=new Item();
                for(int i=0;i<view.length;i++){
                    EditText t=(EditText)findViewById(view[i]);
                    item.put(key[i],t.getText().toString());
                }*/

                EditText edtName = (EditText) findViewById(R.id.edtAddItemName);
                String name = edtName.getText().toString();

                if (edtName.getText().toString().length() == 0) {
                    edtName.setError("Please enter item name!");
                    return;
                }

                EditText edtDec = (EditText) findViewById(R.id.edtAddItemDesc);
                String dec = edtDec.getText().toString();

                if (edtDec.getText().toString().length() == 0) {
                    dec = "No description";
                }

                EditText edtPrice = (EditText) findViewById(R.id.edtAddItemPrice);
                String price = edtPrice.getText().toString();

                if (edtPrice.getText().toString().length() == 0) {
                    price = "0";
                }

                EditText edtSeller = (EditText) findViewById(R.id.edtAddItemSeller);
                String seller = edtSeller.getText().toString();

                if (edtSeller.getText().toString().length() == 0) {
                    edtSeller.setError("Please enter your name!");
                    return;
                }

                EditText edtCate = (EditText) findViewById(R.id.edtAddItemCategory);
                String category = edtCate.getText().toString();

                if (edtCate.getText().toString().length() == 0) {
                    edtCate.setError("Please enter item category!");
                    return;
                }

                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        Item.addItem(params[0], params[1], params[2], params[3], params[4]);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        finish();
                        Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }.execute(name, dec, price, category, seller);
            }
        });
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