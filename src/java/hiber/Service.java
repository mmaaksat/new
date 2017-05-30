/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 
 */
 class Service implements ServiceLayer.Service {
    @Override
    public void Register(Student student) {
Session s=null;
        try{
        s=NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr=s.getTransaction();
        tr.begin();
        s.save(student);
        System.out.println(student.getFirstName());
        tr.commit();
        Email email=new Email();
        String e =email.getEmail();
        String m=email.getMsg();
        System.out.println(e+m);
        Email.SendEmail("makhali.maksat", "15111995makhali", "makhali.maksat@gmail.com", e, "Testing", m);
        
        }
        catch(Exception e){
        e.printStackTrace();
        }
        finally{
        s.close();
        }    
    }

    
}
