package edu.handong.csee.java.hw2.converters;
/**
* This class changes KM to M and implements Convertible class
*/
public class KMToMConverter implements Convertible{
    
    private double fromValue;
    /**This function accepts the number entered by user internally
     * @param fromValue The number entered by user
     */
    public void setFromValue(double fromValue){
        this.fromValue = fromValue;
    }
    /**
     * This function converts number's unit according ( 1 KM = 1000 M )
     */
    public void convert(){
        fromValue =  fromValue*1000;
    }
    /**
     * This function return converted value
     */
    public double getConvertedValue(){
        return fromValue;
    }
    
}
