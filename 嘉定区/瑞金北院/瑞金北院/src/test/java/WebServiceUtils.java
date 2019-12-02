import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.SOAPHeaderElement;

import java.net.URL;

public class WebServiceUtils {
    public static final String url = "http://172.21.11.59/ESBService/ESBService.asmx";
    public static void main(String[] args){
        Object[] params = new Object[]{"z075601",2};
        String result = sendWebservice(params,url);
        System.out.println(result);
    }

    public static String sendWebservice(Object[] params, String url) {
        //String soapaction = "http://170.21.11.00/"; // 域名，这是在server定义的
        String soapaction="http://ESB.Service/";
        String operationName = "CallESB";// 调用方法名
        Service service = new Service();
        String ret = "";

        try {
            SOAPHeaderElement header=new SOAPHeaderElement("http://ESB.TopSchemaV2","ESBEnvelope");
            SOAPElement ESBHeader = header.addChildElement("ESBHeader");
            SOAPElement HeaderControl=header.addChildElement("HeaderControl");
            HeaderControl.addChildElement("AppCode").addTextNode("APP907");
            HeaderControl.addChildElement("Password").addTextNode("0OuN2Tup");
            HeaderControl.addChildElement("MessageCategory").addTextNode("RJHN903010008");
            HeaderControl.addChildElement("Version").addTextNode("");
            HeaderControl.addChildElement("CreateTime").addTextNode("2019-08--17 13:33:00");
            ESBHeader.addChildElement(HeaderControl);
            SOAPElement ESBBody=header.addChildElement("ESBBody");

            SOAPElement BusinessRequest=header.addChildElement("BusinessRequest");
            SOAPElement datatable=BusinessRequest.addChildElement("datatable");
            SOAPElement datarow=datatable.addChildElement("datarow");
            datarow.addChildElement("p1");
            datarow.addTextNode("z075601");
            datarow.addChildElement("p2");
            datarow.addTextNode("1");
            ESBBody.addChildElement(BusinessRequest).addChildElement(datatable).addChildElement(datarow);

            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(url));
          //  headerElement.setParentElement()
            call.addHeader(header);
            call.setOperationName(new QName(soapaction, operationName)); // 设置要调用哪个方法
            // 设置要传递的参数
            call.addParameter(new QName(soapaction, "cardid"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "cardtype"), XMLType.XSD_INT, javax.xml.rpc.ParameterMode.IN);

            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction+operationName);

            ret = (String) call.invoke(params);// 调用方法并传递参数
            System.out.println(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}
