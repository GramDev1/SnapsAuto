# Snaps Auto

## About
I'm a pretty lazy person and suddently had a lot of streaks on Snap Chat. Streaks are fun! They are awesome and some of mine went really high. However, it was hard
maintaining these streaks with my sleep depruived brain so I automated. Welcome to Snaps Auto!

## Usage
SnapsAuto is written in [Kotlin](https://kotlinlang.org), a JVM based langugae written by [Jetbrains](https://jetbrains.org). I find I prefer Kotlin, but it has 100% 
interoperability with Java.

SnapsAuto uses the [Unnoficial Java API Client for Snapchat](https://github.com/hatboysam/JavaSnap) in order to interface with snapchat

### Java Usage
```
//Creates an Auto SNAP with the params: Snapchat instance, the image file, snap duration, how often to send the snap, the date to start or null for instant
AutoSnap snapper = new AutoSnap(Snapchat.login(YOUR_SNAPCHAT_USERNAME,YOUR_SNAPCHAT_PASSWORD),new File("My_Dank_Image.png"),3,new Pair<>(5L, TimeUnit.HOURS),null);
snapper.addRecipient("cool_username1");
snapper.addRecipient("cool_username2");
//So on and so forth
snapper.start();
```

## Getting it
SnapsAuto is available at [Jitpack](https://jitpack.io) for your favorite build tool [here](https://jitpack.io/#mcjp78/SnapsAuto)
