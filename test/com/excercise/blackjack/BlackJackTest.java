package test.com.excercise.blackjack;
import org.junit.Test;
import src.com.excercise.blackjack.service.BlackJackService;

import java.util.Scanner;


public class BlackJackTest {

    @Test
    public void gamePlayTestWrongValue(){
        int mockPlayerMoney = 0;
        BlackJackService service = new BlackJackService();
        assert service.gamePlay(mockPlayerMoney, 0) == 1001;
    }

    @Test
    public void gamePlayTestCorrectValue(){
        int mockPlayerMoney = 100;
        BlackJackService service = new BlackJackService();
        assert service.gamePlay(mockPlayerMoney, 1) == 1000;
    }

}
