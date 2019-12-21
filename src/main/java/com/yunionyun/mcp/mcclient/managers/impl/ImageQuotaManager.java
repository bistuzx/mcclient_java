package com.yunionyun.mcp.mcclient.managers.impl;

import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.EndpointType;
import com.yunionyun.mcp.mcclient.JSONClientException;
import com.yunionyun.mcp.mcclient.Session;
import com.yunionyun.mcp.mcclient.common.McClientJavaBizException;
import com.yunionyun.mcp.mcclient.managers.BaseManager;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zxc
 * @date 2019/09/26
 */
public class ImageQuotaManager extends GlanceManager {
    public ImageQuotaManager() {
        super("quota", "quotas", new String[0], new String[0]);
    }

    public ImageQuotaManager(String serviceType, String keyword, String keywordPlural, EndpointType endpointType){
        super(serviceType,keyword, keywordPlural, endpointType);
    }

    public ImageQuotaManager(EndpointType endpointType){
        super(endpointType);
    }

    public JSONObject get(Session s, Map<String, String> param) throws McClientJavaBizException, IOException, JSONClientException {
        StringBuilder url = new StringBuilder();
        url.append("/");
        url.append(this.keywordPlural);
        if (param != null) {
            Iterator var4 = param.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry)var4.next();
                url.append("/" + (String)entry.getKey() + "/");
                url.append((String)entry.getValue());
            }
        }

        return this._get(s, url.toString(), this.keywordPlural);
    }

}
