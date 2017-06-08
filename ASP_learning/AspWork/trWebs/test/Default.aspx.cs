using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data;//引用命名空间
using System.Data.SqlClient;//引用命名空间

public partial class trWebs_test_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //绑定Repeater控件数据源
        get_datatable();
        //UserInfoRep.DataBind();
    }
    public void get_datatable()
    {
        //数据库连接字符串
       //string strconn = System.Configuration.ConfigurationManager.AppSettings["MovieConnectionString"];
        //实例化连接对象，并赋值strconn
       SqlConnection conn = new SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings["MovieConnectionString"].ConnectionString);
        //打开连接对象
        conn.Open();
        //临时存储
       // DataTable Temp_dt = new DataTable();
        DataSet ds = new DataSet();
        //实例化数据库适配器
        SqlDataAdapter Dad = new SqlDataAdapter("select * from[Table]", conn);
        //填充
        Dad.Fill(ds,"t");

        PagedDataSource pds = new PagedDataSource();
        pds.DataSource = ds.Tables["t"].DefaultView;
        pds.AllowPaging = true;
        pds.PageSize = 1;
        pds.CurrentPageIndex = 1;

        //********
        int CurPage;
        if (Request.QueryString["Page"] != null)
            CurPage = Convert.ToInt32(Request.QueryString["Page"]);
        else
            CurPage = 1;
        pds.CurrentPageIndex = CurPage - 1;
        int Count = pds.PageCount;
        lblMssg.Text = "当前页：" + CurPage.ToString();
        lblPage.Text = Count.ToString();
        if (!pds.IsFirstPage)
        {
            this.first.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=1";
            this.last.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + Convert.ToString(Count - 1); ;
            up.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + Convert.ToString(CurPage - 1);
        }
        else
        {
            this.first.Visible = false;
            this.last.Visible = false;
        }
        if (!pds.IsLastPage)
        {
            next.NavigateUrl = Request.CurrentExecutionFilePath + "?Page=" + Convert.ToString(CurPage + 1);
        }
        else
        {
            this.first.Visible = false;
            this.last.Visible = false;
        }
        //********

        UserInfoRep.DataSource = pds;
        UserInfoRep.DataBind();

        //关闭连接对象
        //conn.Close();
        //释放连接对象资源
        //conn.Dispose();
        //返回DataTable
        //return pds;
    }
}