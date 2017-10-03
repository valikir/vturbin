package Map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    public static final class User{
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday){
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    }

    @Test
    public void TwoUsers(){
        Calendar firstCal = Calendar.getInstance();
        firstCal.set( 1990,Calendar.SEPTEMBER,3 );
        User first = new User("Daria",1, firstCal);
        User second = new User("Daria",1,firstCal);
        Map<User,Object> map = new HashMap<>();
        map.put( first,"first" );
        map.put( second,"second" );
        System.out.println(map);
    }
}
