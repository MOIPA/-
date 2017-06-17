<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="Baike.aspx.cs" Inherits="index_Baike" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <style>
        .tb tr td{
            height:25%;width:50%;
            text-align:left;
            font-size:14px;
            padding-top:0px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div style="height:900px;width:100%;">
        <table style="height:100%;width:100%;" class="tb">
            <tr>
                <td>
                    <img src="baikePICS/baike1.jpg"/>
                </td>
                <td style="padding-left:40px;padding-right:40px;font-size:14px;">
                    <center><h3><p class="label label-info">猫咪注意事项</p></h3></center>
                    <br />
                    <p>
                        食物：藏好巧克力，锁好药箱。﻿﻿﻿因为﻿500毫克感冒药就可以杀死一只3公斤左右的猫咪。
                    </p>
                    <p>
                        药物：不乱用除虱药物，要提前咨询兽医。
                    </p>
                    <p>
                        环境：清理好生活污水﻿﻿﻿﻿，﻿﻿﻿应避免猫咪喝到有消毒剂或清洁剂的脏水。
                    </p>
                </td>
            </tr>
            <tr>
                <td style="padding-left:40px;padding-right:40px;font-size:14px;">
                    <center><h3><p class="label label-info">狗狗注意事项</p></h3></center>
                    <br />
                    <p>
                        卫生：不能随便给狗狗洗澡，以为小狗抵抗地非常弱，狗狗可能会着凉。
                    </p>
                    <p>
                        牛奶：狗狗需要的是高蛋白质、高脂肪和低乳糖的饮品。喝牛奶只会引起腹泻。
                    </p>
                    <p>
                        吃肉：狗狗太小不能吃肉它的肠胃是不能接受的，因为肠胃太弱了无法消化掉。
                    </p>
                    <p>
                        驱虫：驱虫是每只狗狗必须精力的，要定期给狗狗驱虫避免体外寄生虫。
                    </p>
                </td>
                <td>
                     <img src="baikePICS/baike2.jpg"/>
                </td>
            </tr>
            <tr>
                <td>
                     <img src="baikePICS/baike3.jpg"/>
                </td>
                <td style="padding-left:40px;padding-right:40px;font-size:14px;">
                    <center><h3><p class="label label-info">兔子的小知识</p></h3></center>
                    <br />
                    <p>
                        兔子为什么是三瓣嘴？：三瓣嘴的生理特点有利于将兔子的门齿翻出来，这样，它们在啃吃低矮的草时，就不会受到嘴唇的阻挡。
                    </p>
                    <p>
                        兔子只有红眼睛吗？：兔子的眼睛分为红色、蓝色、茶色、黑色、灰色等颜色。
                    </p>
                    <p>
                        兔子是哑巴？：实际上，它们只是很少发出声音。当兔子感到不满时它们会发出“咕咕”或“嘶嘶”的声音以示警告。
                    </p>
                    
                </td>
            </tr>
        </table>
    </div>
</asp:Content>

