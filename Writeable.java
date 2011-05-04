/**
 * @(#) Writeable.java
 */

public class Writeable extends Permission
{
	public Writeable(IFileRights file) 
	{
		super(file);
	}
	
	public void write( String s )
	{
		((File) getFile()).contents = s;
	}
	
	public int getRights( )
	{
		return file.getRights() + 2;
	}
	
	
}
