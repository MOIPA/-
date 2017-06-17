<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/Admin/MangerPage.master" AutoEventWireup="true" CodeFile="DetailsManger.aspx.cs" Inherits="trWebs_Admin_DetailsManger" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
    <div style="height:900px;width:100%;background-color:rgba(0,0,0,0.4);margin-top:20px;">
        <div style="margin-top:140px;width:100%;height:500px;margin:auto">
            <center><table style="margin-top:35px;">
                <tr>
                    <td>
                        <asp:GridView ID="gvCategory" runat="server" DataKeyNames="id" AutoGenerateColumns="False" DataSourceID="ldsCategory" AllowPaging="True" Height="800px" PageSize="3" Width="516px" Font-Size="Large" CellPadding="3" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px">
                            <Columns>
                                <asp:BoundField  DataField="id" HeaderText="MovieId" InsertVisible="false" ReadOnly="true" />
                                <asp:BoundField DataField="name" HeaderText="Name" />
                                <asp:BoundField DataField="style" HeaderText="Style" />
                                <asp:BoundField DataField="grade" HeaderText="Grade" />
                                <asp:CommandField SelectText="详细资料" ShowSelectButton="true" />
                            </Columns>
                            <FooterStyle BackColor="White" ForeColor="#000066" />
                            <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                            <RowStyle ForeColor="#000066" />
                            <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                            <SortedAscendingCellStyle BackColor="#F1F1F1" />
                            <SortedAscendingHeaderStyle BackColor="#007DBB" />
                            <SortedDescendingCellStyle BackColor="#CAC9C9" />
                            <SortedDescendingHeaderStyle BackColor="#00547E" />
                        </asp:GridView>
                    </td>
                    <td>
                        <div style="width:40px;"></div>
                    </td>
                    <td><div>
                        <asp:DetailsView ID="dvCategory" runat="server" AutoGenerateRows="False" DataKeyNames="id" DataSourceID="ldsDetails" HeaderText="详细资料" Width="447px" Height="800px" OnItemDeleted="dvCategory_ItemDeleted" OnItemInserted="dvCategory_ItemInserted" Font-Size="Large" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3">
                            <EditRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                            <Fields>
                                <asp:BoundField  DataField="id" HeaderText="id" InsertVisible="false" ReadOnly="True" SortExpression="id" />
                                <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />
                                <asp:BoundField DataField="style" HeaderText="style" SortExpression="style" />
                                <asp:BoundField DataField="grade" HeaderText="grade" SortExpression="grade" />
                                <asp:BoundField DataField="area" HeaderText="area" SortExpression="area" />
                                <asp:BoundField DataField="releasetime" HeaderText="releasetime" SortExpression="releasetime" />
                                <asp:BoundField DataField="desc" HeaderText="desc" SortExpression="desc" />
                                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowInsertButton="True" />
                            </Fields>
                            <FooterStyle BackColor="White" ForeColor="#000066" />
                            <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                            <RowStyle ForeColor="#000066" />
                        </asp:DetailsView></div>
                    </td>
                </tr>
            </table></center>
            
            <asp:LinqDataSource ID="ldsCategory" runat="server" ContextTypeName="MovieDataContext" TableName="MovieInfo"></asp:LinqDataSource>
            <asp:LinqDataSource ID="ldsDetails" runat="server" ContextTypeName="MovieDataContext" EnableDelete="True" EnableInsert="True" EnableUpdate="True" TableName="MovieInfo" Where="id == @id" EntityTypeName="">
                <WhereParameters>
                <asp:ControlParameter ControlId="gvCategory" DefaultValue="1" Name="id" PropertyName="SelectedValue" Type="Int32" />
                </WhereParameters>
            </asp:LinqDataSource>
            
        </div>
        
    </div>
</asp:Content>

