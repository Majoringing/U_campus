package jxnu.edu.x3321.domain;

public class Followers {
	//int followers_id 关注的id（小粉丝）
	private int follower_id;
	//int follower_user_id 被关注的id（大佬）
	private int follower_user_id;
	public int getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(int follower_id) {
		this.follower_id = follower_id;
	}
	public int getFollower_user_id() {
		return follower_user_id;
	}
	public void setFollower_user_id(int follower_user_id) {
		this.follower_user_id = follower_user_id;
	}
	
	
	

}
