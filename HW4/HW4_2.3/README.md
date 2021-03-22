# HW4_2.3
## Build and run an app
Open the [ImplicitIntents](https://github.com/google-developer-training/android-fundamentals-apps-v2/tree/master/ImplicitIntents) app that you created.
1. Add another button at the bottom of the screen.
2. When the `Button` is clicked, launch a camera app to take a picture. (You don't need to return the picture to the original app.)
    **Note**:
    If you use the Android emulator to test the camera, open the emulator configuration in the Android AVD manager, choose **Advanced Settings**, and then choose **Emulated** for both front and back cameras. Restart your emulator if necessary.
![Implicit_Lntents](00_img/Implicit_Lntents.png)

## Answer these questions
### Question 1
Which constructor method do you use to create an implicit `Intent` to launch a camera app?
- [ ] `new Intent()`
- [ ] `new Intent(Context context, Class<?> class)`
- [ ] `new Intent(String action, Uri uri)`
- [ ] `new Intent(String action)`

### Question 2
When you create an implicit Intent object, which of the following is true?
- [ ] Don't specify the specific `Activity` or other component to launch.
- [ ] Add an `Intent` action or Intent categories (or both).
- [ ] Resolve the `Intent` with the system before calling `startActivity()` or `startActivityforResult()`.
- [ ] All of the above.

### Question 3
Which `Intent` action do you use to take a picture with a camera app?
- [ ] `Intent takePicture = new Intent(Intent.ACTION_VIEW);`
- [ ] `Intent takePicture = new Intent(Intent.ACTION_MAIN);`
- [ ] `Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);`
- [ ] `Intent takePicture = new Intent(Intent.ACTION_GET_CONTENT);`

## Submit your app for grading
### Guidance for graders
Check that the app has the following features:
- It displays a **Take a Picture** button at the bottom of the app.
- When clicked, the button launches a camera app on the device.
- Before sending the intent, the `onClick()` method for the **Take a Picture** `Button` ensures that an app is available on the device, using the `resolveActivity()` and `getPackageManager()` methods.
