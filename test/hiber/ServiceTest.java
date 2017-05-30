/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maks
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Register method, of class Service.
     */
    @Test
    public void testRegister() {
        System.out.println("Register");
        Student student = new Student(1, null, "maks", "jnf", null, null, "sdf", "sdfm", null, null, null, "mahali_maksat@mail.ru", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        Service instance = new Service();
        instance.Register(student);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
