package com.svetikov.storage2020.component;

import com.sourceforge.snap7.moka7.S7;
import com.svetikov.storage2020.models.PLCData;
import com.svetikov.storage2020.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import si.trina.moka7.live.PLC;
import si.trina.moka7.live.PLCListener;

@Slf4j
public class PLCComponent {
    private PLC plc;
    @Qualifier("plc")
    private final ModelService<PLCData,Integer> modelService;

    @Autowired
    public PLCComponent(@Qualifier("plc") ModelService modelService) {
        this.modelService = modelService;
    }

    public void onInitPLC() throws Exception {
        log.info("on init plc");
        for (PLCData plcData : this.modelService.getAllModel()) {
            log.info("plc data list "+plcData.toString());
            this.plc = new PLC(plcData.getId() + "plc", plcData.getAdrIP(),
                    plcData.getLengthRead(),
                    plcData.getLengthWrite(),
                    plcData.getDbRead(),
                    plcData.getDbWrite(),
                    new double[]{},
                    plcData.getRack(),
                    plcData.getSlot(),
                    S7.S7AreaDB,
                    S7.S7AreaDB);
            PLCListenerImpl plcListener = new PLCListenerImpl();
            plc.listeners.add(plcListener);
            Thread threadPLC = new Thread(plc);
            threadPLC.start();
            Thread.sleep(3000);
            log.info("plc connect " + plcData.getId() + "  " + plc.connected);

        }
    }

    private class PLCListenerImpl implements PLCListener {
        @Override
        public void PLCBitChanged(int address, int pos, boolean val, String plcName) {
            switch (address) {
                case 0:
                    switch (pos) {
                        case 1:
                            System.out.println("Bit at address 0.1 of PLC " + plcName + " changed to: " + val);
                    }
            }
        }
    }

    public void onInitDBAreaPLC() throws Exception {
        log.info("on Init DB Area PLC");
        log.info("connect " + plc.connected + "  " + Thread.currentThread().getName());
        log.info("adr " + plc.getDInt(true, 0));

    }
}
