/**
 * @(#) File.java
 */

public class File implements IFileRights
{
	protected String filename;
	
	protected String contents;
	
	public File(String filename) {
		this.filename = filename;
	}
	
	// 1 - read; 2 - write; 3 - execute
	// 011 => 0 + 2 + 4 = 6 => write, execute
	public int getRights( )
	{
		return 0;
	}
	
	
}
