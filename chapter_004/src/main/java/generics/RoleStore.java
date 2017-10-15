package generics;

import java.util.Objects;

public class RoleStore implements Store {

    public SimpleArray roleStore = new SimpleArray(100);

    int index = 0;

    @Override
    public Base add(Base model) {
        roleStore.add(model);
        return (Role) roleStore.get(index++);
    }

    @Override
    public Base update(Base model) {
        int count=0;
       while (roleStore.get( count )!= model){
            count++;
            break;
        }
        Role updated = new Role();
        updated.setId( "updated" );
        roleStore.update( count, updated);
        return (Role) roleStore.get( count );
    }

    @Override
    public boolean delete(String id) {
        int count = 0;
        boolean deleted = false;
        Role role = (Role) roleStore.get(count );
        while (!Objects.equals( role.getId(), id )) {
            role = (Role) roleStore.get(count );;
            count++;
            if (role.getId() == id){
                roleStore.delete( --count );
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}
