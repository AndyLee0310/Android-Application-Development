# HW3_2.1

This section lists possible homework assignments for students who are working through this codelab as part of a course led by an instructor. It's up to the instructor to do the following:
- Assign homework if required.
- Communicate to students how to submit homework assignments.
- Grade the homework assignments.

Instructors can use these suggestions as little or as much as they want, and should feel free to assign any other homework they feel is appropriate.

If you're working through this codelab on your own, feel free to use these homework assignments to test your knowledge.

## Build and run an app
Open the [HelloToast](https://github.com/google-developer-training/android-fundamentals-apps-v2/tree/master/HelloToast) app that you created in a previous practical codelab.
1. Modify the **Toast** button so that it launches a new `Activity` to display the word "Hello!" and the current count, as shown below.
2. Change the text on the `Toast` button to Say Hello.
![Activity](00_img/Activity.png)

## Answer these questions
### Question 1
What changes are made when you add a second `Activity` to your app by choosing **File > New > Activity** and an `Activity` template? Choose one:
- [ ] The second `Activity` is added as a Java class. You still need to add the XML layout file.
- [ ] The second `Activity` XML layout file is created and a Java class added. You still need to define the class signature.
- [X] The second `Activity` is added as a Java class, the XML layout file is created, and the `AndroidManifest.xml` file is changed to declare a second `Activity`.
- [ ] The second `Activity` XML layout file is created, and the `AndroidManifest.xml` file is changed to declare a second `Activity`.

### Question 2
What happens if you remove the `android:parentActivityName` and the `<meta-data>` elements from the second `Activity` declaration in the `AndroidManifest.xml` file? Choose one:
- [ ] The second `Activity` no longer appears when you try to start it with an explicit `Intent`.
- [ ] The second `Activity` XML layout file is deleted.
- [ ] The Back button no longer works in the second `Activity` to send the user back to the main `Activity`.
- [X] The Up button in the app bar no longer appears in the second `Activity` to send the user back to the parent `Activity`.

### Question 3
Which constructor method do you use to create a new explicit `Intent`? Choose one:
- [ ] `new Intent()`
- [X] `new Intent(Context context, Class<?> class)`
- [ ] `new Intent(String action, Uri uri)`
- [ ] `new Intent(String action)`

### Question 4
In the HelloToast app homework, how do you add the current value of the count to the `Intent`? Choose one:
- [ ] As the `Intent` data
- [ ] As the `Intent` `TEXT_REQUEST`
- [ ] As an `Intent` action
- [X] As an `Intent` extra

### Question 5
In the HelloToast app homework, how do you display the current count in the second "Hello" `Activity`? Choose one:
- [ ] Get the `Intent` that the `Activity` was launched with.
- [ ] Get the current count value out of the `Intent`.
- [ ] Update the `TextView` for the count.
- [X] All of the above.

## Submit your app for grading
### Guidance for graders
Check that the app has the following features:
- It displays the **Say Hello** button instead of the **Toast** button.
- The second `Activity` starts when the Say Hello button is pressed, and it displays the message "Hello!" and the current count from `MainActivity`.
- The second `Activity` Java and XML layout files have been added to the project.
- The XML layout file for the second `Activity` contains two `TextView` elements, one with the string "Hello!" and the second with the `count`.
- It includes an implementation of a click handler method for the **Say Hello** button (in `MainActivity`).
- It includes an implementation of the `onCreate()` method for the second `Activity` and updates the count `TextView` with the `count` from `MainActivity`.
