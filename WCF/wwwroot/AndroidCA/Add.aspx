<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Add.aspx.cs" Inherits="Add" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Add</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Label ID="LabelName" runat="server" Text="Name"></asp:Label>
        <asp:TextBox ID="TextBoxName" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="LabelDescription" runat="server" Text="Description"></asp:Label>
        <asp:TextBox ID="TextBoxDescription" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="LabelPrice" runat="server" Text="Price"></asp:Label>
        <asp:TextBox ID="TextBoxPrice" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="LabelCategory" runat="server" Text="Category"></asp:Label>
        <asp:TextBox ID="TextBoxCategory" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="LabelStatus" runat="server" Text="Status"></asp:Label>
        <asp:TextBox ID="TextBoxStatus" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="LabelSeller" runat="server" Text="Seller"></asp:Label>
        <asp:TextBox ID="TextBoxSeller" runat="server"></asp:TextBox>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
    
    </div>
    </form>
</body>
</html>
