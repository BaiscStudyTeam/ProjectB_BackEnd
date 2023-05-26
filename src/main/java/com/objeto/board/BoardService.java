package com.objeto.board;

import org.springframework.stereotype.Service;


@Service
public class BoardService {

    public void callMe() {
        System.out.println("-----------------------------------------------");
        System.out.println("BOARD : Event Recieved From Core-Module");
        System.out.println("-----------------------------------------------");
    }
}
