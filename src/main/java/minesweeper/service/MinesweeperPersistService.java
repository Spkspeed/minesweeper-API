package minesweeper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import minesweeper.exception.MinesweeperException;
import minesweeper.repository.SweeperGridRepository;
import minesweeper.repository.model.SweeperGridStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
//es otra forma de levantar la aplicacion ademas de mvn spring-boot:run
@Service
public class MinesweeperPersistService {

    @Autowired
    SweeperGridRepository sweeperGridRepository;


    Logger logger = LoggerFactory.getLogger(MinesweeperPersistService.class);


    public void saveGame(String user, MineGameGrid mineGameGrid) throws MinesweeperException {
        logger.info("El problema es que devuelve: " );
        logger.info("El usuario es: ");
        logger.info("Instancias del juego del usuario: ");

        try {
            SweeperGridStore sweeperGridStore = new SweeperGridStore();
            sweeperGridStore.setUser(user);
            sweeperGridStore.setGameGridStored(gameGridtoJson(mineGameGrid));
            sweeperGridRepository.save(sweeperGridStore);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MinesweeperException("Could not save game");
        }
    }

    public MineGameGrid loadGame(String user) throws MinesweeperException {
        SweeperGridStore sweeperGridStore = sweeperGridRepository.findByUser(user);
        return restoreGameGridJson(sweeperGridStore.getGameGridStored());
    }

    private String gameGridtoJson(MineGameGrid mineGameGrid) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(mineGameGrid);
    }

    private MineGameGrid restoreGameGridJson(String gameGridJson) throws MinesweeperException{
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(gameGridJson, MineGameGrid.class);
        } catch(IOException e) {
            e.printStackTrace();
            throw new MinesweeperException("Could not restore game");
        }
    }
}
