console.log(require("fs").readFileSync("/dev/stdin").toString().trim().split("\n").reduce((a,b) => +a*60 + +b));