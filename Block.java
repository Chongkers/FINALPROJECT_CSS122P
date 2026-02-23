/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author Jan Denisse
 */
public class Block {
    private int blockNo;
    private Lot lots[]; 
    private double randomizedSq;
    
    public Block(int blockNo){
       setBlockNo(blockNo);
       this.lots = new Lot[20];
       createLots();
    }
    
    public void setBlockNo(int blockNo){
        if(blockNo > 5){
            throw new IllegalArgumentException("Maximum of 5 blocks are allowed");
        } else {this.blockNo = blockNo;}
    }
    
    public Lot[] getLots(){
        return lots;
    }
    
    public int getBlockNo(){
        return blockNo;
    }
    
    public void createLots(){
        for(int i = 0; i < 20; i++){
            if(i == 0 || i == 19){
                randomizedSq = ThreadLocalRandom.current().nextInt(120, 125);
                lots[i] = new CornerLot(i+1, randomizedSq, 57230, Status.AVAILABLE);
            } else {
                randomizedSq = ThreadLocalRandom.current().nextInt(100, 105);
                lots[i] = new InnerLot(i+1, randomizedSq, 50833, Status.AVAILABLE);
            }
            }
        }
    
 }
