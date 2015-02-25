var currentAge, currentAgeStr,
    displayedMessage = "Next year, you will be ";

if (arguments[0]) {
  currentAgeStr = arguments[0];
} else if ($ENV.AGE) {
  currentAgeStr = $ENV.AGE;
} else {
  currentAgeStr = readLine('Current age: ');
}

currentAge = Number(currentAgeStr);

if ( isNaN(currentAge) ) {
  print("[Error] '" + currentAgeStr + "' is not a number.");
  exit(1);
}

print(displayedMessage + (currentAge + 1) + ".");
