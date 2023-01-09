package org.sang.utils;

import org.sang.bean.RespBean;
import org.springframework.http.ResponseEntity;

/**
 * @author sunGuoNan
 * @version 1.0
 */
public class ResponseBodyUtil {

    /**
     * 自定义响应体内容
     *
     * @param hasSuccess
     * @param successMsg
     * @param errorMsg
     * @return
     */
    public static ResponseEntity<RespBean> responseBody(boolean hasSuccess, String successMsg, String errorMsg) {
        if (hasSuccess) {
            return ResponseEntity.status(200).body(new RespBean("success", successMsg));
        } else {
            return ResponseEntity.status(500).body(new RespBean("error", errorMsg));
        }
    }


}
