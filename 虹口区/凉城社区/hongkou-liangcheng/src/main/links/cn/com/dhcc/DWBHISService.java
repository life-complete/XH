package cn.com.dhcc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390- Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
* DWBHISService service = new DWBHISService();
* DWBHISServiceSoap portType = service.getDWBHISServiceSoap();
* portType.getDepList(...);
* </pre>
 * </p>
 * 
 */
@WebServiceClient(name = "DWBHISService", targetNamespace = "http://dhcc.com.cn", wsdlLocation = "http://222.132.155.205:57772/dthealth/web/NurDWB.Interface.Service.cls?wsdl")
public class DWBHISService extends Service {

	private final static URL DWBHISSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger.getLogger(cn.com.dhcc.DWBHISService.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = cn.com.dhcc.DWBHISService.class.getResource(".");
			url = new URL(baseUrl, "http://222.132.155.205:57772/dthealth/web/NurDWB.Interface.Service.cls?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://222.132.155.205:57772/dthealth/web/NurDWB.Interface.Service.cls?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		DWBHISSERVICE_WSDL_LOCATION = url;
	}

	public DWBHISService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public DWBHISService() {
		super(DWBHISSERVICE_WSDL_LOCATION, new QName("http://dhcc.com.cn", "DWBHISService"));
	}

	/**
	 * 
	 * @return returns DWBHISServiceSoap
	 */
	@WebEndpoint(name = "DWBHISServiceSoap")
	public DWBHISServiceSoap getDWBHISServiceSoap() {
		return super.getPort(new QName("http://dhcc.com.cn", "DWBHISServiceSoap"), DWBHISServiceSoap.class);
	}

}
