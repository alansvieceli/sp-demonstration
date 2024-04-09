package br.com.alan.Demonstration.controllers.test.documentation;

import br.com.alan.Demonstration.dtos.test.TestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.UUID;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;


public interface TestControllerDocumentation {


  @Operation(summary = "Fetch All Data")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Data was returned correctly",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = TestDTO.class))}),
      @ApiResponse(responseCode = "400", description = "Bad Request"),
      @ApiResponse(responseCode = "401", description = "Unauthorized"),
      @ApiResponse(responseCode = "403", description = "Forbidden"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  ResponseEntity<List<TestDTO>> findAll(@RequestHeader HttpHeaders headers)
      throws BadRequestException;

  @Operation(summary = "Fetch Only a Data")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Data was returned correctly",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = TestDTO.class))}),
      @ApiResponse(responseCode = "400", description = "Bad Request"),
      @ApiResponse(responseCode = "401", description = "Unauthorized"),
      @ApiResponse(responseCode = "403", description = "Forbidden"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  ResponseEntity<TestDTO> findById(@PathVariable("id") UUID id, @RequestHeader HttpHeaders headers)
      throws BadRequestException;


}
