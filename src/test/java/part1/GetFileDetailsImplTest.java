package part1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Junit class to test the service layer.
 * @author Suprabha
 *
 */
public class GetFileDetailsImplTest extends TestCase{

	GetFileDetailsImpl impl = new GetFileDetailsImpl();


	public GetFileDetailsImplTest( String testName )
	{
		super( testName );
	}

	public static Test suite()
	{
		return new TestSuite( GetFileDetailsImplTest.class );
	}


	public void testgetFileInfo()
	{
		assertEquals(15,impl.getFileInfo().size());
	}

	public void testgetFileForMimeType()
	{
		assertEquals(15,String.valueOf(impl.getFileForMimeType().size()));
	}
}
