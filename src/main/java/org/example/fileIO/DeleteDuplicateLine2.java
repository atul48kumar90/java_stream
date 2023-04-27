package org.example.fileIO;

import java.io.*;
import java.util.HashSet;

public class DeleteDuplicateLine2 {

    public static void main(String[] args) throws IOException {


        PrintWriter pw = new PrintWriter("output2.txt");
        File file = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();

        HashSet<String> set = new HashSet<>();

        while(line != null)
        {
            if(set.add(line))
            {
                pw.println(line);

            }
            line = br.readLine();

        }
        //System.out.println("operation completed");

        pw.flush();
        br.close();
        pw.close();

        System.out.println("operation completed");

    }
}
