using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using AndroidCA;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService" in both code and config file together.
[ServiceContract]
public interface IService
{
    [OperationContract]
    [WebGet(UriTemplate = "/item/{id}", ResponseFormat = WebMessageFormat.Json)]
    WCFItem GetItem(String id);

    [OperationContract]
    [WebGet(UriTemplate = "/list/items", ResponseFormat = WebMessageFormat.Json)]
    string[] ListItems();

    [OperationContract]
    [WebGet(UriTemplate = "/Categories", ResponseFormat = WebMessageFormat.Json)]
    string[] ListCategories();

    [OperationContract]
    [WebGet(UriTemplate = "/update/{id}/{name}/{dec}/{price}/{seller}/{status}", ResponseFormat = WebMessageFormat.Json)]
    String Update(string id, string name, string dec, string price, string seller, string status);

    [OperationContract]
    [WebGet(UriTemplate = "/add/{name}/{desc}/{price}/{category}/{seller}", ResponseFormat = WebMessageFormat.Json)]
    String Add(string name, string desc, string price, string category, string seller);

    [OperationContract]
    [WebGet(UriTemplate = "/delete/{id}", ResponseFormat = WebMessageFormat.Json)]
    String Delete(string id);

    [OperationContract]
    [WebGet(UriTemplate = "/{category}", ResponseFormat = WebMessageFormat.Json)]
    Item[] GetListByCategory(string category);
}
