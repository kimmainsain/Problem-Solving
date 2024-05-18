const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, start] = input[0].split(" ").map(Number);
const 거리차이 = input[1].split(" ").map((value) => Math.abs(value - start));

const gcd = (a, b) => {
  if (b == 0) return a;
  return gcd(b, a % b);
};

const solve = () => {
  let answer = 거리차이[0];
  거리차이.forEach((value, index) => {
    answer = gcd(answer, value);
  });
  console.log(answer);
};

solve();
