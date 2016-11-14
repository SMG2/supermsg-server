import com.hdu.jersey.dao.impl.UserTagDAOImpl;
import com.hdu.jersey.model.UserTag;


public class M {
	public static void main(String[] args) {
		UserTag tag = new UserTag();
		tag.setTagid("755321");
		tag.setUserid("1033614108438");
		
		new UserTagDAOImpl().addTagForUser(tag);
		
	}

}
