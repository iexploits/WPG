package Client;

import Problem.AddProblemTemplate;
import Problem.ProblemTemplate;
import Solution.AddSolutionTemplate;
import Solution.SolutionTemplate;

public class AddWPGFactory extends WPGFactory {

    @Override
    public ProblemTemplate getProblemTemplate() {
        return new AddProblemTemplate();
    }

    @Override
    public SolutionTemplate getSolutionTemplate() {
        return new AddSolutionTemplate();
    }
}
