package Objects;

import Interfaces.Writeable;
import Interfaces.Writer;
import java.util.Date;
import java.util.UUID;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by willpassidomo on 1/23/15.
 */
@PersistenceCapable
public class ChangeOrderDTO implements Writeable{
    @Persistent
    private String id;
    @Persistent(defaultFetchGroup = "true")
    private ProjectDTO project;
    @Persistent(defaultFetchGroup = "true")
    private String subContractor;
    @Persistent(defaultFetchGroup = "true")
    private double amount;
    @Persistent(defaultFetchGroup = "true")
    private String description;
    @Persistent(defaultFetchGroup = "true")
    private boolean executed;
    @Persistent(defaultFetchGroup = "true")
    private Date dateSubmitted;

    public ChangeOrderDTO() {
        this.setDateSubmitted(new Date());
        this.setId(UUID.randomUUID().toString());
    }

    private ChangeOrderDTO(String nothing) {}

    public static ChangeOrderDTO getDBChangeOrder() {
        return new ChangeOrderDTO("");
    }

    public String getSubContractor() {
        return subContractor;
    }

    public void setSubContractor(String subContractor) {
        this.subContractor = subContractor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAmountString(String amount) {
        if (!amount.isEmpty()) {
            this.amount = Double.parseDouble(amount);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public void setExecutedString(String executed) {
        this.executed = new Boolean(executed);
    }

    public Date getDateSubmitted() {
        return this.dateSubmitted;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setDateSubmittedString(String dateSubmitted) {
        this.dateSubmitted = new Date(dateSubmitted);
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
