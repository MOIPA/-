<%@ Page Language="C#" %>

<!DOCTYPE html>

<script runat="server">

    protected void Button1_Click(object sender, EventArgs e)
    {
        output.Text="tangziqing is very stupid";
    }

    protected void Page_Load(object sender, EventArgs e)
    {

    }
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        
        <asp:Button ID="stupid1" runat="server" OnClick="Button1_Click" Text="stupid" Font-Size="XX-Large" />
    
    </div>
        <asp:Label ID="output" runat="server" Text="here to control" Font-Size="XX-Large"></asp:Label>
    </form>
</body>
</html>
