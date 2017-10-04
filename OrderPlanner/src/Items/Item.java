/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;


/**
 *
 * @author ajpap
 */
public class Item {  
    private String productID;
    private float price;
    private float pv;
    private String name;
    private String description;
    private String type;
    private String size;
    
    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }
    
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    
    public float getPV() { return pv; }
    public void setPV(float pv) { this.pv = pv; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public  String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getSize() { return size; };
    public void setSize(String size) { this.size = size; }
    
}

