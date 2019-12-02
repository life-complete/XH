package cn.com.dhcc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetOrderListByAdmResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOrderListByAdmResult" })
@XmlRootElement(name = "GetOrderListByAdmResponse")
public class GetOrderListByAdmResponse {

	@XmlElement(name = "GetOrderListByAdmResult", required = true)
	protected String getOrderListByAdmResult;

	/**
	 * Gets the value of the getOrderListByAdmResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOrderListByAdmResult() {
		return getOrderListByAdmResult;
	}

	/**
	 * Sets the value of the getOrderListByAdmResult property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGetOrderListByAdmResult(String value) {
		this.getOrderListByAdmResult = value;
	}

}
