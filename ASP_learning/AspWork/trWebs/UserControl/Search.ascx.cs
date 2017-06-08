using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class trWebs_UserControl_Search : System.Web.UI.UserControl
{
    private string _text;
    public String Text{
        get { return _text; }
        set { _text = value; }
    }

    protected void Page_Load(object sender, EventArgs e)
    {
        if (this.Text != "") {
            btnSearch.Text = this.Text;
        }
    }
    protected void btnSearch_Click(object sender, EventArgs e)
    {
        Response.Redirect("DetailInfo.aspx?name='"+txtSearch.Text+"'");
    }
}