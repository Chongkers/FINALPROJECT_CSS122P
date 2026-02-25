/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject.UI;

import css121p.finalproject.data.Lot;
import static css121p.finalproject.data.Status.AVAILABLE;
import static css121p.finalproject.data.Status.RESERVED;
import static css121p.finalproject.data.Status.SOLD;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Font;


/**
 *
 * @author Jan Denisse
 */
public class HouseGrid extends JPanel{
    private Lot lot;
    private JLabel numberLabel;
    
    public HouseGrid(Lot lot){
        
        
        this.setLayout(new GridBagLayout());
        
        this.numberLabel = new JLabel(String.valueOf(lot.getHouseNo()));
        this.numberLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
        this.numberLabel.setForeground(Color.BLACK);
        
        this.add(numberLabel);
        
        this.lot = lot;
        this.setMinimumSize(new java.awt.Dimension(25, 25));
        updateColor();
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                triggerDetailsPopup(lot);       
            }
        });
    }
    
    public void updateColor(){
        switch(lot.getHouseStatus()){
            case AVAILABLE -> setBackground(Color.GREEN);
            case RESERVED -> setBackground(Color.YELLOW);
            case SOLD -> setBackground(Color.RED)   ;
        }
        this.repaint();
        setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    private void triggerDetailsPopup(Lot lot) {
        String output = css121p.finalproject.database.InventorySystem.getInstance()
                    .reportLot(lot.getBlockNo(), lot.getHouseNo());
        javax.swing.JOptionPane.showMessageDialog(this, output, "Lot Information", javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
    
}
