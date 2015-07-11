/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author otf
 */
public class DrawRequestItemDTO {
    private String id;
    private String type;
    private String typeName;
    private String subContractor;
    private double amount;
    private String description;
    private boolean executed;
    private Date dateSubmitted;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the subContractor
     */
    public String getSubContractor() {
        return subContractor;
    }

    /**
     * @param subContractor the subContractor to set
     */
    public void setSubContractor(String subContractor) {
        this.subContractor = subContractor;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the executed
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * @param executed the executed to set
     */
    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    /**
     * @return the dateSubmitted
     */
    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * @param dateSubmitted the dateSubmitted to set
     */
    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
    
    public void setDateSubmittedLong(long dateSubmitted) {
        this.dateSubmitted = new Date(dateSubmitted);
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
     
}
