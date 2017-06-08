using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class trWebs_index : System.Web.UI.Page
{
    
    ToTableDataContext db = new ToTableDataContext();

    protected void Page_Load(object sender, EventArgs e)
    {
       lblTime.Text = DateTime.Now.ToLongTimeString();
       get_dataTable();
    }


    private void get_dataTable()
    {
        //连接数据库
        SqlConnection conn = new SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings["MovieConnectionString"].ConnectionString);
        conn.Open();
        //读取数据库存放到内存：dataSet
        DataSet ds = new DataSet();
        SqlDataAdapter sda = new SqlDataAdapter("select * from [MovieInfo]",conn);
        sda.Fill(ds,"t");
        //设置分页器
        PagedDataSource pds = new PagedDataSource();
        pds.DataSource = ds.Tables["t"].DefaultView;
        pds.AllowPaging = true;
        pds.PageSize = 3;

        //设置访问逻辑代码
        int curPage,count;
        if (Request.QueryString["Page"] != null)
            curPage = Convert.ToInt32(Request.QueryString["Page"]);
        else curPage = 1;

        pds.CurrentPageIndex = curPage - 1;
        count = pds.PageCount;
        lblCurrentPage.Text = "当前第：" + curPage.ToString()+"页";
        lblTotalPage.Text = "总共" + count.ToString() + "页";

        if (!pds.IsFirstPage)
        {
            this.first.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=1";
            this.last.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + count.ToString();
            this.up.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + (curPage - 1).ToString();
        }
        else
        {
            this.first.Visible = false;
        }
        if (!pds.IsLastPage)
        {
            this.next.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + (curPage + 1).ToString();
            this.last.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + count.ToString();
        }
        else
        {
            this.last.Visible = false;
        }
        
        //绑定数据源
        MyRep.DataSource = pds;
        MyRep.DataBind();
        conn.Close();
    }



    protected void Unnamed1_Tick(object sender, EventArgs e)
    {
        lblTime.Text = DateTime.Now.ToLongTimeString();
    }
}