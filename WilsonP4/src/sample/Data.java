/*
Jordan Wilson - jwilson160@cnm.edu
WilsonP4
Data
 */
package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    //data variables
    private String name;
    private String email;
    private String weight;
    private double length;
    private String material;
    private String cork;
    private String extras;
    private double price;

    private List<String> extraList = new ArrayList<String>();
    private String extraString;

    //constructor
    public Data(){

    }
    //file text
    @Override
    public String toString(){
        return "Custom order details: \nName: "+name+
                "\nEmail: "+email+"\nRod Weight: "+weight+
                "\nLength: "+length+" ft\nRod Material: "+material+
                "\nGrip Style: "+cork+"\nExtras: \n"+extraString+
                "\nBudget: $"+price;
    }
    //getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCork() {
        return cork;
    }

    public void setCork(String cork) {
        this.cork = cork;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
        extraList.add(extras);
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //building string for extras selected
    public void buildExtras(){
        if(extraList.size() == 0){
            extraString = "None";
        }
        if(extraList.size()==1){
            extraString = extraList.get(0) + "\n";
        }
        if(extraList.size()==2){
            extraString = extraList.get(0) + "\n" + extraList.get(1);
        }
        if(extraList.size()==3){
            extraString = extraList.get(0) + "\n" + extraList.get(1) + "\n" + extraList.get(2);
        }
    }

    //write file
    public void writeFile(File file){
        try{
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this.toString());

            out.close();
        }catch (IOException e){
            System.out.println("Error."+e.getMessage());
        }
    }
}
