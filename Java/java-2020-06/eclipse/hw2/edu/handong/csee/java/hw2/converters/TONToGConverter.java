package edu.handong.csee.java.hw2.converters;
/**
 * This class changes TON to G and implements Convertible class
 */
public class TONToGConverter implements Convertible{

    private double fromValue;
    /**This function accepts the number entered by user internally
     * @param fromValue The number entered by user
     */
    public void setFromValue(double fromValue){
        this.fromValue = fromValue;
    }
    /**
     * This function converts number's unit according ( 1 TON = 1000000 G )
     */
    public void convert(){
        fromValue =  fromValue*1000000;
    }
    /**
     * This function return converted value
     */
    public double getConvertedValue(){
        return fromValue;
    }
    
}
