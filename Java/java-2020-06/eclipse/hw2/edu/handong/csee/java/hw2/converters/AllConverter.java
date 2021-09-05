package edu.handong.csee.java.hw2.converters;
/**This class converts entered number to two other units */
public class AllConverter {

    private double fromValue;
    private String originalMeasure;
    /**declare AllConverter class */
    public AllConverter(){}
    /**This accepts the number entered by user internally
     * @param fromValue The number entered by user
     */
    public AllConverter setFromValue(double fromValue){ 
        this.fromValue = fromValue;
        return this;
    }
    /**This accepts the measure entered by user internally
     * @param originalMeasure The unit enterd by user
     */
    public AllConverter setOriginalMeasure(String originalMeasure){
        this.originalMeasure = originalMeasure;
        return this;
    }
    /**This function convert the measure to two different measures  */
    public void convertAndPrintOut(){
            if(originalMeasure == "TON"){
                TONToGConverter ton_g = new TONToGConverter();
                ton_g.setFromValue(fromValue); ton_g.convert();
                System.out.println(fromValue +" " + originalMeasure + " is " + ton_g.getConvertedValue() + " G");
                TONToKGConverter ton_kg = new TONToKGConverter();
                ton_kg.setFromValue(fromValue); ton_kg.convert();
                System.out.println(fromValue +" " + originalMeasure + " is " + ton_kg.getConvertedValue() + " KG");
            }
            else{
                KMToMConverter km_m = new KMToMConverter();
                km_m.setFromValue(fromValue); km_m.convert();
                System.out.println(fromValue +" " + originalMeasure + " is " + km_m.getConvertedValue() + " M");
                KMToMILEConverter km_mile = new KMToMILEConverter();
                km_mile.setFromValue(fromValue); km_mile.convert();
                System.out.println(fromValue +" " + originalMeasure + " is " + km_mile.getConvertedValue() + " MILE");
            }
        
    }
}
