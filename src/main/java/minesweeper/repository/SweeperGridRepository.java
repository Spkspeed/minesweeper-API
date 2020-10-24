package minesweeper.repository;

import minesweeper.repository.model.SweeperGridStore;
import org.springframework.data.repository.CrudRepository;

public interface SweeperGridRepository extends CrudRepository<SweeperGridStore, Integer> {

    SweeperGridStore findById(int id);

    SweeperGridStore findByUser(String user);

}
