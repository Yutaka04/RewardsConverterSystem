import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }

    @Test
    void convert_from_cash_to_miles() {
        Random random = new Random();
        double cashValueTest = random.nextInt();

        var rewardValue = new RewardValue(cashValueTest);
        assertEquals((int) (cashValueTest / rewardValue.getMILES_TO_CASH_RATE()), rewardValue.getMilesValue());
    }

    @Test
    void convert_from_miles_to_cash() {
        Random random = new Random();
        int milesValueTest = random.nextInt();
        var rewardValue = new RewardValue(milesValueTest);
        assertEquals(milesValueTest * rewardValue.getMILES_TO_CASH_RATE(), rewardValue.getCashValue());
    }
}
