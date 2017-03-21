using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class sy2_4_Choice : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Label lblQuestion = new Label();
        lblQuestion.ID = "lblQuestion";
        lblQuestion.Text = "1.&nbsp;web服务器空间不包括(&nbsp;&nbsp;&nbsp;&nbsp;)。";
        plhChoice.Controls.Add(lblQuestion);
        RadioButtonList rdoltChoice = new RadioButtonList();
        rdoltChoice.ID="rdoltChoice";
        rdoltChoice.Items.Add(new ListItem("A.Wizard","A"));
        rdoltChoice.Items.Add(new ListItem("B.input", "B"));
        rdoltChoice.Items.Add(new ListItem("C.AdRotator", "C"));
        rdoltChoice.Items.Add(new ListItem("D.Calendar", "D"));
        plhChoice.Controls.Add(rdoltChoice);

    }
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        RadioButtonList rdoltChoice = (RadioButtonList)plhChoice.FindControl("rdoltChoice");
        lblDisplay.Text="您选择的是"+rdoltChoice.SelectedValue;
    }
}