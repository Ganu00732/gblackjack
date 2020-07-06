package test.com.excercise.blackjack;

import org.junit.Test;
import src.com.excercise.blackjack.service.BlackJackService;

import org.powermock.api.mockito.PowerMockito;
import java.util.Scanner;

public class BlackJackTest {

    @Test
    public void gamePlayTestWrongValue(){
        int mockPlayerMoney = 0;
        BlackJackService service = new BlackJackService();
        Scanner userInput = new Scanner("0");
        assert service.gamePlay(mockPlayerMoney, userInput) == 1001;
    }

    @Test
    public void gamePlayTestCorrectValue(){
        int mockPlayerMoney = 100;
        BlackJackService service = new BlackJackService();
        //PowerMockito.mockStatic(Scanner.class);
        Scanner userInput = PowerMockito.mock(Scanner.class);
        PowerMockito.when(userInput.nextInt()).thenReturn(1);
        assert service.gamePlay(mockPlayerMoney, userInput) == 1000;
    }

}
