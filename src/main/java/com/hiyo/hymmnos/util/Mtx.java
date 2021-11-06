package com.hiyo.hymmnos.util;
import com.hiyo.hymmnos.bean.Hymmnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 英文字符串矩阵
 */
public class Mtx {
    //计算Hymmnos矩阵相似度
    public static double caculaterMtxSimilarHymmnos(Hymmnos h1, Hymmnos h2){
        return caculaterMtxSimilar(getMtxMap(h1.getTango()), getMtxMap(h2.getTango()));
    }
    public static double caculaterMtxSimilarHymmnos(String target, Hymmnos h2){
        return caculaterMtxSimilar(getMtxMap(target), getMtxMap(h2.getTango()));
    }

    //获取矩阵
    public static Map<String, Double> getMtxMap(String str){
        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < str.length(); i++) {
            String key = str.substring(i, i+1);
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1.0);
            }
        }
        return map;
    }
    //计算矩阵相似度
    public static double caculaterMtxSimilar(Map<String, Double> mtxMap1, Map<String, Double> mtxMap2){
        double sum = 0;
        for(String key1:mtxMap1.keySet()){
            double value1 = mtxMap1.get(key1);
            double value2 = 0.0;
            if(mtxMap2.containsKey(key1)){
                value2 = mtxMap2.get(key1);
            }
            sum += (value1 - value2) * (value1 - value2);
        }

        for(String key2:mtxMap2.keySet()){
            if(mtxMap1.containsKey(key2)){
                continue;
            }
            double value2 = mtxMap2.get(key2);
            sum += value2 * value2;
        }

        return Math.sqrt(sum);
    }

}
