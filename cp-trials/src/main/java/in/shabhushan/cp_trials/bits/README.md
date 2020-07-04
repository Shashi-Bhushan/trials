### Bit Manipulations


#### 1. Add Sign Bit
Add a sign bit to negative value.  
Drawback is you can't add or subtract values in this format and there are two values for zero.  

#### 2. Ones Complement
Add a sign bit to negative value and flip all the bits from positive number.  
You could add or subtract the numbers in this format (add 1 to get the correct value)  
This format still has two representations for one.  

#### 3. Two's complement
Similar to ones complement, but remove the negative zero from the table.  
So, you would get one more negative number than a positive number. So, for a 4 bit space, 1 bit is for sign and 3 for the numbers.  
The positive number range from 1 to 7 and the negative number from -1 to -8.  

treat the sign bit as a -(2^n) bit  

Check youtube video [here](https://www.youtube.com/watch?v=4qH4unVtJkE&t=3s)  

