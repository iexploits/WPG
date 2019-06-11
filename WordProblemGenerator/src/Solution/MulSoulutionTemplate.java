package Solution;

public class MulSoulutionTemplate implements SolutionTemplate {

    @Override
    public boolean isAnswer(int param1, int param2, double userInput) {

        int answer = param1 * param2;
        return (userInput == answer);
    }
}
