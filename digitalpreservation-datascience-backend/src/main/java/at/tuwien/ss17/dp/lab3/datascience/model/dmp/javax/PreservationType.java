//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.05 um 04:15:35 PM CEST 
//


package at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r preservationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="preservationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backupStorageURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="backupsInCronFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="retentionDurationInDays" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preservationType", propOrder = {
    "backupStorageURI",
    "backupsInCronFormat",
    "retentionDurationInDays"
})
public class PreservationType {

    @XmlElement(required = true)
    protected String backupStorageURI;
    @XmlElement(required = true)
    protected String backupsInCronFormat;
    protected double retentionDurationInDays;

    /**
     * Ruft den Wert der backupStorageURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackupStorageURI() {
        return backupStorageURI;
    }

    /**
     * Legt den Wert der backupStorageURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackupStorageURI(String value) {
        this.backupStorageURI = value;
    }

    /**
     * Ruft den Wert der backupsInCronFormat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackupsInCronFormat() {
        return backupsInCronFormat;
    }

    /**
     * Legt den Wert der backupsInCronFormat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackupsInCronFormat(String value) {
        this.backupsInCronFormat = value;
    }

    /**
     * Ruft den Wert der retentionDurationInDays-Eigenschaft ab.
     * 
     */
    public double getRetentionDurationInDays() {
        return retentionDurationInDays;
    }

    /**
     * Legt den Wert der retentionDurationInDays-Eigenschaft fest.
     * 
     */
    public void setRetentionDurationInDays(double value) {
        this.retentionDurationInDays = value;
    }

}
