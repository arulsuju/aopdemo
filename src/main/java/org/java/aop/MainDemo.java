package org.java.aop;
import org.java.aop.dao.AccoutDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainDemo {

    public static void main(String arg[])
    {
        try
        {
            ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
            AccoutDAO accoutDAO=context.getBean("accountDAO",AccoutDAO.class);
            accoutDAO.addAccount();
            System.out.println(accoutDAO.getName());
            try {
                accoutDAO.setAge();
            }
            catch (Exception e)
            {
                return;
            }
            //accoutDAO.addAccount();
            context.close();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
}
