package com.objeto.board.controller;

import com.objeto.board.dto.request.findBoardListByUserIdDto;
import com.objeto.board.entity.Board;
import com.objeto.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
@Validated
public class BoardController {

    private final BoardService boardService;

    /**
     * show post's detail information
     * @param reqDto
     * @return http requet body OK
     */
    @PostMapping("/findBoardListByUserId")
    public ResponseEntity<List<Board>> findBoardListByUserId(@RequestBody findBoardListByUserIdDto reqDto) {
        System.out.println("in the findBoardListByUserId ** ");
        return ResponseEntity.ok(boardService.findBoardListByUserId(reqDto));
    }
}
