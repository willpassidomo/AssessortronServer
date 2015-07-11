/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assesortron;

import Objects.DrawRequestDTO;
import Objects.DrawRequestItemDTO;
import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.WalkThroughDTO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author willpassidomo
 */
public class TaskerImpl {
    
    public static void main (String[] args) {
        WalkThroughDTO wt1 = new WalkThroughDTO();
        wt1.setDate(new Date());
        wt1.setFloor("3");
        wt1.setNote("this the note that goes along with walkthrough 1");
        wt1.setProgress("pretty good");
        WalkThroughDTO wt2 = new WalkThroughDTO();
        wt2.setDate(new Date());
        wt2.setFloor("2");
        wt2.setNote("this in the note that goes along with the second walkthrough");
        wt2.setProgress("pretty shitty");
        WalkThroughDTO wt3 = new WalkThroughDTO();
        wt3.setDate(new Date());
        wt3.setFloor("B2");
        wt3.setNote("this is a 2 line note \n which is for walkthrough number-\n  three");
        wt3.setProgress("average");
        DrawRequestItemDTO drI1 = new DrawRequestItemDTO();
        drI1.setType("Stored Materials");
        drI1.setAmount(54373);
        drI1.setDateSubmitted(new Date());
        drI1.setExecuted(true);
        drI1.setSubContractor("electrical soultions inc");
        drI1.setDescription("this is the description for changeorder number 1");
        DrawRequestItemDTO drI2 = new DrawRequestItemDTO();
        drI2.setType("Change Order");
        drI2.setAmount(5342);
        drI2.setDateSubmitted(new Date());
        drI2.setExecuted(false);
        drI2.setSubContractor("cheif plumbing");
        drI2.setDescription("this is the description for changeorder number 2");
        DrawRequestItemDTO drI3 = new DrawRequestItemDTO();
        drI3.setType("Stored Materials");
        drI3.setAmount(33.22);
        drI3.setDateSubmitted(new Date());
        drI3.setExecuted(true);
        drI3.setSubContractor("this guy over here");
        drI3.setDescription("d d d d d a sd a sd a ds avabdfbdsfasdf 1234");
        DrawRequestDTO dr1 = new DrawRequestDTO();
        dr1.setCurrentRequestString("5000000");
        dr1.setCurrentRecommendationString("200");
        dr1.setConditions("you gotta do some stuff for conditions");
        
        List<DrawRequestItemDTO> dris = new ArrayList<>();
        dris.add(drI1);
        dris.add(drI2);
        dris.add(drI3);
        
        List<WalkThroughDTO> wts = new ArrayList<>();
        wts.add(wt1);
        wts.add(wt2);
        wts.add(wt3);
        
        dr1.setDrawRequestItems(dris);
        dr1.setDate(new Date());
        SiteWalkDTO siteWalk = new SiteWalkDTO();
        siteWalk.setTimeStarted(new Date());
        siteWalk.setDrawRequest(dr1);   
        siteWalk.setWalkThroughs(wts);
     
        sendSiteWalkExcel(siteWalk,"");
    }

    public static boolean sendProjectExcel(ProjectDTO project, String recipient) {
        ExcelConverter doc = new ExcelConverter();
        byte[] excelFile = null;
        String docName = project.getName() +".xls";
        doc.open("testFile");
        doc.renderProject(project);
        try {
            excelFile = doc.saveDocument();
        } catch (IOException ex) {
            Logger.getLogger(TaskerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
        Emailer emailer = new Emailer();
        emailer.sendDefaultMail(recipient, "default AT user", excelFile, docName);

        return true;
        
    }
    
    public static boolean sendSiteWalkExcel(SiteWalkDTO siteWalk, String recipient) {
        ExcelConverter doc = new ExcelConverter();
        byte[] excelFile = null;
        String docName = siteWalk.getProjectName() + "_SiteWalk_" + siteWalk.getTimeStarted().getMonth() + "/" + siteWalk.getTimeStarted().getDay();
        doc.open("testFile");
        doc.renderSiteWalks(siteWalk);
        try {
            excelFile = doc.saveDocument();
        }
        catch (IOException ex) {
            Logger.getLogger(TaskerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        Emailer emailer = new Emailer();
        return emailer.sendDefaultMail(recipient, "default AT user", excelFile, docName);
    }
    
}
