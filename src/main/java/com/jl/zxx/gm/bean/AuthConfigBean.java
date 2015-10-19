package com.jl.zxx.gm.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by zhongxingxing on 2015/10/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthConfigBean implements Serializable {
    private static final long serialVersionUID = 1523394300930017279L;
    private int id;
    private JsonObject funcObj;

    public AuthConfigBean(int id, JsonObject funcObj) {
        this.id = id;
        this.funcObj = funcObj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonObject getFuncObj() {
        return funcObj;
    }

    public void setFuncObj(JsonObject funcObj) {
        this.funcObj = funcObj;
    }


}
