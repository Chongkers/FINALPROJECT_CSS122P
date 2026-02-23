/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject;

/**
 *
 * @author Jan Denisse
 */
import java.text.NumberFormat;
import java.util.Locale;
public class CornerLot extends Lot{
    
    
    public CornerLot(int houseNo, double sqMeters, double pricePerSqMeters, Status houseStatus){
        super(houseNo, sqMeters, pricePerSqMeters, houseStatus);
        setHouseNo(houseNo);
        setSqMeters(sqMeters);
        setPricePerSqMeters(pricePerSqMeters);
        this.houseStatus = houseStatus;
    }
    
    // inner lot costs P 50,833 * 120-125 sqm 
    
    @Override
    public double calculateFinalprice(){
       return sqMeters*pricePerSqMeters;
    }
}
