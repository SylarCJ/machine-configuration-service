package ust.augury.interview.service;

import ust.augury.interview.entity.Machine;

import java.io.IOException;
import java.util.List;

public interface MachineConfigurationService {
    Machine getMachineConfigurationById(String machineId) throws IOException;

    List<Machine> getAllMachineConfiguration() throws IOException;
}
