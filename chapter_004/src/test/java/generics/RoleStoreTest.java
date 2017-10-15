package generics;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddtwoRolesToRoleStoreStoreTwo(){
        RoleStore roleStore = new RoleStore();
        Role newRole = new Role();
        newRole.setId( "12" );

        Role newRole2 = new Role();
        newRole.setId( "14" );

        roleStore.add( newRole );
        roleStore.add( newRole2 );
        assertThat(roleStore.roleStore.get( 0 ),is(newRole));
        assertThat(roleStore.roleStore.get( 1 ),is(newRole2));
    }

    @Test
    public void whenUpdateSecondRoleShowUpdated(){
        RoleStore roleStore = new RoleStore();
        Role newRole = new Role();
        newRole.setId( "12" );

        Role newRole2 = new Role();
        newRole2.setId( "14" );

        roleStore.add( newRole );
        roleStore.add( newRole2 );
       Role updaterole =  (Role) roleStore.update( newRole2 );
        assertThat(roleStore.roleStore.get( 0 ),is(newRole));
        assertThat(roleStore.roleStore.get( 1 ),is(updaterole));
    }

    @Test
    public void whenDeleteSecondRoleShowNull(){
        RoleStore roleStore = new RoleStore();
        Role newRole = new Role();
        newRole.setId( "12" );

        Role newRole2 = new Role();
        newRole2.setId( "14" );

        Role role1 = (Role) roleStore.add( newRole );
        Role role2 = (Role) roleStore.add( newRole2 );
        System.out.println(role1.getId());
        System.out.println(role2.getId());
        roleStore.delete( "14" );
        assertThat(roleStore.roleStore.get( 0 ),is(newRole));
        assertThat(roleStore.roleStore.get( 1 ),is( IsNull.nullValue()));
    }
}