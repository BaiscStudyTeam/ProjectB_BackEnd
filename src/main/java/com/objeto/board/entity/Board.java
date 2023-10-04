package com.objeto.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity(name="board")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Board {

    /**
     * registed board id
     */
    @Id
    private String boardId;

    /**
     * user Id that made board
     */
    private String userId;

    /**
     * board description
     */
    private String board_desc;

    /**
     * board thumbnail image file Link
     */
    private String board_thumbnail;

    /**
     * board Register date
     */
    private Timestamp regDt;


}
