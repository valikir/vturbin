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

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (children != user.children) return false;
            if (name != null ? !name.equals( user.name ) : user.name != null) return false;
            return birthday != null ? birthday.equals( user.birthday ) : user.birthday == null;
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
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.println(map);
    }
}
