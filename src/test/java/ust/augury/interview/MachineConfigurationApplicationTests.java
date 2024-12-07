package ust.augury.interview;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ust.augury.interview.entity.Machine;
import ust.augury.interview.exception.MachineNotFoundException;
import ust.augury.interview.service.impl.MachineConfigurationServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MachineConfigurationApplicationTests {

    private final MachineConfigurationServiceImpl service;

    public MachineConfigurationApplicationTests() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.service = new MachineConfigurationServiceImpl(mapper);
    }

    @Test
    void testGetAllMachineConfiguration() throws Exception {
        List<Machine> machines = service.getAllMachineConfiguration();

        assertNotNull(machines);
        assertFalse(machines.isEmpty());
        assertEquals("5f54dd217546020001758b7b", machines.getFirst().getId());
    }

    @Test
    void testGetMachineConfigurationById() throws Exception {
        Machine machine = service.getMachineConfigurationById("5f54dd217546020001758b7b");

        assertNotNull(machine);
        assertEquals("5f54dd217546020001758b7b", machine.getId());
        assertEquals("101/14 Guide roll felt", machine.getName());
    }

    @Test
    void testGetMachineConfigurationByIdNotFound() {
        Exception exception = assertThrows(
                MachineNotFoundException.class,
                () -> service.getMachineConfigurationById("nonexistent-id")
        );

        assertEquals("Machine not found for ID: nonexistent-id", exception.getMessage());
    }
}

