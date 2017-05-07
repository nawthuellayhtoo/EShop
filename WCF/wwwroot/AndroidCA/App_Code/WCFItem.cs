using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

/// <summary>
/// Summary description for WCFItem
/// </summary>

[DataContract]
public class WCFItem
{
    [DataMember]
    public int Id { get; set; }
    [DataMember]
    public string Name { get; set; }

    [DataMember]
    public string Description { get; set; }
    [DataMember]
    public decimal Price { get; set; }
    [DataMember]
    public string Status { get; set; }
    [DataMember]
    public string Category { get; set; }
    [DataMember]
    public string Seller { get; set; }

    public WCFItem(int id, string name, string description, decimal price, string status, string category, string seller)
    {
        this.Id = id;
        this.Name = name;
        this.Description = description;
        this.Price = price;
        this.Status = status;
        this.Category = category;
        this.Seller = seller;

    }
    //public static WCFItem Make(int id, string name, string description, decimal price, string status, string category, string seller)
    //{
    //    WCFItem i = new WCFItem();
    //    i.id = id;
    //    i.name = name;
    //    i.description = description;
    //    i.price = price;
    //    i.status = status;
    //    i.category = category;
    //    i.seller = seller;
    //    return i;
    //}

    //[DataMember]
    //public int Id
    //{
    //    get { return id; }
    //    set { id = value; }
    //}

    //[DataMember]
    //public string Name
    //{
    //    get { return name; }
    //    set { name = value; }
    //}

    //[DataMember]
    //public string Description
    //{
    //    get { return description; }
    //    set { description = value; }
    //}

    //[DataMember]
    //public decimal Price
    //{
    //    get { return price; }
    //    set { price = value; }
    //}

    //[DataMember]
    //public string Status
    //{
    //    get { return status; }
    //    set { status = value; }
    //}

    //[DataMember]
    //public string Category
    //{
    //    get { return category; }
    //    set { category = value; }
    //}

    //[DataMember]
    //public string Seller
    //{
    //    get { return seller; }
    //    set { seller = value; }
    //}
}