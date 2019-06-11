package Client;

import Data.Item;
import Data.Person;
import Problem.Problem;
import Problem.ProblemType;
import UI.CLIFactory;
import UI.UIFactory;
import Util.DataReceiver;
import Util.Printer;

import java.util.*;

public class Workbook {

    // Core Data for Entire Workbook.
    private ArrayList<Integer> operandRange;        // min, max
    private int numberOfProblems;
    private ArrayList<Problem> problems;

    // Core Data for Generating each Problem.
    private ArrayList<Person> people;
    private ArrayList<Item> items;
    private ArrayList<ProblemType> problemTypes;

    // UI Tools
    private DataReceiver dataReceiver;
    private Printer printer;

    // Setup for Making Workbook.
    public Workbook(UIFactory uiFactory)
    {
        // get UI Tools
        dataReceiver = uiFactory.getDataReceiver();
        printer = uiFactory.getPrinter();

        people = dataReceiver.getPeople();
        items = dataReceiver.getItems();
        problemTypes = dataReceiver.getProblemTypes();

        operandRange = dataReceiver.getOperandRange();
        numberOfProblems = dataReceiver.getUserInputNumberOfProblems();

        problems = new ArrayList<>();

        if(CLIFactory.class.isInstance(uiFactory))
            printCLISetting();
        else
            printGUISetting();
    }

    private void printCLISetting()
    {
        Iterator it;
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        printer.print("-----------------------------------------------------------------");

        printer.print("People List");
        it = people.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }

        printer.print("\nItem List");
        it = items.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }

        printer.print("\nTarget Operand List");
        it = problemTypes.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }

        printer.print("\nThe Number Of Problems : " + numberOfProblems);
        printer.print("The Range Of Operand : " + operandRange.get(0) + " ~ " + operandRange.get(1));
        printer.print("The Number Of Types : " + problemTypes.size());

        printer.print("-----------------------------------------------------------------");

        generateProblems();

        printer.print(numberOfProblems + " Problems are generated Successfully. ");

        printer.print("-----------------------------------------------------------------");
    }

    private void printGUISetting()
    {
        // TO-IMPLEMENTATION
    }

    private void generateProblems()
    {
        if(problemTypes.size() == 1)
        {
            generateProblem(0,numberOfProblems);
        }
        // it's for equally generating problems.
        else {
            int n = problemTypes.size()-1;
            int first = n;
            int cntLimit = numberOfProblems / problemTypes.size();
            int rest = numberOfProblems % problemTypes.size();

            while(n>=0)
            {
                if(first == n)
                {
                    generateProblem((n--), cntLimit + rest);
                } else {
                    generateProblem((n--), cntLimit);
                }
            }

        }
    }

    private void generateProblem(int curr, int limit)
    {
        int i;
        for( i = 0; i < limit; i++ )
        {
            problems.add(new Problem(printer, problemTypes.get(curr), getRandomPerson(), getRandomPerson(), getRandomItem(),
                    operandRange.get(0), operandRange.get(1)));
        }
        switch(problemTypes.get(curr))
        {
            case ADD:
                printer.print(" Successfully generate " + (i) + " Addition Problems");
                break;
            case SUB:
                printer.print(" Successfully generate " + (i) + " Subtraction Problems");
                break;
            case MUL:
                printer.print(" Successfully generate " + (i) + " Multiplication Problems");
                break;
            case DIV :
                printer.print(" Successfully generate " + (i) + " Division Problems");
                break;
            default:
                break;
        }
        return;
    }

    public void solveProblem()
    {
        int countSolved = 0;
        int countProblem = 1;
        Problem problem;
        double answer;

        Iterator it = problems.iterator();

        while(it.hasNext())
        {
            problem = (Problem) it.next();
            printer.print("Question " + (countProblem++) + " . ");
            problem.printProblem();
            printer.print("Type your Answer ");

            answer = dataReceiver.getUserInputAnswer();

            if(problem.scoringProblem(answer))
            {
                printer.print(" Correct !!! Current : " + (++countSolved) + " / " + numberOfProblems );
            }
            else
            {
                printer.print(" Wrong !!! Current : " + (countSolved) + " / " + numberOfProblems );
            }
        }

        printer.print("-----------------------------------------------------------------");
        printer.print("All Question Is Solved. ");
        printer.print(" Score : " + ((countSolved / numberOfProblems)*100) );
    }


    private Person getRandomPerson()
    {
        return (Person) getRandomList(people);
    }

    private Item getRandomItem()
    {
        return (Item) getRandomList(items);
    }

    private ProblemType getRandomProblemType()
    {
        return (ProblemType) getRandomList(problemTypes);
    }

    private Object getRandomList(List list)
    {
        Random r = new Random();
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }

}
