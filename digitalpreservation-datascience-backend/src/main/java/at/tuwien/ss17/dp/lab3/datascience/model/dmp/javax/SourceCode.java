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
 *         &lt;element name="metadata" type="{}metadataType"/>
 *         &lt;element name="preservation" type="{}preservationType"/>
 *         &lt;element name="dataVolume" type="{}dataVolumeType"/>
 *         &lt;element name="documentation" type="{}documentationType"/>
 *         &lt;element name="intellectualPropertyRights" type="{}intellectualPropertyRightsType"/>
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
    "metadata",
    "preservation",
    "dataVolume",
    "documentation",
    "intellectualPropertyRights"
})
public class SourceCode {

    @XmlElement(required = true)
    protected MetadataType metadata;
    @XmlElement(required = true)
    protected PreservationType preservation;
    @XmlElement(required = true)
    protected DataVolumeType dataVolume;
    @XmlElement(required = true)
    protected DocumentationType documentation;
    @XmlElement(required = true)
    protected IntellectualPropertyRightsType intellectualPropertyRights;

    /**
     * Ruft den Wert der metadata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Legt den Wert der metadata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

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
