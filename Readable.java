/**
 * @(#) Readable.java
 */

public class Readable extends Permission
{
	public Readable(IFileRights file) 
	{
		super(file);
	}
	
	public String read( )
	{
		return ((File) getFile()).contents;
	}
	
	public int getRights( )
	{
		return file.getRights() + 4;
	}
	
	
}
