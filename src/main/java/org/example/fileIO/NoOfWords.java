package org.example.fileIO;

import java.io.*;

public class NoOfWords {

    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\Atul Kr Karn\\Desktop\\side_project\\stream\\src\\main\\java\\org\\example\\fileIO\\File.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        int wordCount = 0;
        int characterCount = 0;
        int paraCount = 0;
        int whiteSpaceCount = 0;
        int sentenceCount = 0;

        while((line = bufferedReader.readLine()) != null)
        {
            if(line.equals(""))
            {
                paraCount += 1;
            }
            else{
                characterCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
                whiteSpaceCount += wordCount-1;
                String[] sentence = line.split("[!?.:]+");
                sentenceCount += sentence.length;

            }
            if(sentenceCount >=1)
            {
                paraCount++;
            }

        }

        System.out.println("Total word count : "+ wordCount);
        System.out.println("Total character count :" + characterCount);
        System.out.println("total whitespaces :" + whiteSpaceCount);
        System.out.println("total sentence count :" + sentenceCount);
        System.out.println("total para count :" + paraCount);
    }
}
