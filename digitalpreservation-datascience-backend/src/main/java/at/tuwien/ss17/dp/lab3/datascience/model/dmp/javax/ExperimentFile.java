//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.05 um 04:15:35 PM CEST 
//


package at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="metadata" type="{}metadataType" minOccurs="0"/>
 *         &lt;element name="preservation" type="{}preservationType" minOccurs="0"/>
 *         &lt;element name="dataVolume" type="{}dataVolumeType" minOccurs="0"/>
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
    "dataVolume"
})
public class ExperimentFile {

    protected MetadataType metadata;
    protected PreservationType preservation;
    protected DataVolumeType dataVolume;

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

}
