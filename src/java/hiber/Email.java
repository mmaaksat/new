/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;

import java.util.Properties;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Maks
 */
public class Email {
    String email,msg;
    public void Emails(String email,String message){
    this.email=email;
    this.msg=message;
    }
   

    public void setEmail(String email) {
        this.email = email;
        System.out.print("44e444ere"+this.email);
    }
     public String getEmail() {        
        System.out.print(email);
        return email;        
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public static void SendEmail(String username,String password,String from,String to, String subject,String msg) throws MessagingException{
           Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        Session session=Session.getDefaultInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(username,password);
        }
        
        });
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
        // TODO code application logic here
    }
    
    
    

}