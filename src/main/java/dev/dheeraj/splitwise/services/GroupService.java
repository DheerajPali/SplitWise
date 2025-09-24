package dev.dheeraj.splitwise.services;

import dev.dheeraj.splitwise.exceptions.GroupNotFoundException;
import dev.dheeraj.splitwise.exceptions.UnAuthorizedAccessException;
import dev.dheeraj.splitwise.exceptions.UserNotFoundException;
import dev.dheeraj.splitwise.models.Group;
import dev.dheeraj.splitwise.models.User;
import dev.dheeraj.splitwise.models.constant.UserStatus;
import dev.dheeraj.splitwise.repositories.GroupRepository;
import dev.dheeraj.splitwise.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
//@RequiredArgsConstructor
@NoArgsConstructor
public class GroupService {

    private  GroupRepository groupRepository;
    private  UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(String name, String description, Long createdByUserId, List<User> members)throws UserNotFoundException{
        User createdBy = userRepository.findById(createdByUserId).orElseThrow(() -> new UserNotFoundException("Only registered user can create a group"));

        //if members are not registered, then create those user as invited as well...
        if(members != null && !members.isEmpty()){
            for(User member : members){
                if(!userRepository.existsById(member.getId())){
                    User user = new User();
                    user.setPhone(member.getPhone());
                    user.setUserStatus(UserStatus.INVITED);
                    userRepository.save(user);
                }
            }
            members.add(createdBy);
        }



        Group group = new Group();
        group.setCreatedBy(createdBy);
        group.setName(name);
        group.setDescription(description);
        group.setMembers(members);
        return groupRepository.save(group);
    }

    @Transactional
    public List<Group> getGroupsByUserId(Long userId)throws UserNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not registered, please register & try again"));
        List<Group> usersGroup = groupRepository.findAllByMembersContaining(Collections.singletonList(user));
//        List<Group> usersGroup = new ArrayList<>();
//        for(Group group : allGroups){
//            if(group.getMembers().contains(user)){
//                usersGroup.add(group);
//            }
//        }

        //added to print on commandline
        for(Group group : usersGroup){
            System.out.print(group.getName() + " ");
        }
        return usersGroup;
    }

    @Transactional
    public Group addMemberToGroup(Long userId, Long groupId, Long phone)throws UserNotFoundException, UnAuthorizedAccessException, GroupNotFoundException{
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found with groupId " + groupId));
        if(!Objects.equals(group.getCreatedBy().getId(), userId)) throw new UnAuthorizedAccessException("You don't have access to perform this task");
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not registered, please register & try again"));

        User newMember = userRepository.getUserByPhone(phone);
        if(newMember == null){
            newMember = new User();
            newMember.setUserStatus(UserStatus.INVITED);
            newMember.setPhone(phone);
            userRepository.save(newMember);
        }

        List<User> groupMembers = group.getMembers();
        if(groupMembers == null){
            groupMembers = new ArrayList<>();
        }
        groupMembers.add(newMember);
        group.setMembers(groupMembers);


        return groupRepository.save(group);
    }
}

/*

public Group addMembersToGroup(Long userId, Long groupId, List<User> members)throws UserNotFoundException, UnAuthorizedAccessException, GroupNotFoundException{
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found with groupId " + groupId));
        if(!group.getCreatedBy().getId().equals(userId)) throw new UnAuthorizedAccessException("You don't have access to perform this task");
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not registered, please register & try again"));

        List<User> groupMembers = group.getMembers();

        for(User member : members){
            if(!userRepository.existsById(member.getId())){
                User invitedUser = new User();
                invitedUser.setPhone(member.getPhone());
                invitedUser.setUserStatus(UserStatus.INVITED);
                userRepository.save(invitedUser);
                groupMembers.add(invitedUser);
            }
        }
        group.setMembers(groupMembers);


        // Avoid adding duplicate members
//        User finalNewMember = newMember;
//        if (groupMembers.stream().noneMatch(u -> Objects.equals(u.getId(), finalNewMember.getId()))) {
//            groupMembers.add(newMember);
//            group.setMembers(groupMembers);
//            group = groupRepository.save(group);
//        }
//        groupMembers.addAll(members);

        return groupRepository.save(group);
    }
 */