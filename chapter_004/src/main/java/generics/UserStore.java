package generics;

import java.util.Objects;

public class UserStore implements Store {

    public SimpleArray roleStore = new SimpleArray(100);

    int index = 0;

    @Override
    public User add(Base model) {
        roleStore.add(model);
        return (User) roleStore.get(index++);
    }

    @Override
    public User update(Base model) {
        int count=0;
        while (roleStore.get( count )!= model){
            count++;
            break;
        }
        User updated = new User();
        updated.setId( "updated" );
        roleStore.update( count, updated);
        return (User) roleStore.get( count );
    }

    @Override
    public boolean delete(String id) {
        int count = 0;
        boolean deleted = false;
        User role = (User) roleStore.get(count );
        while (!Objects.equals( role.getId(), id )) {
            role = (User) roleStore.get(count );;
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