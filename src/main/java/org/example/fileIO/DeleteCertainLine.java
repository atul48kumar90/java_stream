package org.example.fileIO;

import java.io.*;
import java.util.HashSet;

public class DeleteCertainLine {

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("output3.txt");

        File file2 = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\delete.txt");

        BufferedReader br2 = new BufferedReader(new FileReader(file2));

        String line2 = br2.readLine();
        HashSet<String> set = new HashSet<>();

        while(line2!=null)
        {
            set.add(line2);
            line2 = br2.readLine();
        }
        File file = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        BufferedReader br1 = new BufferedReader(new FileReader(file));

        String line1 =br1.readLine();

        while(line1!=null)
        {
            if(!set.contains(line1))
            {
                pw.println(line1);
            }
            line1 = br1.readLine();
        }

        pw.flush();
        br1.close();
        br2.close();
        pw.close();

        System.out.println("operation completed");
    }
}
