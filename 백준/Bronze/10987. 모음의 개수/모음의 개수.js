const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim();

const str = "aeiou";
let answer = 0;
for (let i = 0; i < input.length; i++) {
  const value = input[i];
  if (str.includes(value)) answer++;
}
console.log(answer);
