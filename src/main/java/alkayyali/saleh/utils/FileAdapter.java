package alkayyali.saleh.utils;

import static alkayyali.saleh.App.BASE_PATH;

import java.io.File;
import java.io.IOException;

public class FileAdapter {
    final protected String path;


    public FileAdapter(String path) {
        this.path = BASE_PATH + path;
    }

    protected void createFile() {
        try {
            System.out.print(path + " not found creating it");
            new File(path).createNewFile();
        } catch (IOException e) {
            exit();
        }
    }

    protected void exit() {
        System.err.print("something went wrong! could not write users >_<\nEXITTING!");
        System.exit(500);
    }
}
