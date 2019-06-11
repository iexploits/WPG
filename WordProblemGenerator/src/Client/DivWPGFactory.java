package Client;

import Problem.DivProblemTemplate;
import Problem.ProblemTemplate;
import Solution.DivSolutionTemplate;
import Solution.SolutionTemplate;

public class DivWPGFactory extends WPGFactory {
    @Override
    public ProblemTemplate getProblemTemplate() {
        return new DivProblemTemplate();
    }

    @Override
    public SolutionTemplate getSolutionTemplate() {
        return new DivSolutionTemplate();
    }
}
