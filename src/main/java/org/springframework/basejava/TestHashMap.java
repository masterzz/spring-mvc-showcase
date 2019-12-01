package org.springframework.basejava;

import java.util.HashMap;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/11/29 8:45 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("10000000","2");
        String value = hashMap.put("1","3");
        System.out.println(value);

        System.out.println("10000000".hashCode());
    }
}
