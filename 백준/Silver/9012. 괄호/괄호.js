const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input[0]);

const solve = () => {
  let answer = "";
  for (let i = 1; i < n + 1; i++) {
    let count = 0;
    for (let j = 0; j < input[i].length; j++) {
      if (input[i][j] === "(") count++;
      else count--;
      if (count < 0) break;
    }
    if (count == 0) answer += "YES\n";
    else answer += "NO\n";
  }
  console.log(answer);
};

solve();
