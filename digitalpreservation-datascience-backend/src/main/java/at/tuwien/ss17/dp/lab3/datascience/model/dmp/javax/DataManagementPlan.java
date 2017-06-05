//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.05 um 01:52:16 PM CEST 
//


package at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="File" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Metadata" type="{}MetadataType" minOccurs="0"/>
 *                   &lt;element name="Preservation" type="{}PreservationType" minOccurs="0"/>
 *                   &lt;element name="DataVolume" type="{}DataVolumeType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SourceCode" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Preservation" type="{}PreservationType" minOccurs="0"/>
 *                   &lt;element name="DataVolume" type="{}DataVolumeType" minOccurs="0"/>
 *                   &lt;element name="DataRepository" type="{}DataRepositoryType" minOccurs="0"/>
 *                   &lt;element name="Documentation" type="{}DocumentationType" minOccurs="0"/>
 *                   &lt;element name="IntellectualPropertyRights" type="{}IntellectualPropertyRightsType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "file",
    "sourceCode"
})
@XmlRootElement(name = "DataManagementPlan")
public class DataManagementPlan {

    @XmlElement(name = "File")
    protected File file;
    @XmlElement(name = "SourceCode")
    protected SourceCode sourceCode;

    /**
     * Ruft den Wert der file-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    public File getFile() {
        return file;
    }

    /**
     * Legt den Wert der file-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    public void setFile(File value) {
        this.file = value;
    }

    /**
     * Ruft den Wert der sourceCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SourceCode }
     *     
     */
    public SourceCode getSourceCode() {
        return sourceCode;
    }

    /**
     * Legt den Wert der sourceCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceCode }
     *     
     */
    public void setSourceCode(SourceCode value) {
        this.sourceCode = value;
    }

}
