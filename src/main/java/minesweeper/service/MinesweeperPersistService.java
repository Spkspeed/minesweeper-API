package minesweeper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import minesweeper.repository.SweeperGridRepository;
import minesweeper.repository.model.SweeperGridStore;
import org.springframework.beans.factory.annotation.Autowired;

public class MinesweeperPersistService {

    @Autowired
    SweeperGridRepository sweeperGridRepository;

    public void saveGame(String user, MineGameGrid mineGameGrid) throws JsonProcessingException {
        SweeperGridStore sweeperGridStore = new SweeperGridStore();
        sweeperGridStore.setUser(user);
        sweeperGridStore.setGameGridStored(mineGameGrid.gameGridtoJson());
        sweeperGridRepository.save(sweeperGridStore);
    }

    public MineGameGrid loadGame(String user) {
        SweeperGridStore sweeperGridStore = sweeperGridRepository.findByUser(user);
        MineGameGrid mineGameGrid = loadGrid(sweeperGridStore.getGameGridStored());
        return mineGameGrid;
    }

    private MineGameGrid loadGrid(String gameGridStored) {
        return null;
    }

}
