package com.xupt.mapper;

import com.xupt.pojo.User;
import com.xupt.untils.MyMapper;

import java.util.List;


public interface UsersMapperCustom extends MyMapper<User> {

	//List<FriendRequestVO> queryFriendRequestList(String acceptUserId);

	//List<MyFriendsVO> queryMyFriends(String userId);

	void batchUpdateMsgSigned(List<String> msgIdList);

}