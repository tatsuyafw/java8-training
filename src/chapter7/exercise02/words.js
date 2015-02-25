var fileName = "alice.txt";
var String = java.lang.String;
var Files = java.nio.file.Files;
var Paths = java.nio.file.Paths;
var StandardCharsets = java.nio.charset.StandardCharsets;
var Stream = java.util.stream.Stream;
var TreeSet = java.util.TreeSet;
var Pattern = java.util.regex.Pattern;

var contents = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
var words = Pattern.compile("[\\P{L}+]").splitAsStream(contents);

words.filter(function(word) {
  return word.length >= 12
}).sorted().distinct().forEach(function( word ) { print(word); });
