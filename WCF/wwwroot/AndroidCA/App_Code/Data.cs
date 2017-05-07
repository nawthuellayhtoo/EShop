using AndroidCA;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Data
/// </summary>
public class Data
{
    public static List<string> ListItems()
    {
        //using (ItemModel m = new ItemModel())
        //{
        //    return m.Items.Select<Item, string>(i => i.name).ToList<string>();
        //}

        AndroidCAEntities entites = new AndroidCAEntities();
        List<String> list = entites.items.Select(x => x.name).ToList();
        return list;
    }

    public static int Count()
    {
        //using (ItemModel m = new ItemModel())
        //{
        //    return m.Items.Select(i=>i.id).Count();
        //}
        AndroidCAEntities entites = new AndroidCAEntities();
        return entites.items.Count();
    }

    public static List<string> ListCategories()
    {
        using (ItemModel m = new ItemModel())
        {
            return m.Items.Select<Item, string>(c => c.category).Distinct<string>().ToList<string>();
        }
        //AndroidCAEntities entites = new AndroidCAEntities();
        //List<String> list = entites.items.Select(x => x.category).ToList();
    }

    public static Item GetItem(int id)
    {
        using (ItemModel m = new ItemModel())
        {
            return m.Items.Where
                    (i => i.id == id).ToList<Item>()[0];
        }


    }

    public static List<Item> GetListByCategory(string category)
    {
        using (ItemModel m = new ItemModel())
        {
            if (category == "All")
            {
                return m.Items.ToList<Item>();
            }
            else
            {
                return m.Items.Where(p => p.category == category).ToList<Item>();
            }
        }
    }

    public static String AddItem(item i)
    {
        //using (ItemModel m = new ItemModel())
        //{
        //    m.Items.Add(i);
        //    int status = m.SaveChanges();
        //    if (status > 0)
        //        return "Success";
        //    return "Fail";
        //}

        AndroidCAEntities entities = new AndroidCAEntities();
        entities.items.Add(i);
        int status = entities.SaveChanges();
        if (status > 0)
            return "Success";
        return "Fail";



    }
    public static string UpdateItem(item i)
    {
        //using (ItemModel m = new ItemModel())
        //{
        //    m.Entry(i).State = System.Data.Entity.EntityState.Modified;
        //    m.SaveChanges();
        //}
        //var result = db.Books.SingleOrDefault(b => b.BookNumber == bookNumber);
        //if (result != null)
        //{
        //    result.SomeValue = "Some new value";
        //    db.SaveChanges();
        //}
        AndroidCAEntities entities = new AndroidCAEntities();
        var v = entities.items.Where(x => x.id == i.id).FirstOrDefault();
        item a = (item)v;
        a.name = i.name;
        a.description = i.description;
        a.price = i.price;
        a.seller = i.seller;
        a.status = i.status;
        int status = entities.SaveChanges();
        if (status > 0)
            return "Success";
        return "Fail";
    }

    public static string DeleteItem(string id)
    {
        int itemId = Convert.ToInt32(id);
        //using (ItemModel m = new ItemModel())
        //{
        //    Item c = m.Items.Where(p => p.id == ID).ToList<Item>()[0];
        //    m.Items.Remove(c);
        //    m.SaveChanges();
        //}
        AndroidCAEntities entities = new AndroidCAEntities();
        var v = entities.items.Where(x => x.id == itemId).FirstOrDefault();
        item a = (item)v;
        entities.items.Remove(a);
        int status = entities.SaveChanges();
        if (status > 0)
            return "Success";
        return "Fail";
    }
}