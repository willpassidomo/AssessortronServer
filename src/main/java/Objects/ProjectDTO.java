package Objects;

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
public class ProjectDTO {
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
    private List<SiteWalkDTO> siteWalks;// = new ArrayList<ChangeOrder>();
    
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


    public void addDrawRequests(DrawRequestDTO drawRequest) {
        //this.drawRequests.add(drawRequest);
    }


    public void addWalkThroughs(WalkThroughDTO walkThrough) {
        //walkThroughs.add(walkThrough);
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
     * @return the siteWalks
     */
    public List<SiteWalkDTO> getSiteWalks() {
        return siteWalks;
    }

    /**
     * @param siteWalks the siteWalks to set
     */
    public void setSiteWalks(List<SiteWalkDTO> siteWalks) {
        this.siteWalks = siteWalks;
    }
}