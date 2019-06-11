package Client;

import UI.CLIFactory;
import UI.UIFactory;

public class WPG {

    public static void main(String[] args)
    {
        UIFactory uiFactory = new CLIFactory();

        Workbook workbook = new Workbook(uiFactory);

        workbook.solveProblem();
    }
}
