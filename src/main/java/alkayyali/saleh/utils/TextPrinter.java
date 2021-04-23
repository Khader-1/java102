package alkayyali.saleh.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextPrinter extends FileAdapter{

    public TextPrinter(String path) {
        super(path);
    }

    public void write(String string) {
        try {
            PrintWriter writer = new PrintWriter(new File(path));
            writer.write(string);
            writer.close();
        } catch (FileNotFoundException e) {
            createFile();
            write(string);
        } catch (Exception e) {
            exit();
        }
    }
}
