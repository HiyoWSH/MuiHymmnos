package com.hiyo.hymmnos.service;

import com.hiyo.hymmnos.bean.Hymmnos;
import com.hiyo.hymmnos.util.Dictionary;
import com.hiyo.hymmnos.util.Mtx;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HymmnosServiceImpl implements HymmnosService {
    @Override
    public Hymmnos transHymmnos(String tango) {
        for(Hymmnos hymmnos: Dictionary.getHymmnosDictionary()){
            if (StringUtils.equalsIgnoreCase(hymmnos.getTango(), tango)){
                return hymmnos;
            }
        }
        return null;
    }

    @Override
    public List<Hymmnos> searchSimilarHymmnos(String tango, Integer count) {
        List<Hymmnos> hys = new ArrayList<>(Dictionary.getHymmnosDictionary());
        for(Hymmnos hymmnos:hys){
            hymmnos.setSimilar(Mtx.caculaterMtxSimilarHymmnos(tango, hymmnos));
        }
        Collections.sort(hys);
        return hys.subList(0, count);
    }
}
