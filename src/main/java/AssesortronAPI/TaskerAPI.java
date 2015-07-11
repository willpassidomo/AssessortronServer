/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssesortronAPI;

import Assesortron.Emailer;
import Assesortron.TaskerImpl;
import Database.Database;
import Objects.FieldValueDTO;
import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.StringWrapper;
import Objects.WalkThroughDTO;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willpassidomo
 */

@Api(name = "assesortronTaskerAPI",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "AssesorTron",
                ownerName = "AssesorTron",
                packagePath = ""),
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
            Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)


public class TaskerAPI {
    
    public StringWrapper sendProjectExcel(ProjectDTO project, @Named("recipient")String recipient) {
        //Database.storeProject(project);
        if(TaskerImpl.sendProjectExcel(project, recipient)) {
            return new StringWrapper("true");
        } else {
            return new StringWrapper("false");
        }
    }
    
    public StringWrapper sendSiteWalkExcel(SiteWalkDTO siteWalk, @Named("recipient")String recipient) {
        if(TaskerImpl.sendSiteWalkExcel(siteWalk, recipient)) {
            return new StringWrapper("success!");
        } else {
            return new StringWrapper("Message FAILED");
        }
    }
    
    public StringWrapper testEmail(@Named("recipient")String recipient, @Named("fileName")String fileName) {
        Emailer emailer = new Emailer();
        emailer.sendDefaultMail(recipient, recipient, new byte[1000], fileName);
        return new StringWrapper("stuff");
    }
    
    public List<String> getStringTests() {
        return Database.getStringValues();
    }
    
    public StringWrapper submitTestList(@Named("stringvalues")List<String> stringValues) {
        String strings = "";
        for (String string: stringValues) {
            strings += string + "\n";
        }
        Database.storeStringValues(stringValues);
        return new StringWrapper(strings);
    }
    
    public StringWrapper submitSiteWalk(SiteWalkDTO siteWalk) {
        Database.storeSiteWalk(siteWalk);
        return new StringWrapper(siteWalk.getWalkThroughs().size()+" SiteWalks Recieved");
    }
    
    public StringWrapper submitProject(ProjectDTO project) {
        if (project != null) {
            if (project.getName()!= null) {
                Database.storeProject(project);
            } else return new StringWrapper("walkThroughs was null");
        } else {
            return new StringWrapper("project was null");
        }
        return new StringWrapper(project.getSiteWalks().size()+"");
    }

    
    public List<WalkThroughDTO> getWalkThroughs() {
        return Database.getWalkThroughValues();
    }
    
    
    public ProjectDTO getProjectA(@Named("projectId") String projectId) {
        return Database.getProject("username");
    }
    
    public List<ProjectDTO> getProjects() {
        return Database.getProjects("");
    }
    
    public List<FieldValueDTO> getFieldValues(@Named("projectId") String projectId) {
        return null;
    }
    
    
 /**
    public ProjectDTO getProjectB(@Named("projectId") String projectId) {
        return Database.getProject2("username");
    }
    
    public ProjectDTO getProjectsC(@Named("projectId") String ProjectId) {
        return Database.getProject3("username");
    }
    **/
    //CRUD project;
    //CRUD DrawRequestl
    //CRUD SiteWalkDTO
    //CRUD ChangeOrder
    //CRUD WalkThrough
    //CRUD images for use classes
    //
    
    //login, locations, 
}
