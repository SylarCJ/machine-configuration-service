package ust.augury.interview.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ust.augury.interview.entity.Machine;
import ust.augury.interview.exception.MachineNotFoundException;
import ust.augury.interview.service.MachineConfigurationService;

import java.io.IOException;
import java.util.List;

@Service
public class MachineConfigurationServiceImpl implements MachineConfigurationService {

    private final ObjectMapper mapper;

    @Autowired
    public MachineConfigurationServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Machine> getAllMachineConfiguration() throws IOException {
        // Deserialize the JSON file into a list of Machine objects
        return mapper.readValue(
                new ClassPathResource("machine_configs.json").getInputStream(),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Machine getMachineConfigurationById(String machineId) throws IOException {
        List<Machine> machines = getAllMachineConfiguration();

        // Find the machine with the specified ID
        return machines.stream()
                .filter(machine -> machine.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new MachineNotFoundException(machineId));
    }
}
