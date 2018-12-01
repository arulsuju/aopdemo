package org.java.aop.dao;

import org.springframework.stereotype.Component;
@Component
public class AccoutDAO {
    public void addAccount()
    {
        System.out.println("Adding account"+getClass());
    }
    public String getName()
    {
        System.out.println("Adding Name account"+getClass());
        return "Suju";
    }
    public void setAge()
    {
        int a=10;
        int b=0;
        System.out.println(a/b);
        System.out.println("Adding Age account"+getClass());
    }

}
