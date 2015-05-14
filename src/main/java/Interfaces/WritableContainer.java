/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.util.List;

/**
 *
 * @author willpassidomo
 */
public interface WritableContainer {
    public List<Writeable> getWriteables();
    public void add(Writeable writeable);
    public Writeable remove(Writeable writeable);
    public void update(Writeable writeable);
    public List<Writeable> removeAll(Writeable writeable);
}
