package console;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ConsoleIO {

    public static void main(String[] args){
        // Stores the new user entered
        ArrayList users = new ArrayList();
        // Condition for new user
        String confirmation = "Y";
        System.out.println("Would you like to make a new user (Y/N)?");
        // Collection of user data/confirmations
        Scanner userInput = new Scanner(System.in);
        if(userInput.hasNextLine()){
           confirmation = userInput.nextLine();
        }

        // Creation of a new user
        while(confirmation.equals("Y")){

            HashMap<String, String> user = new HashMap<>();
            // Used to validate each field of the user after completion
            HashMap<String, String> userValidation = new HashMap<>();

            // Collection of the user information
            System.out.println("What is your first name?");
            if(userInput.hasNextLine()){
                user.put("first", userInput.nextLine());
            }
            System.out.println("What is your last name?");
            if(userInput.hasNextLine()){
                user.put("last", userInput.nextLine());
            }

            // Establishing the validation for the recent input fields
            System.out.printf("%s is your first name? \n", user.get("first"));
            if(userInput.hasNextLine()) {
                userValidation.put("first:", userInput.nextLine());
            }
            System.out.printf("%s is your last name? \n", user.get("last"));
            if(userInput.hasNextLine()) {
                userValidation.put("last", userInput.nextLine());
            }

            // Wrap this in a while loop  for the condition that the whole userValidation has at least one "N"
            while(userValidation.containsValue("N")){
            for (String field : userValidation.keySet()) {
                if (userValidation.get(field).equals("N")) {
                    System.out.println("Please reenter your " + field + " name");
                    user.put(field, userInput.nextLine());
                    // Then add the condition to remove the "N" from the validation
                    System.out.printf("%s is your %s (Y/N)? \n", user.get(field), field);
                    if(userInput.hasNextLine()) {
                        userValidation.put(field, userInput.nextLine());
                    }
                }
            }
            }
            // Establishing the condition for creating a new user
            System.out.println("Great, would you like to make another user (Y/N)?");
            if(userInput.hasNextLine()){
                confirmation = userInput.nextLine();
            }

        }


    }

}