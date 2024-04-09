package br.com.alan.Demonstration.controllers.test;

import br.com.alan.Demonstration.controllers.test.documentation.TestControllerDocumentation;
import br.com.alan.Demonstration.dtos.test.TestDTO;
import br.com.alan.Demonstration.services.test.TestService;
import br.com.alan.Demonstration.utils.HeaderUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tests", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Test Controller", description = "Request group description")
public class TestController implements TestControllerDocumentation {

  private final TestService testService;

  @Override
  public ResponseEntity<List<TestDTO>> findAll(@RequestHeader HttpHeaders headers)
      throws BadRequestException {
    List<TestDTO> list = this.testService.findAll(HeaderUtils.getAction(headers));

    if (list.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(list);
  }

  @Override
  public ResponseEntity<TestDTO> findById(@PathVariable("id")UUID id, @RequestHeader HttpHeaders headers) throws BadRequestException {

    TestDTO testDTO =  this.testService.findById(id, HeaderUtils.getAction(headers));

    if (testDTO == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(testDTO);

  }

}
