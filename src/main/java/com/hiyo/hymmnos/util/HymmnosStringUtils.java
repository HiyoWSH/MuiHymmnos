package com.hiyo.hymmnos.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HymmnosStringUtils {

    public static List<String> doSplit(String target, String model){
        List<String> res = new ArrayList<>();
        String[] kcs = model.split("\\.");
        int index = 0;
        int lastindex = 0;
        for(String kc:kcs){
            if(StringUtils.isBlank(kc)){
                continue;
            }
            index = target.indexOf(kc, lastindex) + 1;
            res.add(target.substring(lastindex, index));
            lastindex = index;
        }
        return res;
    }

    public static void main(String argv[]){
        List<String> list = doSplit("fYmmYArLYA", "f.m.m.r.");
        for (String s:list){
            System.out.println(s);
        }
        System.out.println("====================");
        list = doSplit("fYmmYAr", "f.m.m.r");
        for (String s:list){
            System.out.println(s);
        }
    }
}
