/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
    private static PersistenceManagerFactory pmfInstance = null;

    private PMF() {}

    public static PersistenceManagerFactory get() {
        if (pmfInstance == null) {
            pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");
        }
        return pmfInstance;
    }
}