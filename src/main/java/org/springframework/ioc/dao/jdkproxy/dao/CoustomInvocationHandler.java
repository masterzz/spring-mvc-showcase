package org.springframework.ioc.dao.jdkproxy.dao;

import java.lang.reflect.Method;

public interface CoustomInvocationHandler {
    public Object invoke(Method method);
}
