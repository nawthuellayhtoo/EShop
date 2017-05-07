package com.example.thuellay.team2androidca;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ThueLlay on 12/21/2016.
 */

public class Item extends HashMap<String,String>
{
    final static String host="http://10.10.24.59/AndroidCA/Service.svc";

    public Item(){

    }
    public Item(String id,String name, String description, String price, String status, String category, String seller){
        put("Id",id);
        put("Name",name);
        put("Description",description);
        put("Price",price);
        put("Status",status);
        put("Category",category);
        put("Seller",seller);
    }
    //For All
    public static List<String> listItem(){
        List<String> list= new ArrayList<String>();
        try{
            JSONArray a=JSONParser.getJSONArrayFromUrl(host+"/");
            for(int i=0;i<a.length();i++)
            {
                String c=a.getString(i);
                list.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<Item> getCategoryItems(String categoryName){
        List<Item> list= new ArrayList<Item>();
        try{
            JSONArray a=JSONParser.getJSONArrayFromUrl(host+"/"+categoryName);
            for(int i=0;i<a.length();i++)
            {
                Item item = new Item();
                JSONObject jsonObject = a.getJSONObject(i);
                item.put("Id",Integer.toString(jsonObject.getInt("id")));
                item.put("Name",jsonObject.getString("name"));
                item.put("Description",jsonObject.getString("description"));
                item.put("Price",Double.toString(jsonObject.getDouble("price")));
                item.put("Status",jsonObject.getString("status"));
                item.put("Category",jsonObject.getString("category"));
                item.put("Seller",jsonObject.getString("seller"));
                list.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> listCategory(){
        List<String> list= new ArrayList<String>();
        try{
            JSONArray a=JSONParser.getJSONArrayFromUrl(host+"/Categories");
            for(int i=0;i<a.length();i++)
            {
                String c=a.getString(i);
                list.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static Item getItem(String id){

        Item item=new Item();
        try{
            JSONObject c=JSONParser.getJSONFromUrl(host+"/item/"+id);
            item.put("Id",Integer.toString(c.getInt("Id")));
            item.put("Name",c.getString("Name"));
            item.put("Description",c.getString("Description"));
            item.put("Price",Double.toString(c.getDouble("Price")));
            item.put("Status",c.getString("Status"));
            item.put("Category",c.getString("Category"));
            item.put("Seller",c.getString("Seller"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public static void updateItem(String id,String name,String desc,String price,String seller,String status) {
        /*JSONObject jItem = new JSONObject();
        try {
            jItem.put("Id",Integer.parseInt(item.get("Id")));
            jItem.put("Name", item.get("Name"));
            jItem.put("Description", item.get("Description"));
            jItem.put("Price", Double.parseDouble(item.get("Price")));
            jItem.put("Status",item.get("Status"));
            jItem.put("Seller",item.get("Seller"));

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(name," ");
        while(st.hasMoreTokens()) {

            sb.append(st.nextToken());
            sb.append("%20");
        }
        StringBuilder sb1 = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(desc," ");
        while(st1.hasMoreTokens()) {

            sb1.append(st1.nextToken());
            sb1.append("%20");
        }

        StringBuilder sb2 = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(seller," ");
        while(st2.hasMoreTokens()) {

            sb2.append(st2.nextToken());
            sb2.append("%20");
        }
        String result = JSONParser.getStream(host+"/update/"+id+"/"+sb+"/"+sb1+"/"+price+"/"+sb2+"/"+status);
    }

    public static void deleteItem(String id) {
        String result = JSONParser.getStream(host+"/delete/"+id);
    }

    public static void addItem(String name,String desc,String price,String category,String seller) {
       /* JSONObject jItem = new JSONObject();
        try {
            jItem.put("Name", item.get("Name"));
            jItem.put("Description", item.get("Description"));
            jItem.put("Price", Double.parseDouble(item.get("Price")));
            jItem.put("Status","Available");
            jItem.put("Category",item.get("Category"));
            jItem.put("Seller",item.get("Seller"));

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(name," ");
        while(st.hasMoreTokens()) {

            sb.append(st.nextToken());
            sb.append("%20");
        }

        StringBuilder sb1 = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(desc," ");
        while(st1.hasMoreTokens()) {

            sb1.append(st1.nextToken());
            sb1.append("%20");
        }

        StringBuilder sb2 = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(category," ");
        while(st2.hasMoreTokens()) {

            sb2.append(st2.nextToken());
            sb2.append("%20");
        }

        StringBuilder sb3 = new StringBuilder();
        StringTokenizer st3 = new StringTokenizer(seller," ");
        while(st3.hasMoreTokens()) {

            sb3.append(st3.nextToken());
            sb3.append("%20");
        }
        String result = JSONParser.getStream(host+"/add/"+sb+"/"+sb1+"/"+price+"/"+sb2+"/"+sb3);
    }
}
