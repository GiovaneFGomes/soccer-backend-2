package com.giovane.soccer.config.swagger.annotations.constants;

import lombok.*;
import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class TeamConstantsOperationSwagger {

    public static final String TEAM_SAVE_SUMMARY_OP = "This endpoint save a football team";
    public static final String TEAM_SAVE_DESCRIPTION_OP = "This method will save a football team";

    public static final String TEAM_PUT_SUMMARY_OP = "This endpoint updates a football team";
    public static final String TEAM_PUT_DESCRIPTION_OP = "This method will updates a football team";

    public static final String TEAM_DELETE_BY_ID_SUMMARY_OP = "This endpoint deletes a football team";
    public static final String TEAM_DELETE_BY_ID_DESCRIPTION_OP = "This method will delete the football team";

    public static final String TEAM_FIND_BY_ID_SUMMARY_OP = "This endpoint find a single team";
    public static final String TEAM_FIND_BY_ID_DESCRIPTION_OP = "This method will find a single team in the database";

    public static final String TEAM_FIND_ALL_SUMMARY_OP = "This endpoint find all teams";
    public static final String TEAM_FIND_ALL_DESCRIPTION_OP = "This method will find all teams in the database";

}
