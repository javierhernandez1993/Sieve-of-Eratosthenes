# Sieve-of-Eratosthenes
Android Internship Coding Challenge

DESCRIPTION

Within my code, I used the following three lines to disable landscape mode for this application:

  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  
Also, the Wikipedia page of the Sieve of Eratosthenes shows an optimized implementation by using two for loops with specific conditions. To test for complexity, I converted the second for loop into a while loop. So in my code, I have both the for loop and while loop written but one must be commented out to run successfully. The following lines shows both loops:

  //using a while loop -->
    int j = i*2;
    while (j < maxPrime+1) {
      A[j] = true;
      j = j+i;
    }

  //using a for loop -->
    for (int j = i * 2; j < maxPrime + 1; j = j + i) {
      A[j] = true;
    }
    
Next, an array had to be used to hold boolean values that will determine if the indexed number was prime, so I had to choose between using Boolean[] or boolean[]. Boolean[] is an object with built-in methods and boolean[] is a primitive type that is cheap when considering memory expense. That being said, I used boolean[] in my implementation.

For creativity, the user has to input a number and push the "RUN" button to run the algorithm. If the text field is empty, the button will be disabled until it is filled in with a number. The following lines show whether the button is disabled or not:

  input = (EditText) findViewById(R.id.editText);
  run = (Button) findViewById(R.id.button);
  
  input.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
  
    @Override
    public void afterTextChanged(Editable s) {
      if (input.getText().toString().matches("")) {
        run.setEnabled(false);
      }
      else {
        run.setEnabled(true);
      }
    }
  });
