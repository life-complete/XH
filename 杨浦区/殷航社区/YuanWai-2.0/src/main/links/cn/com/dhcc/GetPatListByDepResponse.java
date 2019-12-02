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
 *         &lt;element name="GetPatListByDepResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getPatListByDepResult" })
@XmlRootElement(name = "GetPatListByDepResponse")
public class GetPatListByDepResponse {

	@XmlElement(name = "GetPatListByDepResult", required = true)
	protected String getPatListByDepResult;

	/**
	 * Gets the value of the getPatListByDepResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetPatListByDepResult() {
		return getPatListByDepResult;
	}

	/**
	 * Sets the value of the getPatListByDepResult property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGetPatListByDepResult(String value) {
		this.getPatListByDepResult = value;
	}

}
