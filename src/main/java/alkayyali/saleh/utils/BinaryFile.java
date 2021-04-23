package alkayyali.saleh.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BinaryFile<T> extends FileAdapter {


    public BinaryFile(String path) {
        super(path);
    }

    public T read(T defualt) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            T readed = (T) ois.readObject();
            ois.close();
            return  readed;
        } catch (FileNotFoundException e) {
            createFile();
            return read(defualt);
        } catch (IOException | ClassNotFoundException ex) {
            write(defualt);
            return read(defualt);
        }
    }

    public void write(T object) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        } catch (FileNotFoundException e) {
            createFile();
            write(object);
        } catch (Exception e) {
            exit();
        }
    }

}
