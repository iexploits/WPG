package Solution;

public class SubSolutionTemplate implements SolutionTemplate {

    @Override
    public boolean isAnswer(int param1, int param2, double userInput) {

        int answer = Math.max(param1, param2) - Math.min(param1, param2);
        return (userInput == answer);
    }
}
