package com.svetikov.storage2020.service;

import com.svetikov.storage2020.models.BoardBox;
import com.svetikov.storage2020.repository.BoardBoxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Qualifier("board")
public class BorderService implements ModelService<BoardBox,Long> {
    @Qualifier("board")
    private BoardBoxRepository boardBoxRepository;
    @Autowired
    public BorderService(BoardBoxRepository boardBoxRepository) {
        this.boardBoxRepository = boardBoxRepository;
    }


    @Override
    public BoardBox saveModel(BoardBox boardBox) {
        return boardBoxRepository.save(boardBox);
    }

    @Override
    public BoardBox getModelBuID(Long aLong) {
        return boardBoxRepository.findById(aLong).orElse(null);
    }

    @Override
    public List<BoardBox> getAllModel() {
        return boardBoxRepository.findAll();
    }

    @Override
    public BoardBox deleteModel(Long aLong) {
        BoardBox boardBox=boardBoxRepository.findById(aLong).orElse(null);
        boardBoxRepository.delete(boardBox);
        return boardBox;
    }
}
