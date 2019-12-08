package org.springframework.aop.entity;

import org.springframework.aop.anno.Entity;

@Entity(value ="city")
// 如果不是value属性，则需要指定
//@Entity
public class CityEntity {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
