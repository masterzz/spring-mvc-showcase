package org.springframework.log;


import org.apache.log4j.Logger;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/11/26 11:39 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class TestLog4j {
    static Logger logger = Logger.getLogger("log4j");

    public static void main(String[] args) {
        logger.info("fdfdsf");
    }
}
