# Algo Trials

This directory has been my primary playground for algorithm trials.

I've started with this course and will be logging progress here

#### 1. **Algorithms** - *Rebort Sedgewick and Kevin Wayne*
---------------------
Coursera link [here](https://www.coursera.org/learn/algorithms-part1/home/welcome)

Kevin Wayne's [github repo](https://github.com/kevin-wayne/algs4) which hosts the base code for standard input output that I used in this project at many places.

Also, check out [this](https://github.com/reneargento/algorithms-sedgewick-wayne) repo. The guy is nice enough to share the solutions for all the questions in the book.
I took inspiration from this on some of the solutions I wrote and blatantly copied his code in some other places :D

##### Useful Reads
- [Chapter 1, Section 1](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/notes/chapter1/README.md)

##### Useful Links

- [Book Site](https://algs4.cs.princeton.edu/home/)
- [Java Algorithms and Clients](https://algs4.cs.princeton.edu/code/)

##### Few noteworthy Solutions

- [Majority](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section4/webexercise/Exercise5Majority.java)
- [Finding Duplicates](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/trials/FindingDuplicates.java)
- [Missing Elements](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/trials/MissingElements.java)
- [Common Elements](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section4/exercise/Exercise12CommonElements.java)
- Check Chapter 1, Section 4, Exercise 15 both solutions (One map based, other sum based Three sum solution)
- [Local Minimum](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section4/exercise/Exercise18LocalMinimum.java)
- [Less Than, Exercise 29 Section 1, Chapter 1](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section1/exercise/Exercise28.java)
- [Dice Distribution Generation Logic](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section1/exercise/Exercise35.java)
- [Circular Sorted String](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section2/webexercise/Exercise6.java)
- [Binary Representation String](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section3/exercise/Exercise5.java)
- [To Proper Infix Expression](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section3/exercise/Exercise9.java)
- [Josepheus Problem](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section3/exercise/Exercise37.java)
- [Move to Front](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/algorithms/chapter1/section3/exercise/Exercise40.java)

#### 2. **Dynamic Programming** - *Meenakshi, Kamal Rawat*
---------------------

##### Few noteworthy Solutions

- [Count 3 Ways](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter8/Count3Ways.java)
- [Edit Distance](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter9/EditDistance.java)
- [String Interleaving](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter8/StringInterleaving.java)
- [Cutting Rod](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter9/CuttingRod.java)
- [0/1 Knapsack](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter9/Knapsack.java)
- [LPS](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/src/main/java/in/shabhushan/algo_trials/dynamic_programming/chapter9/LongestPalindromicSubsequence.java)

#### 3. **CLRS** - *Cormen, Leiserson, Rivest, Stein*
---------------------

##### Few noteworthy Solutions

- [Chapter 6 Problem 6.3 - Young Tableau](https://github.com/Shashi-Bhushan/trials/blob/master/algo-trials/clrs/chapter6/youngTableau.cpp)


#### How to Run Benchmarks

Build the project using maven. No need to run test cases
`mvn clean install -D skipTests`

Run the perfs jar
`java -jar target/algo-trials-1.0-SNAPSHOT-perf-tests.jar `
