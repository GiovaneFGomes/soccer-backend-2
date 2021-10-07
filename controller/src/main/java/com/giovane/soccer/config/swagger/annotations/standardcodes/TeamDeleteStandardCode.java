package com.giovane.soccer.config.swagger.annotations.standardcodes;

import java.lang.annotation.*;

import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.http.MediaType;

import static java.lang.annotation.ElementType.*;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsParameterSwagger.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsOperationSwagger.*;

@Target({ METHOD, ANNOTATION_TYPE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "The football team has been deleted"),
        @ApiResponse(responseCode = "400", description = "An incorrect request has been sent"),
        @ApiResponse(responseCode = "404", description = "Team id does not exist",
                content = @Content(schema = @Schema(implementation = ExceptionDetailsNotFound.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
})
@Parameter(name = "id", example = "10", required = true,
        description = TEAM_DESCRIPTION_PARAM, in = PATH
)
@Operation(summary = TEAM_DELETE_BY_ID_SUMMARY_OP, description = TEAM_DELETE_BY_ID_DESCRIPTION_OP)
public @interface TeamDeleteStandardCode {

}
