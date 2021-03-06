package cn.icedsoul.groupmessageservice.repository;


import cn.icedsoul.groupmessageservice.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IcedSoul on 2018/2/20.
 */
public interface GroupMessageRepository extends JpaRepository<GroupMessage, Integer> {

    @Query(value = "select * from group_message where group_id = ?1 limit ?2",nativeQuery = true)
    List<GroupMessage> findAll(Integer groupId, Integer limit);

    List<GroupMessage> findAllByFromIdAndToIdAndIsTransport(Integer fromId, Integer toId, Integer isTransport);

    List<GroupMessage> findAllByToIdAndTypeAndIsTransport(Integer toId, Integer type, Integer isTransport);

    List<GroupMessage> findAllByToIdAndIsTransport(Integer toId, Integer isTransport);
}
