package dev.dheeraj.splitwise.controllers;

import dev.dheeraj.splitwise.dtos.*;
import dev.dheeraj.splitwise.exceptions.GroupNotFoundException;
import dev.dheeraj.splitwise.exceptions.UnAuthorizedAccessException;
import dev.dheeraj.splitwise.exceptions.UserNotFoundException;
import dev.dheeraj.splitwise.models.Group;
import dev.dheeraj.splitwise.services.GroupService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public CreateGroupResponseDTO createGroup(CreateGroupRequestDTO requestDTO){
        CreateGroupResponseDTO responseDTO = new CreateGroupResponseDTO();
        try{
            Group group = groupService.createGroup(requestDTO.getName(), requestDTO.getDescription(), requestDTO.getUserId(),requestDTO.getMembers());
            responseDTO.setGroup(group);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Group created successfully");
            return responseDTO;
        } catch (UserNotFoundException e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public GetGroupByUserResponseDTO getGroupsByUserId(GetGroupByUserRequestDTO requestDTO){
        GetGroupByUserResponseDTO responseDTO = new GetGroupByUserResponseDTO();
        try{
            List<Group> groups = groupService.getGroupsByUserId(requestDTO.getUserId());
            responseDTO.setGroups(groups);
            responseDTO.setMessage("Group fetched successfully");
        }
        catch (UserNotFoundException e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public AddMemberToGroupResponseDTO addMemberToGroup(AddMemberToGroupRequestDTO requestDTO){
        AddMemberToGroupResponseDTO responseDTO = new AddMemberToGroupResponseDTO();
        try{
            Group group = groupService.addMemberToGroup(requestDTO.getUserId(),requestDTO.getGroupId(), requestDTO.getNewMemberPhoneNumber());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User added successfully");
            return responseDTO;
        } catch (UserNotFoundException | GroupNotFoundException | UnAuthorizedAccessException e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return  responseDTO;
    }
}
