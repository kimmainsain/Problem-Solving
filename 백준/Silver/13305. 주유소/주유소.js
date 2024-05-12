const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input.shift());
const distance = input.shift().split(" ").map(Number);
const Liter = input.shift().split(" ").map(Number);

let min = Number.MAX_VALUE;
let answer = 0;

const solve = () => {
  distance.forEach((value, index) => {
    min = Math.min(min, Liter[index]);
    answer += min * value;
  });
  console.log(answer);
};

solve();
