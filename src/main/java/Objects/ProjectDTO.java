package Objects;

import Interfaces.WritableContainer;
import Interfaces.Writeable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by willpassidomo on 1/14/15.
 */
@PersistenceCapable
public class ProjectDTO implements WritableContainer {
    @PrimaryKey
    private String id;
    @Persistent(defaultFetchGroup = "true")
    private Date dateCreated;
    @Persistent(defaultFetchGroup = "true")
    private String name;
    @Persistent(defaultFetchGroup = "true")
    private String address;
    @Persistent(defaultFetchGroup = "true")
    private String initialStartDate;
    @Persistent(defaultFetchGroup = "true")
    private String initialCompletionDate;
    @Persistent(defaultFetchGroup = "true")
    private String actualStartDate;
    @Persistent(defaultFetchGroup = "true")
    private String actualCompletionDate;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal loanAmount;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal contractAmount;
    @Persistent(defaultFetchGroup = "true")
    private int numAGFloors;
    @Persistent(defaultFetchGroup = "true")
    private int numBasementFlors;
    @Persistent(defaultFetchGroup = "true")
    private double squareFeet;
    @Persistent(defaultFetchGroup = "true")
    private boolean hasOutdoorWork;

    @Persistent(defaultFetchGroup = "true")
    private List<UUID> pictures = new ArrayList<UUID>();


    @Persistent(mappedBy = "project")
    private List<ChangeOrderDTO> changeOrders;// = new ArrayList<ChangeOrder>();
    @Persistent(defaultFetchGroup = "true")
    private List<DrawRequestDTO> drawRequests;// = new ArrayList<DrawRequest>();
    @Persistent()
    private List<WalkThroughDTO> walkThroughs;// = new ArrayList<WalkThrough>();

    public ProjectDTO(String string) {

    }

    public ProjectDTO() {
        this.id = UUID.randomUUID().toString();
    }

