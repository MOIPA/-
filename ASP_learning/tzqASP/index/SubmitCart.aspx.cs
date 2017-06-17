using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class index_SubmitCart : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnContinue_Click(object sender, EventArgs e)
    {
        Response.Redirect("index.aspx");
    }
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        PetDataContext db = new PetDataContext();
        Order order = new Order();
        order.UserName = "张三";
        order.OrderDate = DateTime.Now;
        order.Addr1 = txtGoodsAddress.Text.Trim();
        order.Phone = txtPhone.Text.Trim();
        order.Status = "未审核";
        db.Order.InsertOnSubmit(order);
        db.SubmitChanges();
        int id = order.OrderId;
        for (int i = 0; i < Profile.Cart.name.Count; i++)
        {
            OrderItem orderItem = new OrderItem();
            orderItem.OrderId = id;
            orderItem.ProName = (String)Profile.Cart.name[i];
            orderItem.ListPrice = (int)Profile.Cart.price[i];
            orderItem.Qty = (int)Profile.Cart.qty[i];
            orderItem.TotalPrice = (int)Profile.Cart.qty[i] * (int)Profile.Cart.price[i];
            db.OrderItem.InsertOnSubmit(orderItem);
            db.SubmitChanges();
            
        }
        Profile.Cart.id.Clear();
        Profile.Cart.name.Clear();
        Profile.Cart.price.Clear();
        Profile.Cart.qty.Clear();
        Profile.Cart.totalPrice="";
        lblMsg.Text = "已经成功结算，谢谢光临";
    }
}