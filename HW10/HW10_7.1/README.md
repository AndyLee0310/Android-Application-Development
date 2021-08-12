# HW10_7.1

### ref:
##### https://developer.android.com/codelabs/android-training-create-asynctask?index=..%2F..%2Fandroid-training#9
------

## Answer these questions
### Question 1
For a ProgressBar:
1. How do you determine the range of values that a ProgressBar can show?   
	*Ans:* Set the android:max in the ProgressBar attributes

2. How do you change how much of the progress bar is filled in?   
	*Ans:* I create an onProgressUpdate function in SimpleAsyncTask class to update

### Question 2
If an AsyncTask is defined as follows:
```JAVA
private class DownloadFilesTask extends AsyncTask<URL, Integer, Long>
```
1. What is the type of the value that is passed to doInBackground() in the AsyncTask?   
	*Ans:* URL

2. What is the type of the value that is passed to the callback that reports the progress of the task?   
	*Ans:* Integer

3. What is the type of the value that is passed to the callback that is executed when the task completes?   
	*Ans:* Long

### Question 3
To report progress of the work executed by an `AsyncTask`, what callback method do you implement, and what method do you call in your `AsyncTask` subclass?
- [ ] Implement `publishProgress()`. Call `publishProgress()`.
- [ ] Implement `publishProgress()`. Call `onProgressUpdate()`.
- [X] Implement `onProgressUpdate()`. Call `publishProgress()`.
- [ ] Implement `onProgressUpdate()`. Call `onProgressUpdate()`.