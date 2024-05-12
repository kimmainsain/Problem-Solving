const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input[0]);
const distance = input[1].split(" ").map(Number);
const Liter = input[2].split(" ").map(Number);

let min = Number.MAX_VALUE;
let answer = BigInt(0);

const solve = () => {
  distance.forEach((value, index) => {
    min = Math.min(min, Liter[index]);
    answer += BigInt(min * value);
  });
  console.log(answer.toString());
};

solve();
