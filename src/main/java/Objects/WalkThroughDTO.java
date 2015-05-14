package Objects;


import Interfaces.Writeable;
import Interfaces.Writer;
import java.util.ArrayList;
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
public class WalkThroughDTO implements Writeable {
    @Persistent
    private String id;
    @Persistent
    private ProjectDTO project;
    @Persistent(defaultFetchGroup = "true")
    private Date date;
    @Persistent(defaultFetchGroup = "true")
    private String floor;
    @Persistent(defaultFetchGroup = "true")
    private String Trade;
    @Persistent(defaultFetchGroup = "true")
    private String Progress;
    @Persistent(defaultFetchGroup = "true")
    private String notes;
    @Persistent(defaultFetchGroup = "true")
    private List<UUID> pictures = new ArrayList<UUID>();

    public WalkThroughDTO() {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public WalkThroughDTO(String nothing) {}

    public static WalkThroughDTO getDBWalkThrough() {
        return new WalkThroughDTO("");
    }

    public void setNote(String note) {
        this.setNotes(note);
    }

    public String getNotes() {
        return notes;
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

    public void setDateString(String stringDate) {
        this.date = new Date(stringDate);
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTrade() {
        return Trade;
    }

    public void setTrade(String trade) {
        Trade = trade;
    }

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public void addSitePicture(UUID pictureUri) {
        this.pictures.add(pictureUri);
    }

    public void removeSitePicture(UUID pictureUri) {
        this.pictures.remove(pictureUri);
    }

    public void removeSitePicture(int i) {
        this.pictures.remove(i);
    }

    public List<UUID> getPictures() {
        return this.pictures;
    }

    public UUID getPicture(int i) {
        return this.pictures.get(i);
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSitePictures(List<UUID> pictures) {
        this.pictures = pictures;
    }

    public void addSitePicture(String stringUri) {
        UUID uuid = (UUID.fromString(stringUri));
        addSitePicture(uuid);
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
