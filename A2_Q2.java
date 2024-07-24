//****************************************************************
//Assignment 2
//Written by Jaden Wright-Maurais
//****************************************************************
/*This program will customize a customers pizza order online (with different 
toppings at different sizes) and calculate the final price.*/

import java.util.Scanner;

public class A2_Q2 {

	public static void main(String[] args) {
		
		String pizzaSize = "", toppings = "";
		int size = 0,topping = 0, preparingPizza = 1;
		float totalPrice=0, pricePizza = 0, topPrice = 0, finalPrice = 0;
		//constant prices for size
		final float smallPizza = 10.0f, mediumPizza = 12.0f, largePizza = 14.0f;
		//constant prices for toppings 
		final float pepperoni = 2.5f, sausage = 2.5f, pineapple = 2.0f, beef = 3.5f, chicken= 2.5f, mushroom = 2.0f;
		
		Scanner In = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("   Welcome to Online Pizza Delivery");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("    How many pizzas are you ordering?");
		int numPizzas = In.nextInt();
		
		//repeating order for each pizza user wants
		for (numPizzas = numPizzas; numPizzas>0 ;numPizzas -=1,preparingPizza +=1,finalPrice += totalPrice) 
		{
			
			do//validating user input for size of pizza
			{
				System.out.println("\nLet us customize your #" + preparingPizza + " pizza! Please enter the size (1-3):"
					+ "\n        1. Small;\n        2. Medium;\n        3. Large;");
				size = In.nextInt();
				if (size <= 0 || size >3)
					System.out.println("Wrong input, please choose (1-3).");
			}
			while ( size <= 0 || size >3);
			
			switch (size) {
				case 1:
					pizzaSize = "small" ;
					pricePizza = smallPizza;
					break;
				case 2: 
					pizzaSize = "medium";
					pricePizza = mediumPizza;
					break;
				case 3:
					pizzaSize = "large";
					pricePizza = largePizza;
					break;
			}
			
			totalPrice = pricePizza;
			System.out.println("Pizza #" +preparingPizza+ " size: " + pizzaSize );
			
		
					
			do//repeating until user doesn't want toppings 
			{
				//Validating user input for toppings
				do 
				{
					System.out.println("Now let's add toppings. What toppings do you want? Please choose (1-7):"
						+ "\n        1. Sausage;\n        2. Pepperoni;\n        3. Pineapple;"
						+ "\n        4. Beef;\n        5. Chicken;\n        6. Mushroom;\n        7. No Toppings.");
					topping = In.nextInt();
					if (topping <= 0 || topping > 7)
						System.out.println("Wrong input, please choose (1-7).");
				}
				while ( topping <= 0 || topping > 7);
					

				switch (topping) 
				{
					case 1:
						toppings = "Sausage";
						topPrice = sausage;
						break;
					case 2:
						toppings = "Pepporoni";
						topPrice = pepperoni;
						break;
					case 3:
						toppings = "Pineapple";
						topPrice = pineapple;
						break;
					case 4: 
						toppings = "Beef";
						topPrice = beef;
						break;
					case 5:
						toppings = "Chicken";
						topPrice = chicken;
							break;
					case 6:
						toppings = "Mushroom";
						topPrice = mushroom;
						break;
				}
					
				if (topping != 7) 
				{
					System.out.println("Topping #1 is selected: " + toppings);
					totalPrice = totalPrice +topPrice;
				}
				
			}
			while (0 < topping && topping < 7);
			
			//will calculate order once pizza and toppings have been chosen 
			System.out.println("No more toppings");
			topPrice = 0;
			totalPrice = totalPrice +topPrice;
			if (numPizzas ==1) 
				In.close();
				
		}
		System.out.println("Alright! your pizzas are coming up. The total price is "+ finalPrice);
		
	}
	
	
}