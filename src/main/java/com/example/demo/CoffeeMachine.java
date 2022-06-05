package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class CoffeeMachine extends TextsOutputs implements IAmericano,ITea,ICappuccino,ILatte {
    String Drink;
    int DrinkCost;

    public CoffeeMachine(String coffee, int coffeeCost) {
        Drink = coffee;
        DrinkCost = coffeeCost;
    }

    @Override
    public String toString() {
        return
                "Drink - " + Drink +  ", Cost = " + DrinkCost + "$";
    }

    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        ArrayList<CoffeeMachine> Order = new ArrayList<>();
        ArrayList<String> OrderTech = new ArrayList<>();
        int userInput;
        int userInput2;
        int orderSum = 0;

        //The first cycle to choose drinks
        do {
            Welcome();//Used from TextOutputs
            UserChoice();//Used from TextOutputs
            userInput = Integer.parseInt(READER.readLine());
            //Check if Condition is met from menu, otherwise start from the beginning
            if (userInput > 5 || userInput<1){
                ErrorText(); //Used from TextOutputs
            } else {
                //case to find and add needed drink to the list + sum up all prices
                switch (userInput) {
                    case 1 -> {
                        CoffeeMachine Drink1 = new CoffeeMachine(IAmericanoName, IAmericanoCost);//creating object for Americano
                        Order.add(Drink1);//adding object to the list
                        OrderTech.add(IAmericanoName);//adding the name object to the list
                        orderSum += IAmericanoCost;//sum up the price
                    }
                    case 2 -> {
                        CoffeeMachine Drink2 = new CoffeeMachine(ITeaName, ITeaCost);//creating object for Tea
                        Order.add(Drink2);//adding object to the list
                        OrderTech.add(ITeaName);//adding the name object to the list
                        orderSum += ITeaCost;//sum up the price
                    }
                    case 3 -> {
                        CoffeeMachine Drink3 = new CoffeeMachine(ICappuccinoName, ICappuccinoCost);//creating object for Cappuccino
                        Order.add(Drink3);//adding object to the list
                        OrderTech.add(ICappuccinoName);//adding the name object to the list
                        orderSum += ICappuccinoCost;//sum up the price
                    }
                    case 4 -> {
                        CoffeeMachine Drink4 = new CoffeeMachine(ILatteName, ILatteCost);//creating object for Latte
                        Order.add(Drink4);//adding object to the list
                        OrderTech.add(ILatteName);//adding the name object to the list
                        orderSum += ILatteCost;//sum up the price
                    }
                }
            }
        }   while (userInput != 5);//if 5 chosen from menu, stop the cycle and go next
        //Cycle to continue to prepare or cancel an order
        do {
            Lines();//Used from TextOutputs
            System.out.println("Your order is - " + Order);
            System.out.println("Your Order contains " + Order.size() + " Drink(s)");
            System.out.println("The total cost for your order is - " + orderSum + "$");
            Lines();//Used from TextOutputs
            CancelOrContinue();//Used from TextOutputs
            userInput2 = Integer.parseInt(READER.readLine());
            //Checking user input2 if condition is met, otherwise error text will appear
            if (userInput2 > 2 || userInput2 < 1){
                ErrorText();//Used from TextOutputs
            } else if (userInput2 == 1) {
                Lines();//Used from TextOutputs
                FarewellText();//Used from TextOutputs
                Lines();//Used from TextOutputs
                //Cycle to choose what should be prepared, by calling methods to prepare
                for (int i = 0; i < Order.size(); i++) {
                    //if Americano in the list, then prepare it
                    if ((Objects.equals(OrderTech.get(i), IAmericanoName))) {
                        Order.get(i).Prepare_IAmericano();
                    //if Tea in the list, then prepare it
                    } else if ((Objects.equals(OrderTech.get(i), ITeaName))) {
                        Order.get(i).Prepare_ITea();
                    //if Cappuccino in the list, then prepare it
                    } else if ((Objects.equals(OrderTech.get(i), ICappuccinoName))) {
                        Order.get(i).Prepare_ICappuccino();
                    //if Latte in the list, then prepare it
                    } else if ((Objects.equals(OrderTech.get(i), ILatteName))) {
                        Order.get(i).Prepare_ILatte();
                    } else {
                        break;
                    }
                }
                //if 2 chosen, cancel order
            } else if(userInput2 == 2) {
                CancelOrder();//Used from TextOutputs
                FarewellText();//Used from TextOutputs
                        break;
                    }
        }   while (userInput2 != 2 && userInput2 != 1);
    }
    //Methods taken from Interfaces in order to prepare drinks
    @Override
    public void Prepare_IAmericano() {
        System.out.println("Americano is preparing");
    }

    @Override
    public void Prepare_ITea() {
        System.out.println("Tea is going to be prepared");
    }

    @Override
    public void Prepare_ICappuccino() {
        System.out.println("Cappuccino is preparing");
    }

    @Override
    public void Prepare_ILatte() {
        System.out.println("Latte is going to be ready");
    }
}