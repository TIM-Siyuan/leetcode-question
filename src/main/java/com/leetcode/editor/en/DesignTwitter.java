//Design a simplified version of Twitter where users can post tweets, follow/unf
//ollow another user and is able to see the 10 most recent tweets in the user's ne
//ws feed. Your design should support the following methods: 
//
// 
// 
// postTweet(userId, tweetId): Compose a new tweet. 
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news
// feed. Each item in the news feed must be posted by users who the user followed 
//or by the user herself. Tweets must be ordered from most recent to least recent.
// 
// follow(followerId, followeeId): Follower follows a followee. 
// unfollow(followerId, followeeId): Follower unfollows a followee. 
// 
// 
//
// Example:
// 
//Twitter twitter = new Twitter();
//
//// User 1 posts a new tweet (id = 5).
//twitter.postTweet(1, 5);
//
//// User 1's news feed should return a list with 1 tweet id -> [5].
//twitter.getNewsFeed(1);
//
//// User 1 follows user 2.
//twitter.follow(1, 2);
//
//// User 2 posts a new tweet (id = 6).
//twitter.postTweet(2, 6);
//
//// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//
//twitter.getNewsFeed(1);
//
//// User 1 unfollows user 2.
//twitter.unfollow(1, 2);
//
//// User 1's news feed should return a list with 1 tweet id -> [5],
//// since user 1 is no longer following user 2.
//twitter.getNewsFeed(1);
// 
// Related Topics Hash Table Heap Design


package com.leetcode.editor.en;

import java.util.*;

public class DesignTwitter{

    public static void main(String[] args) {
       //Solution solution = new DesignTwitter().new Solution();
       
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    private int timestamp = 0;
    private class Tweet {
        private int id;
        private int time;
        private Tweet next;

        // 需要传入推文内容（id）和发文时间
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    };
    private class User  {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(id);
        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unfollow(int userId){
            if(userId != this.id)
                followed.remove(userId);
        }

        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    };

    private HashMap<Integer, User> userMap = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        // 关注列表的用户ID
        Set<Integer> users = userMap.get(userId).followed;
        // 自动通过 time 属性从大到小排序，容量为 users 的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for(int id : users){
            Tweet twt = userMap.get(id).head;
            if(twt == null) continue;
            pq.add(twt);
        }

        while (!pq.isEmpty()){
            if(res.size() == 10) break;
            // 弹出 time 值最大的（最近发表的）
            Tweet twt = pq.poll();
            res.add(twt.id);
            // 将下一篇 Tweet 插入进行排序
            if(twt.next != null)
                pq.add(twt.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            User flwer = userMap.get(followerId);
            flwer.unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)


}