using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

public partial class trWebs_View_UserCenter : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack){
            if(Request.QueryString["movieId"]!=null){
                int id = int.Parse(Request.QueryString["movieId"]);
                AddMovieInfo(id);
            }
            Bind();
        }
    }

    protected void AddMovieInfo(int id)
    {
        int isExit = 0;
        for (int j = 0; j < Profile.Cart.movieName.Count; j++)
        {
            if(id==(int)Profile.Cart.movieId[j]){
                isExit = 1;
                lblError.Text = "您已收藏本电影";
            }
        }
        if(isExit==0){
            MovieDataContext db = new MovieDataContext();
            var movie = (from m in db.MovieInfo
                         where m.id == id
                         select m).First();
            Profile.Cart.movieId.Add(movie.id);
            Profile.Cart.movieName.Add(movie.name);
            Profile.Save();
        }
    }
    protected void Bind() {
        DataTable dt = new DataTable();
        dt.Columns.Add("movieId");
        dt.Columns.Add("movieName");

        for (int i = 0; i < Profile.Cart.movieName.Count; i++)
        {
            DataRow row = dt.NewRow();
            row[0] = Profile.Cart.movieId[i];
            row[1] = Profile.Cart.movieName[i];
            dt.Rows.Add(row);
        }
        gvCart.DataSource = dt;
        gvCart.DataBind();
    }

    protected void btnDelete_Click(object sender, EventArgs e)
    {
        int movieId = 0;
        for (int i = 0; i < gvCart.Rows.Count; i++)
        {
            CheckBox chkMovie = new CheckBox();
            chkMovie = (CheckBox)gvCart.Rows[i].FindControl("chkMovie");
            if(chkMovie!=null){
                if (chkMovie.Checked)
                {
                    movieId = int.Parse(gvCart.Rows[i].Cells[1].Text);
                    DeleteMovie(movieId);
                }
            }
        }
        Bind();
    }

    protected void DeleteMovie(int id)
    {
        int j = 0;
        for (int i = 0; i < Profile.Cart.movieName.Count; i++)
        {
            if(id==(int)Profile.Cart.movieId[i]){
                j = i;
                break;
            }
        }
        Profile.Cart.movieId.RemoveAt(j);
        Profile.Cart.movieName.RemoveAt(j);
       
        Profile.Save();
    }

    protected void btnClear_Click(object sender, EventArgs e)
    {
        Profile.Cart.movieId.Clear();
        Profile.Cart.movieName.Clear();
        Profile.Save();
        Response.Redirect("index.aspx");
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Redirect("UserCenter.aspx");
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        Response.Redirect("ChangePwd.aspx");
    }
    protected void Button3_Click(object sender, EventArgs e)
    {
        Response.Redirect("FindPwd.aspx");
    }
}