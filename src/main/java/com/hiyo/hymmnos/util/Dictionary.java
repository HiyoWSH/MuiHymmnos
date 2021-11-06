package com.hiyo.hymmnos.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hiyo.hymmnos.bean.Hymmnos;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.TypeRef;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Dictionary {
    private static JSONArray hymmnosArray;
    private static List<Hymmnos> hymmnos;
    static {
        init();
    }

    private static void init(){
        URL url = Dictionary.class.getClassLoader().getResource("hymmnos.dictionary");
        File file = new File(url.getFile());
        hymmnosArray = FileOperate.readFile(file);
        hymmnos = (List<Hymmnos>) JSONArray.parseArray(hymmnosArray.toJSONString(), Hymmnos.class);
    }

    public static JSONArray getArrayHymmnosDictionary(){
        return hymmnosArray;
    }

    public static List<Hymmnos> getHymmnosDictionary(){
        return (List<Hymmnos>) JSONArray.parseArray(hymmnosArray.toJSONString(), Hymmnos.class);
    }

    public static void main(String[] argv){
        System.out.println(getArrayHymmnosDictionary().toString());
        System.out.println(getHymmnosDictionary());
    }
}
