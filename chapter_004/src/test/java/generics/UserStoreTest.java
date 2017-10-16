package generics;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void whenAddtwoUserssToUserStoreStoreTwo(){
        UserStore roleStore = new UserStore();
        User newRole = new User();
        newRole.setId( "12" );

        User newRole2 = new User();
        newRole.setId( "14" );

        roleStore.add( newRole );
        roleStore.add( newRole2 );
        assertThat(roleStore.RoleandUserStore.get( 0 ),is(newRole));
        assertThat(roleStore.RoleandUserStore.get( 1 ),is(newRole2));
    }

    @Test
    public void whenUpdateSecondUserShowUpdated(){
        UserStore roleStore = new UserStore();
        User newRole = new User();
        newRole.setId( "12" );

        User newRole2 = new User();
        newRole2.setId( "14" );

        roleStore.add( newRole );
        roleStore.add( newRole2 );
        User updaterole =  (User) roleStore.update( newRole2 );
        assertThat(roleStore.RoleandUserStore.get( 0 ),is(newRole));
        assertThat(roleStore.RoleandUserStore.get( 1 ),is(updaterole));
    }

    @Test
    public void whenDeleteSecondUserShowNull(){
        UserStore roleStore = new UserStore();
        User newRole = new User();
        newRole.setId( "12" );

        User newRole2 = new User();
        newRole2.setId( "14" );

        User role1 = (User) roleStore.add( newRole );
        User role2 = (User) roleStore.add( newRole2 );
        System.out.println(role1.getId());
        System.out.println(role2.getId());
        roleStore.delete( "14" );
        assertThat(roleStore.RoleandUserStore.get( 0 ),is(newRole));
        assertThat(roleStore.RoleandUserStore.get( 1 ),is( IsNull.nullValue()));
    }

}