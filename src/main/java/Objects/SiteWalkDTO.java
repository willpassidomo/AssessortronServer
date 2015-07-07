/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Interfaces.WritableContainer;
import Interfaces.Writeable;
import Interfaces.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author willpassidomo
 */
public class SiteWalkDTO implements WritableContainer, Writeable {
    private Date timeStarted;
    private Date lastEntry;
    private UUID projectID;
    private String projectName;
    private List<FieldValueDTO> fieldValues;
    
    private ArrayList<WalkThroughDTO> walkThroughs = new ArrayList<>();
    private DrawRequestDTO drawRequest;
    
    private ArrayList<Writeable> writeables = new ArrayList<>();
    
    public Date getStartDate() {
        return getTimeStarted();
    }
    
    public String getProjectName() {
        return projectName;
    }

    @Override
    public List<Writeable> getWriteables() {
//        writeables.add(this);
//        writeables.addAll(drawRequests);
//        writeables.addAll(changeOrders);
//        writeables.addAll(walkThroughs);
        return writeables;
    }

    @Override
    public void add(Writeable writeable) {
        getWriteables().add(writeable);
    }

    @Override
    public Writeable remove(Writeable writeable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Writeable writeable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Writeable> removeAll(Writeable writeable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Writer writer) {
        writer.write(this);
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
    public ArrayList<WalkThroughDTO> getWalkThroughs() {
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
    public void setWalkThroughs(ArrayList<WalkThroughDTO> walkThroughs) {
        this.walkThroughs = walkThroughs;
    }

    /**
     * @param drawRequests the drawRequests to set
     */
    public void setDrawRequest(DrawRequestDTO drawRequests) {
        this.drawRequest = drawRequests;
    }


    /**
     * @param writeables the writeables to set
     */
    public void setWriteables(ArrayList<Writeable> writeables) {
        this.writeables = writeables;
    }
    
    
    
}
