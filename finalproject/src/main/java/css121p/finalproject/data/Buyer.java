/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package css121p.finalproject.data;

/**
 *
 * @author Jan Denisse
 */
public class Buyer {
    //aggregation relationship: a buyer HAS-A lot
    
    private String name;
    private String contactNumber;
    
    public Buyer (String name, String contactNumber){
        this.name = name;
        this.contactNumber = contactNumber;
    }
    
    public String getBuyer(){
        return name;
    }
}
