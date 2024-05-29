const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");
console.log(input.slice(1).map((value) => value.toLocaleLowerCase()).join("\n"))