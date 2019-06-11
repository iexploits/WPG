package Util;

import Data.Item;
import Data.Person;
import Problem.ProblemType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CLIDataReceiver implements DataReceiver {

    private Scanner scanner = new Scanner(System.in);

    private boolean isInputYes(String input)
    {
        // Caution ! operator " == " is for comparating String object's address.
        if(input.toUpperCase().equals("Y")) return true;
        else return false;
    }

    private ArrayList<String> getStringsFromCLI()
    {
        ArrayList<String> inputs = new ArrayList<>();

        while(true)
        {
            System.out.print(" INPUT String >> ");
            String userInput = scanner.nextLine().trim();

            if(userInput.length() == 0)
            {
                if(inputs.size() == 0)
                {
                    System.out.println(" < System > It needs at least 1 input. Please Try Again. ");
                    continue;
                }
                break;
            }

            inputs.add(userInput);
        }
        return inputs;
    }

    private int getIntegerFromCLI()
    {
        int input;

        while(true)
        {
            System.out.print(" >> ");
            input = scanner.nextInt();
            // if it's not a int
            if(!Integer.class.isInstance(input) || input < 0)
            {
                System.out.println(" < System > Wrong Integer. Please Try Again. ");
               continue;
            }
            else break;
        }

        return input;
    }

    private double getDoubleFromCLI()
    {
        double input;

        while(true)
        {
            System.out.print(" >> ");
            input = scanner.nextDouble();
            // if it's not a double
            if(!Double.class.isInstance(input) || input < 0)
            {
                System.out.println(" < System > Wrong Double. Please Try Again. ");
                continue;
            }
            else break;
        }

        return input;
    }


    @Override
    public ArrayList<Person> getPeople() {

        System.out.println("----------------------------------------------------------");
        System.out.println("Please Input people' name you want to add on your problem.");
        System.out.println("If you type whitespace, System will go to next step. ");
        System.out.println("----------------------------------------------------------");

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<String> inputs = getStringsFromCLI();

        // Iterator Pattern
        Iterator it = inputs.iterator();
        while(it.hasNext())
        {
            people.add(new Person((String)it.next()));
        }

        return people;
    }

    @Override
    public ArrayList<Item> getItems() {

        System.out.println("----------------------------------------------------------");
        System.out.println("Please Input Items' name you want to add on your problem.");
        System.out.println("If you type whitespace, System will go to next step. ");
        System.out.println("----------------------------------------------------------");

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> inputs = getStringsFromCLI();

        // Iterator Pattern
        Iterator it = inputs.iterator();
        while(it.hasNext())
        {
            items.add(new Item((String)it.next()));
        }

        return items;
    }

    @Override
    public ArrayList<ProblemType> getProblemTypes() {

        ArrayList<ProblemType> problems = new ArrayList<>();
        String input;

        System.out.println("----------------------------------------------------------");
        System.out.println("Please Check operators you want to generate problem.");
        System.out.println("Type Y/N to each operator.");
        System.out.println("----------------------------------------------------------");

        System.out.print("[ + ] : ");
        input = scanner.nextLine().trim();
        if(isInputYes(input)) problems.add(ProblemType.ADD);

        System.out.print("[ - ] : ");
        input = scanner.nextLine().trim();
        if(isInputYes(input)) problems.add(ProblemType.SUB);

        System.out.print("[ * ] : ");
        input = scanner.nextLine().trim();
        if(isInputYes(input)) problems.add(ProblemType.MUL);

        System.out.print("[ / ] : ");
        input = scanner.nextLine().trim();
        if(isInputYes(input)) problems.add(ProblemType.DIV);

        return problems;
    }

    @Override
    public ArrayList<Integer> getOperandRange() {

        ArrayList<Integer> range = new ArrayList<>();

        int input;

        System.out.println("----------------------------------------------------------");
        System.out.println("Please Check operators you want to generate problem.");
        System.out.println("It must be Integer. ex) 0 ~ 999 ");
        System.out.println("----------------------------------------------------------");

        System.out.println("[ Please type Min Value ]");
        input = getIntegerFromCLI();
        range.add(input);

        System.out.println("[ Please type Max Value ]");
        input = getIntegerFromCLI();
        range.add(input);

        return range;
    }

    @Override
    public double getUserInputAnswer() {

        System.out.println("----------------------------------------------------------");
        System.out.println("Please write your answer. It can be rational number.");
        System.out.println("----------------------------------------------------------");

        return getDoubleFromCLI();
    }

    @Override
    public int getUserInputNumberOfProblems() {

        System.out.println("----------------------------------------------------------");
        System.out.println("Please type the number of problems.");
        System.out.println(" It must be natural number.");
        System.out.println("----------------------------------------------------------");

        return getIntegerFromCLI();
    }
}
