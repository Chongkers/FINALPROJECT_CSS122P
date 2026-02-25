/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject.data;

/**
 *
 * @author Jan Denisse
 */
import java.text.NumberFormat;
import java.util.Locale;
public class CornerLot extends Lot{
    
    
    public CornerLot(int blockNo, int houseNo, double sqMeters, double pricePerSqMeters, Status houseStatus){
        super(blockNo, houseNo, sqMeters, pricePerSqMeters, houseStatus);
        setHouseNo(houseNo);
        setSqMeters(sqMeters);
        setPricePerSqMeters(pricePerSqMeters);
        this.houseStatus = houseStatus;
        this.blockNo = blockNo;

    }
    
    // inner lot costs P 50,833 * 120-125 sqm 
    
    @Override
    public double calculateFinalprice(){
       return sqMeters*pricePerSqMeters;
    }
}
