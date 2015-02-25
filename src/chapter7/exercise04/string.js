var string = "abcdefghijklmnopqrstuvwxyz"
var subString = string.slice(1, 25)
var klass = subString.getClass();
print(klass)

// java.lang.String.class.cast(klass)
// ClassCastException が発生する
// java.lang.Class を java.lang.String へキャストできないため
