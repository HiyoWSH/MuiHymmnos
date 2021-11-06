package com.hiyo.hymmnos.service;

import com.hiyo.hymmnos.bean.Hymmnos;

import java.util.List;

public interface HymmnosService {
    /**
     * transHymmnos
     * @param tango
     * @return
     */
    public Hymmnos transHymmnos(String tango);

    /**
     * search the most similar (count) Hymmnos
     * @param tango
     * @param count
     * @return
     */
    public List<Hymmnos> searchSimilarHymmnos(String tango, Integer count);
}
