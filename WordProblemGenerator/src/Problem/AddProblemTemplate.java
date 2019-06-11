package Problem;

public class AddProblemTemplate implements ProblemTemplate {

    @Override
    public String generate(String person1, String person2, String item, int param1, int param2) {

        String question = "@person1 has @param1 @item. @person2 has @param2 @item. \n"
                            + "How many @item do they have? ";

        question = question.replaceAll("@person1", person1);
        question = question.replaceAll("@person2", person2);
        question = question.replaceAll("@item", item);
        question = question.replaceAll("@param1", Integer.toString(param1));
        question = question.replaceAll("@param2", Integer.toString(param2));

        return question;
    }
}
