using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class index_Pet : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string id = Request.QueryString["id"];
        get_dataTable(id);
    }
    private void get_dataTable(string id)
    {
        //连接数据库
        SqlConnection conn = new SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings["MyPetConnectionString"].ConnectionString);
        conn.Open();
        //读取数据库存放到内存：dataSet
        DataSet ds = new DataSet();
        SqlDataAdapter sda = new SqlDataAdapter("select * from [MyPetInfo] where ID="+id, conn);
        sda.Fill(ds, "t");
        MyRep.DataSource = ds.Tables["t"].DefaultView;
        MyRep.DataBind();
        conn.Close();
    }
}