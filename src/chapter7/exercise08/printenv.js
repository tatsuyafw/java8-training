var environmentVariables = java.lang.System.getenv();

for each (var e in environmentVariables.entrySet()) {
  print(e.key + "=" + e.value)
}
