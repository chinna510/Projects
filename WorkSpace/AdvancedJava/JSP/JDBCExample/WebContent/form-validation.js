function validate(frm) {
if (!hasData(frm.from.value)) {
alert("Please type your name in the 'From:' box");
return false;
}
return true;
}
function hasData(s) {
if (s == null)
return false;
var n = s.length;
for (var i = 0; i < n; i++) {
var c = s.charAt(i);
switch (c) {
case ' ':
case '\t':
case '\n':
continue;
default:
return true;
}
}
return false;
}