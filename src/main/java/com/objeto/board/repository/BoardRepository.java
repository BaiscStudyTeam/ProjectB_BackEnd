package com.objeto.board.repository;

import com.objeto.board.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, String> {

    List<Board> findByUserId(String userId);
}
