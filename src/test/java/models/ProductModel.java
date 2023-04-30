package models;

import java.util.Map;

public class ProductModel {
    public String ProductName;
    public String ProductPrice;
    public String ProductQuantity;

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.ProductPrice = productPrice;
    }

    public void setProductQuantity(String productQuantity) {
        this.ProductQuantity = productQuantity;
    }

    public static ProductModel addProduct(Map<String, String> entry){
        ProductModel productModel = new ProductModel();
        productModel.setProductName(entry.get("ProductName"));
        productModel.setProductPrice(entry.get("ProductPrice"));
        productModel.setProductQuantity(entry.get("ProductQuantity"));
        return productModel;
    }
}
