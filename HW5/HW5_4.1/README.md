# HW5_4.1

### ref:
##### https://developer.android.com/codelabs/android-training-clickable-images?index=..%2F..%2Fandroid-training#9
------

## Answer these questions
### Question 1
How do you add images to an Android Studio project? Choose one:
- [ ] Drag each image to the layout editor.
- [X] Copy the image files into your project's `drawable` folder.
- [ ] Drag an `ImageButton` to the layout editor.
- [ ] Choose **New > Image** Asset and then choose the image file.


### Question 2
How do you make an `ImageView` clickable like a simple `Button`? Choose one:
- [ ] Add the `android:contentDescription attribute` to the `ImageView` in the layout and use it to call the click handler in the `Activity`.
- [ ] Add the `android:src` attribute to the `ImageView` in the layout and use it to call the click handler in the `Activity`.
- [X] Add the `android:onClick` attribute to the `ImageView` in the layout and use it to call the click handler in the `Activity`.
- [ ] Add the `android:id` attribute to the `ImageView` in the layout and use it to call the click handler in the `Activity`.

### Question 3
Which rule applies to a click handler called from the attribute in the layout? Choose one:
- [ ] The click handler method must include the event listener `View.OnClickListener`, which is an interface in the `View` class .
- [X] The click handler method must be `public`, return `void`, and define a `View` as its only parameter.
- [ ] The click handler must customize the `View.OnClickListener` class and override its click handler to perform some action.
- [ ] The click handler method must be `private` and return a `View`.