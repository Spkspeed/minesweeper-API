package minesweeper.service;

import minesweeper.exception.MinesweeperException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MinesweeperPersistServiceTest {

    public static final String USER_2 = "user2";
    public static final String USER_1 = "user1";

    @Autowired
    MinesweeperPersistService minesweeperPersistService;

    @Test
    public void testSaveGameShouldReturnNotThrowException() throws MinesweeperException {
        MinesweeperService minesweeperService = new MinesweeperService();
        minesweeperService.createGame(USER_1);
        try {
            MineGameGrid mineGameGrid = minesweeperService.gameInstances.get(USER_1);
            minesweeperPersistService.saveGame(USER_1, mineGameGrid);
        } catch(Exception e) {
            fail();
        }
    }

    @Test
    public void testSavedGameCanBeRestored() throws MinesweeperException {
        MinesweeperService minesweeperService = new MinesweeperService();
        minesweeperService.createGame(USER_2);
        try {
            MineGameGrid mineGameGrid = minesweeperService.gameInstances.get(USER_2);
            minesweeperPersistService.saveGame(USER_2, mineGameGrid);

            MineGameGrid restoredMineGameGrid = minesweeperPersistService.loadGame(USER_2);
            assertThat(restoredMineGameGrid.getElapsedTime(), equalTo(mineGameGrid.getElapsedTime()));

        } catch(Exception e) {
            fail();
        }
    }

    @Test
    public void testSavedCustomGameCanBeRestored() throws MinesweeperException {
        MinesweeperService minesweeperService = new MinesweeperService();
        minesweeperService.createGame(USER_1, 10, 10 ,10);

        try {
            MineGameGrid mineGameGrid = minesweeperService.gameInstances.get(USER_1);
            minesweeperPersistService.saveGame(USER_1, mineGameGrid);

            MineGameGrid restoredMineGameGrid = minesweeperPersistService.loadGame(USER_1);
            assertThat(restoredMineGameGrid.getElapsedTime(), equalTo(mineGameGrid.getElapsedTime()));
            assertThat(restoredMineGameGrid.totalCols, equalTo(mineGameGrid.totalCols));
            assertThat(restoredMineGameGrid.totalRows, equalTo(mineGameGrid.totalRows));
            assertThat(restoredMineGameGrid.totalMinesInGrid, equalTo(mineGameGrid.totalMinesInGrid));

        } catch(Exception e) {
            fail();
        }
    }

}
