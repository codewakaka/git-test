package com.javaweb.study.nio;

import java.io.*;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileCopy {

    public static void copyFileBySteam(File source, File dest) {
        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest);
            byte[] byte1 = new byte[1024];
            int len;
            if ((len = fis.read(byte1)) > 0) {
                fos.write(byte1,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  copyFileByChine(File source, File dest){
        try {
            FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel distChannel = new FileOutputStream(dest).getChannel();
            for (long a = sourceChannel.size(); a > 0;) {
               long target =sourceChannel.transferTo(sourceChannel.position(),a,distChannel);
               sourceChannel.position(target+sourceChannel.position());
               a -= target;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
