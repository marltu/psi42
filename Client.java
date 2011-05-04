/**
 * @(#) Client.java
 */

public class Client
{
	public static void main(String [] args) 
	{
		IFileRights p = new Writeable(new Executable(new Readable(new File("test.txt"))));
		
		System.out.println(p.getRights());
		
		try {
			((Writeable) Permission.getPermission(p, "Writeable")).write("labas");
			
			System.out.println(
					((Readable) Permission.getPermission(p, "Readable")).read()
			);
			
			p = Permission.removePermission(p, "Writeable");
			
			System.out.println(p.getRights());
			
			System.out.println(Permission.getPermission(p, "Writeable"));
			
			System.out.println(
					((Readable) Permission.getPermission(p, "Readable")).read()
			);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
