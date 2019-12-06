package org.springframework.ioc.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/6 12:39 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
@Service
@Scope("prototype")
public class BService {
    @Autowired
    AService aService;
}
