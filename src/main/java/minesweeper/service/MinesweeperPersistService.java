package minesweeper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import minesweeper.repository.SweeperGridRepository;
import minesweeper.repository.model.SweeperGridStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MinesweeperPersistService {

    @Autowired
    SweeperGridRepository sweeperGridRepository;

    public void saveGame(String user, MineGameGrid mineGameGrid) throws JsonProcessingException {
        SweeperGridStore sweeperGridStore = new SweeperGridStore();
        sweeperGridStore.setUser(user);
        sweeperGridStore.setGameGridStored(gameGridtoJson(mineGameGrid));
        sweeperGridRepository.save(sweeperGridStore);
    }

    public MineGameGrid loadGame(String user) {
        SweeperGridStore sweeperGridStore = sweeperGridRepository.findByUser(user);
        return restoreGameGridJson(sweeperGridStore.getGameGridStored());
    }

    private String gameGridtoJson(MineGameGrid mineGameGrid) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(mineGameGrid);
    }

    private MineGameGrid restoreGameGridJson(String gameGridJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(gameGridJson, MineGameGrid.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
