package week01.job02;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class job02 extends ClassLoader{

    public static void main(String[] args) {

        try {
            //获取Class对象
            Class helloClass = new job02().findClass("Hello");
            //获取Hello实例对象
            Object hello = helloClass.newInstance();
            //获取hello方法
            Method helloMethod = helloClass.getMethod("hello");
            //执行hello方法
            helloMethod.invoke(hello);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected  Class<?> findClass(String name) throws ClassNotFoundException {
        //定义文件名称
        String filePathName = "D:\\Geek\\week01\\Hello.xlass";
        //定义文件对象
        File file = new File(filePathName);
        //定义字节数组，用于每次读取字节
        byte[] bytes = new byte[100];


        //文件存在时，执行
        if(file.exists()){
            //try-with-resource 定义文件输入流和字节数组输出流
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
                int size = -1;
                //读取文件，至末尾时停止
                 while((size = fileInputStream.read(bytes)) != -1){
                     System.out.println("length:" + size);
                     //遍历bytes数组，进行转码， x = 255 - x
                     for(int i=0;i<size;i++){
                         bytes[i] = (byte) (255-bytes[i]);
                         System.out.println(bytes[i]);
                     }
                     //将bytes数组写入字节数组输出流
                     byteArrayOutputStream.write(bytes,0,size);
                 }

                 //将字节数组输出流内容写入新的byte数组 resultBytes
                 byte[] resultBytes = byteArrayOutputStream.toByteArray();


                 //返回Class对象
                return defineClass(name,resultBytes,0,resultBytes.length);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return super.findClass(name);
    }



}
