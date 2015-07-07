package Objects;


import Interfaces.Writeable;
import Interfaces.Writer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    private BigDecimal currentRecommendation;
    @Persistent(defaultFetchGroup = "true")
    private String conditions;
    @Persistent(defaultFetchGroup = "true")
    private List<DrawRequestItemDTO> drawRequestItems;


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
    
    public void setDateLong(long date) {
        this.date = new Date(date);
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

    /**
     * @return the currentRecommendation
     */
    public BigDecimal getCurrentRecommendation() {
        return currentRecommendation;
    }

    /**
     * @param currentRecommendation the currentRecommendation to set
     */
    public void setCurrentRecommendation(BigDecimal currentRecommendation) {
        this.currentRecommendation = currentRecommendation;
    }
    
    public void setCurrentRecommendationString(String currentRecommendation) {
        this.currentRecommendation = new BigDecimal(currentRecommendation);
    }

    /**
     * @return the conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * @return the drawRequestItems
     */
    public List<DrawRequestItemDTO> getDrawRequestItems() {
        return drawRequestItems;
    }

    /**
     * @param drawRequestItems the drawRequestItems to set
     */
    public void setDrawRequestItems(List<DrawRequestItemDTO> drawRequestItems) {
        this.drawRequestItems = drawRequestItems;
    }
}
