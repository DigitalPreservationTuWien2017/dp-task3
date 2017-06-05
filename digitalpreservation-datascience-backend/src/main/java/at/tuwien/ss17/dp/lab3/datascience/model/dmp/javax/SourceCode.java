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
 *         &lt;element name="Preservation" type="{}PreservationType" minOccurs="0"/>
 *         &lt;element name="DataVolume" type="{}DataVolumeType" minOccurs="0"/>
 *         &lt;element name="DataRepository" type="{}DataRepositoryType" minOccurs="0"/>
 *         &lt;element name="Documentation" type="{}DocumentationType" minOccurs="0"/>
 *         &lt;element name="IntellectualPropertyRights" type="{}IntellectualPropertyRightsType"/>
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
    "preservation",
    "dataVolume",
    "dataRepository",
    "documentation",
    "intellectualPropertyRights"
})
public class SourceCode {

    @XmlElement(name = "Preservation")
    protected PreservationType preservation;
    @XmlElement(name = "DataVolume")
    protected DataVolumeType dataVolume;
    @XmlElement(name = "DataRepository")
    protected DataRepositoryType dataRepository;
    @XmlElement(name = "Documentation")
    protected DocumentationType documentation;
    @XmlElement(name = "IntellectualPropertyRights", required = true)
    protected IntellectualPropertyRightsType intellectualPropertyRights;

    /**
     * Ruft den Wert der preservation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreservationType }
     *     
     */
    public PreservationType getPreservation() {
        return preservation;
    }

    /**
     * Legt den Wert der preservation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreservationType }
     *     
     */
    public void setPreservation(PreservationType value) {
        this.preservation = value;
    }

    /**
     * Ruft den Wert der dataVolume-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataVolumeType }
     *     
     */
    public DataVolumeType getDataVolume() {
        return dataVolume;
    }

    /**
     * Legt den Wert der dataVolume-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataVolumeType }
     *     
     */
    public void setDataVolume(DataVolumeType value) {
        this.dataVolume = value;
    }

    /**
     * Ruft den Wert der dataRepository-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataRepositoryType }
     *     
     */
    public DataRepositoryType getDataRepository() {
        return dataRepository;
    }

    /**
     * Legt den Wert der dataRepository-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRepositoryType }
     *     
     */
    public void setDataRepository(DataRepositoryType value) {
        this.dataRepository = value;
    }

    /**
     * Ruft den Wert der documentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentationType }
     *     
     */
    public DocumentationType getDocumentation() {
        return documentation;
    }

    /**
     * Legt den Wert der documentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentationType }
     *     
     */
    public void setDocumentation(DocumentationType value) {
        this.documentation = value;
    }

    /**
     * Ruft den Wert der intellectualPropertyRights-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IntellectualPropertyRightsType }
     *     
     */
    public IntellectualPropertyRightsType getIntellectualPropertyRights() {
        return intellectualPropertyRights;
    }

    /**
     * Legt den Wert der intellectualPropertyRights-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IntellectualPropertyRightsType }
     *     
     */
    public void setIntellectualPropertyRights(IntellectualPropertyRightsType value) {
        this.intellectualPropertyRights = value;
    }

}
