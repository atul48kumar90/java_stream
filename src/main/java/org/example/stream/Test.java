package org.example.stream;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        try{
            FileReader fw=new FileReader("org/example/stream/doc.txt");
        }
        catch(FileNotFoundException e){
//                System.out.println(e);
//                e.printStackTrace();

        }System.out.println(100/0);
    }
}
