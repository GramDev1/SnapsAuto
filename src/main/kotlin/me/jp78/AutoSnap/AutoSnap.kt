package me.jp78.AutoSnap

import com.habosa.javasnap.Snapchat
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Jp78 cuz lazy. Open sourced
 *
 * Creates a new autosnap class
 * @param snap A snapchat instance with your login details
 * @param image The file you want to send to your streaks. Please note it *must* be an image!
 * @param time  How long should your glorious picture last? The full 10 seconds? Maybe 3?
 * @param every How often you want to send the snap. Is it every 24 hours? Every minute? Put it here!
 * @param start Don't wanna have to start your program at midnight? You don't have to! Put the date here when to start the snaps, or null for instant!
 */
class AutoSnap(val snap: Snapchat, var image: File, val time : Int, val every: Pair<Long, TimeUnit>, val start: Date?) {
    private var recipients: MutableList<String> = ArrayList()
    private val timer = Timer("Snap timer")
    private var started = false
    /**
     * Adds a recipient to your streaks. Username should be snap username
     * @param username the snapchat's username/handle
     * @return The autosnap (For chaining)
     */
    public fun addRecipient(username: String) : AutoSnap{
        if (! recipients.contains(username)) recipients.add(username)
        return this
    }

    /**
     * Person ticked you off? Wanna ruin that streak? Do so here!
     * @param username Handle of the person you wanna ruin the streak with
     */
    fun removeRecipient(username: String) {
        recipients.remove(username)
    }

    /**
     * Don't remember all those streaks? Get 'em here!
     * @return The people you are sending pics 2
     */
    fun getRecipients(): List<String> {
        return recipients.toList()
    }

    /**
     * For when you wanna do away with the current recipients and start fresh
     *
     * @param newRecepients The new recipients
     * @return The autosnap (For chaining)
     */
    fun setRecipients(newRecepients: List<String>) : AutoSnap{
        this.recipients = newRecepients.toMutableList()
        return  this;
    }

    /**
     * Start the snappin!
     */
    fun start() : AutoSnap {
        if(started) throw IllegalStateException("You cannot start an autosnap twice! Please create a new autosnap!")
        if (start != null) timer.schedule(SnapTask(this), start, every.second.toMillis(every.first)) else timer.schedule(SnapTask(this),System.currentTimeMillis() + 1000, every.second.toMillis(every.first))
        started = false
        return this
    }



}