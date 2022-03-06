package com.example.Parstagram.fragments

import android.util.Log
import com.example.Parstagram.Post
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class ProfileFragment: FeedFragment() {

    // only include query of the signed in user
    override fun queryPosts(){
        // Specify which class to query
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        // Find all Post objects
        query.include(Post.KEY_USER)

        // only reutrn posts from currenlty sigend in user
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser())

        // return posts in descneding order
        query.addDescendingOrder("createdAt")

        query.setLimit(20); // limit to at most 20 results

        query.findInBackground(object: FindCallback<Post> {
            override fun done(posts: MutableList<Post>?, e: ParseException?) {
                if (e != null) {
                    e.printStackTrace()
                }else{
                    if (posts != null){
                        for (post in posts){
                            Log.i(TAG, "Post： " + post.getDescription() + ", Username: " + post.getUser()?.username)
                        }
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}