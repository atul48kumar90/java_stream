package org.example.fileIO;

import java.awt.image.ImagingOpException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoundEmail {

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("email.txt");
        Pattern pat= Pattern.compile( "[a-zA-Z0-9]" + "[a-zA-Z0-9_.]" + "*@[a-zA-Z0-9]" + "+([.][a-zA-Z]+)+");

        File file = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();

        while(line !=null)
        {
            Matcher mat = pat.matcher(line);
            while(mat.find())
            {
                pw.println(mat.group());
            }
            line = br.readLine();
        }

        pw.flush();
        br.close();
        pw.close();

        System.out.println("completed");

    }
}
