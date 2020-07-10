package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepositoryImp;
import com.example.demo.view.admin.AdminFrame;

import java.time.LocalDate;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        User user = new User();
        user.setUsername("vovantam");
        user.setPassword("123");
        user.setName("Vo Van Tam");
        user.setEmail("vovantam@gmail.com");
        user.setAddress("Quang Tri");
        user.setRole(1);
        user.setAge(25);
        user.setDob(LocalDate.now());
        user.setDepartment("Nhan Su");
        user.setGender(1);

        //UserRepositoryImp repositoryImp = new UserRepositoryImp();
        //repositoryImp.update(3, user);
        //System.out.println(repositoryImp.getAll());
        AdminFrame adminFrame = new AdminFrame();
        adminFrame.setVisible(true);
    }
}
