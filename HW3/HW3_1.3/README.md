# HW3_1.3
## Change an app
Open the [ScrollingText2](https://github.com/google-developer-training/android-fundamentals/tree/master/ScrollingText2) app that you created in the **Working with TextView Elements** lesson.
1. Change the subheading so that it wraps within a column on the left that is 100 dp wide, as shown below.
2. Place the text of the article to the right of the subheading as shown below.
![Scrolling_text_in_two_columns](00_img/Scrolling_text_in_two_columns.png)

## Answer these questions
### Question 1
How many views can you use within a `ScrollView`? Choose one:
- [ ] One view only
- [X] One view or one view group
- [ ] As many as you need

### Question 2
Which XML attribute do you use in a `LinearLayout` to show views side by side? Choose one:
- [X] `android:orientation="horizontal"`
- [ ] `android:orientation="vertical"`
- [ ] `android:layout_width="wrap_content"`

### Question 3
Which XML attribute do you use to define the width of the `LinearLayout` inside the scrolling view? Choose one:
- [ ] `android:layout_width="wrap_content"`
- [X] `android:layout_width="match_parent"`
- [ ] `android:layout_width="200dp"`

## Submit your app for grading
**Guidance for graders**
Check that the app has the following features:
- The layout shows the subheading in the left column and the article text in the right column, as shown in the above figure.
- The `ScrollView` includes a `LinearLayout` with two `TextView` elements.
- The `LinearLayout` orientation is set to horizontal.