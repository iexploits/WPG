package UI;

import Util.CLIDataReceiver;
import Util.CLIPrinter;
import Util.DataReceiver;
import Util.Printer;

public class CLIFactory extends UIFactory {

    @Override
    public DataReceiver getDataReceiver() {
        return new CLIDataReceiver();
    }

    @Override
    public Printer getPrinter() {
        return new CLIPrinter();
    }
}
