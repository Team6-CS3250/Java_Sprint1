/*Just set up a bunch of empty methods, so we can adjust them throughout production
Not sure what imports we may need yet*/
/* READ ME! So far I can get the code to show the entire .txt file of inventory. I'm trying to get it to write to a new file
 * with the line of the product ID and the 4 other fields.  I have not reached this functionality yet, just a start off point
 * that I want to upload to the repository for more iteration*/
import java.util.Scanner;
import java.io.*;



public class InventoryData {

    String productID = "";
    String quantity = "";
    double wholesaleCost = 0;
    double salePrice = 0;
    String supplierID = "";
    //This method calls the other two methods to run and has a while loop print
    public void viewInventory() {
        boolean showInv = true;
        if(showInv) {
            typeProductID();
            response(productID);
        }
    }
    //This method ask the user for an input
    public String typeProductID() {
        Scanner manager = new Scanner(System.in);
        System.out.println("Please enter a 12 digit product ID. (Capitalization matters)");
        String productID = manager.nextLine();
        return productID;

    }
    //This is the method that writes the info from the first file to a second file for easy printing
    public void response(String r) {
        productID = r;
        try{
            FileWriter writer = new FileWriter("ThisInventory.txt");//Calls in proper stuff for uploading the file to write off it
            File fullList = new File("inventory_team6.txt");//New file to be written to
            Scanner writeThis = new Scanner(fullList);//Scanner to write to file
            //While loop to write the file
            while(writeThis.hasNextLine()){
                String thisID = writeThis.nextLine();
                /*I want this if statement to find r and write that line of the spreadsheet.
                 * This functionality isn't achieved yet. I think what needs to be done is the Scanner
                 * needs to know to stop and only print the line that has the actual product ID on it. */
                if(thisID.contains(r)){
                    writer.write("Here is your inventory information " + thisID);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        try{
            File show = new File("ThisInventory.txt");
            Scanner reader = new Scanner(show);
            boolean isPrinting = true;
            System.out.println("\n\n");
            //while loop prints new .txt file
            while(isPrinting) {
                String line = reader.nextLine();
                System.out.println(line);
                isPrinting = false;
            }
            reader.close();
            System.out.println("\n\n");

        }

        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void testFile() {
        //Method to test whether or not my .txt file is formatted properly and the scanner can read it
        try {
            File inv = new File("inventory_team6.txt");
            Scanner reader = new Scanner(inv);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
            System.out.println("\n\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
//Getters and setters might not be useful for the moment
    /*public void setProductID () {
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
    }*/

    }
}