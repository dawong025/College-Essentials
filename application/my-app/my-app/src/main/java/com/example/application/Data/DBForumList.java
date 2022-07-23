package com.example.application.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.xdevapi.Statement;

public class DBForumList {
    public static ArrayList<HashMap<String, String>> searchHomeItem(String Title, String selector) throws ClassNotFoundException {
        //This function will return an array of hashmaps.
        //Each hashmap contains unique information for individual forum posts.
        ArrayList<HashMap<String, String>> posts = new ArrayList<HashMap<String, String>>();
        String url = "jdbc:mysql://aa6sm8glmiegl4.cabpjb9qfuhk.us-west-1.rds.amazonaws.com/ebdb";
        String userName = "team42022";
        String password = "team4_2022";

        try{
            //Variables needed to hold information from database to be stored in hashmaps/posts
            String forumTitle;
            String username;
            String description;

            //Establishes database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection to the database" + url + "didn't go kaboom");
            Statement stmt = (Statement) connection.createStatement();

            //An SQL query that relates and joins 3 tables together.
            //"Forum Post" joins to a general "Posts" table, and "Posts" joins and relates to "Registered User" table 
            String q = "SELECT ForumPost.title, ForumPost.description, ForumPost.created_at, RegisteredUser.username"
                      +"FROM Posts"
                      +"JOIN ForumPost ON ForumPost.forum_post_id = Posts.forum_post_id"
                      +"JOIN RegisteredUser ON RegisteredUser.registered_user_id = Posts.registered_user_id";

            ResultSet rs = ((java.sql.Statement) stmt).executeQuery(q);
            while (rs.next()) {
                HashMap<String, String> post = new HashMap<String, String>();
                forumTitle = rs.getString("title");
                username = rs.getString("first_name");
                description = rs.getString("description");
                post.put("title",forumTitle);
                post.put("user",username);
                post.put("description",description);
                System.out.println(forumTitle + " " +username+ " "+description);
                posts.add(post);
            }

        }catch(SQLException e){
            
        }

        return posts;
    }
}
