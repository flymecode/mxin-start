package com.xupt.service.impl;

import com.xupt.enums.MsgSignFlagEnum;
import com.xupt.mapper.ChatMsgMapper;
import com.xupt.mapper.UserMapper;
import com.xupt.netty.ChatMsg;
import com.xupt.pojo.User;
import com.xupt.service.UserService;
import com.xupt.untils.IdWorker;
import com.xupt.untils.MD5Utils;
import com.xupt.untils.QRCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author maxu
 * @date 2019/4/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QRCodeUtils qrCodeUtils;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private ChatMsgMapper chatMsgMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        return result == null ? false : true;
    }

    @Override
    public User queryUserForLogin(String username, String pwd) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",MD5Utils.getMD5Str(pwd));
        User result = userMapper.selectOneByExample(userExample);
        return result;
    }

    @Override
    public User saveUser(User user) {
         user.setNickname("");
        user.setFaceImage("");
        user.setFaceImageBig("");
        user.setQrcode("");
        user.setId(String.valueOf(idWorker.nextId()));
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUserInfo(User user) {
        return null;
    }

    @Override
    public Integer preconditionSearchFriends(String myUserId, String friendUsername) {
        return null;
    }

    @Override
    public User queryUserInfoByUsername(String username) {
        return null;
    }

    @Override
    public void sendFriendRequest(String myUserId, String friendUsername) {

    }

    @Override
    public void deleteFriendRequest(String sendUserId, String acceptUserId) {

    }

    @Override
    public void passFriendRequest(String sendUserId, String acceptUserId) {

    }

    @Override
    public String saveMsg(com.xupt.netty.ChatMsg chatMsg) {
        com.xupt.pojo.ChatMsg msgDB = new com.xupt.pojo.ChatMsg();
        String msgId = String.valueOf(idWorker.nextId());
        msgDB.setId(msgId);
        msgDB.setAcceptUserId(chatMsg.getReceiverId());
        msgDB.setSendUserId(chatMsg.getSenderId());
        msgDB.setCreateTime(new Date());
        msgDB.setSignFlag(MsgSignFlagEnum.unsign.type);
        msgDB.setMsg(chatMsg.getMsg());
        chatMsgMapper.insert(msgDB);
        return msgId;
    }

    @Override
    public void updateMsgSigned(List<String> msgIdList) {

    }

    @Override
    public List<ChatMsg> getUnReadMsgList(String acceptUserId) {
        return null;
    }

}
