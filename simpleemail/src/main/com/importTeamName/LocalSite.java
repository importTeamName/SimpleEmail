import java.util.Vector;

/**
 * Class for the Local Site for the SimpleEmail system
 * @author Benjamin Lanier
 */
public class LocalSite {
	private User currentUser;
	/*When a user logs in an instance of the local site will be created
	 *  for that user
	 */
	public LocalSite(User userOfThisLocalSite)
	{
		currentUser = userOfThisLocalSite;
	}
	
	
}
