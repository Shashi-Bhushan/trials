## Synchronization

Synchronization of a block of code has two purpose. Before jumping into those, take a look at this [code](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/concurrent/StopThread.java)
and guess how much time it would take for the main function to finish. You might say 1 second, but it would be wrong.
The code will run infinitely.

Now, two functions of synchronization
1. Mutual Exclusion
When you want multiple threads to have mutual exclusion on a block of code, i.e. atomicity and treating the whole block of code as a single
operation, you would use synchronization.

2. Communication
If one thread has made any change into a variable state and you want to communicate it to another thread, then also you would use synchronization.
This is what's missing in the code there. Main thread has changes the value of `stopRequested` but the spawned thread doesn't know about the change.
