package com.jl.zxx.testctrls;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongxingxing on 2015/10/19.
 */
@Controller
public class DevicesController {
    @RequestMapping(value = "/detectDevice")
    public
    @ResponseBody
    String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";

        } else if (device.isMobile()) {
            deviceType = "mobile";

        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }
}
