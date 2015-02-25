var pipe = function() {
  var output;
  for each (var command in arguments) {
    output = $EXEC(command, output);
  }
  print(output);
};

pipe('find .', 'grep -v class', 'sort');
