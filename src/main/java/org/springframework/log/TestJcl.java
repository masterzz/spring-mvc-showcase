package org.springframework.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/11/26 14:46 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class TestJcl {
    static Log log = LogFactory.getLog("jcl");

    public static void main(String[] args) {
        log.debug("jcl");
    }
}
