
using System;  
using System.Data;  
using System.Data.SqlClient;  
using System.Configuration;  
using System.Collections;  
using System.Web;  
using System.Web.Security;  
using System.Web.UI;  
using System.Web.UI.WebControls;  
using System.Web.UI.WebControls.WebParts;  
using System.Web.UI.HtmlControls;    

public partial class repeate : System.Web.UI.Page  
{  
    protected void Page_Load(object sender, EventArgs e)  
    {  
        if (!IsPostBack)  
        {  
            
            Repeater1.DataSource = pds();  
            Repeater1.DataBind();              
        }  
    }  
    private PagedDataSource pds()  
    {  
        string connstring = ConfigurationManager.ConnectionStrings["pconn"].ConnectionString;  
        SqlConnection con = new SqlConnection(connstring);  
         
        DataSet ds = new DataSet();  
        SqlDataAdapter sda = new SqlDataAdapter("select * from authors",con);  
        sda.Fill(ds,"name");  
        SqlDataAdapter sda2 = new SqlDataAdapter("select * from titleauthor",con);  
        sda2.Fill(ds,"title");  
        ds.Relations.Add("myrela",ds.Tables["name"].Columns["au_id"],ds.Tables["title"].Columns["au_id"]);  
  
        PagedDataSource pds = new PagedDataSource();  
        pds.DataSource = ds.Tables["name"].DefaultView;  
        pds.AllowPaging = true;//允许分页  
        pds.PageSize = 5;//单页显示项数  
        pds.CurrentPageIndex = Convert.ToInt32(Request.QueryString["page"]);  
        return pds;  
    }  
  
    protected void Repeater1_ItemDataBound(object sender, RepeaterItemEventArgs e)  
    {  
        if (e.Item.ItemType == ListItemType.Footer)  
        {  
            DropDownList ddlp = (DropDownList)e.Item.FindControl("ddlp");  
  
            HyperLink lpfirst = (HyperLink)e.Item.FindControl("hlfir");  
            HyperLink lpprev = (HyperLink)e.Item.FindControl("hlp");  
            HyperLink lpnext = (HyperLink)e.Item.FindControl("hln");  
            HyperLink lplast = (HyperLink)e.Item.FindControl("hlla");  
  
            pds().CurrentPageIndex = ddlp.SelectedIndex;  
  
            int n = Convert.ToInt32(pds().PageCount);//n为分页数  
            int i = Convert.ToInt32(pds().CurrentPageIndex);//i为当前页  
  
            Label lblpc = (Label)e.Item.FindControl("lblpc");  
            lblpc.Text = n.ToString();  
            Label lblp = (Label)e.Item.FindControl("lblp");  
            lblp.Text = Convert.ToString(pds().CurrentPageIndex + 1);  
  
            if (!IsPostBack)  
            {  
                for (int j = 0; j < n; j++)  
                {  
                    ddlp.Items.Add(Convert.ToString(j + 1));  
                }  
            }  
  
            if (i <= 0)  
            {  
                lpfirst.Enabled = false;  
                lpprev.Enabled = false;  
                lplast.Enabled = true;  
                lpnext.Enabled = true;  
            }  
            else  
            {  
                lpprev.NavigateUrl = "?page=" + (i - 1);  
            }  
            if (i >= n - 1)  
            {  
                lpfirst.Enabled = true;  
                lplast.Enabled = false;  
                lpnext.Enabled = false;  
                lpprev.Enabled = true;  
            }  
            else  
            {  
                lpnext.NavigateUrl = "?page=" + (i + 1);  
            }  
  
            lpfirst.NavigateUrl = "?page=0";//向本页传递参数page  
            lplast.NavigateUrl = "?page=" + (n - 1);  
  
            ddlp.SelectedIndex = Convert.ToInt32(pds().CurrentPageIndex);//更新下拉列表框中的当前选中页序号  
        }  
  
    }  
    protected void ddlp_SelectedIndexChanged(object sender, EventArgs e)  
    {//脚模板中的下拉列表框更改时激发  
        string pg=Convert.ToString((Convert.ToInt32(((DropDownList)sender).SelectedValue)-1));//获取列表框当前选中项  
        Response.Redirect("repeate.aspx?page="+pg);//页面转向  
    }  
}
