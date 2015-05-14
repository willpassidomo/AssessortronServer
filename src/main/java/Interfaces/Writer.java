/*
 * To change this license header, choose License Headers in ProjectDTO Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.ChangeOrderDTO;
import Objects.DrawRequestDTO;
import Objects.WalkThroughDTO;

/**
 *
 * @author willpassidomo
 */
public interface Writer {
    public void write(ChangeOrderDTO changeOrder);
    public void write(DrawRequestDTO drawRequest);
    public void write(ProjectDTO project);
    public void write(SiteWalkDTO siteWalk);
    public void write(WalkThroughDTO walkThrough);
}
