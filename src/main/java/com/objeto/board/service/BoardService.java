package com.objeto.board.service;

import com.objeto.board.dto.request.findBoardListByUserIdDto;
import com.objeto.board.entity.Board;
import com.objeto.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findBoardListByUserId(findBoardListByUserIdDto reqDto) {
        return boardRepository.findByUserId(reqDto.getUserId());
    }

}
