package Client;

import Problem.ProblemTemplate;
import Problem.ProblemType;
import Solution.SolutionTemplate;

public abstract class WPGFactory {


    public static WPGFactory getWPGFactory(ProblemType type)
    {
        if(type == ProblemType.ADD) { return new AddWPGFactory(); }
        else if(type == ProblemType.SUB) { return new SubWPGFactory(); }
        else if(type == ProblemType.MUL) { return new MulWPGFactory(); }
        else if(type == ProblemType.DIV) { return new DivWPGFactory(); }

        return null;
    }

    public abstract ProblemTemplate getProblemTemplate();

    public abstract SolutionTemplate getSolutionTemplate();
}
