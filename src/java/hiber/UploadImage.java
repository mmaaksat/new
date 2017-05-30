/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
 
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Maks
 */
@ManagedBean
public class UploadImage {
    private ServletContext servletContext;

    private String destination,file;
    File webInfPath;
    public String getFile(){
    return file;
    }
    public void handleFileUpload(FileUploadEvent event)  throws UnsupportedEncodingException{
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
            
 String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("WEB-INF/classes/");
		System.out.println(fullPath);
               // destination=fullPath;
		System.out.println(pathArr[0]);
		fullPath = pathArr[0];
                destination=fullPath+"image/";
                file=destination+event.getFile().getFileName();
                System.out.print(file);
         try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
}