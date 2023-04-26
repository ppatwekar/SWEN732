package sample.controller;

import sample.model.User;

import java.util.ArrayList;
import java.util.List;

//The values in this class must be set once login happens
public class CurrentSessionUser {
    //current User
    static User currentUser;

    //id in database of current user
    static int userId;

    public static User getCurrentSessionUser(){
        return currentUser;
    }

    public static int getCurrentSessionUserId(){
        return userId;
    }

}
