/**
 * @(#) Executable.java
 */

public class Executable extends Permission
{
	public Executable(IFileRights file) 
	{
		super(file);
	}
	
	public void execute( )
	{
		System.out.println("Execute: ");
		System.out.println(((File) getFile()).contents);
	}
	
	public int getRights( )
	{
		return file.getRights() + 1;
	}
	
	
}
