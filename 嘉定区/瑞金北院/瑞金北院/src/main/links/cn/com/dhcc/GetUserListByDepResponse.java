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
 *         &lt;element name="GetUserListByDepResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getUserListByDepResult" })
@XmlRootElement(name = "GetUserListByDepResponse")
public class GetUserListByDepResponse {

	@XmlElement(name = "GetUserListByDepResult", required = true)
	protected String getUserListByDepResult;

	/**
	 * Gets the value of the getUserListByDepResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetUserListByDepResult() {
		return getUserListByDepResult;
	}

	/**
	 * Sets the value of the getUserListByDepResult property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGetUserListByDepResult(String value) {
		this.getUserListByDepResult = value;
	}

}
