package Kim.OwnHub.service;

import Kim.OwnHub.DTO.ScheduleDTO;
import Kim.OwnHub.entity.Schedule;
import Kim.OwnHub.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    public void addSchedule(ScheduleDTO scheduleDTO){

        try{

            Schedule schedule = new Schedule.Builder()
                    .sdate(scheduleDTO.getSdate())
                    .edate(scheduleDTO.getEdate())
                    .stitle(scheduleDTO.getStitle())
                    .scontent(scheduleDTO.getScontent())
                    .s_status(scheduleDTO.getS_status())
                    .suid(scheduleDTO.getSuid())
                    .build();

            scheduleRepository.save(schedule);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Schedule> viewSchedule(String uid){

        List<Schedule> schedule = new ArrayList<>();

        try{

            schedule = scheduleRepository.findBySuid(uid);

        }catch (Exception e){
            e.printStackTrace();
        }

        return schedule;
    }

}