    public static ProjectDTO initializeDBProject() {
        return new ProjectDTO("");
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInitialStartDate() {
        return initialStartDate;
    }

    public void setInitialStartDate(String initialStartDate) {
        this.initialStartDate = initialStartDate;
    }

    public String getInitialCompletionDate() {
        return initialCompletionDate;
    }

    public void setInitialCompletionDate(String initialCompletionDate) {
        this.initialCompletionDate = initialCompletionDate;
    }

    public String getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(String actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public String getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(String actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanAmountString(String loanAmount) {
        if (loanAmount != null && !loanAmount.isEmpty()) {
            this.setLoanAmount(new BigDecimal(loanAmount));
        }
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public void setContractAmountString(String contractAmount) {
        if (contractAmount != null && !contractAmount.isEmpty()) {
            this.setContractAmount(new BigDecimal(contractAmount));
        }
    }

    public int getNumAGFloors() {
        return numAGFloors;
    }

    public void setNumAGFloors(int numAGFloors) {
        this.numAGFloors = numAGFloors;
    }

    public void setNumAGFloorsString(String numAGFloors) {
        if (numAGFloors != null && !numAGFloors.isEmpty()) {
            this.setNumAGFloors(Integer.parseInt(numAGFloors));
        }
    }

    public int getNumBasementFloors() {
        return getNumBasementFlors();
    }

    public void setNumBasementFloors(int numBasementFlors) {
        this.setNumBasementFlors(numBasementFlors);
    }

    public void setNumBasementFloorsString(String numBasementFlors) {
        if (numBasementFlors != null && !numBasementFlors.isEmpty()) {
            this.setNumBasementFlors(Integer.parseInt(numBasementFlors));
        }
    }

    public boolean isHasOutdoorWork() {
        return hasOutdoorWork;
    }

    public void setHasOutdoorWork(boolean hasOutdoorWork) {
        this.hasOutdoorWork = hasOutdoorWork;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCreatedString(String date) {
        this.setDateCreated(new Date(date));
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public void setSquareFeetString(String squareFeet) {
        if (squareFeet != null && !squareFeet.isEmpty()) {
            this.setSquareFeet(Double.parseDouble(squareFeet));
        }
    }

    public List<DrawRequestDTO> getDrawRequests() {
        return drawRequests;
    }

    public DrawRequestDTO getDrawRequestById(String id) {
        for (DrawRequestDTO dr : getDrawRequests()) {
            if (dr.getId().equals(id)) {
                return dr;
            }
        }
        return null;
    }

    public void addDrawRequests(DrawRequestDTO drawRequest) {
        //this.drawRequests.add(drawRequest);
    }

    public List<WalkThroughDTO> getWalkThroughs() {
        return walkThroughs;
    }

    public WalkThroughDTO getWalkThroughById(String id) {
        for (WalkThroughDTO wt : getWalkThroughs()) {
            if (wt.getId().equals(id)) {
                return wt;
            }
        }
        return null;
    }

    public void addWalkThroughs(WalkThroughDTO walkThrough) {
        //walkThroughs.add(walkThrough);
    }

    public List<ChangeOrderDTO> getChangeOrders() {
        return changeOrders;
    }

    public ChangeOrderDTO getChangeOrderById(String id) {
        for (ChangeOrderDTO co : getChangeOrders()) {
            if (co.getId().equals(id)) {
                return co;
            }
        }
        return null;
    }

    public void addChangeOrder(ChangeOrderDTO changeOrder) {
        //changeOrders.add(changeOrder);
    }

    public WalkThroughDTO removeWalkThrough(int i) {
        return getWalkThroughs().remove(i);
    }

    public DrawRequestDTO removeDrawRequest(int i) {
        return getDrawRequests().remove(i);
    }

    public ChangeOrderDTO removeChangeOrder(int i) {
        return getChangeOrders().remove(i);
    }

    public void addSitePicture(UUID pictureUri) {
        this.getPictures().add(pictureUri);
    }

    public void removeSitePicture(UUID pictureUri) {
        this.getPictures().remove(pictureUri);
    }

    public void removeSitePicture(int i) {
        this.getPictures().remove(i);
    }

    public List<UUID> getPictures() {
        return this.pictures;
    }

    public UUID getPicture(int i) {
        return this.getPictures().get(i);
    }

    public void setSitePictures(List<UUID> sitePictures) {
        this.setPictures(new ArrayList<UUID>(sitePictures));
    }

    /**
     * @return the numBasementFlors
     */
    public int getNumBasementFlors() {
        return numBasementFlors;
    }

    /**
     * @param numBasementFlors the numBasementFlors to set
     */
    public void setNumBasementFlors(int numBasementFlors) {
        this.numBasementFlors = numBasementFlors;
    }

    /**
     * @param pictures the pictures to set
     */
    public void setPictures(List<UUID> pictures) {
        this.pictures = pictures;
    }

    /**
     * @param changeOrders the changeOrders to set
     */
    public void setChangeOrders(List<ChangeOrderDTO> changeOrders) {
        this.changeOrders = changeOrders;
    }

    /**
     * @param drawRequests the drawRequests to set
     */
    public void setDrawRequests(List<DrawRequestDTO> drawRequests) {
        this.drawRequests = drawRequests;
    }

    /**
     * @param walkThroughs the walkThroughs to set
     */
    public void setWalkThroughs(List<WalkThroughDTO> walkThroughs) {
        this.walkThroughs = walkThroughs;
    }

    @Override
    public List<Writeable> getWriteables() {
        List<Writeable> writeables = new ArrayList<Writeable>();
        for(Writeable d: this.getDrawRequests())
            writeables.add(d);
        for(Writeable c: this.getChangeOrders())
            writeables.add(c);
        for(Writeable w: this.getWalkThroughs())
            writeables.add(w);
        return writeables;
    }

    @Override
    public void add(Writeable writeable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}