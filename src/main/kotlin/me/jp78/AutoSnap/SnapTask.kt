package me.jp78.AutoSnap

import java.util.*

/**
 * This file was created by @author thejp for the use of
Jpsy. Please note, all rights to code are retained by
afore mentioned thejp unless otherwise stated.
File created: Tuesday, March, 2017
 */
class SnapTask internal constructor(val snapper : AutoSnap) : TimerTask() {
    override fun run() {
        snapper.snap.sendSnap(snapper.image,snapper.getRecipients(),false,false,snapper.time)
    }
}