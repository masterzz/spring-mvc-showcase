package org.springframework.aop.util;

import org.springframework.aop.anno.Entity;

public class CommonUtil {
    /**
     * 通过一个对象构建一条查询sql语句
     *
     * @param object
     */
    public static String buildQuerySqlForEntity(Object object) {
        Class clazz = object.getClass();
        //setup1判断是否加了注解，这里的化是false因为注解是有生命周期的
//        System.out.println(clazz.isAnnotationPresent(Entity.class));
        if (clazz.isAnnotationPresent(Entity.class)) {
            //setup2得到注解
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
//            setup3 调用方法
            String entityName = entity.value();
            System.out.println(entityName);
        }
        return "";
    }
}
