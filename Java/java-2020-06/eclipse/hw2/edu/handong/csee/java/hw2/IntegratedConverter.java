package edu.handong.csee.java.hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.handong.csee.java.hw2.converters.*; // You will learn the import statement in L11.

/**
 * This class converts the units entered with other units
 */

public class IntegratedConverter {

    private double fromValue;
    /**
     * This main function activates 'IntegratedConverter' 
     * @param args This parameter is number, number's unit and the other unit uwer want to change to
     */
    public static void main(String[] args) {

        IntegratedConverter myConverter = new IntegratedConverter();

        myConverter.run(args);

    }
    /**
     * This function convert number depending entered units
     * @param args This returned parameter is number, number's unit and the other unit uwer want to change to
     */
    private void run(String[] args) {

        fromValue = Double.parseDouble(args[0]);
        String originalMeasure = Util.getUppercaseString(args[1]);
        String targetMeasure = Util.getUppercaseString(args[2]);

        if(!targetMeasure.equals("ALL")) {

            String converterName = "edu.handong.csee.java.hw2.converters." + originalMeasure + "To" + targetMeasure + "Converter";

            // You will learn about the try-catch block and Exception in L19
            try {

                // Advanced Java feature: Reflection (it lets us use classes with their String class names.)
                // (JC does not teach this topic as it is advanced one but you can study by yourself!!)
                // https://www.oracle.com/technical-resources/articles/java/javareflection.html
                Class<?> converterClass = (Class<?>) Class.forName(converterName);
                Constructor<?> constructor = (Constructor<?>) converterClass.getConstructor();
                Convertible myConverter = (Convertible) constructor.newInstance();
                myConverter.setFromValue(fromValue);
                myConverter.convert();
                System.out.println(fromValue +" " + originalMeasure + " is " + myConverter.getConvertedValue() + " " + targetMeasure + "!");

            } catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                System.out.println("The converter (" + converterName + ") for " + originalMeasure + " to " + targetMeasure + " does not exist!!");
            }

        } else {

            AllConverter myAllConverter = new AllConverter();
            // When your method returns `this' in methods of AllConverter, you can call them in this way (method chaining).
            // Think/understand how and why this work. Study and search for Method chaining
            // https://stackoverflow.com/questions/21180269/how-to-achieve-method-chaining-in-java
            // https://www.geeksforgeeks.org/method-chaining-in-java-with-examples/#:~:text=Method%20Chaining%20is%20the%20practice,with%20a%20(dot.).
            myAllConverter.setFromValue(fromValue).setOriginalMeasure(originalMeasure).convertAndPrintOut();
        }
    }
}

