package part1;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FileUtilTest 
    extends TestCase
{
    /**
     * Create the test case to test every method of util class.
     *
     * @param testName name of the test case
     */
    public FileUtilTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FileUtilTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testgetFileExtension()
    {
        	assertTrue("txt".equals(FileUtil.getFileExtension("sss.txt")));
    }
    
    
    public void testgetContentType()
    {
    	File file =  new File("/Users/Suprabha/Downloads/RegistrationInfo1.xlsx") ;
    	assertNotNull(FileUtil.getContentType(file));
    }
    
    
    public void testloadProperty()
    {
    
    	assertEquals("/Users/Suprabha/Downloads",FileUtil.loadProperty("location"));
    }
    
    
    public void testloadAllProperties()
    {
        assertEquals(2,FileUtil.loadAllProperties("mimetype").length);
    }
}
