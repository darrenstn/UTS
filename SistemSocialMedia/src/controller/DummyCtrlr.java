/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.*;

/**
 *
 * @author Darren
 */
public class DummyCtrlr {
    ArrayList<User> user = new ArrayList<>();
    DummyCtrlr(){
        user.add(new User("user1", "user1", "user1", "user1"));
        user.get(0).getPost().add(new Post("post1", ContentState.PINNED, new Timestamp(2000),ContentType.VIDEO));
    }
}
