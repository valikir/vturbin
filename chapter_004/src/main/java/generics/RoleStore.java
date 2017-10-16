package generics;


public class RoleStore extends AbstractStore {

    @Override
    public Base add(Base model) {
        return super.add( model );
    }

    @Override
    public Base update(Base model) {
    return super.update( model );
    }

    @Override
    public boolean delete(String id) {
       return super.delete( id );
    }
}
