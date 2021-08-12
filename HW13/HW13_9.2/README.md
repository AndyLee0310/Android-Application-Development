# HW13_9.2

### ref:
##### https://developer.android.com/codelabs/android-training-adding-settings-to-app?index=..%2F..%2Fandroid-training#9
------

## Answer these questions
### Question 1
In which file of the DroidCafeWithSettings project do you define the array of entries and the array of values for the ListPreference? Choose one:
- [ ] `pref_general.xml`
- [X] `strings.xml`
- [ ] `menu_main.xml`
- [ ] `activity_main.xml`
- [ ] `content_main.xml`

### Question 2
In which file of the DroidCafeWithSettings project do you use the array of entries and the array of values in setting up the ListPreference, and also set the ListPreference key and default value? Choose one:
- [X] `pref_general.xml`
- [ ] `strings.xml`
- [ ] `menu_main.xml`
- [ ] `content_main.xml`
- [ ] `content_main.xml`

### Question 3
How do you set up a settings `Activity` and a `Fragment` with a `SwitchPreference` for the UI, and still remain compatible with the `v7 appcompat library` for backward compatibility with older versions of Android?
- [ ] Use a settings activity that extends `Activity`, a fragment that extends `PreferenceFragment`, and a `SwitchPreference` for the UI.
- [ ] Change `MainActivity` to extend `Activity`.
- [X] Use a settings activity that extends `AppCompatActivity`, a fragment that extends `PreferenceFragmentCompat`, and a `SwitchPreferenceCompat` for the UI.
- [ ] You can't use a fragment with a `SwitchPreference` and remain compatible with the `v7 appcompat library`.