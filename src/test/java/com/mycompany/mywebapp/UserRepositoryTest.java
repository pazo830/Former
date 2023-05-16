package com.mycompany.mywebapp;
import java.util.Optional;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.User;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.Userrepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private Userrepository repo;

    @Test



    public void testAddNew(){

        User user = new User();
user.setDistrict("Gasabo");
user.setProvince("Kigali");
user.setFirstname("zainab");
user.setLastname("Suleiman");
user.setFarming_type("MAize");
user.setFertilizer_type("nkunganire");
User savedUser = repo.save(user);








    }
    @Test
    public void testListAll() {
       Iterable<User>users= repo.findAll();
       for(User user:users){
           System.out.println(user);
       }
    }
    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User>optionaluser= repo.findById(userId);
        User user = optionaluser.get();
       // user.setPassword("hello20222");



        User updatedUser= repo.findById(userId).get();
    }
}
