import java.util.Scanner;
/**
Demonstrates the use of the mutator method setName,SetPopulatin,setGrowthRate.
*/
public class CH05_MySpeciesFifthTry
{
	private String name;
	private int population;
	private double growthRate;
	
	public void readInput()	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the species' name?");
		name = keyboard.nextLine( );
		System.out.println("What is the population of the species?");
		keyboard = new Scanner(System.in);
		population = keyboard.nextInt( );
		System.out.println("Enter growth rate (% increase per year):");
		growthRate = keyboard.nextDouble( );
	}
	public void writeOutput()	{
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}
	public int predictPopulation(int years)	{
		int result = 0;
		double populationAmount = population;
		int count = years;
		while ((count > 0) && (populationAmount > 0))
		{
		populationAmount = (populationAmount +
		(growthRate / 100) * populationAmount);
		count--;
		} if (
		populationAmount >
		0)
		result = (int)populationAmount;
		return result;
	}
	public void setSpecies(String newName, int newPopulation, double newGrowthRate)	{
		name = newName;
		if (newPopulation >= 0)
		population = newPopulation;
		else
		{
		System.out.println(
		"ERROR: using a negative population.");
		System.exit(0);
		}
		growthRate = newGrowthRate;
	}
	public String getName()	{
		return name;
	}
	public int getPopulation()	{
		return population;
	}
	public double getGrowthRate() {
		return growthRate;
	}
	public void setName(String newName)	{
		name = newName;
	}
	public void setPopulation(int newPopulation) {
		population = newPopulation;
	}
	public void setGrowthRate(double newGrowthRate)	{
		growthRate = newGrowthRate;
	}
	public static void main(String[] args)
	{
		CH05_MySpeciesFifthTry speciesOfTheMonth = new CH05_MySpeciesFifthTry( );
		System.out.println("Enter number of years to project:");
		Scanner keyboard = new Scanner(System.in);
		int numberOfYears = keyboard.nextInt( );
		System.out.println("Enter data on the Species of the Month:");
		speciesOfTheMonth.readInput( );
		speciesOfTheMonth.writeOutput( );
		int futurePopulation = speciesOfTheMonth.predictPopulation(numberOfYears);
		System.out.println("In " + numberOfYears + " years the population will be " + futurePopulation);
		//Change the species to show how to change
		//the values of instance variables:
		//speciesOfTheMonth.setSpecies("Klingon ox", 10, 15);
		speciesOfTheMonth.setName("Klingon ox");
		speciesOfTheMonth.setPopulation(10);
		speciesOfTheMonth.setGrowthRate(15.0);
		System.out.println("The new Species of the Month:");
		speciesOfTheMonth.writeOutput( );
		futurePopulation = speciesOfTheMonth.predictPopulation(numberOfYears);
		System.out.println("In " + numberOfYears + " years the population will be " + futurePopulation);
	}
}