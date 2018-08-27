package com.kahvedunyasi.barista.data.network.request.post;

import java.util.Map;


abstract class BaseRequest {
    public abstract Map<String, String> getFieldMap();
}
