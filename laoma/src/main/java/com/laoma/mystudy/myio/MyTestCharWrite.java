package com.laoma.mystudy.myio;


import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

public class MyTestCharWrite {
    @Test
    public void test1() throws IOException {

        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream("aaa.txt"), Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = "明天要下雨 124554";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            ;
        }
    }

    @Test
    public void test2() {
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream("hello.txt"), Charset.forName("UTF-8"));
            char[] chars = new char[1024];
            int charsRead = reader.read(chars);
            System.out.println(new String(chars, 0, charsRead));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert reader != null;
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void myTest() throws IOException {
        PrintWriter printWriter = new PrintWriter("aaa.txt");
        Reader reader = new BufferedReader(new FileReader("hello.txt"));
        char[] chars = new char[4096];
        int char1 = 0;
        while ((char1 = reader.read(chars)) != -1) {
            printWriter.write(chars, 0, char1);

        }
        printWriter.close();
        reader.close();


    }
}
