package org.springframework.ioc.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/6 12:38 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
@Service
@Scope("prototype")
//@Profile("development")
public class AService {
    @Autowired
    BService bService;
}
