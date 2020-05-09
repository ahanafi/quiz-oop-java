/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Ahmad Hanafi
 */
public class Item {
    private int ID;
    private String NAME;
    
    public Item(int idData, String nama) {
        this.ID = idData;
        this.NAME = nama;
    }
    
    public int getId() {
        return ID;
    }

    public String getName() {
        return NAME;
      }

    @Override
    public String toString() {
        return NAME;
    }   
}

class ItemRenderer extends BasicComboBoxRenderer {
  
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null) {
                Item item = (Item) value;
                setText(item.getName());
        }
        if (index == -1) {
                Item item = (Item) value;
                setText(item.getId() + "");
        }
        return this;
    }
}
