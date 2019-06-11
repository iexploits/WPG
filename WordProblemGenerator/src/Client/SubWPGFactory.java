package Client;

import Problem.ProblemTemplate;
import Problem.SubProblemTemplate;
import Solution.SolutionTemplate;
import Solution.SubSolutionTemplate;

public class SubWPGFactory extends WPGFactory {
    @Override
    public ProblemTemplate getProblemTemplate() {
        return new SubProblemTemplate();
    }

    @Override
    public SolutionTemplate getSolutionTemplate() {
        return new SubSolutionTemplate();
    }
}
