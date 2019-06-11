package Problem;

public class SubProblemTemplate implements ProblemTemplate{

    @Override
    public String generate(String person1, String person2, String item, int param1, int param2) {

        String question = "@person1 has @param1 @item. @person1 give @param2 @item to @person2. \n"
                + "How many @item does @person1 have left?";

        int p1 = Math.max(param1, param2);
        int p2 = Math.min(param1, param2);

        question = question.replaceAll("@person1", person1);
        question = question.replaceAll("@person2", person2);
        question = question.replaceAll("@item", item);
        question = question.replaceAll("@param1", Integer.toString(p1));
        question = question.replaceAll("@param2", Integer.toString(p2));

        return question;
    }
}
