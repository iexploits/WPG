package Util;

import Data.Item;
import Data.Person;
import Problem.ProblemType;

import java.util.ArrayList;

public interface DataReceiver {


    ArrayList<Person> getPeople();

    ArrayList<Item> getItems();

    ArrayList<ProblemType> getProblemTypes();

    ArrayList<Integer> getOperandRange();

    double getUserInputAnswer();

    int getUserInputNumberOfProblems();

}
