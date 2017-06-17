using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

public partial class index_shopcenter : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            if (Request.QueryString["id"] != null)
            {
                int id = int.Parse(Request.QueryString["id"]);
                AddPetInfo(id);
            }
            Bind();
        }
    }
    protected void AddPetInfo(int id)
    {
        int isExit = 0;
        for (int j = 0; j < Profile.Cart.name.Count; j++)
        {
            if (id == (int)Profile.Cart.id[j])
            {
                int s = (int)Profile.Cart.qty[j];
                s++;
                Profile.Cart.qty[j] = s;
                Profile.Save();
                isExit = 1;
            }
        }
        if (isExit == 0)
        {
            PetDataContext db = new PetDataContext();
            var pet = (from m in db.MyPetInfo
                         where m.ID == id
                         select m).First();
            Profile.Cart.id.Add(pet.ID);
            Profile.Cart.name.Add(pet.name);
            Profile.Cart.kind.Add(pet.kind);
            Profile.Cart.price.Add(pet.price);
            Profile.Cart.qty.Add(1);
            Profile.Save();
        }
    }
    protected void Bind()
    {
        Profile.Cart.totalPrice = TotalPrice().ToString();
        lblTotalPrice.Text = Profile.Cart.totalPrice;
        DataTable dt = new DataTable();
        dt.Columns.Add("id");
        dt.Columns.Add("name");
        dt.Columns.Add("kind");
        dt.Columns.Add("price");
        dt.Columns.Add("qty");
        for (int i = 0; i < Profile.Cart.name.Count; i++)
        {
            DataRow row = dt.NewRow();
            row[0] = Profile.Cart.id[i];
            row[1] = Profile.Cart.name[i];
            row[2] = Profile.Cart.kind[i];
            row[3] = Profile.Cart.price[i];
            row[4] = Profile.Cart.qty[0];
            dt.Rows.Add(row);
        }
        gvCart.DataSource = dt;
        gvCart.DataBind();
    }

    protected void btnDelete_Click(object sender, EventArgs e)
    {
        int petId = 0;
        for (int i = 0; i < gvCart.Rows.Count; i++)
        {
            CheckBox chkPet = new CheckBox();
            chkPet = (CheckBox)gvCart.Rows[i].FindControl("chkPet");
            if (chkPet != null)
            {
                if (chkPet.Checked)
                {
                    petId = int.Parse(gvCart.Rows[i].Cells[1].Text);
                    DeletePet(petId);
                }
            }
        }
        Bind();
    }

    protected void DeletePet(int id)
    {
        int j = 0;
        for (int i = 0; i < Profile.Cart.name.Count; i++)
        {
            if (id == (int)Profile.Cart.id[i])
            {
                j = i;
                break;
            }
        }
        Profile.Cart.id.RemoveAt(j);
        Profile.Cart.name.RemoveAt(j);
        Profile.Cart.kind.RemoveAt(j);
        Profile.Cart.price.RemoveAt(j);
        Profile.Cart.qty.RemoveAt(j);
        Profile.Save();
    }

    protected void btnClear_Click(object sender, EventArgs e)
    {
        Profile.Cart.id.Clear();
        Profile.Cart.name.Clear();
        Profile.Cart.kind.Clear();
        Profile.Cart.price.Clear();
        Profile.Cart.qty.Clear();
        Profile.Save();
        Response.Redirect("index.aspx");
    }

    protected decimal TotalPrice() {
        decimal sum = 0;
        for (int j = 0; j < Profile.Cart.name.Count; j++)
        {
            int qty=(int)Profile.Cart.qty[j];
            int listPrice = (int)Profile.Cart.price[j];
            sum += qty * listPrice;
        }
        return sum;
    }

    //登陆后跳转部分
    protected void lnkbtnManage_Click(object sender, EventArgs e)
    {
        Response.Redirect("Admin/UserManger.aspx");
    }
    protected void lnkbtnCart_Click(object sender, EventArgs e)
    {
        Response.Redirect("shopcenter.aspx");
    }
    protected void btnComputerAgain_Click(object sender, EventArgs e)
    {
        lblError.Text = "";
        PetDataContext db = new PetDataContext();
        for(int i=0;i<gvCart.Rows.Count;i++){
            TextBox txtqty = new TextBox();
            txtqty = (TextBox)gvCart.Rows[i].FindControl("txtQty");
            if (txtqty != null)
            {
                var product = (from p in db.MyPetInfo where p.ID == int.Parse(gvCart.Rows[i].Cells[1].Text) select p).First();
                if (int.Parse(txtqty.Text) > product.qty)
                {
                    lblError.Text += "error:库存不足，商品名为：" + gvCart.Rows[i].Cells[2].Text + "的库存量为：" + product.qty.ToString() + "<br />";
                }
                else
                {
                    ChangeQty(int.Parse(gvCart.Rows[i].Cells[1].Text),int.Parse(txtqty.Text));
                }
            }
        }
        Bind();
    }
    protected void ChangeQty(int id,int qty)
    {
        for (int i = 0; i < Profile.Cart.name.Count; i++)
        {
            Profile.Cart.qty[i] = qty;
            Profile.Save();
        }
    }

    protected void btnSettle_Click(object sender, EventArgs e)
    {
        Response.Redirect("SubmitCart.aspx");
    }
    protected void btnContinue_Click(object sender, EventArgs e)
    {
        Response.Redirect("index.aspx");
    }
    protected void gvCart_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
    protected void LoginStatus1_LoggingOut(object sender, LoginCancelEventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Redirect("Password.aspx");
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        Response.Redirect("Password.aspx");
    }
}