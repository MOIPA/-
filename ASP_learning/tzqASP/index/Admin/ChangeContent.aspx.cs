using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Web.Security;

public partial class index_Admin_ChangeContent : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        lblTime.Text = DateTime.Now.ToLongTimeString();
    }
    protected void Unnamed1_Tick(object sender, EventArgs e)
    {
        lblTime.Text = DateTime.Now.ToLongTimeString();
    }
    protected void dvCategory_ItemDeleted(object sender, DetailsViewDeletedEventArgs e)
    {
        gvPet.DataBind();
    }
    protected void dvCategory_ItemInserted(object sender, DetailsViewInsertedEventArgs e)
    {
        gvPet.DataBind();
    }
}