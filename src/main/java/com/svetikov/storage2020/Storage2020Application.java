package com.svetikov.storage2020;

import com.svetikov.storage2020.component.PLCComponent;
import com.svetikov.storage2020.models.BoardBox;
import com.svetikov.storage2020.models.PLCData;
import com.svetikov.storage2020.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Storage2020Application implements CommandLineRunner {
    @Qualifier("plc")
    private final ModelService<PLCData,Integer> modelService;
    @Qualifier("board")
    private final ModelService<BoardBox,Long> modelBoxService;
    private final PLCComponent plcComponent;

    @Autowired
    public Storage2020Application(@Qualifier("plc") ModelService modelService,@Qualifier("board")ModelService modeBoxService, PLCComponent plcComponent) {
        this.modelService = modelService;
        this.modelBoxService=modeBoxService;
        this.plcComponent = plcComponent;
    }


    public static void main(String[] args) {
        SpringApplication.run(Storage2020Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("start test");
        PLCData plcData = new PLCData(
                "192.168.0.190",
                8,
                32,
                1,
                0,
                0,
                2
        );



        modelService.saveModel(plcData);
//        Thread.sleep(3000);
        plcComponent.onInitPLC();
//        plcComponent.onInitDBAreaPLC();


        BoardBox boardBox=new BoardBox(1,1,1,1,1);
modelBoxService.saveModel(boardBox);


    }
}
