package br.com.alan.Demonstration.dtos.test;

import br.com.alan.Demonstration.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDTO {

  UUID id;

  String description;

  int unit;

  ActionType actionType;

}
