package com.hiyo.hymmnos.bean;

import com.hiyo.hymmnos.util.Mtx;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hymmnos implements Comparable<Hymmnos>{
    private String tango;
    private String imi;
    private String chsimi;
    private String hatsuon;
    private String ryuuha;
    private double similar;

    public String getImi() {
        return imi;
    }

    public void setImi(String imi) {
        this.imi = imi;
    }

    public String getChsimi() {
        return chsimi;
    }

    public void setChsimi(String chsimi) {
        this.chsimi = chsimi;
    }

    public String getHatsuon() {
        return hatsuon;
    }

    public void setHatsuon(String hatsuon) {
        this.hatsuon = hatsuon;
    }

    public String getRyuuha() {
        return ryuuha;
    }

    public void setRyuuha(String ryuuha) {
        this.ryuuha = ryuuha;
    }

    public String getTango() {
        return tango;
    }

    public void setTango(String tango) {
        this.tango = tango;
    }

    public double getSimilar() {
        return similar;
    }

    public void setSimilar(double similar) {
        this.similar = similar;
    }

    @Override
    public int compareTo(Hymmnos hymmnos){
        if(this.getSimilar() > hymmnos.getSimilar()){
            return 1;
        } else if (this.getSimilar() == hymmnos.getSimilar()) {
            return 0;
        }
        return -1;
    }
//    public static void main(String []argv){
//
//        List<String> lines = FileOperate.FileRead("C:\\Users\\wangsh\\Documents\\hymmnos a順.txt", "utf-8");
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < lines.size(); i++) {
//            if(lines.get(i).contains("<tr>")){
//                if(start == 0){
//
//                } else {
//                    dealHyms(lines, start, i);
//                }
//                start = i;
//            }
//        }
//    }
//
//    private static void dealHyms(List<String> lines, int start, int end) {
//        System.out.println("dealHyms " + start + " " + end);
//        int index = 0;
//        Hymmnos hymmnos = new Hymmnos();
//        for (int i = start; i <= end; i++) {
//            String line = lines.get(i);
//            if(line.contains("<b>")) {
//                int begining = line.indexOf("<b>") + 3 ;
//                int ending = line.indexOf("</b>");
//                String value = line.substring(begining,ending);
//                System.out.println(value);
//                switch (index){
//                    case 0:
//                        hymmnos = new Hymmnos();
//                        hymmnos.setTango(value);
//                        break;
//                    case 1:
//                        hymmnos.setImi(value);
//                        break;
//                    case 2:
//                        hymmnos.setHatsuon(value);
//                        break;
//                    case 3:
//                        hymmnos.setRyuuha(value);
//                        session.insert("saveHymmnos", hymmnos);
//                        break;
//                }
//
//                index = ++index % 4;
//            }
//        }
//
//        session.commit();
//    }

//    public static void main(String[] argv) {
//        while (true) {
//            Scanner in = new Scanner(System.in);
//            StringBuilder lineStr = new StringBuilder();
//            while(in.hasNext()) {
//                String tmpStr = in.nextLine();
//                String[] tangos = tmpStr.split(" ");
//                translate(tangos);
//            }
//        }
//    }
//
//    private static void translate(String[] tangos) {
//        StringBuilder builder = new StringBuilder();
//        List<Hymmnos> allList = session.selectList("selectHymmnos");
//        List<String> toFindSimilar = new ArrayList<String>();
//        for (String tango: tangos){
//            if(StringUtils.isBlank(tango)){
//                continue;
//            }
//            List<Hymmnos> hymmList = session.selectList("selectHymmnosBytango", tango);
//            //完全一致的情况
//            for(Hymmnos hymmnos:hymmList){
//                if(StringUtils.equalsIgnoreCase(tango, hymmnos.getTango())){
//                    hymmList = new ArrayList<>();
//                    hymmList.add(hymmnos);
//                    break;
//                }
//            }
//            //未查到的情况  寻找词被包含的情况
//            if(hymmList.size() == 0){
////                hymmList = new ArrayList<>(allList);
////                Iterator<Hymmnos> it = hymmList.iterator();
////                while (it.hasNext()) {
////                    Hymmnos hymmnos = it.next();
////                    if(!StringUtils.containsIgnoreCase(tango, hymmnos.getTango())){
////                        it.remove();
////                    }
////                }
//                toFindSimilar.add(tango);
//            }
//            //实在找不到
//            if(hymmList.size() == 0){
//                builder.append(tango);
//                builder.append("(not found)");
//            }
//            for(Hymmnos hymmnos:hymmList){
//                builder.append(hymmnos.imi);
//                builder.append("(" + hymmnos.getTango() + ")");
//            }
//            builder.append(" ++ ");
//        }
//        builder.append(findSimilar(toFindSimilar, allList));
//        System.out.println(builder.toString().replaceFirst(" \\+\\+ \n*","\n\n"));
//    }
//
//    private static String findSimilar(List<String> toFindSimilar, List<Hymmnos> allList) {
//        StringBuilder builder = new StringBuilder();
//        for(String str:toFindSimilar){
//            builder.append("\n" + str + ":\n");
//            List<Hymmnos> similarestMtxList = getSimilarestMtxList(str, allList);
//            for(Hymmnos hymmnos:similarestMtxList){
//                builder.append("(" + hymmnos.getTango() + ")");
//                builder.append(hymmnos.imi);
//                builder.append("\n");
//            }
//        }
//
//        return builder.toString();
//    }
//
//    /**
//     * 搜索最相似的5个结果集
//     * @param target
//     * @param hymmnosList
//     * @return
//     */
//    private static List<Hymmnos> getSimilarestMtxList(String target, List<Hymmnos> hymmnosList) {
//        for(Hymmnos hymmnos:hymmnosList){
//            hymmnos.setSimilar(Mtx.caculaterMtxSimilarHymmnos(target, hymmnos));
//        }
//        Collections.sort(hymmnosList);
//        return hymmnosList.subList(0, 5);
//    }
}
