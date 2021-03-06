package com.giovane.soccer.service.v1.team;

import com.giovane.soccer.service.model.team.request.TeamRequestService;
import com.giovane.soccer.service.model.team.response.TeamResponseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService service;

    public TeamResponseService saveTeam(TeamRequestService team) {
        return service.saveTeam(team);
    }

    public TeamResponseService updateTeamById(TeamRequestService team, Integer id) {
        TeamResponseService teamId = service.findTeamById(id);
        return service.updateTeamById(team, teamId.getId());
    }

    public void deleteTeamById(Integer id) {
        service.findTeamById(id);
        service.deleteTeamById(id);
    }

    public TeamResponseService findTeamById(Integer id) {
        service.findTeamById(id);
        return service.findTeamById(id);
    }

    public List<TeamResponseService> findAllTeams() {
        return service.findAllTeams();
    }

}
