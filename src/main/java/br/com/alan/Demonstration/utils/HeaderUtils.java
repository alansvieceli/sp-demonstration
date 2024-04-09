package br.com.alan.Demonstration.utils;


import br.com.alan.Demonstration.enums.ActionType;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

@UtilityClass
@Slf4j
public class HeaderUtils {

  final String ACTION = "Action";

  public ActionType getAction(HttpHeaders header) {

    try {

      if (header != null && header.containsKey(ACTION)) {
        String value = header.getFirst(ACTION);
        return ActionType.valueOf(value);
      }

    } catch (Exception e) {
      return ActionType.OK;
    }

    return ActionType.NOT_FOUND;
  }

}
