/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assesortron;

import Interfaces.Writeable;
import Objects.ChangeOrderDTO;
import Objects.DrawRequestDTO;
import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.WalkThroughDTO;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author willpassidomo
 */
public class TaskerImpl {
    
//    public static void main (String[] args) {
//        WalkThroughDTO wt1 = new WalkThroughDTO();
//        wt1.setDate(new Date());
//        wt1.setFloor("3");
//        wt1.setNote("this the note that goes along with walkthrough 1");
//        wt1.setProgress("pretty good");
//        WalkThroughDTO wt2 = new WalkThroughDTO();
//        wt2.setDate(new Date());
//        wt2.setFloor("2");
//        wt2.setNote("this in the note that goes along with the second walkthrough");
//        wt2.setProgress("pretty shitty");
//        WalkThroughDTO wt3 = new WalkThroughDTO();
//        wt3.setDate(new Date());
//        wt3.setFloor("B2");
//        wt3.setNote("this is a 2 line note \n which is for walkthrough number-\n  three");
//        wt3.setProgress("average");
//        ChangeOrderDTO co1 = new ChangeOrderDTO();
//        co1.setAmount(54373);
//        co1.setDateSubmitted(new Date());
//        co1.setExecuted(true);
//        co1.setSubContractor("electrical soultions inc");
//        co1.setDescription("this is the description for changeorder number 1");
//        ChangeOrderDTO co2 = new ChangeOrderDTO();
//        co2.setAmount(5342);
//        co2.setDateSubmitted(new Date());
//        co2.setExecuted(false);
//        co2.setSubContractor("cheif plumbing");
//        co2.setDescription("this is the description for changeorder number 2");
//        DrawRequestDTO dr1 = new DrawRequestDTO();
//        dr1.setCurrentRequestString("5000000");
//        dr1.setMaxRequestString("20000");
//        dr1.setMinRequestString("35");
//        dr1.setContingencyDrawString("400");
//        dr1.setContingencyBalanceString("1000000");
//        dr1.setRetainageRelString("10.0");
//        dr1.setBalanceToCompleteString("100002000202020");
//        dr1.setDate(new Date());
//        SiteWalkDTO siteWalk = new SiteWalkDTO();
//        siteWalk.add(co1);
//        siteWalk.add(co2);
//        siteWalk.add(dr1);
//        siteWalk.add(wt1);
//        siteWalk.add(wt2);
//        siteWalk.add(wt3);
//        sendSiteWalkExcel(siteWalk,"");
//    }

    public static boolean sendProjectExcel(ProjectDTO project, String recipient) {
        ExcelConverter doc = new ExcelConverter();
        byte[] excelFile = null;
        String docName = project.getName() +".xls";
        doc.open("testFile");
        for(Writeable ea: project.getWriteables()) {
                ea.visit(doc);
            }
        doc.renderDocument();
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
    
}
