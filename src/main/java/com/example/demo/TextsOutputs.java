package com.example.demo;

abstract public class TextsOutputs implements IAmericano,ITea,ICappuccino,ILatte {
    //Texts to be used in Coffee machine
    public static void Welcome(){
        System.out.println("Welcome to Coffee Machine");
    }
    public static void UserChoice(){
        System.out.println("Please select drinks you would like to order:"
                + "\n" + "1 - " + IAmericanoName + ", the cost is - " + IAmericanoCost + "$"
                + "\n" + "2 - " + ITeaName + ", the cost is - " + ITeaCost + "$"
                + "\n" + "3 - " + ICappuccinoName + ", the cost is - " + ICappuccinoCost + "$"
                + "\n" + "4 - " + ILatteName + ", the cost is - " + ILatteCost + "$"
                + "\n" + "5 - " + "Proceed preparation the order " + "\n" +
                "Enter the corresponding digit:");
    }
    public static void CancelOrContinue(){
        System.out.println("\n" + "Would you like to continue?"+ "\n" +
                            "Press 1 to prepare you drinks"+ "\n" +
                            "Press 2 to cancel your order");
    }
    public static void Lines(){
        System.out.println("______________________________");
    }
    public static void ErrorText(){
        System.out.println("Error, impossible to proceed, please enter digits in provided range!");
    }
    public static void FarewellText(){
        System.out.println("Thank you for choosing our Coffee machine, good luck and see you soon!");
    }
    public static void CancelOrder(){
        System.out.println("Your order is cancelled!");
    }
}