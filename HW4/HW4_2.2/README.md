# HW4_2.2
## Build and run an app
1. Create an app with a layout that holds a counter TextView, a Button to increment the counter, and an EditText. See the screenshot below as an example. You don't have to precisely duplicate the layout.
2. Add a click handler for the Button that increments the counter.
3. Run the app and increment the counter. Enter some text into the EditText.
4. Rotate the device. Note that the counter is reset, but the EditText is not.
5. Implement onSaveInstanceState() to save the current state of the app.
6. Update onCreate() to restore the state of the app.
7. Make sure that when you rotate the device, the app state is preserved.
![CounterHomework](00_img/CounterHomework.png)


## Answer these questions
### Question 1
If you run the homework app before implementing `onSaveInstanceState()`, what happens if you rotate the device? Choose one:
- [ ] The `EditText` no longer contains the text you entered, but the counter is preserved.
- [ ] The counter is reset to 0, and the `EditText` no longer contains the text you entered.
- [X] The counter is reset to 0, but the contents of the `EditText` is preserved.
- [ ] The counter and the contents of the `EditText` are preserved.

### Question 2
What `Activity` lifecycle methods are called when a device-configuration change (such as rotation) occurs? Choose one:
- [ ] Android immediately shuts down your `Activity` by calling `onStop()`. Your code must restart the `Activity`.
- [ ] Android shuts down your `Activity` by calling `onPause()`, `onStop()`, and `onDestroy()`. Your code must restart the `Activity`.
- [X] Android shuts down your `Activity` by calling `onPause()`, `onStop()`, and `onDestroy()`, and then starts it over again, calling `onCreate()`, `onStart()`, and `onResume()`.
- [ ] Android immediately calls `onResume()`.

### Question 3
When in the Activity lifecycle is onSaveInstanceState() called? Choose one:
- [ ] `onSaveInstanceState()` is called before the onStop() method.
- [ ] `onSaveInstanceState()` is called before the onResume() method.
- [ ] `onSaveInstanceState()` is called before the onCreate() method.
- [X] `onSaveInstanceState()` is called before the onDestroy() method.

### Question 4
Which Activity lifecycle methods are best to use for saving data before the Activity is finished or destroyed? Choose one:
- [X] `onPause()` or `onStop()`
- [ ] `onResume()` or `onCreate()`
- [ ] `onDestroy()`
- [ ] `onStart()` or `onRestart()`

## Submit your app for grading
### Guidance for graders
Check that the app has the following features:
- It displays a counter, a `Button` to increment that counter, and an `EditText`.
- Clicking the `Button` increments the counter by 1.
- When the device is rotated, both the counter and `EditText` states are retained.
- The implementation of `MainActivity.java` uses the `onSaveInstanceState()` method to store the counter value.
- The implementation of `onCreate()` tests for the existence of the `outState` `Bundle`. If that `Bundle` exists, the counter value is restored and saved to the `TextView`.
