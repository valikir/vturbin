package generics;

public class User extends Base{
    @Override
    void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }
}