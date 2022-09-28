package com.company.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CmdUtils {
    public static void runCMD(String cmdline){
        try {
            // 执行命令
            Process process  = Runtime.getRuntime().exec(cmdline);
            // Process process  = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", cmdline});
            // 等待命令行结束执行
            process.waitFor();
            // 获取返回数据
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 循环输出返回数据
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            if(br != null){
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 命令， 工作目录
    public static void runCMD(String cmdline, String dir) {
        try {
            // 执行命令
            Process process = Runtime.getRuntime().exec(cmdline, null, new File(dir));
            // Process process  = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", cmdline});
            // 等待命令行结束执行
            process.waitFor();
            // 获取返回数据
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 循环输出返回数据
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            if (br != null) {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void cmdIn(){
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}