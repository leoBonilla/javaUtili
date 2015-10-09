/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.rut;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class RutTest {
    
    public RutTest() {
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
     * Test of validarRut method, of class Rut.
     */
    @Test
    public void testValidarRut() {
        System.out.println("validarRut");
        Map map = new HashMap();
        map.put(0,"10.365.197-2");
        map.put(1,"6283589-3");
        map.put(2,"19097332-8");
        map.put(3,"20.554.367-8");
        boolean expResult = true;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            expResult =  Rut.validarRut((String) e.getValue());
        }
         assertEquals(true,expResult);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cleanRut method, of class Rut.
     */
    @Test
    public void testCleanRut() {
        System.out.println("cleanRut");
        String rut = "12.456.234-k";
        String expResult = "12456234K";
        String result = Rut.cleanRut(rut);
        assertEquals(expResult, result);
        result = Rut.cleanRut("12345678-0");
        assertEquals("123456780",result);

    }

    /**
     * Test of copyVerificatorDigit method, of class Rut.
     */
    @Test
    public void testCopyVerificatorDigit() {
        System.out.println("copyVerificatorDigit");
        String rut = "123456790";
        char expResult = '0';
        char result = Rut.copyVerificatorDigit(rut);
        assertEquals(expResult, result);
    }
    
}
