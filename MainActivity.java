/* Dummy test */

package com.example.senthilkumarp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFile();
    }

    public void readFile() {
/*
    	 * 1. How to convert an image file to  byte array?
    	 */

        File file = new File("C:\\rose.jpg");

        //FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(file);
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
                System.out.println("read " + readNum + " bytes,");
            }
        }  catch (FileNotFoundException ex) {
            //Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] bytes = bos.toByteArray();

    }
}
