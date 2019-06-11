package Solution;

public class DivSolutionTemplate implements SolutionTemplate{

    @Override
    public boolean isAnswer(int param1, int param2, double userInput) {

        double answer;

        // If the answer is not a real number,
        // System will calculate its Allowance.
        // If it is lower than 0.1 , it'll true.
        if(param1 % param2 != 0)
        {
            answer = (double)param1 / param2;

            return Math.abs(userInput - answer) <= 0.1;
        }

        answer = param1 / param2;
        return (userInput == answer);
    }
}
