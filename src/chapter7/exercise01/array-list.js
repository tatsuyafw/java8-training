// 基本的な java.util.ArrayList を試してみる

var list = new java.util.ArrayList()
list.add(1)
list.add("JavaScript")

// list.add(new java.lang.Long(100L)) # エラー

 // Object も追加できる
list.add({ foo: "bar"})

// Function も追加できる
list.add(function() { return "foo" })
for each (var value in list) print(value)

// 1
// JavaScript
// [object Object]
// function() { return "foo" }
// と表示される
