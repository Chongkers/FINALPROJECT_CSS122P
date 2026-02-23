/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject;

/**
 *
 * @author Jan Denisse
 */
public abstract class Lot {
    protected int houseNo;
    protected double sqMeters;
    protected double pricePerSqMeters;
    protected Status houseStatus;
    protected String resident;
    
    
    public Lot(int houseNo, double sqMeters, double pricePerSqMeters, Status houseStatus){
        setHouseNo(houseNo);
        setSqMeters(sqMeters);
        setPricePerSqMeters(pricePerSqMeters);
        this.houseStatus = Status.AVAILABLE;
    }
    
    // setters so that lot, sqMeters and pricePerSqMeters are not 0 or a negative integer.
    
    public void setHouseNo(int houseNo){
        if(houseNo <= 0){
            throw new IllegalArgumentException("Negative values are invalid");
        } else {this.houseNo = houseNo;}
    } 
    
    public void setSqMeters(double sqMeters){
        if(sqMeters <= 0){
            throw new IllegalArgumentException("Negative values are invalid");
        } else {this.sqMeters = sqMeters;}
    } 
    
    public void setPricePerSqMeters(double pricePerSqMeters){
        if(pricePerSqMeters <= 0){
            throw new IllegalArgumentException("Negative values are invalid");
        } else {this.pricePerSqMeters = pricePerSqMeters;}
    } 
    
    //getters
    
    public int getHouseNo(){
        return houseNo;
    }
    
    public double getSqMeters(){
        return sqMeters;
    }
    
    public double getPricePerSqMeters(){
        return pricePerSqMeters;
    }
    
    public Status getHouseStatus(){
        return houseStatus;
    }
    
    public String getResidentName(){
        if(resident!=null){
            return resident;
        }
        else {return "VACANT";}
    }
    
    // status setters
    
    public void reserve(){
        houseStatus = Status.RESERVED;
    }
    
    public void sold(){
        houseStatus = Status.SOLD;
    }
    
    public void available(){
        houseStatus = Status.AVAILABLE;
    }
    
    public void sellTo(String name){
        this.resident = name;
    }
    
    public void reserveTo(String name){
        this.resident = name;
    }
    
    public abstract double calculateFinalprice();
}


