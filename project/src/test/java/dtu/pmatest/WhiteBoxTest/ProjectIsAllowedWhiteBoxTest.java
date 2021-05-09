package dtu.pmatest.WhiteBoxTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dtu.pma.OperationNotAllowedException;
import dtu.pma.Project;

public class ProjectIsAllowedWhiteBoxTest {
    Project sut = new Project("title", 0);



    @Test
    public void testInputDataSetA() {
        
        String ID = null;

       try {
        sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   

    }

    @Test
    public void testInputDataSetB() {
        
        String ID = "";

       try {
        sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   

    }

    @Test
    public void testInputDataSetC() {
        
        String ID = "12345";

        boolean result= false;
       try {
       result = sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   
    }

    @Test
    public void testInputDataSetD() {
        
        String ID = "123";

        boolean result= false;
       try {
       result = sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   
    }

    @Test
    public void testInputDataSetE() {
        
        String ID = "ABCD";

        boolean result= false;
       try {
       result = sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   
    }

    
    @Test
    public void testInputDataSetF() {
        
        String ID = "1234";

        boolean result= false;
       try {
       result = sut.isAllowedID(ID);
    } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }   
        assertTrue(result);

    }








}
