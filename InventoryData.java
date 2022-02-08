//Just set up a bunch of empty methods, so we can adjust them throughout production
//Not sure what imports we may need yet

//import

public class InventoryData {

    String productID = "";
    String quantity = "";
    double wholesaleCost = 0;
    double salePrice = 0;
    String supplierID = "";

    public void setProductID () {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setQuantity() {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setWholesaleCost() {
        this.wholesaleCost = wholesaleCost;
    }

    public double getWholesaleCost() {
        return wholesaleCost;
    }

    public void setSalePrice() {
        this.salePrice = salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSupplierID() {
        this.supplierID = supplierID;
    }

    public String getSupplierID() {
        return supplierID;
    }
}
