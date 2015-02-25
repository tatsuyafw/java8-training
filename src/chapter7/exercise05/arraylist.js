var createExtendedArrayListayList = function() {
  var arrayList = new (Java.extend(java.util.ArrayList)) {
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arrayList).add(x);
    }
  };
  return arrayList;
};

var arr1 = createExtendedArrayListayList();
arr1.add(1);
arr1.add(2);
arr1.add(3);
print(arr1);

print();

var arr2 = createExtendedArrayListayList();
arr2.add(3);
arr2.add(2);
arr2.add(1);
print(arr2);
