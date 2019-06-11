package Solution;

public class AddSolutionTemplate implements SolutionTemplate{

    @Override
    public boolean isAnswer(int param1, int param2, double userInput) {

        int answer = param1 + param2;
        return (userInput == answer);
    }
}
