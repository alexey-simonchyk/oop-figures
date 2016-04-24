package Data;

import Data.Figures.Figure;

import java.io.*;
import java.util.ArrayList;

public class InformationFile {

    private File tempFile;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public void checkExsistFile() {
        tempFile = new File("temp.bin");
        try {
            if (!tempFile.exists())
                tempFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void write(FigureList list) {
        try {
            ArrayList<Figure> temp = list.getList();
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tempFile.getAbsoluteFile())));
                objectOutputStream.writeObject(temp);
            objectOutputStream.close();
        }
        catch (IOException e) {
            System.out.println(e);

        }
    }

    public void read(FigureList list) {
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(tempFile.getAbsoluteFile())));

            list.setList((ArrayList<Figure>) objectInputStream.readObject());

            objectInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }
}
