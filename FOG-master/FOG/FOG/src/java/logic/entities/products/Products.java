/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entities.products;

/**
 *
 * @author Runej
 */
public class Products {

    private int productID;
    int productHeight;
    int productLength;
    private String category;
    private String subCategory;
    private String name;
    private int price;

    public Products(int productID, String category, String subCategory, String name,int productHeight, int productLength, int price) {
        this.productID = productID;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.productHeight = productHeight;
        this.productLength = productLength;
        this.price = price;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the subCategory
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    public int getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(int productHeight) {
        this.productHeight = productHeight;
    }

    public int getProductLength() {
        return productLength;
    }

    public void setProductLength(int productLength) {
        this.productLength = productLength;
    }

    
   }
