package com.giovane.soccer.config.swagger.annotations.standardcodes;

import java.lang.annotation.*;

import io.swagger.annotations.*;
import com.giovane.soccer.dto.TeamResponse;
import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import static java.lang.annotation.ElementType.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsParameterSwagger.*;
import static com.giovane.soccer.config.swagger.annotations.constants.TeamConstantsOperationSwagger.*;

@Target({ METHOD, ANNOTATION_TYPE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Found a single football team", response = TeamResponse.class),
        @ApiResponse(code = 400, message = "An incorrect request has been sent"),
        @ApiResponse(code = 404, message = "Team id does not exist", response = ExceptionDetailsNotFound.class)
})
@ApiImplicitParams({
        @ApiImplicitParam(name = "id", required = true, value = TEAM_FIND_BY_ID_DESCRIPTION_PARAM)
})
@ApiOperation(value = TEAM_FIND_SUMMARY_OP, notes = TEAM_FIND_DESCRIPTION_OP)
public @interface TeamGetStandardCode {

}
