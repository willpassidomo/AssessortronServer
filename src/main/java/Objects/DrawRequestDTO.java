package Objects;


import Interfaces.Writeable;
import Interfaces.Writer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by willpassidomo on 1/15/15.
 */
@PersistenceCapable
public class DrawRequestDTO implements Writeable{
    @Persistent
    private String id;
    @Persistent
    private ProjectDTO project;
    @Persistent(defaultFetchGroup = "true")
    private Date date;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal currentRequest;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal maxRequest;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal minRequest;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal retainageRel;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal contigencyDraw;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal contingencyBalance;
    @Persistent(defaultFetchGroup = "true")
    private BigDecimal balanceToComplete;

    public DrawRequestDTO() {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public DrawRequestDTO(String nothing) {}

    public static DrawRequestDTO getDBDrawRequest() {
        return new DrawRequestDTO("");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateString(String date) {
        this.date = new Date(date);
    }

    public BigDecimal getCurrentRequest() {
        return currentRequest;
    }

    public void setCurrentRequest(BigDecimal currentRequest) {
        this.currentRequest = currentRequest;
    }

    public void setCurrentRequestString(String currentRequest) {
        this.currentRequest = new BigDecimal(currentRequest);
    }

    public BigDecimal getMaxRequest() {
        return maxRequest;
    }

    public void setMaxRequest(BigDecimal maxRequest) {
        this.maxRequest = maxRequest;
    }

    public void setMaxRequestString(String maxRequest) {
        this.maxRequest = new BigDecimal(maxRequest);
    }

    public BigDecimal getMinRequest() {
        return minRequest;
    }

    public void setMinRequest(BigDecimal minRequest) {
        this.minRequest = minRequest;
    }

    public void setMinRequestString(String minRequest) {
        this.minRequest = new BigDecimal(minRequest);
    }

    public BigDecimal getRetainageRel() {
        return retainageRel;
    }

    public void setRetainageRel(BigDecimal retainageRel) {
        this.retainageRel = retainageRel;
    }

    public void setRetainageRelString(String retainageRel) {
        this.retainageRel = new BigDecimal(retainageRel);
    }

    public BigDecimal getContigencyDraw() {
        return contigencyDraw;
    }

    public void setContingencyDraw(BigDecimal contigencyDraw) {
        this.contigencyDraw = contigencyDraw;
    }

    public void setContingencyDrawString(String contingencyDraw) {
        this.contigencyDraw = new BigDecimal(contingencyDraw);
    }

    public BigDecimal getContingencyBalance() {
        return contingencyBalance;
    }

    public void setContingencyBalance(BigDecimal contingencyBalance) {
        this.contingencyBalance = contingencyBalance;
    }

    public void setContingencyBalanceString(String contingencyBalance) {
        this.contingencyBalance = new BigDecimal(contingencyBalance);
    }

    public BigDecimal getBalanceToComplete() {
        return balanceToComplete;
    }

    public void setBalanceToComplete(BigDecimal balanceToComplete) {
        this.balanceToComplete = balanceToComplete;
    }

    public void setBalanceToCompleteString(String balanceToComplete) {
        this.balanceToComplete = new BigDecimal(balanceToComplete);
    }

    @Override
    public void visit(Writer writer) {
        writer.write(this);
    }

    /**
     * @return the project
     */
    public ProjectDTO getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(ProjectDTO project) {
        this.project = project;
    }
}
