package ust.augury.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ust.augury.interview.entity.Machine;
import ust.augury.interview.service.MachineConfigurationService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/machines")
public class MachineConfigurationController {

    private final MachineConfigurationService machineConfigurationService;

    @Autowired
    public MachineConfigurationController(MachineConfigurationService machineConfigurationService) {
        this.machineConfigurationService = machineConfigurationService;
    }

    @GetMapping("/{machineId}")
    public Machine getMachineConfiguration(@PathVariable String machineId) throws IOException {

        return machineConfigurationService.getMachineConfigurationById(machineId);
    }

    @GetMapping
    public List<Machine> getAllMachineConfiguration() throws IOException {

        return machineConfigurationService.getAllMachineConfiguration();
    }
}
