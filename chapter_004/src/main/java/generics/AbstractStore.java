package generics;

import java.util.Objects;

public abstract class AbstractStore implements Store {

    public SimpleArray RoleandUserStore = new SimpleArray(100);

    int index = 0;

    @Override
    public Base add(Base model) {
        RoleandUserStore.add(model);
        return (Base) RoleandUserStore.get(index++);
    }

    @Override
    public Base update(Base model) {
        int count=0;
        while (RoleandUserStore.get( count )!= model){
            count++;
            break;
        }
        model.setId( "updated" );
        RoleandUserStore.update( count, model);
        return (Base) RoleandUserStore.get( count );
    }

    @Override
    public boolean delete(String id) {
        int count = 0;
        boolean deleted = false;
        Base base = (Base)  RoleandUserStore.get(count );
        while (!Objects.equals( base.getId(), id )) {
            base = (Base) RoleandUserStore.get(count );;
            count++;
            if (base.getId() == id){
                RoleandUserStore.delete( --count );
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}

