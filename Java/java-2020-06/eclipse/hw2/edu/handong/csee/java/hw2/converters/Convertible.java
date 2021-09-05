package edu.handong.csee.java.hw2.converters;
/**
* This interface convert unit to other unit
*/
public interface Convertible {
    /**This function accepts the number entered by user internally
     * @param fromValue The number entered by user
     */
    public void setFromValue(double fromValue);
    /**
     * This function return converted value
     */
    public double getConvertedValue();
    /**
     * This function converts number's unit
     */
    public void convert();

}