using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.IO;

namespace MonitorInfo.Demo.InvokeESB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ESBWebService.ESBServiceSoapClient esb = new MonitorInfo.Demo.InvokeESB.ESBWebService.ESBServiceSoapClient();
            string xmlMessage = ConvertToXmlMessage(textBox1.Text, textBox2.Text, textBox3.Text, ConvertToXmlPara());
            textBox6.Text = xmlMessage;
            textBox7.Text = esb.CallESB(xmlMessage);

            //************************关于返回结果的说明************************
            //
            //由于此服务为先调用ESB，再通过ESB调用后台服务，所以返回结果分2种情况。
            //
            //一、ESB直接报错，一般会直接返回错误字符串，ESB直接报错一般包含账户密码、服务代码等配置错误或没有权限等情况产生
            //
            //二、实际后台服务返回结果，具体如下：
            //
            //<ActionResult><Success>True</Success><Data><?xml version="1.0" encoding="utf-16"?>
            //<xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata">
            //  <xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:UseCurrentLocale="true">
            //    <xs:complexType>
            //      <xs:choice minOccurs="0" maxOccurs="unbounded">
            //        <xs:element name="Table">
            //          <xs:complexType>
            //            <xs:sequence>
            //              <xs:element name="jyje" type="xs:decimal" minOccurs="0" />
            //            </xs:sequence>
            //          </xs:complexType>
            //        </xs:element>
            //      </xs:choice>
            //    </xs:complexType>
            //  </xs:element>
            //</xs:schema><NewDataSet>
            //  <Table>
            //    <jyje>1627071.75</jyje>
            //  </Table>
            //</NewDataSet></Data></ActionResult>
            //
            //Success：True时表示调用方法成功；False时表示调用失败，可能存在参数不对等情况，会具体告知原因
            //Data：具体调用方法返回的结果或具体错误的原因。根据Data具体类型进行相应转换
            //
            //******************************************************************

            //解析返回的数据

            string[] returnxml = AnalysisReturnXml(textBox7.Text);
            if (returnxml != null && returnxml.Length == 2)
            {
                if (returnxml[0] == "True")
                {
                    //转换DataSet
                    DataSet ds = ConvertToDataSet(returnxml[1]);
                }
            }
            else
            {
                //返回字符串格式错误
            }
        }

        /// <summary>
        /// 生成调用ESB的XML文件，此格式固定不变
        /// </summary>
        /// <param name="EsbAppCode">账号，固定不变</param>
        /// <param name="EsbPassword">密码，固定不变</param>
        /// <param name="EsbServiceCode">服务代码，一个方法对应一个服务代码</param>
        /// <param name="xmlPara">服务参数，不同服务代码对应参数不相同</param>
        /// <returns></returns>
        string ConvertToXmlMessage(string EsbAppCode, string EsbPassword, string EsbServiceCode, string xmlPara)
        {
            return "<ESBEnvelope xmlns=\"http://ESB.TopSchemaV2\">" +
                        "<ESBHeader><HeaderControl AppCode=\"" + EsbAppCode + "\" Password=\"" + EsbPassword + "\" MessageCategory=\"" + EsbServiceCode + "\" Version=\"\" CreateTime=\"" + DateTime.Now.ToString("yyyy-MM--dd HH:mm:ss") + "\"></HeaderControl></ESBHeader>" +
                        "<ESBBody><BusinessRequest><![CDATA[" + xmlPara + "]]></BusinessRequest></ESBBody>" +
                   "</ESBEnvelope>";
        }

        /// <summary>
        /// 生成服务参数，此格式根据不同服务会变
        /// xml中datatable、datarow固定不变，具体内容参数要求顺序正确，具体参数名称可自定定义
        /// 如：某个方法需要3个参数，则可以生产如下字符串作为服务参数
        /// <datatable><datarow><p1>123</p1><p2>abc</p2><p3>2019-01-01</p3></datarow></datatable>
        /// </summary>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        string ConvertToXmlPara()
        {
            string p1 = textBox4.Text;
            string p2 = textBox5.Text;
            string p3 = textBox9.Text;
            string p4 = textBox8.Text;

            switch ((int)numericUpDown1.Value)
            {
                case 0:
                    return "";
                case 1:
                    return "<datatable><datarow><p1>" + p1 + "</p1></datarow></datatable>";
                case 2:
                    return "<datatable><datarow><p1>" + p1 + "</p1><p2>" + p2 + "</p2></datarow></datatable>";
                case 3:
                    return "<datatable><datarow><p1>" + p1 + "</p1><p2>" + p2 + "</p2><p3>" + p3 + "</p3></datarow></datatable>";
                case 4:
                    return "<datatable><datarow><p1>" + p1 + "</p1><p2>" + p2 + "</p2><p3>" + p3 + "</p3><p4>" + p4 + "</p4></datarow></datatable>";
                default:
                    return "";
            }
        }

        /// <summary>
        /// 解析返回的XML文件
        /// </summary>
        /// <param name="xml"></param>
        /// <returns></returns>
        string[] AnalysisReturnXml(string xml)
        {
            try
            {
                XmlDocument xd = new XmlDocument();
                xd.LoadXml(xml.Replace("<?xml version=\"1.0\" encoding=\"utf-16\"?>", ""));
                XmlNodeList xmlNoteList = xd.GetElementsByTagName("ActionResult");

                if (xmlNoteList != null && xmlNoteList[0] != null && xmlNoteList[0].ChildNodes != null)
                {
                    string[] results = new string[xmlNoteList[0].ChildNodes.Count];

                    for (int i = 0; i < xmlNoteList[0].ChildNodes.Count; i++)
                    {
                        results[i] = xmlNoteList[0].ChildNodes[i].InnerXml;
                    }

                    return results;
                }
                else
                {
                    return new string[2] { "False", "返回的XML文件格式错误" };
                }
            }
            catch
            {
                throw;
            }
        }

        DataSet ConvertToDataSet(string xml)
        {
            DataSet ds = new DataSet();

            TextReader trSchema = null;
            TextReader trData = null;

            try
            {
                trSchema = new StringReader(xml.Substring(0, xml.IndexOf("<NewDataSet")));
                trData = new StringReader(xml.Substring(xml.IndexOf("<NewDataSet")));

                ds.ReadXmlSchema(trSchema);
                ds.ReadXml(trData);
            }
            catch
            {
                throw;
            }
            finally
            {
                trSchema.Close();
                trSchema.Dispose();
                trData.Close();
                trData.Dispose();
            }

            return ds;
        }

        private void textBox6_Enter(object sender, EventArgs e)
        {
            textBox6.SelectAll();
            textBox6.Copy();

        }

        private void textBox7_Enter(object sender, EventArgs e)
        {
            textBox7.SelectAll();
            textBox7.Copy();
        }
    }
}
