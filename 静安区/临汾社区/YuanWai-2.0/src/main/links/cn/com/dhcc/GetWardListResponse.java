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
 *         &lt;element name="GetWardListResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getWardListResult" })
@XmlRootElement(name = "GetWardListResponse")
public class GetWardListResponse {

	@XmlElement(name = "GetWardListResult", required = true)
	protected String getWardListResult;

	/**
	 * Gets the value of the getWardListResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetWardListResult() {
		return getWardListResult;
	}

	/**
	 * Sets the value of the getWardListResult property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGetWardListResult(String value) {
		this.getWardListResult = value;
	}

}
