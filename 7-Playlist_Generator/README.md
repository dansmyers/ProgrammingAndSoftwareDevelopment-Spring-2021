# Finish the Playlist Generator Project

## Move `.mvn` to your project directory

The `.mvn` directory is a "hidden" directory used by the Maven build tool. Files and directories starting with `.` are considered hidden and won't be displayed by the shell when you do a regular `ls` command.

Copy `.mvn` from your other project directory into `Playlist-Generator`. First, `cd` into `PLaylist-Generator`, then use the `cp` command:

```
cp -r ../cms167-f19-java-spring-boot/.mvn .
```

`-r` makes the copy operation recursive&ndash;copying all subdirectories&ndash; and `.` refers to the current working directory as the destination of the copy. You can verify that the operation worked by typing `ls -a`.


## Finish `TrackInfo.java`

If you haven't done so, use `PlaylistInfo` as a guide to complete `TrackInfo`. The methods are all symmetric.


## Add code to `Controller`


## Test


## Add Spotify `<iframe>`

