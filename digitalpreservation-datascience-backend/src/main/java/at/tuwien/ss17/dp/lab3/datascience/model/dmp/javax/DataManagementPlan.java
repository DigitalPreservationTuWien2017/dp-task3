//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.05 um 04:15:35 PM CEST 
//


package at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="dataRepository" type="{}dataRepositoryType"/>
 *         &lt;element name="ethicsPrivacy" type="{}ethicsPrivacyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rolesAndResponsibilities" type="{}rolesAndResponsibilitiesType" maxOccurs="unbounded"/>
 *         &lt;element name="budget" type="{}budgetType" maxOccurs="unbounded"/>
 *         &lt;element name="experimentFile" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="metadata" type="{}metadataType" minOccurs="0"/>
 *                   &lt;element name="preservation" type="{}preservationType" minOccurs="0"/>
 *                   &lt;element name="dataVolume" type="{}dataVolumeType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sourceCode" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="metadata" type="{}metadataType" minOccurs="0"/>
 *                   &lt;element name="preservation" type="{}preservationType"/>
 *                   &lt;element name="dataVolume" type="{}dataVolumeType"/>
 *                   &lt;element name="documentation" type="{}documentationType" maxOccurs="unbounded"/>
 *                   &lt;element name="intellectualPropertyRights" type="{}intellectualPropertyRightsType"/>
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
    "dataRepository",
    "ethicsPrivacy",
    "rolesAndResponsibilities",
    "budget",
    "experimentFile",
    "sourceCode"
})
@XmlRootElement(name = "DataManagementPlan")
public class DataManagementPlan {

    @XmlElement(required = true)
    protected DataRepositoryType dataRepository;
    protected List<EthicsPrivacyType> ethicsPrivacy;
    @XmlElement(required = true)
    protected List<RolesAndResponsibilitiesType> rolesAndResponsibilities;
    @XmlElement(required = true)
    protected List<BudgetType> budget;
    protected ExperimentFile experimentFile;
    protected SourceCode sourceCode;

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
     * Gets the value of the ethicsPrivacy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ethicsPrivacy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEthicsPrivacy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EthicsPrivacyType }
     * 
     * 
     */
    public List<EthicsPrivacyType> getEthicsPrivacy() {
        if (ethicsPrivacy == null) {
            ethicsPrivacy = new ArrayList<EthicsPrivacyType>();
        }
        return this.ethicsPrivacy;
    }

    /**
     * Gets the value of the rolesAndResponsibilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rolesAndResponsibilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRolesAndResponsibilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RolesAndResponsibilitiesType }
     * 
     * 
     */
    public List<RolesAndResponsibilitiesType> getRolesAndResponsibilities() {
        if (rolesAndResponsibilities == null) {
            rolesAndResponsibilities = new ArrayList<RolesAndResponsibilitiesType>();
        }
        return this.rolesAndResponsibilities;
    }

    /**
     * Gets the value of the budget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetType }
     * 
     * 
     */
    public List<BudgetType> getBudget() {
        if (budget == null) {
            budget = new ArrayList<BudgetType>();
        }
        return this.budget;
    }

    /**
     * Ruft den Wert der experimentFile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExperimentFile }
     *     
     */
    public ExperimentFile getExperimentFile() {
        return experimentFile;
    }

    /**
     * Legt den Wert der experimentFile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExperimentFile }
     *     
     */
    public void setExperimentFile(ExperimentFile value) {
        this.experimentFile = value;
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
