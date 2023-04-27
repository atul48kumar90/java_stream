package org.example.fileIO;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromSpecificIndex {

    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        int i=0;
        fin.skip(7);

        System.out.println("printing text from index 8");

        while((i = fin.read()) !=-1)
        {
            System.out.print((char)(i));
        }

        fin.close();


    }
}
