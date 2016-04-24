package Data;

import java.io.File;

public class ClassList {

    private File file;

    public ClassList() {
        file = new File("out/production/OOPFigures/Data/MouseListenerButtons");
    }

    public String[] getFilesList () {
        File[] list = file.listFiles();
        String[] fileNames = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            fileNames[i] = list[i].getName();
        }
        return fileNames;
    }
}
