package com.mxin.mxinstart.mapper;

import com.mxin.mxinstart.pojo.Users;
import com.mxin.mxinstart.untils.MyMapper;

import java.util.List;


public interface UsersMapperCustom extends MyMapper<Users> {

	//List<FriendRequestVO> queryFriendRequestList(String acceptUserId);

	//List<MyFriendsVO> queryMyFriends(String userId);

	void batchUpdateMsgSigned(List<String> msgIdList);

}