//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.06 um 11:17:38 AM CEST 
//


package at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse f�r metadataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="metadataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dcFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcMimeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcEncoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dcCreator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dcDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadataType", propOrder = {
    "dcFormat",
    "dcMimeType",
    "dcEncoding",
    "dcTitle",
    "dcDescription",
    "dcCreator",
    "dcSource",
    "dcDate"
})
public class MetadataType {

    @XmlElement(required = true)
    protected String dcFormat;
    @XmlElement(required = true)
    protected String dcMimeType;
    @XmlElement(required = true)
    protected String dcEncoding;
    @XmlElement(required = true)
    protected String dcTitle;
    protected String dcDescription;
    @XmlElement(required = true)
    protected String dcCreator;
    @XmlElement(required = true)
    protected String dcSource;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dcDate;

    /**
     * Ruft den Wert der dcFormat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcFormat() {
        return dcFormat;
    }

    /**
     * Legt den Wert der dcFormat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcFormat(String value) {
        this.dcFormat = value;
    }

    /**
     * Ruft den Wert der dcMimeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMimeType() {
        return dcMimeType;
    }

    /**
     * Legt den Wert der dcMimeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMimeType(String value) {
        this.dcMimeType = value;
    }

    /**
     * Ruft den Wert der dcEncoding-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcEncoding() {
        return dcEncoding;
    }

    /**
     * Legt den Wert der dcEncoding-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcEncoding(String value) {
        this.dcEncoding = value;
    }

    /**
     * Ruft den Wert der dcTitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTitle() {
        return dcTitle;
    }

    /**
     * Legt den Wert der dcTitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTitle(String value) {
        this.dcTitle = value;
    }

    /**
     * Ruft den Wert der dcDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcDescription() {
        return dcDescription;
    }

    /**
     * Legt den Wert der dcDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcDescription(String value) {
        this.dcDescription = value;
    }

    /**
     * Ruft den Wert der dcCreator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCreator() {
        return dcCreator;
    }

    /**
     * Legt den Wert der dcCreator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCreator(String value) {
        this.dcCreator = value;
    }

    /**
     * Ruft den Wert der dcSource-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcSource() {
        return dcSource;
    }

    /**
     * Legt den Wert der dcSource-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcSource(String value) {
        this.dcSource = value;
    }

    /**
     * Ruft den Wert der dcDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDcDate() {
        return dcDate;
    }

    /**
     * Legt den Wert der dcDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDcDate(XMLGregorianCalendar value) {
        this.dcDate = value;
    }

}
