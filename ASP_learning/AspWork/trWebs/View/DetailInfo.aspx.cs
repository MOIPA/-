using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class trWebs_View_DetailInfo : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

            string id = Request.QueryString["id"];
            string name = Request.QueryString["name"];
            if (name != null && name != "")
                get_dataByName(name);
            else get_data(id);

    }

    private void get_data(string id)
    {
        SqlConnection conn = new SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings["MovieConnectionString"].ConnectionString);
        conn.Open();
        DataSet ds = new DataSet();
        SqlDataAdapter sda = new SqlDataAdapter("select * from [MovieInfo] where id="+id, conn);
        
        sda.Fill(ds,"t");
        myrep.DataSource = ds.Tables["t"].DefaultView;
        myrep.DataBind();
        conn.Close();
    }
    private void get_dataByName(string name)
    {
        SqlConnection conn = new SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings["MovieConnectionString"].ConnectionString);
        conn.Open();
        DataSet ds = new DataSet();
        SqlDataAdapter sda = new SqlDataAdapter("select * from [MovieInfo] where name=" + name, conn);

        sda.Fill(ds, "t");
        myrep.DataSource = ds.Tables["t"].DefaultView;
        myrep.DataBind();
        conn.Close();
    }
}