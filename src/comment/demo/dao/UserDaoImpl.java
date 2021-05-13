package comment.demo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("Dao add.....");
    }
}
