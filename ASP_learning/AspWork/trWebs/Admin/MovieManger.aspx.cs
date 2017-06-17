using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class trWebs_Admin_MovieManger : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void dvCategory_ItemDeleted(object sender, DetailsViewDeletedEventArgs e)
    {
        gvCategory.DataBind();
    }
    protected void dvCategory_ItemInserted(object sender, DetailsViewInsertedEventArgs e)
    {
        gvCategory.DataBind();
    }
}