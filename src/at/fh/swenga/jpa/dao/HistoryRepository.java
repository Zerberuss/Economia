package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.model.HistoryModel;
import at.fh.swenga.jpa.model.PlayerModel;

@Repository
@Transactional
public interface HistoryRepository extends JpaRepository<HistoryModel, String>{
	
	List<HistoryModel> findByPlayerUsername(String username);
	
	List<HistoryModel> findAll();



}
