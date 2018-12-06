/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatguy;

import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vrushangdesai
 */
public class findmovie {
    String movie_name;
    findmovie(String movie_name){
        this.movie_name=movie_name;
    }

    String find() {
        String link="Link Not Found :(\n\n"
                + "If You Found Movie Link On Internet \n\n"
                + "You Can Submit It To Us Like \n\n"
                + "|movieadd:Name Of Movie>Link Of Movie|\n\n"
                + "Eg : |movieadd:3 idiots>http://3idiots.com|\n\n";
        
        //Preparing Database Variables For Connection
        String url = "jdbc:sqlite:/Users/vrushangdesai/Desktop/fullmovies.db";
        Connection conn = null;
        String dlink="\n\nAnd Here's A Special Gift :)\nYes ,Direct Download Linnk :D\n";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            String sql_query = "SELECT url FROM fullmovies WHERE movie_name LIKE '%{!!}%' ;".replace("{!!}",movie_name);
            String movie=movie_name;
            System.out.println(sql_query);
            System.out.println("Fetching records without condition...");
            ResultSet rs = stmt.executeQuery(sql_query);
            link="Hey,Thanks For Search WIth Us,\n\n"
                    + "====================\n"
                        + "Movie You Selected Was :     "+ 
                         movie
                        +"\n\n"
                        + "Here Are Some Results I Found :)\n\n"
                    + "=====================\n";
          
            while(rs.next()){
            String records=rs.getString("url");
                System.out.println(records);
                
                         dlink=dlink+"\n\n"+getDirectLink(records);
                        
                        link = link + "\n\n\n"+records; 
            
            }
            


        } catch (SQLException ex) {
            Logger.getLogger(findmovie.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
        return link+"\n\n"+dlink;
    }
    
    String getDirectLink(String url){
        String directUrl="Didnt Found It Sorry";
        
        
        try {
            String path = System.getProperty("user.home")+"/Desktop/play";
            YoutubeDL.setExecutablePath("/usr/local/Cellar/youtube-dl/2018.12.03/bin/youtube-dl");
            YoutubeDLRequest request = new YoutubeDLRequest(url,path );
            request.setOption("get-url");
            YoutubeDLResponse response = YoutubeDL.execute(request);
            String stdOut = response.getOut(); // Executable output
            directUrl=stdOut;
            System.out.println(stdOut);
            
        } catch (Exception e) {
            System.out.println(e);
        }

      
        
        return directUrl;
    
    }
    
}
