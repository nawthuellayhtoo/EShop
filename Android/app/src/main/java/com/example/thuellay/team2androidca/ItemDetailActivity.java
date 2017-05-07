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
import android.widget.RadioButton;

public class ItemDetailActivity extends Activity {
    final static int []view = {R.id.edtDetailItemName, R.id.edtDetailItemDesc, R.id.edtDetailItemPrice, R.id.edtDetailItemSeller};
    final static String []key = {"Name", "Description", "Price", "Seller"};
    String itemId= null;
    String category=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
       final String item = getIntent().getExtras().getString("Id");

        new AsyncTask<String, Void, Item>() {
            @Override
            protected Item doInBackground(String... params) {
                return Item.getItem(params[0]);
            }

            @Override
            protected void onPostExecute(Item result) {
                itemId=result.get("Id");
                category=result.get("Category");
                for (int i=0; i<view.length; i++) {
                    EditText t = (EditText) findViewById(view[i]);
                    t.setText(result.get(key[i]));
                }
                if(result.get("Status").equalsIgnoreCase("Sold")){
                    RadioButton rb=(RadioButton) findViewById(R.id.radio_sold);
                    rb.setChecked(true);
                }
                else if(result.get("Status").equalsIgnoreCase("Available")){
                    RadioButton rb=(RadioButton) findViewById(R.id.radio_available);
                    rb.setChecked(true);
                }
                else{
                    RadioButton rb1=(RadioButton) findViewById(R.id.radio_sold);
                    RadioButton rb2=(RadioButton) findViewById(R.id.radio_available);
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                }
            }
        }.execute(item);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateItem);
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Item c = new Item();

//                for (int i=0; i<view.length; i++) {
//                    EditText t = (EditText) findViewById(view[i]);
//                    c.put(key[i], t.getText().toString());
//                }
//   c.put("Id",itemId);
                String id=itemId;
                EditText edtName=(EditText)findViewById(R.id.edtDetailItemName);
                String name=edtName.getText().toString();

                if (edtName.getText().toString().length() == 0) {
                    edtName.setError("Please enter item name!");
                    return;
                }

                EditText edtDec=(EditText)findViewById(R.id.edtDetailItemDesc);
                String dec=edtDec.getText().toString();

                if (edtDec.getText().toString().length() == 0) {
                    dec = "No description";
                }

                EditText edtPrice=(EditText)findViewById(R.id.edtDetailItemPrice);
                String price=edtPrice.getText().toString();

                if (edtPrice.getText().toString().length() == 0) {
                    price = "0";
                }

                EditText edtSeller=(EditText)findViewById(R.id.edtDetailItemSeller);
                String seller=edtSeller.getText().toString();

                if (edtSeller.getText().toString().length() == 0) {
                    edtSeller.setError("Please enter your name!");
                    return;
                }

                String status=null;
                RadioButton btnSold=(RadioButton) findViewById(R.id.radio_sold);
                RadioButton btnAvailable=(RadioButton) findViewById(R.id.radio_available);
                if(btnSold.isChecked()){
                     status="Sold";
                }
                else if(btnAvailable.isChecked()){
                     status="Available";
                }

                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        Item.updateItem(params[0],params[1],params[2],params[3],params[4],params[5]);
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void result) {
                        finish();
                        /*
                        Intent intent = new Intent(ItemDetailActivity.this, ItemActivity.class);
                        intent.putExtra("Category", category);
                        startActivity(intent);
                        */
                    }
                }.execute(id,name,dec,price,seller,status);
            }
        });

        Button btnDelete=(Button)findViewById(R.id.btnDeleteItem);
        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Item c = new Item();
                    new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        Item.deleteItem(params[0]);
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void result) {
                         finish();
                       /* Intent intent = new Intent(ItemDetailActivity.this, ItemActivity.class);
                        intent.putExtra("Category", category);
                        startActivity(intent);*/
                    }
                }.execute(itemId);
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


