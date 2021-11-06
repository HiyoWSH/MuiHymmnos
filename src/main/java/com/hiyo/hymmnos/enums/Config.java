package com.hiyo.hymmnos.enums;

import org.apache.commons.lang3.StringUtils;

public enum  Config {
    CHS_MODE("chs-mode"),
    JP_MODE("jp-mode"),
    EN_MODE("en-mode"),
    HATSUON_MODE("hatsuon-mode");

    Config(String mode){
        this.mode = mode;
    }

    private String mode;

    public Config getMode(String mode){
        for(Config c:Config.values()){
            if(StringUtils.equalsIgnoreCase(c.mode, mode)){
                return c;
            }
        }
        return null;
    }
}
