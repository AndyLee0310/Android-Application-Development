# HW1
This section lists possible homework assignments for students who are working through this codelab as part of a course led by an instructor. It's up to the instructor to do the following:
- Assign homework if required.
- Communicate to students how to submit homework assignments.
- Grade the homework assignments.
Instructors can use these suggestions as little or as much as they want, and should feel free to assign any other homework they feel is appropriate.

If you're working through this codelab on your own, feel free to use these homework assignments to test your knowledge.

## Build and run an app
- Create a new Android project from the Empty Template.
- Add logging statements for various log levels in onCreate() in the main activity.
- Create an emulator for a device, targeting any version of Android you like, and run the app.
- Use filtering in Logcat to find your log statements and adjust the levels to only display debug or error logging statements.

## Answer these questions
### Question 1

What is the name of the layout file for the main activity?

- [ ] MainActivity.java
- [ ] AndroidManifest.xml
- [x] activity_main.xml
- [ ] build.gradle

### Question 2
What is the name of the string resource that specifies the application's name?

- [x] app_name
- [ ] xmlns:app
- [ ] android:name
- [ ] applicationId

### Question 3
Which tool do you use to create a new emulator?

- [ ] Android Device Monitor
- [x] AVD Manager
- [ ] SDK Manager
- [ ] Theme Editor

### Question 4
Assume that your app includes this logging statement:
```Jave
 Log.i("MainActivity", "MainActivity layout is complete");
```
You see the statement "MainActivity layout is complete" in the Logcat pane if the Log level menu is set to which of the following? (Hint: multiple answers are OK.)

- [x] Verbose
- [x] Debug
- [x] Info
- [ ] Warn
- [ ] Error
- [ ] Assert

## Submit your app for grading
Check to make sure the app has the following:
- An `Activity` that displays "Hello World" on the screen.
- Log statements in `onCreate()` in the main activity.
- Log level in the **Logcat** pane shows only debug or error logging statements.