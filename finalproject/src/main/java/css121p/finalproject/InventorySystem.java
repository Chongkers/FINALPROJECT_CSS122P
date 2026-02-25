/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject.database;
import css121p.finalproject.data.Lot;
import css121p.finalproject.data.Status;
import css121p.finalproject.data.Buyer;
import css121p.finalproject.data.Block;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jan Denisse
 */
public class InventorySystem {
    private int x,y;
    private static final InventorySystem INSTANCE = new InventorySystem();
    private Block blocks[] = new Block[5];
    private InventorySystem(){initializeBlocks();}
    String[] columns = {"Block", "Lot Number", "Status", "Square Meters", "Price", "Resident"};
    public DefaultTableModel tableReport = new DefaultTableModel(columns, 0);
    
    
    public void initializeBlocks(){
        for(int i = 0; i < 5; i++){
            blocks[i] = new Block(i+1);
        }
    }
    
    public static InventorySystem getInstance(){
        return INSTANCE;
    }        

    
    public void reportLot(){
        
        for(int i = 0; i<getBlocks().length; i++){
            // we get the current block in the array, we directly call the block array.
            Block currentBlock = blocks[i];
            // we then get the array of 20 lots inside one block, we have to use a getter.
            Lot lotsInBlock[] = currentBlock.getLots();
            for(int j = 0; j<currentBlock.getLots().length; j++){
                Lot currentLot = lotsInBlock[j];
                Object[] rowData = {currentBlock.getBlockNo(), currentLot.getHouseNo(), currentLot.getHouseStatus(), currentLot.getSqMeters(), currentLot.calculateFinalprice(), currentLot.getResidentName()};
                tableReport.addRow(rowData);
            }
            
        }
    }
    
    public Lot findLot(int FindBlockNumber, int FindLotNumber){
        for(Block b : blocks){
            if(b.getBlockNo() == FindBlockNumber){
                Lot[] currentLot = b.getLots();
                if (FindLotNumber > 0 && FindLotNumber <= 20){
                    return currentLot[FindLotNumber-1];
                }
            }
        }
        return null;
    }
    
    public Block[] getBlocks(){
        return blocks;
    }
    
    public void processPurchase(Buyer buyer, int x, int y){
        Lot targetLot = findLot(x,y);
        
            if (targetLot.getHouseStatus() == Status.AVAILABLE || targetLot.getHouseStatus() == Status.RESERVED ){
                targetLot.sellTo(buyer.getBuyer());
                targetLot.Sold();
                System.out.println("Transaction complete! "+" Block "+x+" Lot "+y+" is now acquired by "+buyer.getBuyer());
                tableReport.setRowCount(0);
                reportLot();
            } else {System.out.println("This lot is already taken!");}
            
    }
    
    public void processReservation(Buyer buyer, int x, int y){
        Lot targetLot = findLot(x,y);
        
            if (targetLot.getHouseStatus() == Status.AVAILABLE){
                targetLot.sellTo(buyer.getBuyer());
                targetLot.Reserve();
                System.out.println("Reservation complete! "+" Block "+x+" Lot "+y+" is now reserved by "+buyer.getBuyer());
                tableReport.setRowCount(0);
                reportLot();
            } else {System.out.println("This lot is already taken!");}
            
    }
    
    public void processSell(Buyer buyer, int x, int y){
        Lot targetLot = findLot(x,y);
        
            if (targetLot != null){
                targetLot.Available();
                targetLot.sellTo(null);
            }
            tableReport.setRowCount(0);
            reportLot();
    }
    
    public Status getLotStatus(int x, int y){
        Lot targetLot = findLot(x,y);
            if (targetLot == null){return null;}
        return targetLot.getHouseStatus();
    }
    
    public String reportLot(int x, int y){
        Lot targetLot = findLot(x,y);
        String formattedPrice = String.format("%,.2f", targetLot.calculateFinalprice());

        
        if(targetLot != null){
            return ("--- Lot Information ---\n" +
               "Lot: " + targetLot.getHouseNo() + "\n" +
               "Block: " + targetLot.getBlockNo() + "\n" +
               "Status: " + targetLot.getHouseStatus() + "\n" +
               "Area: " + targetLot.getSqMeters() + " sqm\n" +
               "Price: PHP " + formattedPrice);
        }
        else {return ("Error: Lot not found at Block " + x + ", Lot " + y);}
    }
}
