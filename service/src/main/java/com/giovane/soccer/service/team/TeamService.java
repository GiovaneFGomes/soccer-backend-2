package com.giovane.soccer.service.team;

import java.util.List;
import com.giovane.soccer.dto.TeamRequestDto;
import com.giovane.soccer.dto.TeamResponseDto;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.TeamRepository;
import com.giovane.soccer.exceptions.notfound.NotFoundException;
import com.giovane.soccer.mapper.TeamMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamResponseDto saveTeam(TeamRequestDto team) {
        Team teamEntity = TeamMapper.INSTANCE.toTeamEntity(team);
        Team teamSave = teamRepository.save(teamEntity);
        return TeamMapper.INSTANCE.toTeamResponseDto(teamSave);
    }

    public TeamResponseDto updateTeamById(TeamRequestDto team, Integer id){
        Team teamId = teamRepository
                .findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        team.setId(teamId.getId());
        Team teamEntity = TeamMapper.INSTANCE.toTeamEntity(team);
        Team teamSave = teamRepository.save(teamEntity);
        return TeamMapper.INSTANCE.toTeamResponseDto(teamSave);
    }

    public void deleteTeamById(Integer id) {
        teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        teamRepository.deleteById(id);
    }

    public TeamResponseDto findTeamById(Integer id){
        Team teamId = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return TeamMapper.INSTANCE.toTeamResponseDto(teamId);
    }

    public List<TeamResponseDto> findAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamMapper.INSTANCE::toTeamResponseDto)
                        .toList();
    }

}
