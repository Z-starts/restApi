package com.jl.zxx.gm;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.jl.zxx.gm.bean.AuthConfigBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import java.io.*;

/**
 * Created by zhongxingxing on 2015/10/19.
 */
@RestController
public class GmController {
    @ControllerAdvice
    static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
        public JsonpAdvice() {
            super("JSON_CALLBACK");
        }
    }

    @RequestMapping(value = "/gm")
    @ResponseBody
    String version() {
        return "GM server v0.0.1";
    }

    @RequestMapping(value = "/gm/authConfig", method = RequestMethod.GET)
    @ResponseBody
    AuthConfigBean getAuthConfig(@RequestParam(value = "name") String name) {
        JsonObject jo = new JsonObject();
        jo.addProperty("id", 1);
        jo.addProperty("funid", 4);
        jo.addProperty("name", name);
        return new AuthConfigBean(1, jo);
    }

    @RequestMapping(value = "/gm/testArray", method = RequestMethod.GET)
    @ResponseBody
    JsonArray getArray() {
        JsonArray ja = new JsonArray();
        ja.add(new JsonPrimitive(2));
        ja.add(new JsonPrimitive(3));
        return ja;
    }

    @RequestMapping(value = "/gm/auth", method = RequestMethod.GET)
    @ResponseBody
    JsonObject getAuth() {
        Reader jr = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("auth.json")));
        if (jr != null)
            return new Gson().fromJson(jr, JsonObject.class);
        else
            return new JsonObject();
    }

    @RequestMapping(value = "/gm/nav", method = RequestMethod.GET)
    @ResponseBody
    JsonObject getNavigator() {
        Reader jr = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("navigator.json")));
        if (jr != null)
            return new Gson().fromJson(jr, JsonObject.class);
        else
            return new JsonObject();
    }
}
