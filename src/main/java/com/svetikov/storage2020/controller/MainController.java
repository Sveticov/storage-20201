package com.svetikov.storage2020.controller;

import com.svetikov.storage2020.component.ComponentPLCDATA;
import com.svetikov.storage2020.component.PLCComponent;
import com.svetikov.storage2020.models.BoardBox;
import com.svetikov.storage2020.models.PLCData;
import com.svetikov.storage2020.repository.PLCRepository;
import com.svetikov.storage2020.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/app")
public class MainController {
    @Autowired
    @Qualifier("plc")
    ModelService<PLCData, Integer> plcRepository;
    @Autowired
    @Qualifier("board")
    ModelService<BoardBox, Long> boardRepository;
    @Autowired
    PLCComponent plcComponent;

    @GetMapping("/1")
    public List<PLCData> getA() {
        return plcRepository.getAllModel();
    }

    @GetMapping("/2")
    public void getB() throws Exception {
        plcComponent.onInitDBAreaPLC();
    }

    @GetMapping("/3")
    public List<BoardBox> box() {

        return boardRepository.getAllModel();
    }

}
