package org.example.fileIO;

import java.io.*;

public class DeleteDuplicateline {

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("output.txt");
        File file = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        BufferedReader br1 = new BufferedReader(new FileReader(file));
        String line1 = br1.readLine();

        while(line1 != null)
        {

            boolean flag = false;
            while(line1 != null)
            {
                BufferedReader br2 = new BufferedReader(new FileReader("output.txt"));
                String line2 = br2.readLine();

                while(line2 != null)
                {
                    if(line2.equals(line1))
                    {
                        flag = true;
                        break;
                    }
                    line2 = br2.readLine();
                }

                if(!flag)
                {
                    pw.println(line1);
                    pw.flush();
                }
                line1 = br1.readLine();
            }

            br1.close();;
            pw.close();

            System.out.println("operation completed");
        }


    }
}
