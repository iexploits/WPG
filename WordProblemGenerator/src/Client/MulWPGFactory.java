package Client;

import Problem.MulProblemTemplate;
import Problem.ProblemTemplate;
import Solution.MulSoulutionTemplate;
import Solution.SolutionTemplate;

public class MulWPGFactory extends WPGFactory {
    @Override
    public ProblemTemplate getProblemTemplate() {
        return new MulProblemTemplate();
    }

    @Override
    public SolutionTemplate getSolutionTemplate() {
        return new MulSoulutionTemplate();
    }
}
