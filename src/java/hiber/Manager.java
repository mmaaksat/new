/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.mail.MessagingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hiber.Email;


/**
 *
 * @author Maks
 */
@ManagedBean
@ViewScoped
public class Manager implements Serializable{

    private Map<String, HashSet<String>> data = new HashMap<>();
    private String faculty;
    private String specialty;
    private Integer idSpecialty;
    private String msg;
    private String lname;
    private String fname;
    private String email;
    private Date birthdaydate;
    private String gender;
    private Year entryYear;
    private String edulevel;
    private HashSet<String> faculties;
    private HashSet<String> specialties;
    Specialty specialtyObj;
    Faculty facultyObj;
    private Set<Educationhistory> educationhistories;
    private List<Faculty> facultyList = new ArrayList();

    @PostConstruct
    public void init() {

        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("fgdf");
            trans = session.beginTransaction();
            Query query = session.createQuery("from Faculty");
            facultyList = query.list();
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        faculties = new HashSet<>();

        for (Faculty faculty : facultyList) {
            faculties.add(faculty.getName());
            System.out.println("faculty names: " + faculty.getName());
        }
        
    }

    public Map<String, HashSet<String>> getData() {
        return data;
    }

    public void setData(Map<String, HashSet<String>> data) {
        this.data = data;
    }

    public HashSet<String> getFaculties() {
        return faculties;
    }

    public void setFaculties(HashSet<String> faculties) {
        this.faculties = faculties;
    }

    public HashSet<String> getSpecialties() {
        return specialties;
    }

    
    public String getEdulevel() {
        return edulevel;
    }

    public void setEdulevel(String edulevel) {
        this.edulevel = edulevel;
    }

    public void setSpecialties(HashSet<String> specialties) {
        this.specialties = specialties;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {

        return specialty;
    }

    public void setFname(String Fname) {
        this.fname = Fname;
    }

    public String getFname() {

        return fname;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getEmail() {

        return email;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setLname(String Lname) {
        this.lname = Lname;
    }

    public String getLname() {

        return lname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthdaydate() {
        return birthdaydate;
    }

    public void setBirthdaydate(Date date3) {
        this.birthdaydate = date3;
    }

    public void setEntryYear(Year entryYear) {
        this.entryYear = entryYear;
    }

    public Year getEntryYear() {
        return entryYear;
    }

    public void onFacultyChange() {
      System.out.println("onFacultyChange****************");
        specialties = new HashSet<String>();
        if (faculty != null && !faculty.equals("")) {
            for (Faculty facultys : facultyList) {
                if (faculty.equals(facultys.getName().toString())) {
                    Set<Specialty> specialtiess = facultys.getSpecialties();
                    for (Specialty specialty : specialtiess) {
                        System.out.println(specialty.getName());
                        specialties.add(specialty.getName());
                    }
                }
            }
        }
        
        
    }

    public void displayLocation() throws MessagingException {
       educationhistories=null;
        msg = "Hello " + fname + " " + lname + "!" + " You are selected " + faculty + " of specialty: " + specialty;
         if (specialty != null && !specialty.equals("")) {
               System.out.println("specialty****************");
            for (Faculty facultys : facultyList) {
             
                    Set<Specialty> specialtiess = facultys.getSpecialties();
                    for (Specialty specialtys: specialtiess) {
                        if(specialty.equals(specialtys.getName())){
                            idSpecialty=specialtys.getIdspecialty();
                        }
                    }
                }
            
        }
 
     System.out.println("aaaa"+birthdaydate);
      Email emails=new Email();
       emails.Emails(email,msg);
       emails.setEmail(email);
       emails.setMsg(msg);
         Student student=new Student(100,specialtyObj,fname,lname,null,edulevel,"aaa",gender,birthdaydate,"1","1","1","1","1","1","1","1",birthdaydate,"1","1","1","1","1","1","1","1","1","1","1","1","1","2",11,"100",educationhistories);
       Service service=new Service();
       service.Register(student);
      
       FacesMessage mg;
          
         
      
            mg = new FacesMessage("Selected  ", "Email: " + email );
       
        FacesContext.getCurrentInstance().addMessage(null, mg);
    }
}
