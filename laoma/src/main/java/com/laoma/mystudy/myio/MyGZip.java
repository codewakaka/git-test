package com.laoma.mystudy.myio;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyGZip {
    public static void main(String[] args) {
      /*  try {
            gzip("H:\\pdf\\0f2cc8b473b243e.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            zip(new File("H:\\pdf"),new File("H:\\pdf.zip"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void gzip(String fileName) throws IOException {
        InputStream in = null;
        String gzipFileName = fileName + ".gz";
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fileName));
            out = new BufferedOutputStream(new FileOutputStream(gzipFileName));
            copy(in,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert out != null;
            out.close();
            in.close();
        }
    }
    public static void copy(InputStream in,OutputStream out) throws IOException {
        byte[] bytes = new  byte[4096];
        int byteRead = 0;
        if((byteRead =  in.read(bytes)) != -1){
            out.write(bytes,0,byteRead);
        }
    }

    public static void  zip(File inFile,File zipFile) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
        if(!inFile.exists()){
            throw new FileNotFoundException(inFile.getAbsolutePath());
        }
     //   getCanonicalPath()返回的就是标准的将符号完全解析的路径
        inFile = inFile.getCanonicalFile();
        String rootPath = inFile.getParent();
        if(rootPath.endsWith(File.separator)){
            rootPath += File.separator;
        }
        addFileToZipOut(inFile,out,rootPath);
    }
    private static void addFileToZipOut(File file,ZipOutputStream out,String rootPath) throws IOException {
        String relativePath = file.getCanonicalPath().substring(rootPath.length());
        if(file.isFile()){
            out.putNextEntry(new ZipEntry(relativePath));
            InputStream in  = new BufferedInputStream(new FileInputStream(file));
            copy(in,out);
        }else {
            out.putNextEntry(new ZipEntry(relativePath + File.separator));
            for (File f:file.listFiles()) {
                addFileToZipOut(f,out,rootPath);
            }
        }
    }
}
