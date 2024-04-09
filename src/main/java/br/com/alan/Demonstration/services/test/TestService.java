package br.com.alan.Demonstration.services.test;

import br.com.alan.Demonstration.dtos.test.TestDTO;
import br.com.alan.Demonstration.enums.ActionType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

  private TestDTO createTestDTO(String description, int unit, ActionType action) {
    return TestDTO.builder()
        .id(UUID.randomUUID())
        .description(description)
        .unit(unit)
        .actionType(action)
        .build();
  }

  public TestDTO findById(UUID id, ActionType action) {

    if (action.equals(ActionType.OK)) {
      return createTestDTO("Test", 98, action);
    }

    return null;
  }

  public List<TestDTO> findAll(ActionType action) throws BadRequestException {
    List<TestDTO> list = new ArrayList<>();

    System.out.println(action);

    if (action.equals(ActionType.OK)) {
      for (int i = 1; i <= 3; i++) {
        list.add(createTestDTO("Test 0" + i, i, action));
      }
      return list;
    }

    if (action.equals(ActionType.BAD_REQUEST)) {
      throw new BadRequestException("Erro (400)");
    }

    if (action.equals(ActionType.INTERNAL_SERVER_ERROR)) {
      throw new RuntimeException("Erro (500)");
    }

    return list;
  }

}
