package Problem;

public class DivProblemTemplate implements ProblemTemplate{

    @Override
    public String generate(String person1, String person2, String item, int param1, int param2) {

        String question = "@person1 has @param1 @item. @person1 wants to distribute equally to @param2 friends.\n"
                + "How many @item each friends have? ";

        question = question.replaceAll("@person1", person1);
        question = question.replaceAll("@item", item);
        question = question.replaceAll("@param1", Integer.toString(param1));
        question = question.replaceAll("@param2", Integer.toString(param2));

        return question;
    }
}
