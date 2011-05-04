/**
 * @(#) Permission.java
 */

public abstract class Permission implements IFileRights
{
	IFileRights file;
	
	protected Permission(IFileRights file) {
		this.file = file;
	}
	
	public IFileRights getFile( )
	{
		// go deeper to find real file
		if (file instanceof Permission) {
			return ((Permission) file).getFile();
		} else {
			// found real one
			return file;
		}
	}
	
	public int getRights( )
	{
		return file.getRights();
	}
	
	public static Permission getPermission(IFileRights f, String t ) throws ClassNotFoundException
	{	
		if (Class.forName(t).isAssignableFrom(f.getClass()))
			return (Permission) f;
		else {
			if (f instanceof Permission) {
				return Permission.getPermission( ((Permission) f).file, t);
			} else {
				return null;
			}
		}
	}
	
	public static IFileRights removePermission(IFileRights f, String t) throws ClassNotFoundException
	{
		if (!(f instanceof Permission))
			return f;
		
		if (Class.forName(t).isAssignableFrom(f.getClass())) {
			return ((Permission) f).file;
		} else {
			((Permission) f).file = Permission.removePermission(((Permission) f).file, t);
			return f;
		}
	}
	
	protected Permission getParentPermission(String t) throws ClassNotFoundException
	{
		if (Class.forName(t).isAssignableFrom(this.file.getClass()))
			return this;
		if (this.file instanceof Permission)
			return ((Permission)this.file).getParentPermission(t);
		return null;
	}
}
