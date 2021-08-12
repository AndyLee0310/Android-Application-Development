# HW13_9.1

### ref:
##### https://developer.android.com/codelabs/android-training-shared-preferences?index=..%2F..%2Fandroid-training#9
------

## Answer these questions
### Question 1
In which lifecycle method do you save the app state to shared preferences?    
	*Ans:* onPause()

### Question 2
In which lifecycle method do you restore the app state?    
	*Ans:* onCreate()

### Question 3
Can you think of a case where it makes sense to have both shared preferences and instance state?    
	*Ans:* 使用shared preferences保存登錄狀態，使用instance state保存和傳遞登錄信息。
