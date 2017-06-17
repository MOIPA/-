using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Web.Security;

public partial class index_Admin_UserManger : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        lblTime.Text = DateTime.Now.ToLongTimeString();
        if (!IsPostBack)
        {
            GetAllUsers();
            string[] roles = Roles.GetAllRoles();
            lstRoles.DataSource = roles;
            lstRoles.DataBind();
            MembershipUserCollection users = Membership.GetAllUsers();
            lstUsers.DataSource = users;
            lstUsers.DataBind();
        }
        if (lstRoles.SelectedItem != null)
        {
            GetUsersInRole();
        }
       
    }
    protected void Unnamed1_Tick(object sender, EventArgs e)
    {
        lblTime.Text = DateTime.Now.ToLongTimeString();
    }

    private void GetUsersInRole()
    {
        string[] usersInRole = Roles.GetUsersInRole(lstRoles.SelectedValue);
        gvUsers.DataSource = usersInRole;
        gvUsers.DataBind();
    }

    protected void btnToRole_Click(object sender, EventArgs e)
    {
        if (lstRoles.SelectedItem == null)
        {
            lblMsg.Text = "请选择角色";
            return;
        }
        if (lstUsers.SelectedItem == null)
        {
            lblMsg.Text = "请选择用户";
            return;
        }

        string[] newUsers = new string[lstUsers.GetSelectedIndices().Length];
        for (int i = 0; i < newUsers.Length; i++)
        {
            newUsers[i] = lstUsers.Items[lstUsers.GetSelectedIndices()[i]].Value;
        }
        try
        {
            Roles.AddUsersToRole(newUsers, lstRoles.SelectedValue);
            GetUsersInRole();
        }
        catch (Exception ee)
        {
            lblMsg.Text = ee.Message;
        }
    }

    protected void gvUsers_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        GridViewRow gridViewRole = gvUsers.Rows[e.RowIndex];
        Label lblName = (Label)gridViewRole.Cells[0].FindControl("lblName");
        string username = lblName.Text;
        try
        {
            Roles.RemoveUserFromRole(username, lstRoles.SelectedValue);
        }
        catch (Exception ee)
        {
            lblMsg.Text = "从角色中删除用户时的错误：" + ee.GetType().ToString();
        }
        GetUsersInRole();
    }

    protected void gvUsers_SelectedIndexChanged(object sender, EventArgs e)
    {

    }


    private void GetAllUsers()
    {
        MembershipUserCollection users = Membership.GetAllUsers();
        gvUser.DataSource = users;
        gvUser.DataBind();
    }
    protected void gvUser_SelectedIndexChanged(object sender, EventArgs e)
    {
    }
    protected void gvUser_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        GridViewRow gvRow = gvUser.Rows[e.RowIndex];
        string username = gvRow.Cells[0].Text;
        Membership.DeleteUser(username);
        GetAllUsers();
    }

}