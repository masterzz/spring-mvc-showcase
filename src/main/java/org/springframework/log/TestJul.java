package org.springframework.log;

import java.util.logging.Logger;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/11/26 11:33 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class TestJul {
    static Logger logger = Logger.getLogger("jul");

    public static void main(String[] args) {
        logger.info("jul");
    }
}
