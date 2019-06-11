package UI;

import Util.DataReceiver;
import Util.Printer;

public abstract class UIFactory {

    public static UIFactory getUIFactory(String type)
    {
        if(type == "cli")
        {
            return new CLIFactory();
        }
        else if(type == "gui")
        {
            return null;
        }

        return null;
    }

    public abstract DataReceiver getDataReceiver();
    public abstract Printer getPrinter();
}
