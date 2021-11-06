package com.hiyo.hymmnos;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    public static List<String> outputMode = new ArrayList<>();
//    static {
//        outputMode.add("chs-mode");
//    }
    public static String runMode = "chs-mode";


    public static void main(String []argv){
        while (true) {
            printNextPage();
            printMenu();
            String input = getInput();
            processInput(input);
        }
    }

    private static void printMenu(){
        System.out.println("© 2020 Kuribna Muiko");
        System.out.println("Run mode : " + runMode);
        System.out.println("请键入待翻译的文本：");
    }

    private static void printHelp(){

    }

    private static void printNextPage(){
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    private static String getInput(){
        Scanner in = null;
        try{
            in = new Scanner(System.in);
            StringBuilder lineStr = new StringBuilder();
            String tmpStr = null;
            if (in.hasNextLine()) {
                tmpStr = in.nextLine();
                System.out.println(tmpStr);
                return tmpStr;
            }
        } finally {
//            if(in != null){
//                try{
//                    in.close();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
        }
        return null;
    }

    private static void processInput(String input) {
        if(!inputCheck(input)){
            System.out.println("请不要输入奇怪的东西。");
            Scanner in = new Scanner(System.in);
            if(in.hasNextLine()){
                in.nextLine();
            }
            return;
        }
        switch (input){
            case "--help":
                printHelp();
                break;
            case "exit":
                System.exit(0);
            default:
                doTrans(input);
        }
    }

    private static boolean inputCheck(String input) {
        if(StringUtils.isBlank(input)){
            return false;
        }
        if(input.length() > 299){
            return false;
        }
        if(input.length() > 30 && !input.contains(" ")){
            return false;
        }
        return true;
    }

    private static void doTrans(String input) {
    }
}
