using AndroidCA;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service" in code, svc and config file together.
public class Service : IService
{
    public WCFItem GetItem(String id)
    {
        int itemId=Convert.ToInt32(id);
        Item i = Data.GetItem(itemId);
        return new WCFItem(i.id, i.name, i.description, i.price, i.status, i.category, i.seller);
    }

    public string[] ListItems()
    {
        return Data.ListItems().ToArray<String>();
    }

    public string[] ListCategories()
    {
        return Data.ListCategories().ToArray<String>();
    }

    public string Update(string id, string name, string desc, string price, string seller, string status)
    {
        //Item item = new Item
        //{
        //id = i.Id,
        //name = i.Name,
        //description = i.Description,
        //price = i.Price,
        //category = i.Category,
        //status = i.Status,
        //seller = i.Seller
        //};

        //Data.UpdateItem(item);
        item item = new item();
        item.id = Convert.ToInt32(id);
        item.name = name;
        item.description = desc;
        item.price = Decimal.Parse(price);
        item.seller = seller;
        item.status = status;
        string s = Data.UpdateItem(item);

        return s;
    }

    public string Add(string name, string desc, string price, string category, string seller)
    {
        item item = new item();
        item.name = name;
        item.description = desc;
        item.price = Decimal.Parse(price);
        item.category = category;
        item.seller = seller;
        item.status = "Available";
        string s = Data.AddItem(item);

        return s;
    }

    public string Delete(string id)
    {
        //int myid = Convert.ToInt32(id);
        //Item item = Data.GetItem(myid);
        String s = Data.DeleteItem(id);

        return s;
    }

    public Item[] GetListByCategory(string category)
    {
        return Data.GetListByCategory(category).ToArray<Item>();

    }
}
