# Sieve-of-Eratosthenes
Android Internship Coding Challenge

DESCRIPTION

Within my code, I used the following three lines to disable landscape mode for this application:

  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  
Also, the Wikipedia page of the Sieve of Eratosthenes shows an optimazed implentation by using two for loops with specific conditions. To test for complexity, I converted the second for loop into a while loop. So in my code, I have both the for loop and while loop written but one must be commented out to run successfully. The following lines shows both loops:

  //using a while loop
    int j = i*2;
    while (j < maxPrime+1) {
      A[j] = Boolean.FALSE;
      j = j+i;
    }

  //using a for loop
    for (int j = i * 2; j < maxPrime + 1; j = j + i) {
      A[j] = true;
    }
    
Next, to hold the boolean values for each 
