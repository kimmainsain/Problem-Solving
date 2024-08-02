const data = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
console.log(Number(data[0]) + Number(data[1]) - Number(data[2]));
console.log(data[0] + data[1] - Number(data[2]));