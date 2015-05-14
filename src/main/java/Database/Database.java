/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Objects.ChangeOrderDTO;
import Objects.DrawRequestDTO;
import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.WalkThroughDTO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 *
 * @author willpassidomo
 */
public class Database {
    private static PersistenceManager pm;
    
    private static List<String> stringValues = new ArrayList<String>();
    private static List<WalkThroughDTO> walkThroughs = new ArrayList<WalkThroughDTO>();
    

    
    public static void storeProject(ProjectDTO project) {
        //TODO
        //should this go here, since it is totally neccessary for retreival
        //that the project field is not null, as a validation type check?
        for (WalkThroughDTO wt: project.getWalkThroughs()) {
            wt.setProject(project);
        }
        for (ChangeOrderDTO co: project.getChangeOrders()) {
            co.setProject(project);
        }
        for (DrawRequestDTO dr: project.getDrawRequests()) {
            dr.setProject(project);
        }
        
        pm = PMF.get().getPersistenceManager();
        try
        {
            pm.makePersistent(project);
        }
        finally 
        {
            pm.close();
        }
    }
    
    public static ProjectDTO getProject(String projectId) {
        Key key = KeyFactory.createKey(ProjectDTO.class.getSimpleName(), projectId);
        return pm.getObjectById(ProjectDTO.class, key);
    }
    
    public static ProjectDTO getProject2(String projectId) {
        return pm.getObjectById(ProjectDTO.class, projectId);
    }
    
    public static ProjectDTO getProject3(String projectId) {
        Key key = KeyFactory.createKey(ProjectDTO.class.getSimpleName(), projectId);
        ProjectDTO project = pm.getObjectById(ProjectDTO.class, key);
        project.getWalkThroughs();
        project.getDrawRequests();
        project.getChangeOrders();
        return project;
    }
    
    public static List<ProjectDTO> getProjects(String userId) {
        pm = PMF.get().getPersistenceManager();
        List<ProjectDTO> projects = null;
        try {
            Query query = pm.newQuery(ProjectDTO.class, "");
            projects = (List<ProjectDTO>)query.execute();
            return projects;
        }
        finally {
            pm.close();
        }
    }
    
    
    
    
    public static File retrievePicture(UUID picUUID) {
        return null;
    }
    
    public static void storeStringValues(List<String> stringValues1) {
        stringValues = stringValues1;
    }
    
    public static List<String> getStringValues() {
        return stringValues;
    }

    
    public static List<WalkThroughDTO> getWalkThroughValues() {
        return walkThroughs;
    }
    
    public static void storeSiteWalk(SiteWalkDTO siteWalk) {
        walkThroughs.addAll(siteWalk.getWalkThroughs());
    }

}
