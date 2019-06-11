package Problem;

public class MulProblemTemplate implements ProblemTemplate{

    @Override
    public String generate(String person1, String person2, String item, int param1, int param2) {

        String question = "@person1 has @param1 @item with @param2 bundles.\n"
                + "How many @item @person1 have? ";

        question = question.replaceAll("@person1", person1);
        question = question.replaceAll("@item", item);
        question = question.replaceAll("@param1", Integer.toString(param1));
        question = question.replaceAll("@param2", Integer.toString(param2));

        return question;
    }
}
