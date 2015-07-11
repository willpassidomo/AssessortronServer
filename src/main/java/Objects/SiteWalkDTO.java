/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author willpassidomo
 */
public class SiteWalkDTO {
    private Date timeStarted;
    private Date lastEntry;
    private UUID projectID;
    private String projectName;
    private List<FieldValueDTO> fieldValues;
    private List<WalkThroughDTO> walkThroughs = new ArrayList<>();
    
    private DrawRequestDTO drawRequest;
        
    public Date getStartDate() {
        return getTimeStarted();
    }
    
    public String getProjectName() {
        return projectName;
    }


    /**
     * @return the timeStarted
     */
    public Date getTimeStarted() {
        return timeStarted;
    }

    /**
     * @return the lastEntry
     */
    public Date getLastEntry() {
        return lastEntry;
    }

    /**
     * @return the projectID
     */
    public UUID getProjectID() {
        return projectID;
    }

    /**
     * @return the walkThroughs
     */
    public List<WalkThroughDTO> getWalkThroughs() {
        return walkThroughs;
    }

    /**
     * @return the drawRequests
     */
    public DrawRequestDTO getDrawRequest() {
        return drawRequest;
    }


    /**
     * @param timeStarted the timeStarted to set
     */
    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }
    
    public void setTimeStatedLong(long timeStarted) {
        setTimeStarted(new Date(timeStarted));
    }

    /**
     * @param lastEntry the lastEntry to set
     */
    public void setLastEntry(Date lastEntry) {
        this.lastEntry = lastEntry;
    }
    
    public void setLastEntryLong(long lastEntry) {
        setLastEntry(new Date(lastEntry));
    }
    
    public void setFieldValues(List<FieldValueDTO> fieldValues) {
        this.fieldValues = fieldValues;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(UUID projectID) {
        this.projectID = projectID;
    }
    
    public void setProjectIDString(String projectId) {
        setProjectID(UUID.fromString(projectId));
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @param walkThroughs the walkThroughs to set
     */
    public void setWalkThroughs(List<WalkThroughDTO> walkThroughs) {
        this.walkThroughs = walkThroughs;
    }

    /**
     * @param drawRequests the drawRequests to set
     */
    public void setDrawRequest(DrawRequestDTO drawRequests) {
        this.drawRequest = drawRequests;
    }    
    
}
