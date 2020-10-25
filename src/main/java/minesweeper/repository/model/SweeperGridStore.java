package minesweeper.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SweeperGridStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    String user;

    String gameGridStored;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGameGridStored() {
        return gameGridStored;
    }

    public void setGameGridStored(String gameGridStored) {
        this.gameGridStored = gameGridStored;
    }
}
