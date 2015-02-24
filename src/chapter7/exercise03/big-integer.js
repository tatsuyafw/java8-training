// JavaScript の Number の精度を超えている (2^53まで)
var b = new java.math.BigInteger('1234567890987654321');
print(b)
print(b.mod(java.math.BigInteger.TEN))
print(b.toString(2))
