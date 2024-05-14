const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const solve = () => {
  let answer = "";
  for (let i = 0; i < input.length - 1; i++) {
    const [n, m] = input[i].split(" ").map(Number);
    if (n > m) answer += "Yes\n";
    else answer += "No\n";
  }
  console.log(answer);
};

solve();
