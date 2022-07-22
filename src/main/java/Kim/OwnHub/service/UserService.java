package Kim.OwnHub.service;


import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    //의존성 주입(DI, Dependency Injection)
    private final UserRepository userRepository;

    //유저의 계정 Id로 유저 정보를 반환해주는 메소드
    public UserDTO getUserByUserId(String userId){

        UserInfo uinfo = new UserInfo();

        //엔티티 객체의 정보를 옮겨 저장하기 위한 DTO 객체 선언
        UserDTO userDTO = new UserDTO();

        try{

            //엔티티 객체에 유저 정보 저장
            uinfo = userRepository.findByUserId(userId);


            //엔티티 "UserInfo"의 정보를 DTO객체에 세팅
            userDTO.convert(uinfo);

        }catch (Exception e){
            e.printStackTrace();
        }

        //DTO를 반환
        return userDTO;
    }

    //유저 이름이 일치하는 모든 유저정보 반환 메소드
    public List<UserInfo> getAllUserByUsername(String username){


        //"UserInfo" 엔티티의 형식을 갖는 ArrayList 선언
        List<UserInfo> ulist = new ArrayList<>();

        try{

            //유저 이름으로 DB 조회 후 일치하는 정보를 ArrayList 모두 저장
            ulist = userRepository.findByUsername(username);

        }catch (Exception e){
            e.printStackTrace();
        }

        //반환
        return ulist;

    }

    //팀 이름이 일치하는 모든 유저정보 반환 메소드
    public List<UserInfo> getAllUserByUserTeam(String team){

        //"UserInfo" 엔티티의 형식을 갖는 ArrayList 선언
        List<UserInfo> ulist = new ArrayList<>();

        try{

            //팀 이름으로 DB 조회 후 일치하는 정보를 ArrayList 모두 저장
            ulist = userRepository.findByTeam(team);

        }catch (Exception e){
            e.printStackTrace();
        }

        //반환
        return ulist;

    }


    //회원가입 데이터 영속화 용
    public void joining(UserInfo userInfo){

        try{

            //유저 정보 영속화
            userRepository.save(userInfo);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
