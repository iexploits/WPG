package Problem;


import Client.WPGFactory;
import Data.Item;
import Data.Person;
import Solution.SolutionTemplate;
import Util.Printer;

import java.util.Random;

/***
 *     Class For Each Problem's Skeleton.
 *
 *
 *
 */
public class Problem {

    private Printer printer;

    private ProblemTemplate problemTemplate;
    private SolutionTemplate solutionTemplate;

    private Person person1, person2;
    private Item item;
    private int param1, param2;

    public Problem(Printer printer, ProblemType problemType, Person person1, Person person2, Item item, int range_min, int range_max)
    {
        this.printer = printer;

        this.person1 = person1;
        this.person2 = person2;
        this.item = item;
        this.param1 = getRandomInteger(range_min, range_max);
        this.param2 = getRandomInteger(range_min, range_max);

        WPGFactory factory = WPGFactory.getWPGFactory(problemType);
        problemTemplate = factory.getProblemTemplate();
        solutionTemplate = factory.getSolutionTemplate();
    }

    public void printProblem()
    {
        printer.print(problemTemplate.generate(person1.toString(), person2.toString(), item.toString(), param1, param2));
    }

    public boolean scoringProblem(double userInput)
    {
        return solutionTemplate.isAnswer(param1, param2, userInput);
    }

    private int getRandomInteger(int range_min, int range_max)
    {
        Random r = new Random();
        return r.nextInt(range_max-range_min) + 1 ;
    }
}
