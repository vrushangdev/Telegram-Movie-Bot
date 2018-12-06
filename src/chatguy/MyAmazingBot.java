/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatguy;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 *
 * @author vrushangdesai
 */
public class MyAmazingBot extends TelegramLongPollingBot{
    
    @Override
    public void onUpdateReceived(Update update) {
    
        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        SendMessage message = new SendMessage(); // Create a message object object
                message.setChatId(chat_id);
                message.setText("Hi Welcome To My Bot :)\n\n"
                        + "----------"
                        + "\n\nWhat Would You Like Me To Do ?\n"
                        + "----------"
                        + "\n\nHere Is What I Can Do Now\n"
                        + "----------"
                        + "\n\n(1)Type Movie Name And I Will Send You Direct Donwload Link\n"
                        + "\n\n\n"
                        
                        + "It Should Be In Format eg :>> |movie:mitron|");
                
                               
              

                    
                try {
                   
            if(message_text.contains("movie:")){
                String moviename=message_text.split(":")[1];
                message.setText("Your Selected Movie Is :   "+ moviename);
                execute(message);
                message.setText("Fetching It For You In My DataBase\n\n");
                execute(message);
                findmovie fm = new findmovie(moviename);
                String movielink = fm.find();
                message.setText(movielink);
                execute(message);
                

            }
            else{
               execute(message);

            }
            
            
        } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
        }
        

        // TODO
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "TradingChef";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "790315587:AAGttB2cGSouEvapuuG_umrOd6ObRlRZYho";
    }
    
}
