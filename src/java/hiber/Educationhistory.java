package hiber;
// Generated Oct 29, 2016 11:27:02 AM by Hibernate Tools 4.3.1



/**
 * Educationhistory generated by hbm2java
 */
public class Educationhistory  implements java.io.Serializable {


     private Integer ideducationHistory;
     private Student student;
     private String educatedPlaceName;
     private String duringTime;
     private String anddress;

    public Educationhistory() {
    }

	
    public Educationhistory(Student student) {
        this.student = student;
    }
    public Educationhistory(Student student, String educatedPlaceName, String duringTime, String anddress) {
       this.student = student;
       this.educatedPlaceName = educatedPlaceName;
       this.duringTime = duringTime;
       this.anddress = anddress;
    }
   
    public Integer getIdeducationHistory() {
        return this.ideducationHistory;
    }
    
    public void setIdeducationHistory(Integer ideducationHistory) {
        this.ideducationHistory = ideducationHistory;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getEducatedPlaceName() {
        return this.educatedPlaceName;
    }
    
    public void setEducatedPlaceName(String educatedPlaceName) {
        this.educatedPlaceName = educatedPlaceName;
    }
    public String getDuringTime() {
        return this.duringTime;
    }
    
    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }
    public String getAnddress() {
        return this.anddress;
    }
    
    public void setAnddress(String anddress) {
        this.anddress = anddress;
    }




}


