package past.Houzz;

import java.util.*;

class Twitter {

    Map<Integer, User> userMap;
    int maxFeedReturn;
    int time;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        maxFeedReturn = 10;
        time = 0;
    }

    private class Tweet {
        int id;
        int timeStamp;
        Tweet next;
        public Tweet(int id) {
            this.id = id;
            timeStamp = time;
            next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followee;
        Tweet tweet_head;
        public User(int id) {
            this.id = id;
            tweet_head = null;
            followee = new HashSet<>();
            followee.add(id);
        }

        public void post(int tid) {
            Tweet cur = new Tweet(tid);
            time++;
            cur.next = tweet_head;
            tweet_head = cur;
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> followee = userMap.get(userId).followee;
        PriorityQueue<Tweet> queue=  new PriorityQueue<Tweet>(followee.size(), new Comparator<Tweet>() {
            @Override
            public int compare(Tweet a, Tweet b) {
                return b.timeStamp - a.timeStamp;
            }
        });
        for (int x : followee) {
            if (userMap.get(x).tweet_head != null) {
                queue.add(userMap.get(x).tweet_head);
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet cur = queue.poll();
            res.add(cur.id);
            count++;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).followee.add(followeeId);

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId) || followeeId == followerId) {
            return;
        }
        userMap.get(followeeId).followee.remove(followeeId);
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
